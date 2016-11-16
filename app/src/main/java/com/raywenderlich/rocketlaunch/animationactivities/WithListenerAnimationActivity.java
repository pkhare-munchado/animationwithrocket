package com.raywenderlich.rocketlaunch.animationactivities;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.widget.Toast;

public class WithListenerAnimationActivity extends BaseAnimationActivity {
  @Override
  protected void onStartAnimation() {

    ValueAnimator valueAnimator1=ValueAnimator.ofFloat(0,-mScreenHeight);
    valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        float value=(float)animation.getAnimatedValue();
        mRocket.setTranslationY(value);
        mDoge.setTranslationY(value);
      }
    });

    valueAnimator1.addListener(new Animator.AnimatorListener() {
      @Override
      public void onAnimationStart(Animator animation) {
        Toast.makeText(WithListenerAnimationActivity.this, "animation started", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onAnimationEnd(Animator animation) {
        Toast.makeText(WithListenerAnimationActivity.this, "animation ended", Toast.LENGTH_SHORT).show();
        finish();
      }

      @Override
      public void onAnimationCancel(Animator animation) {

      }

      @Override
      public void onAnimationRepeat(Animator animation) {

      }
    });

    valueAnimator1.setDuration(5000l);
    valueAnimator1.start();
  }
}
