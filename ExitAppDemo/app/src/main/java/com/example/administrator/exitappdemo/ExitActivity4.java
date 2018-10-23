package com.example.administrator.exitappdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/10/23.
 */

public class ExitActivity4 extends AppCompatActivity {
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            String msg = "是否确定退出应用\n否则取消";
            new NotificationDialog(this,null, msg, null,new NotificationDialog.DialogCallBack() {

                @Override
                public void onResult(boolean confirmed, Bundle bundle) {
                    if(confirmed){
                        System.exit(0);
                    }else{
                    }
                }
            }, true).show();
        }
        return super.onKeyDown(keyCode, event);
    }
}
