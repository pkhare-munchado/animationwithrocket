package com.raywenderlich.rocketlaunch.animationactivities;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;

public class LaunchAndSpinAnimatorSetAnimatorActivity extends BaseAnimationActivity {
  @Override
  protected void onStartAnimation() {

    ValueAnimator valueAnimator=ValueAnimator.ofFloat(0,-mScreenHeight);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        mRocket.setTranslationY((float)animation.getAnimatedValue());
      }
    });
    ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(mRocket,"rotation",0,360f);
    AnimatorSet animatorSet=new AnimatorSet();
    animatorSet.play(valueAnimator).with(objectAnimator);
    animatorSet.setDuration(DEFAULT_ANIMATION_DURATION);
    animatorSet.start();
  }
}
