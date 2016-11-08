package com.fineeat;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.image.ImageInfo;

import static com.fineeat.R.attr.logo;

/**
 * Created by Nicholascwz on 11/3/2016.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        //Fresco
        //By default, Fresco does not write out all its logs. You need to configure the image pipeline to do so.
        //Set<RequestListener> requestListeners = new HashSet<>();
        //requestListeners.add(new RequestLoggingListener());

        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true) //included down sample to improve performance
                //.setRequestListeners(requestListeners) //congifure image pipeline to display FLog
                .build();
        //Fresco initialization
        Fresco.initialize(this, config);
        //congifure image pipeline to display FLog
        //FLog.setMinimumLoggingLevel(FLog.VERBOSE);
    }

    public static float getScreenWidth(Context context){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels; // for dp divide by displayMetrics.density;
    }

    public static void frescoDisplayImage(final Context context,final SimpleDraweeView simpledraweeview, Uri uri){
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

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setControllerListener(controllerListener)
                .setUri(uri)
                // other setters
                .build();
        simpledraweeview.setController(controller);
    }
}
