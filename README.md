# Neural-Code-Search
An implementation of the paper  [https://dl.acm.org/doi/abs/10.1145/3211346.3211353]

'''
Searching over large code corpora can be a powerful productivity tool for both beginner and experienced developers because it helps them quickly find examples of code related to their intent. Code search becomes even more attractive if developers could express their intent in natural language,similar to the interaction that Stack Overflow supports.

'''

[1] The dataset used for this is taken from the github repository : [link](https://github.com/facebookresearch/Neural-Code-Search-Evaluation-Dataset)


[2] The repository [codesearch](https://github.com/nokia/codesearch) by Nokia has been of great help and most of the code has been taken from there.

The repository contains many clean data sets and pretrained models for the same . But I did not find any code or model for the data that I mentioned above which is given by the original authors of the paper. 

So I decided to download and process the data into a format that can be consumed by the code by the second code. It took a lot of time ,so I have uploaded the processed datasets which can be downloaded in two parts and appended by a simple list append from here [1](https://drive.google.com/file/d/1VzyabXE3ecKZ39o2UovdE04BWQdVe0QQ/view?usp=sharing) [2](https://drive.google.com/file/d/1T0Mk9lTg3NOEh7hmZOsBSYyXx5fea1vN/view?usp=sharing)


I trained the ncs model on the data and the pretrained models are also available for further downstream tasks.

fasttext model[link](https://drive.google.com/file/d/1zqAK8kYAsONgnbRuzOA9fifGIXcsKBSz/view?usp=sharing)
tfidf model [link]

entire model along with params [link]


### Next I provided with some outputs corresponding to the test set .

****************************************
QUERY: How to hide status bar in Android?
****************************************

----------------------------------------
RANK 1
****************************************
DESCRIPTION: setStatusBarAndroid
CODE:
    public static void setStatusBarAndroid() {

    }



RANK 2
****************************************
DESCRIPTION: hideStatusBar
CODE:
	public final void hideStatusBar() {
		StatusBarHelper.hideStatusBar(getWindow());
	}


RANK 3
****************************************
DESCRIPTION: setHideStatusBar
CODE:
        public GSYSmallVideoHelperBuilder setHideStatusBar(boolean hideStatusBar) {
            this.mHideStatusBar = hideStatusBar;
            return this;
        }

****************************************
QUERY: How to handle back button in activity?
----------------------------------------


RANK 1
****************************************
DESCRIPTION: handleBackButton
CODE:
	protected void handleBackButton() 
	{
		this.getActivity().finish();
	}
}


RANK 2
****************************************
DESCRIPTION: onStartButtonClick
CODE:
    public void onStartButtonClick(View view) {
        handleOnStartButtonClick(view);
    }


----------------------------------------



The entire result can be obtained from here.[link](https://drive.google.com/file/d/1W8byMeoVoOWumbGCggS_F_GEOzDPzK6v/view?usp=sharing)


To setup the model 

1. run setup.py

2. Download the data

3. The model can be trained from ncs/train_ncs_with_custom_data.py

4. Download the test file

5. To get predictions ncs/predict_custom_data.py

I have also provided a script for loading the pretrained model and evaluating which can be found in ncs/load_model_and_predict.py

Some ablation study is therte in experiments in ncs/experiments.ipynb which I have copied from the original repo.

ncs/ncs.ipynb is also taken from original repo but have been used to reflect the results on our data.













To Do

1. re-ranking 
2. query improvement
3. automatic evaluation