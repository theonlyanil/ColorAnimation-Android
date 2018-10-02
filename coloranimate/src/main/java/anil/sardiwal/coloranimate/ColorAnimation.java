package anil.sardiwal.coloranimate;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.View;

public class ColorAnimation
{
    public static int pos = 0;

    public static void rgb(final View view, int time)
    {
        // It's ON
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int colorFrom = ((ColorDrawable) view.getBackground()).getColor();
                int colorTo = RGB.returningColor();
                int time = 6000; //4000;

                animate(colorFrom, colorTo, view, time);
                handler.postDelayed(this, time / 4);
            }
        };

        handler.postDelayed(runnable, 100);
    }
    
    private static void animate(int colorFrom, int colorTo, final View view, int animDuration)
    {
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(animDuration); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                if(view != null)
                {
                    view.setBackgroundColor((int) animator.getAnimatedValue());
                }
            }

        });
        colorAnimation.start();
    }


}
