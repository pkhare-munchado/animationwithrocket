package com.raywenderlich.rocketlaunch.animationactivities;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;

public class FlyWithDogeAnimationActivity extends BaseAnimationActivity {
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

    ValueAnimator valueAnimator2=ValueAnimator.ofFloat(0,360f);
    valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        mDoge.setRotation((float)animation.getAnimatedValue());
      }
    });
    AnimatorSet animatorSet=new AnimatorSet();
    animatorSet.play(valueAnimator1).with(valueAnimator2);
    animatorSet.setDuration(DEFAULT_ANIMATION_DURATION);
    animatorSet.start();
  }
}
