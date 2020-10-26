****************************************
QUERY: Remove underline from links in TextView.
****************************************

----------------------------------------
RANK 1
----------------------------------------
DESCRIPTION: onCreate
CODE:
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.link);

        // text1 shows the android:autoLink property, which
        // automatically linkifies things like URLs and phone numbers
        // found in the text.  No java code is needed to make this
        // work.

        // text2 has links specified by putting <a> tags in the string
        // resource.  By default these links will appear but not
        // respond to user input.  To make them active, you need to
        // call setMovementMethod() on the TextView object.

        TextView t2 = (TextView) findViewById(R.id.text2);
        t2.setMovementMethod(LinkMovementMethod.getInstance());

        // text3 shows creating text with links from HTML in the Java
        // code, rather than from a string resource.  Note that for a
        // fixed string, using a (localizable) resource as shown above
        // is usually a better way to go; this example is intended to
        // illustrate how you might display text that came from a
        // dynamic source (eg, the network).

        TextView t3 = (TextView) findViewById(R.id.text3);
        t3.setText(
            Html.fromHtml(
                "<b>text3: Constructed from HTML programmatically.</b>  Text with a " +
                "<a href=\"http://www.google.com\">link</a> " +
                "created in the Java source code using HTML."));
        t3.setMovementMethod(LinkMovementMethod.getInstance());

        // text4 illustrates constructing a styled string containing a
        // link without using HTML at all.  Again, for a fixed string
        // you should probably be using a string resource, not a
        // hardcoded value.

        SpannableString ss = new SpannableString(
            "text4: Manually created spans. Click here to dial the phone.");

        ss.setSpan(new StyleSpan(Typeface.BOLD), 0, 30,
                   Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new URLSpan("tel:4155551212"), 31+6, 31+10,
                   Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView t4 = (TextView) findViewById(R.id.text4);
        t4.setText(ss);
        t4.setMovementMethod(LinkMovementMethod.getInstance());
    }
}

----------------------------------------

----------------------------------------
RANK 2
----------------------------------------
DESCRIPTION: insertAtSignLink
CODE:
    private static void insertAtSignLink(final String text, SpannableStringBuilder builder, int start) {

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                G.isLinkClicked = true;
                checkUsernameAndGoToRoom(text, ChatEntry.profile);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
//                if (G.isDarkTheme) {
//                    ds.linkColor = LinkColorDark;
//                } else {
//                    ds.linkColor = LinkColor;
//                }
                ds.linkColor = Color.parseColor(G.linkColor);

                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };

        builder.setSpan(clickableSpan, start, start + text.length() + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }


----------------------------------------

----------------------------------------
RANK 3
----------------------------------------
DESCRIPTION: setUnderline
CODE:
    public void setUnderline(boolean enabled) {
      if (enabled) {
        underlineStartPosition = captionStringBuilder.length();
      } else if (underlineStartPosition != POSITION_UNSET) {
        // underline spans won't overlap, so it's safe to modify the builder directly with them
        captionStringBuilder.setSpan(new UnderlineSpan(), underlineStartPosition,
            captionStringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        underlineStartPosition = POSITION_UNSET;
      }
    }


----------------------------------------

----------------------------------------
RANK 4
----------------------------------------
DESCRIPTION: setUnderline
CODE:
    public void setUnderline(boolean enabled) {
      if (enabled) {
        underlineStartPosition = captionStringBuilder.length();
      } else if (underlineStartPosition != POSITION_UNSET) {
        // underline spans won't overlap, so it's safe to modify the builder directly with them
        captionStringBuilder.setSpan(new UnderlineSpan(), underlineStartPosition,
            captionStringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        underlineStartPosition = POSITION_UNSET;
      }
    }


----------------------------------------

----------------------------------------
RANK 5
----------------------------------------
DESCRIPTION: gatherLinks
CODE:
    private void gatherLinks(String s, Pattern pattern, int type) {
        Matcher m = pattern.matcher(s);

        while (m.find()) {
            int start = m.start();
            int end = m.end();

            Hyperlink link = new Hyperlink();

            link.type = type;
            link.textSpan = s.subSequence(start, end);
            link.color = linkTextColor;
            link.underline = linkUnderline;
            link.span = new LinkSpan(link.textSpan.toString(), link.type, link.color, link.underline);
            link.start = start;
            link.end = end;

            links.add(link);
        }
    }


----------------------------------------
