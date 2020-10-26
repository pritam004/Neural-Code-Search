****************************************
QUERY: How to convert a Bitmap to Drawable in android?
****************************************

----------------------------------------
RANK 1
----------------------------------------
DESCRIPTION: bitmapFromImageView
CODE:
    public static Bitmap bitmapFromImageView(ImageView view) {
        Drawable drawable = view.getDrawable();
        if (drawable != null) {
            if (drawable instanceof ColorDrawable) {
                return convertToBitmap(drawable, view.getWidth(), view.getHeight());
            } else if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
        }
        return null;
    }


----------------------------------------

----------------------------------------
RANK 2
----------------------------------------
DESCRIPTION: bitmapFromImageView
CODE:
    public static Bitmap bitmapFromImageView(ImageView view) {
        Drawable drawable = view.getDrawable();
        if (drawable != null) {
            if (drawable instanceof ColorDrawable) {
                return convertToBitmap(drawable, view.getWidth(), view.getHeight());
            } else if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
        }
        return null;
    }


----------------------------------------

----------------------------------------
RANK 3
----------------------------------------
DESCRIPTION: createMarker
CODE:
    private Marker createMarker(LatLong p, int resource )
    {
        Drawable drawable = getResources().getDrawable(resource);
        Bitmap bitmap = AndroidGraphicFactory.convertToBitmap(drawable);
        return new Marker(p, bitmap, 0, -bitmap.getHeight() / 2);
    }


----------------------------------------

----------------------------------------
RANK 4
----------------------------------------
DESCRIPTION: convertDrawableToBitmap
CODE:
    public static Bitmap convertDrawableToBitmap (Context context, int drawableID) {

            Drawable drawable = ContextCompat.getDrawable(context, drawableID);
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            } else if (drawable instanceof VectorDrawable) {
                return getBitmap((VectorDrawable) drawable);
            } else {
                throw new IllegalArgumentException("unsupported drawable type");
            }

    }


----------------------------------------

----------------------------------------
RANK 5
----------------------------------------
DESCRIPTION: getBitmap
CODE:
    public static Bitmap getBitmap(Context context, int resId) {
        Drawable drawable = getDrawable(context, resId);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        return bitmapDrawable.getBitmap();
    }


----------------------------------------

