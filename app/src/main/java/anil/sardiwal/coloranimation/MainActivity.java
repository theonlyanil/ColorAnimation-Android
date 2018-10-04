package anil.sardiwal.coloranimation;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    public static int pos = 0;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.relativelayout);


        //ColorAnimation(relativeLayout);
    }

    private void ColorAnimation(final ViewGroup viewGroup)
    {
        final Handler handler = new Handler();
        Runnable runnable;
        // It's ON
        runnable = new Runnable() {
            @Override
            public void run() {
                int colorFrom = ((ColorDrawable) viewGroup.getBackground()).getColor();
                int colorTo = returningColor();
                int time = 2000; //4000;

                colorAnimation(colorFrom, colorTo, viewGroup, time);
                handler.postDelayed(this, time/4);
            }
        };

        handler.postDelayed(runnable, 100);

    }

    public void colorAnimation(int colorFrom, int colorTo, final View view, int animDuration)
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

    /*
        Color Animation Code STARTS
     */
    // Continuous Color change - Action bar / Toolbar
    private int returningColor()
    {
        final int[] rainbowColors = new int[]
                {

                        getResources().getColor(R.color.red),
                        getResources().getColor(R.color.green),
                        getResources().getColor(R.color.blue),
                        getResources().getColor(R.color.green),
                        getResources().getColor(R.color.red)

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
