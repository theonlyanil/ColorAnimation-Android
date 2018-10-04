package anil.sardiwal.coloranimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import anil.sardiwal.coloranimate.ColorAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout relativeLayout = findViewById(R.id.relativelayout);

        ColorAnimation.rgb(relativeLayout, 6000);
    }
}
