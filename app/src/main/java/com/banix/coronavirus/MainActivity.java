package com.banix.coronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


import com.banix.coronavirus.Quiz.Quiz1;

import at.markushi.ui.CircleButton;

public class MainActivity extends AppCompatActivity {
    private Button ButtonLogin;
    private at.markushi.ui.CircleButton btn_fb;
    private at.markushi.ui.CircleButton btn_site;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initContent();
        GoTosite();
        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageQuiz();
            }
        });

    }

    public void GoTosite() {
        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        btn_site.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                arg0.startAnimation(animRotate);
                String url = "http://www.ineas.tn/fr";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btn_fb.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                arg0.startAnimation(animRotate);
                String url = "https://www.youtube.com/watch?v=1bwNrWiCGiE&fbclid=IwAR1eQc-31znkmAHTUncwexPbSiZcmdTLv2OlyaGtExr7D7nGRPlu3Wbo2Cc";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    public void PageQuiz() {
        Intent intent = new Intent(this, Quiz1.class);
        startActivity(intent);
    }

    private void initContent() {
        ButtonLogin = (Button) findViewById(R.id.signinbtn);
        btn_fb = (CircleButton) findViewById(R.id.fblogo);
        btn_site = (CircleButton) findViewById(R.id.planet);

    }
}
