package com.example.administrator.exitappdemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/10/22.
 */

public class NotificationDialog extends Dialog{
    private String title;//标题
    private String msg;//内容
    private DialogCallBack callback;//回调
    private Bundle bundle;
    private boolean showCancel = false;//是否显示取消
    public interface DialogCallBack {
        void onResult(boolean confirmed, Bundle bundle);
    }
    public NotificationDialog(Context context, String title, String msg, Bundle bundle, DialogCallBack callback, boolean showCancel) {
        super(context);
        this.title = title;
        this.msg = msg;
        this.callback = callback;
        this.bundle = bundle;
        this.showCancel = showCancel;
        this.setCanceledOnTouchOutside(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.notification_dialog);

        TextView cancel = findViewById(R.id.btn_cancel);
        TextView ok = findViewById(R.id.btn_ok);
        TextView titleView = findViewById(R.id.title);
        setTitle(title);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btn_ok) {
                    dismiss();

                    if (callback != null) {
                        callback.onResult(true, bundle);
                    }
                } else if (view.getId() == R.id.btn_cancel) {
                    dismiss();
                    if (callback != null) {
                        callback.onResult(false, bundle);
                    }
                }
            }
        };
        cancel.setOnClickListener(listener);
        ok.setOnClickListener(listener);

        if (title != null)
            titleView.setText(title);

        if (showCancel) {
            cancel.setVisibility(View.VISIBLE);
        }

        if (msg != null)
            ((TextView)findViewById(R.id.alert_message)).setText(msg);
    }
}
