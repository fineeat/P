package com.fineeat;

import android.app.Application;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestLoggingListener;

import java.util.HashSet;
import java.util.Set;

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
}
