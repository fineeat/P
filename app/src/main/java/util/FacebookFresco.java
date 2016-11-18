package util;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

/**
 * Created by Nicholascwz on 11/11/2016.
 */

public class FacebookFresco {
    public static float getScreenWidth(Context context){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels; // for dp divide by displayMetrics.density;
    }

    public static void frescoDisplayImage(final Context context, final SimpleDraweeView simpledraweeview, Uri uri){
        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(
                    String id,
                    @Nullable ImageInfo imageInfo,
                    @Nullable Animatable anim) {
                if (imageInfo == null) {
                    return;
                }

                //Image resolution
                int imageWidth = imageInfo.getWidth();
                int imageHeight = imageInfo.getHeight();

                //drawee view width
                int draweeViewWidth = (int)getScreenWidth(context);

                //Only set if image width is greater than zero
                if( imageWidth > 0 && imageHeight > 0 && draweeViewWidth > 0 )
                {
                    simpledraweeview.getLayoutParams().height = draweeViewWidth * imageHeight / imageWidth;
                    simpledraweeview.requestLayout();
                }
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
                Log.e(getClass().toString(), throwable + " || Error loading " + id);
            }
        };

        DraweeController controller = com.facebook.drawee.backends.pipeline.Fresco.newDraweeControllerBuilder()
                .setControllerListener(controllerListener)
                .setUri(uri)
                // other setters
                .build();
        simpledraweeview.setController(controller);
    }
}
