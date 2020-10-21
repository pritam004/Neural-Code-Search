
import os
import json
import time
import numpy as np
import sys

from codesearch.encoders import BasicEncoder
from codesearch import embedding_pretraining
from codesearch.embedding_pretraining import train_fasttext_model_from_snippets, load_fasttext_model
from codesearch.utils import SaveableFunction
from codesearch.data import load_snippet_collection, EVAL_DATASETS, SNIPPET_COLLECTIONS, eval_datasets_from_regex
from codesearch.ncs.ncs_embedder import TfidfCodeEmbedder, NcsEmbedder
from codesearch.evaluation import evaluate_and_dump 
from codesearch.embedding_retrieval import EmbeddingRetrievalModel
start = time.time()


fast_text_checkpoint = os.environ.get("fast_text_checkpoint", None)
model_filename = os.environ.get("model_filename", None)

snippets_collection = os.environ.get("snippets_collection", "so-ds-feb20")
train_snippets_collection = os.environ.get("train_snippets_collection", "so-ds-feb20")
valid_dataset = os.environ.get("valid_dataset", None)
test_dataset = os.environ.get("test_dataset", "conala-curated-0.5-test")

text_overrides = json.loads(os.environ.get("text_overrides", "{}"))
code_overrides = json.loads(os.environ.get("code_overrides", "{}"))
fast_text_overrides = json.loads(os.environ.get("fast_text_overrides", "{}"))
zip_fn_name = os.environ.get("zip_fn", "zip_descr_end")
output_dir = os.environ.get("output_dir", ".")


if valid_dataset and valid_dataset not in EVAL_DATASETS and valid_dataset not in SNIPPET_COLLECTIONS:
    raise ValueError()
test_datasets = eval_datasets_from_regex(test_dataset)
snippets = load_snippet_collection(snippets_collection)
train_snippets = load_snippet_collection(train_snippets_collection) 


f=open('../../processed_search.json')
train_snippets=json.load(f)

snippets=train_snippets

print('done loading dataset')


enc = BasicEncoder(text_preprocessing_params=text_overrides, code_preprocessing_params=code_overrides)
zip_fn = getattr(sys.modules[embedding_pretraining.__name__], zip_fn_name)
model = train_fasttext_model_from_snippets(train_snippets, enc, zip_fn, fast_text_overrides, "./", save=True)
print('done training model')

tfidf_model = TfidfCodeEmbedder.create_tfidf_model(enc, model, snippets)
embedder = NcsEmbedder(model, enc, tfidf_model)

retrieval_model = EmbeddingRetrievalModel(embedder)
retrieval_model.add_snippets(snippets)

embedder.save('best_ncs_embedder')

print('saved_embeder')

sample_queries = ["hide android keyboard","train a tensorflow model", "plot a bar chart", "merge two dataframes", "sort a list", "read a pandas dataframe from a file", "plot an image"]
config = {"text": text_overrides, "code": code_overrides, "fasttext": fast_text_overrides}
evaluate_and_dump(
    retrieval_model, 
    config, 
    output_dir, 
    valid_dataset, 
    test_datasets,
    sample_queries=sample_queries
)