****************************************
QUERY: Close/hide the Android Soft Keyboard.
****************************************

----------------------------------------
RANK 1
----------------------------------------
DESCRIPTION: closeSoftKeyboard
CODE:
	public static ViewAction closeSoftKeyboard() {
		return new ViewAction() {
			/**
			 * The real {@link CloseKeyboardAction} instance.
			 */
			private final ViewAction mCloseSoftKeyboard = new CloseKeyboardAction();

			@Override
			public Matcher<View> getConstraints() {
				return mCloseSoftKeyboard.getConstraints();
			}

			@Override
			public String getDescription() {
				return mCloseSoftKeyboard.getDescription();
			}

			@Override
			public void perform(final UiController uiController, final View view) {
				mCloseSoftKeyboard.perform(uiController, view);
				uiController.loopMainThreadForAtLeast(KEYBOARD_DISMISSAL_DELAY_MILLIS);
			}
		};
	}


----------------------------------------

----------------------------------------
RANK 2
----------------------------------------
DESCRIPTION: closeSoftKeyboardWithDelay
CODE:
    static ViewAction closeSoftKeyboardWithDelay() {
        return new ViewAction() {
            /**
             * The delay time to allow the soft keyboard to dismiss.
             */
            private static final long KEYBOARD_DISMISSAL_DELAY_MILLIS = 1000L;

            /**
             * The real {@link CloseKeyboardAction} instance.
             */
            private final ViewAction mCloseSoftKeyboard = new CloseKeyboardAction();

            @Override
            public Matcher<View> getConstraints() {
                return mCloseSoftKeyboard.getConstraints();
            }

            @Override
            public String getDescription() {
                return mCloseSoftKeyboard.getDescription();
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                mCloseSoftKeyboard.perform(uiController, view);
                uiController.loopMainThreadForAtLeast(KEYBOARD_DISMISSAL_DELAY_MILLIS);
            }
        };
    }


----------------------------------------

----------------------------------------
RANK 3
----------------------------------------
DESCRIPTION: hideKeyboard
CODE:
    protected void hideKeyboard(View view) {
        /*
        Hide Keyboard by touching screen outside keyboard
        */
        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }


----------------------------------------

----------------------------------------
RANK 4
----------------------------------------
DESCRIPTION: onClose
CODE:
	public void onClose() {
		hideSoftKeyboard();
		finish();
	}


----------------------------------------

----------------------------------------
RANK 5
----------------------------------------
DESCRIPTION: onClose
CODE:
    public void onClose() {
        hideSoftKeyboard();
        finish();
    }


----------------------------------------

