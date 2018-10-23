package com.example.administrator.exitappdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn1,R.id.btn2, R.id.btn3, R.id.btn4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(1);
                break;
            case R.id.btn2:
                startActivity(2);
                break;
            case R.id.btn3:
                startActivity(3);
                break;
            case R.id.btn4:
                startActivity(4);
                break;
        }
    }

    private void startActivity(int i) {
        switch (i){
            case 1:
                Intent intent1 = new Intent(MainActivity.this,ExitActivity1.class);
                intent1.putExtra("text","方法一");
                startActivity(intent1);
                finish();
                break;
            case  2:
                Intent intent2 = new Intent(MainActivity.this,ExitActivity2.class);
                intent2.putExtra("text","方法二");
                startActivity(intent2);
                finish();
                break;
            case 3:
                Intent intent3 = new Intent(MainActivity.this,ExitActivity3.class);
                intent3.putExtra("text","方法三");
                startActivity(intent3);
                finish();
                break;
            case 4:
                Intent intent4 = new Intent(MainActivity.this,ExitActivity4.class);
                intent4.putExtra("text","方法四");
                startActivity(intent4);
                finish();
                break;
        }
    }

}
