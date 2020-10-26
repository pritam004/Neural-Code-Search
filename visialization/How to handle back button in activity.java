****************************************
QUERY: How to handle back button in activity?
****************************************

----------------------------------------
RANK 1
----------------------------------------
DESCRIPTION: handleBackButton
CODE:
	protected void handleBackButton() 
	{
		this.getActivity().finish();
	}
}

----------------------------------------

----------------------------------------
RANK 2
----------------------------------------
DESCRIPTION: onStartButtonClick
CODE:
    public void onStartButtonClick(View view) {
        handleOnStartButtonClick(view);
    }


----------------------------------------

----------------------------------------
RANK 3
----------------------------------------
DESCRIPTION: onOptionsItemSelected
CODE:
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Intent intent = new Intent(MainActivity.this, AboutDev.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_exit) {
            new AlertDialog.Builder(this)
                    .setTitle("Exit Confirmation")
                    .setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                            System.exit(0);
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
            return true;
        }

        if (id == R.id.action_Dial){
            Intent intent = new Intent(MainActivity.this,Dialar.class);
            startActivity(intent);

            return  true;
        }

        if (id == R.id.action_Msg){

            Intent intent = new Intent(MainActivity.this,Massenger.class);
            startActivity(intent);

            return true;

        }

        return super.onOptionsItemSelected(item);
    }


----------------------------------------

----------------------------------------
RANK 4
----------------------------------------
DESCRIPTION: create
CODE:
    public static UIAdjustMainActivity create( MainActivity activity, View button ){
        return new UIAdjustMainActivity( activity, button );
    }


----------------------------------------

----------------------------------------
RANK 5
----------------------------------------
DESCRIPTION: create
CODE:
    public static UIAdjustMainActivity create( MainActivity activity, View button ){
        return new UIAdjustMainActivity( activity, button );
    }


----------------------------------------

