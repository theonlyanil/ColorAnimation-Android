package anil.sardiwal.coloranimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import anil.sardiwal.coloranimate.ColorAnimation;

public class MainActivity extends AppCompatActivity {

    public static int pos = 0;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.relativelayout);


        //ColorAnimation.rgb(this, relativeLayout, 40000);
        ColorAnimation.colour(this, relativeLayout, 8000, R.color.colorPrimary);
    }

}
