package com.example.androidcontrolelectric;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class ViewActivity extends Activity {

	private static final int COLOR_SELECTOR = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_view3);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		Bundle extras = getIntent().getExtras(); 
		if(extras !=null) {
		    String Device = extras.getString("Device");
		    TextView detial = (TextView) findViewById(R.id.txt_device_name);
			detial.setText("Device : "+Device);
		}
		// then set background color
		
	}

	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// check which activity gives data
		switch (requestCode) {
		// checking for our ColorSelectorActivity using request code
		case COLOR_SELECTOR:
			// check whether result comes with RESULT_OK (That mean no problem
			// in result)
			if (resultCode == RESULT_OK) {
				// then get the color string that return from our
				// ColorSelectorActivity
				String Device = data.getExtras().getString("Device");
				// then set background color
				TextView detial = (TextView) findViewById(R.id.txt_device_name);
				detial.setText("Device : "+Device);
			}
		}
	}
}
