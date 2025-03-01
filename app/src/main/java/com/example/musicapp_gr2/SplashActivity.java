package com.example.musicapp_gr2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
import android.animation.Animator;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_MusicApp_GR2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        LottieAnimationView animationView = findViewById(R.id.lottieAnimationView);
        if (animationView != null) {
            animationView.addAnimatorListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {}
                @Override
                public void onAnimationEnd(Animator animation) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
                @Override
                public void onAnimationCancel(Animator animation) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
                @Override
                public void onAnimationRepeat(Animator animation) {}
            });
        } else {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }
    }
}