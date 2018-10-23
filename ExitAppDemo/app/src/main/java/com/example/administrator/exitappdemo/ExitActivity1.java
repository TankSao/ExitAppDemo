package com.example.administrator.exitappdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/10/23.
 */

public class ExitActivity1 extends AppCompatActivity{
    @BindView(R.id.tv)
    TextView tv;
    private long firstTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
        ButterKnife.bind(this);
        String text = getIntent().getStringExtra("text");
        tv.setText(text);
    }

    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 6200) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            firstTime = secondTime;
        } else {
            System.exit(0);
        }
    }
}
