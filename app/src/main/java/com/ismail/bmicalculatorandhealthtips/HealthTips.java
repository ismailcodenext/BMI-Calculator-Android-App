package com.ismail.bmicalculatorandhealthtips;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HealthTips extends AppCompatActivity {

    ImageView imgHealth;
    Animation myAnimZoomIn, myAnimRightLeft;

    TextView tvHead;

    LinearLayout layout1, layout2, layout3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);

        imgHealth = findViewById(R.id.imgHealth);
        tvHead = findViewById(R.id.tvHead);
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);


        myAnimZoomIn = AnimationUtils.loadAnimation(HealthTips.this, R.anim.zoom_in);
        myAnimRightLeft = AnimationUtils.loadAnimation(HealthTips.this, R.anim.right_to_left_slow);

        imgHealth.startAnimation(myAnimZoomIn);
        tvHead.startAnimation(myAnimRightLeft);
        layout1.startAnimation(myAnimRightLeft);
        layout2.startAnimation(myAnimRightLeft);
        layout3.startAnimation(myAnimRightLeft);



    }
}