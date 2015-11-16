package com.example.createthreadrunnable;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textView;
	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {

			super.handleMessage(msg);
			String string = textView.getText().toString();
			int num = Integer.parseInt(string);
			num = num - 1;
			string = Integer.toString(num);
			textView.setText(string);
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView);
	}

	@Override
	protected void onStart() {

		super.onStart();
		Thread myThread = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 10; i > 0; i--) {
					try {
						Thread.sleep(1000);
						// handler.sendMessage(handler.obtainMessage());
						handler.sendMessage(handler.obtainMessage());

					} catch (InterruptedException e) {

						e.printStackTrace();
					}

				}
			}
		});
		myThread.start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}