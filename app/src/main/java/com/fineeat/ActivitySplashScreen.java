package com.fineeat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import data.ImportMethod;
import model.Company;

public class ActivitySplashScreen extends Activity {
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    /** Called when the activity is first created. */
    Thread splashTread;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getWindow().setStatusBarColor(Color.parseColor("#1b1c1b"));
        StartAnimations();
    }
    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        ImageView l=(ImageView) findViewById(R.id.splash);
        l.clearAnimation();
        l.startAnimation(anim);

        /*anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.splash);
        iv.clearAnimation();
        iv.startAnimation(anim);*/

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    Company.resetImportStatus();
                    //Category
                    ImportMethod.ImportCategories();
                    //Cuisine
                    ImportMethod.ImportCuisines();
                    //Restaurant
                    ImportMethod.ImportRestaurant();

                    // Splash screen pause time
                    while (waited < 3000 || !Company.importStatusRestaurant) {
                        sleep(100);
                        waited += 100;
                        Log.v("Wait", "Import status: " + Company.importStatusRestaurant + " - Duration waited: " + waited);
                    }
                    //ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreenActivity.this);
                    Intent intent = new Intent(ActivitySplashScreen.this, ActivityMain.class);
                    //intent.putExtra("anim_type", "ExplodeJava");
                    //intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    //startActivity(intent, options.toBundle());
                    startActivity(intent);
                    ActivitySplashScreen.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    ActivitySplashScreen.this.finish();
                }

            }
        };

        splashTread.start();

    }

}
