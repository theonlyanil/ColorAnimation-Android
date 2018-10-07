package anil.sardiwal.coloranimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
        Button button = findViewById(R.id.cancelButton);


        //ColorAnimation.rgb(this, relativeLayout, 40000);
        ColorAnimation.rgb(relativeLayout, 4000);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorAnimation.stop();
            }
        });
    }

}
