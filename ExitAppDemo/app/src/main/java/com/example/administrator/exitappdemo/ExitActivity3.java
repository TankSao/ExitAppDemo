package com.example.administrator.exitappdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/10/23.
 */

public class ExitActivity3 extends AppCompatActivity {
    @BindView(R.id.tv)
    TextView tv;
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
        AlertDialog.Builder builder = null;
        builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("确定退出应用?");
        builder.setCancelable(true); // 将对话框设置为可取消
        // 给按钮添加注册监听
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 点击按钮所调用的方法
                System.exit(0);
            }
        });
        builder.setNegativeButton("取消",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 点击按钮所调用的方法

            }
        });
        builder.show();
    }
}
