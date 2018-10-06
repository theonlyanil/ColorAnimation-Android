package anil.sardiwal.coloranimate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import java.lang.ref.WeakReference;

public class ColorAnimation {
    private static int pos = 0;

    public static void rgb(final Context context, final View view, final int time) {
        if (context == null || view == null) {
            return;
        }
        final int colorTo = RGB.returningColor(context);
        animate(view, time, colorTo);
        safeRgbCaller(new WeakReference<>(context), new WeakReference<>(view), time);
    }

    private static void safeRgbCaller(final WeakReference<Context> contextReference, final WeakReference<View> viewReference, final int time) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (contextReference == null || viewReference.get() == null) {
                    return;
                }
                rgb(contextReference.get(), viewReference.get(), time);
            }
        }, time);
    }

    public static void colorRes(final Context context, final View view, final int time, @ColorRes final int colorRes) {
        if (context == null || view == null) {
            return;
        }
        final int colorTo = context.getResources().getColor(colorRes);
        animate(view, time, colorTo);
    }

    public static void color(final Context context, final View view, final int time, @ColorInt final int color) {
        if (context == null || view == null) {
            return;
        }
        animate(view, time, color);
    }

    private static void animate(final View view, final int time, @ColorInt final int colorTo) {
        final WeakReference<View> viewReference = new WeakReference<>(view);

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    View view = viewReference.get();
                    if (view == null) {
                        return;
                    }

                    Drawable background = view.getBackground();
                    if (background instanceof ColorDrawable) {
                        final int colorFrom = ((ColorDrawable) background).getColor();
                        colorAnimation(colorFrom, colorTo, view, time);
                    } else {
                        Log.e("ColorAnimation.animate", "View background should be instance of ColorBackground");
                    }
                } catch (Exception e) {
                    Log.e("ColorAnimation.color", e.getLocalizedMessage());
                }
            }
        };

        handler.post(runnable);
    }

    private static void colorAnimation(int colorFrom, int colorTo, @NonNull final View view, int animDuration) {
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(animDuration); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                view.setBackgroundColor((int) animator.getAnimatedValue());
            }
        });
        colorAnimation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Log.e("ColorAnimation.End", "Bitti");
            }
        });
        colorAnimation.start();
        Log.e("ColorAnimation.End", "Başladı");
    }

    private static class RGB {
        static int[] rainbowColors;

        // Continuous Color change - Action bar / Toolbar
        static int returningColor(Context context) {
            if (context == null) {
                return 0;
            }
            if (rainbowColors == null) {
                rainbowColors = generateColors(context);
            }

            final int rainbowColor = rainbowColors[pos];
            pos++;
            if (pos == rainbowColors.length - 1) {
                pos = 0;
            }
            return rainbowColor;
        }

        private static int[] generateColors(Context context) {
            return new int[]{
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
        }
    }
}
