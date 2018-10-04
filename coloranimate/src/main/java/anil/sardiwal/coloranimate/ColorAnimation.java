package anil.sardiwal.coloranimate;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.util.Log;
import android.view.View;

public class ColorAnimation
{
    private static int pos = 0;
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static void rgb(Context context, final View view, final int time)
    {
        ColorAnimation.context = context;
        final Handler handler = new Handler();
        Runnable runnable;
        // It's ON
        runnable = new Runnable() {
            @Override
            public void run() {
                try {

                    int colorFrom = ((ColorDrawable) view.getBackground()).getColor();
                    int colorTo = RGB.returningColor();
                    int time = 2000; //4000;

                    colorAnimation(colorFrom, colorTo, view, time);
                    handler.postDelayed(this, time/4);
                }
                catch (Exception e)
                {
                    Log.e("ColorAnimation.Anil", e.getLocalizedMessage());
                }
            }
        };

        handler.postDelayed(runnable, 100);
    }

    private static void colorAnimation(int colorFrom, int colorTo, final View view, int animDuration)
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

    private static class RGB
    {
        // Continuous Color change - Action bar / Toolbar
        public static int returningColor()
        {
            final int[] rainbowColors = new int[]
                    {

                            context.getResources().getColor(R.color.red),
                            context.getResources().getColor(R.color.pink),
                            context.getResources().getColor(R.color.purple),
                            context.getResources().getColor(R.color.deep_purple),
                            context.getResources().getColor(R.color.indigo),
                            context.getResources().getColor(R.color.blue),
                            context.getResources().getColor(R.color.light_blue),
                            context.getResources().getColor(R.color.cyan),
                            context.getResources().getColor(R.color.teal),
                            context.getResources().getColor(R.color.green),
                            context.getResources().getColor(R.color.light_green),
                            context.getResources().getColor(R.color.lime),
                            context.getResources().getColor(R.color.yellow),
                            context.getResources().getColor(R.color.amber),
                            context.getResources().getColor(R.color.orange),
                            context.getResources().getColor(R.color.deep_orange),
                            context.getResources().getColor(R.color.orange),
                            context.getResources().getColor(R.color.amber),
                            context.getResources().getColor(R.color.yellow),
                            context.getResources().getColor(R.color.lime),
                            context.getResources().getColor(R.color.light_green),
                            context.getResources().getColor(R.color.green),
                            context.getResources().getColor(R.color.teal),
                            context.getResources().getColor(R.color.cyan),
                            context.getResources().getColor(R.color.light_blue),
                            context.getResources().getColor(R.color.blue),
                            context.getResources().getColor(R.color.indigo),
                            context.getResources().getColor(R.color.deep_purple),
                            context.getResources().getColor(R.color.purple),
                            context.getResources().getColor(R.color.pink),
                            context.getResources().getColor(R.color.red)
                    };


            if(pos < rainbowColors.length-1)
            {
                pos++;
                return rainbowColors[pos];
            }
            else
            {
                pos = 0;
                return rainbowColors[pos];
            }
        }
    }

}
