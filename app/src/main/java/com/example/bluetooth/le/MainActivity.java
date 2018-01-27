package com.example.bluetooth.le;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MainActivity extends Activity {
	private ImageButton LoginBtn;
	private EditText username;
	private EditText password;
	private Socket mMsgSocket1 = null;
    private DataOutputStream out;

    private ImageButton denglu;

    private byte[] heart_buff={(byte)0x01,(byte)0x01,(byte)0x00,(byte)0x92,(byte)0xce,(byte)0xe0,(byte)0xdd,(byte)0x97,(byte)0x93,(byte)0x31,(byte)0x0a,
			(byte)0xc4,(byte)0xcd,(byte)0x1d,(byte)0xdc,(byte)0x13,(byte)0x3a,(byte)0x01,(byte)0x3f,(byte)0x00,(byte)0x00};
    int i=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 去掉标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		username = (EditText) findViewById(R.id.login_username);
		password = (EditText) findViewById(R.id.login_password);

		SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
		username.setText(preferences.getString("username", null));
		password.setText(preferences.getString("password", null));

		Log.i("diyibu","7777777777");
        // 获取对象
		LoginBtn = (ImageButton) findViewById(R.id.login_btn);
		// 设置按钮的监听事件
		LoginBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				SharedPreferences mSpSettings = getSharedPreferences("data", MODE_PRIVATE);
				SharedPreferences.Editor edit = mSpSettings.edit();
				edit.putBoolean("isKeep", true);

				edit.putString("username", username.getText().toString());
				edit.putString("password", password.getText().toString());
				edit.commit();


				// ��½�ж�
				if (username.getText().toString().equals("shu") && password.getText().toString().equals("scie")) {
					Intent intent = new Intent();
					Log.i("diyibu","8888888888888");
                    intent.setClass(MainActivity.this, DeviceScanActivity.class);
                     startActivity(intent);
					MainActivity.this.finish();

				} else {
					Toast.makeText(MainActivity.this,"用户名或者密码错误" ,
							Toast.LENGTH_SHORT).show();
				}

			}
		});

	}

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x16) {
                Toast.makeText(MainActivity.this, "服务器连接失败！请检查网络是否打开", Toast.LENGTH_LONG).show();
            }


        }
    };


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu1.main, menu);
		return true;
	}

}
