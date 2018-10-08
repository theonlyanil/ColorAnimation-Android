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
    private static ValueAnimator valueAnimator;
    private static Handler handler;
    private static Runnable runnable;

    public static void stop()
    {
        handler.removeCallbacks(runnable);
        if(!handler.hasMessages(0))
        {
            valueAnimator.cancel();
        }
    }

    public static void rgb(final View view, final int time)
    {
        ColorAnimation.context = view.getContext();
        handler = new Handler();
        // It's ON
        runnable = new Runnable() {
            @Override
            public void run() {
                try {

                    int colorFrom = ((ColorDrawable) view.getBackground()).getColor();
                    int colorTo = RGB.returningColor();

                    colorAnimation(colorFrom, colorTo, view, time);
                    handler.postDelayed(this, time/4);
                }
                catch (Exception e)
                {
                    Log.e("ColorAnimation.rgb", e.getLocalizedMessage());
                }
            }
        };

        handler.post(runnable);
    }

    public static void colour(final View view, final int time, final int colour)
    {
        ColorAnimation.context = view.getContext();
        final Handler handler = new Handler();
        Runnable runnable;
        // It's ON
        runnable = new Runnable() {
            @Override
            public void run() {
                try {

                    int colorFrom = ((ColorDrawable) view.getBackground()).getColor();
                    int colorTo = context.getResources().getColor(colour);

                    colorAnimation(colorFrom, colorTo, view, time);
                    handler.postDelayed(this, time/4);
                }
                catch (Exception e)
                {
                    Log.e("ColorAnimation.color", e.getLocalizedMessage());
                }
            }
        };

        handler.post(runnable);
    }

    private static void colorAnimation(int colorFrom, int colorTo, final View view, int animDuration)
    {
        valueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        valueAnimator.setDuration(animDuration); // milliseconds
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                if(view != null)
                {
                    view.setBackgroundColor((int) animator.getAnimatedValue());
                }
            }

        });
        valueAnimator.start();
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
