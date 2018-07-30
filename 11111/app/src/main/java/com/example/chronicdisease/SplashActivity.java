package com.example.chronicdisease;

import com.example.chronicdisease.base_elestical.BaseElestical;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//					WindowManager.LayoutParams.FLAG_FULLSCREEN);
        MyApp.getInstance().addActivity(this);
        setContentView(R.layout.splash_screen_view);

        AlphaAnimation animation = new AlphaAnimation(0.1f, 1.0f);    //启动动画
        animation.setDuration(1000);
        this.findViewById(R.id.homeBackgroud).startAnimation(animation);

        animation.setAnimationListener(new AnimationListener() {

            public void onAnimationStart(Animation animation) {

            }

            public void onAnimationRepeat(Animation animation) {

            }

            public void onAnimationEnd(Animation animation) {

                Intent intent = new Intent(SplashActivity.this,
                        MainActivity.class);
                SplashActivity.this.startActivity(intent);
//						overridePendingTransition(R.anim.splash_screen_fade,R.anim.splash_screen_hold);
                SplashActivity.this.finish();
            }
        });
    }
}
