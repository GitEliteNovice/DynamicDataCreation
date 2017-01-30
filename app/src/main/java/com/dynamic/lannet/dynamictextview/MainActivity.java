package com.dynamic.lannet.dynamictextview;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FlowLayout myLInearLayout2;
    LinearLayout filterview;
    FlowLayout.LayoutParams params;
    int flag = 0;
    Animation animationslidedown, animationslideup;
    String delivery[] = {"Delhi", "Ghaziabad", "Bihar", "Lucknow", "Manali", "Mumbai", "Goa", "Assam", "Shilong", "Jammu", "ludhiana"};
    private TextView[] valueTV = new TextView[20];
    ImageView underfive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLInearLayout2 = (FlowLayout) findViewById(R.id.linearLayout2);
        filterview = (LinearLayout) findViewById(R.id.filterview);
        params = new FlowLayout.LayoutParams(5, 5);

        animationslidedown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        animationslideup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);

        underfive = (ImageView) findViewById(R.id.underfive);
        underfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0) {
                    //     headertextviewlayout.setText("Filter by distance:");
                    myLInearLayout2.removeAllViews();
                    for (int i = 0; i < delivery.length; i++) {
                        valueTV[i] = new TextView(MainActivity.this);
                        valueTV[i].setId(i);
                        valueTV[i].setText(delivery[i]);
                        valueTV[i].setTag("" + delivery[i]);
                        valueTV[i].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Toast.makeText(getApplicationContext(), v.getTag().toString(), Toast.LENGTH_LONG).show();
                                String va = (String) v.getTag();
                                // String[] splited = va.split("\\s+");
                                //Log.d("splited",splited[0]);
                                Toast.makeText(getApplicationContext(), va, Toast.LENGTH_LONG).show();
                                // keyword1 = "&distance=" +splited[0] ;
                                // demo.setVisibility(View.VISIBLE);
                                // pd.show();
                                // filterbydistance();
                            }
                        });
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            valueTV[i].setBackgroundResource(R.drawable.round_textview);
                            valueTV[i].setTextColor(getResources().getColor(R.color.white_color));
                        }
                        valueTV[i].setLayoutParams(params);
                        myLInearLayout2.addView(valueTV[i]);
                    }
                    flag = 1;
                    //   underfive.setVisibility(View.GONE);
                    filterview.setVisibility(View.VISIBLE);
                    filterview.startAnimation(animationslidedown);
                    animationslidedown.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            // underfive.setTextColor(getResources().getColor(R.color.white_color));
                            // underfive.setBackgroundColor(getResources().getColor(R.color.back_color));

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                } else {
                    flag = 0;
                    filterview.startAnimation(animationslideup);
                    animationslideup.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {

                            filterview.setVisibility(View.GONE);

                            //     underfive.setTextColor(getResources().getColor(R.color.black_color));
                            //   underfive.setBackgroundColor(getResources().getColor(R.color.appcolor));
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                }
            }
        });

    }
}
