package hsb;

import java.io.FileNotFoundException;

import com.example.nino.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.view.Display;
import android.view.WindowManager;

public class ImageManager
{
	public static Bitmap LoadBackgroundBitmap(Context context, int id) throws Exception, OutOfMemoryError
	{
		Display display = ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inPreferredConfig = Config.RGB_565;
		options.inJustDecodeBounds = true;

		float widthScale = options.outWidth / displayWidth;
		float heightScale = options.outHeight / displayHeight;
		float scale = widthScale > heightScale ? widthScale : heightScale;
		
		if (scale >= 8)
			options.inSampleSize = 8;
		else if (scale >= 6)
			options.inSampleSize = 6;
		else if (scale >= 4)
			options.inSampleSize = 4;
		else if (scale >= 2)
			options.inSampleSize = 2;
		else
			options.inSampleSize = 1;
		
		options.inJustDecodeBounds = false;
		
		return BitmapFactory.decodeResource( context.getResources() , id, options );
	}
}
