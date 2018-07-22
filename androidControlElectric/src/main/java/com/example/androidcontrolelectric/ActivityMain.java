package com.example.androidcontrolelectric;

import ioio.lib.api.AnalogInput;
import ioio.lib.api.DigitalInput;
import ioio.lib.api.DigitalOutput;
import ioio.lib.api.DigitalInput.Spec.Mode;
import ioio.lib.api.DigitalOutput.Spec;
import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.BaseIOIOLooper;
import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ActivityMain extends IOIOActivity {

	public ToggleButton cmdDevice1;
	public ToggleButton cmdDevice2;
	public ToggleButton cmdDevice3;
	public ToggleButton cmdDevice4;
	public ToggleButton cmdDevice5;

	public TextView txtDevice1;
	public TextView txtDevice2;
	public TextView txtDevice3;
	public TextView txtDevice4;
	public TextView txtDevice5;

	public ImageButton viewDevice1;
	public ImageButton viewDevice2;
	public ImageButton viewDevice3;
	public ImageButton viewDevice4;
	public ImageButton viewDevice5;

	public Looper looper;

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		looper.en_latch = true;
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		looper.en_latch = false;
		super.onResume();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		InitialSetting();
	}

	@Override
	protected IOIOLooper createIOIOLooper() {
		looper = new Looper();
		return looper;
	}

	@Override
	public void onBackPressed() {
		looper.en_latch = true;
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("ÍÍ¡¨Ò¡áÍ¾¾ÅÔà¤ªÑè¹ËÃ×ÍäÁè")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								ActivityMain.super.onBackPressed();
								finish();
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
						looper.en_latch = false;
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

	public void ViewMore() {
		final Dialog dialog = new Dialog(ActivityMain.this);
		// dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
		dialog.setContentView(R.layout.activity_view3);
		dialog.setTitle(" áÊ´§ÃÒÂÅÐàÍÕÂ´à¤Ã×èÍ§ãªéä¿¿éÒ ");

		dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
				WindowManager.LayoutParams.MATCH_PARENT);
		dialog.show();
	}

	public void InitialSetting() {

		// Create Variable
		// *****************************************************

		viewDevice1 = (ImageButton) findViewById(R.id.viewDevice1);
		viewDevice2 = (ImageButton) findViewById(R.id.viewDevice2);
		viewDevice3 = (ImageButton) findViewById(R.id.viewDevice3);
		viewDevice4 = (ImageButton) findViewById(R.id.viewDevice4);
		viewDevice5 = (ImageButton) findViewById(R.id.viewDevice5);
		// *****************************************************
		cmdDevice1 = (ToggleButton) findViewById(R.id.cmdDevice1);
		cmdDevice2 = (ToggleButton) findViewById(R.id.cmdDevice2);
		cmdDevice3 = (ToggleButton) findViewById(R.id.cmdDevice3);
		cmdDevice4 = (ToggleButton) findViewById(R.id.cmdDevice4);
		cmdDevice5 = (ToggleButton) findViewById(R.id.cmdDevice5);
		// *****************************************************
		txtDevice1 = (TextView) findViewById(R.id.txtDevice1);
		txtDevice2 = (TextView) findViewById(R.id.txtDevice2);
		txtDevice3 = (TextView) findViewById(R.id.txtDevice3);
		txtDevice4 = (TextView) findViewById(R.id.txtDevice4);
		txtDevice5 = (TextView) findViewById(R.id.txtDevice5);
		// *****************************************************

		// *****************************************************
		viewDevice1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// More("áÊ´§ÃÒÂÅÐàÍÕÂ´ÍØ»¡Ã³ì", "ÍØ»¡Ã³ì 1");
				ViewMore();
			}
		});

		viewDevice2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// More("áÊ´§ÃÒÂÅÐàÍÕÂ´ÍØ»¡Ã³ì", "ÍØ»¡Ã³ì 2");
				ViewMore();
			}
		});

		viewDevice3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// More("áÊ´§ÃÒÂÅÐàÍÕÂ´ÍØ»¡Ã³ì", "ÍØ»¡Ã³ì 3");
				ViewMore();
			}
		});

		viewDevice4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// More("áÊ´§ÃÒÂÅÐàÍÕÂ´ÍØ»¡Ã³ì", "ÍØ»¡Ã³ì 4");
				ViewMore();
			}
		});

		viewDevice5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// More("áÊ´§ÃÒÂÅÐàÍÕÂ´ÍØ»¡Ã³ì", "ÍØ»¡Ã³ì 5");
				ViewMore();
			}
		});

		// *****************************************************
		cmdDevice1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					txtDevice1.setText("ÍØ»¡Ã³ì·Õè 1 à»Ô´");
				} else
					txtDevice1.setText("ÍØ»¡Ã³ì·Õè 1 »Ô´");
			}
		});

		cmdDevice2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					txtDevice2.setText("ÍØ»¡Ã³ì·Õè 2 à»Ô´");
				} else
					txtDevice2.setText("ÍØ»¡Ã³ì·Õè 2 »Ô´");
			}
		});

		cmdDevice3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					txtDevice3.setText("ÍØ»¡Ã³ì·Õè 3 à»Ô´");
				} else
					txtDevice3.setText("ÍØ»¡Ã³ì·Õè 3 »Ô´");
			}
		});

		cmdDevice4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					txtDevice4.setText("ÍØ»¡Ã³ì·Õè 4 à»Ô´");
				} else
					txtDevice4.setText("ÍØ»¡Ã³ì·Õè 4 »Ô´");
			}
		});

		cmdDevice5.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					txtDevice5.setText("ÍØ»¡Ã³ì·Õè 5 à»Ô´");
				} else
					txtDevice5.setText("ÍØ»¡Ã³ì·Õè 5 »Ô´");
			}
		});

	}

	/************************** IOIO CLASS ****************************************/
	public class Looper extends BaseIOIOLooper {

		public DigitalOutput LEDSTATUS;

		public DigitalOutput EN_Device1;
		public DigitalOutput EN_Device2;
		public DigitalOutput EN_Device3;
		public DigitalOutput EN_Device4;
		public DigitalOutput EN_Device5;

		public AnalogInput AN1;
		public AnalogInput AN2;
		public AnalogInput AN3;
		public AnalogInput AN4;
		public AnalogInput AN5;

		public DigitalOutput EN_LE;
		public DigitalOutput EN_OC;

		public DigitalInput ReadDevice1;
		public DigitalInput ReadDevice2;
		public DigitalInput ReadDevice3;
		public DigitalInput ReadDevice4;
		public DigitalInput ReadDevice5;

		public int P_ReadState = 3;
		public int i = 0;
		public Boolean en_latch = false;

		@Override
		protected void setup() throws ConnectionLostException,
				InterruptedException {
			LEDSTATUS = ioio_.openDigitalOutput(IOIO.LED_PIN, false);
			//EN_LE = ioio_.openDigitalOutput(38, true);

			ReadDevice1 = ioio_.openDigitalInput(7, Mode.PULL_DOWN);
			ReadDevice2 = ioio_.openDigitalInput(6, Mode.PULL_DOWN);
			ReadDevice3 = ioio_.openDigitalInput(5, Mode.PULL_DOWN);
			ReadDevice4 = ioio_.openDigitalInput(4, Mode.PULL_DOWN);
			ReadDevice5 = ioio_.openDigitalInput(3, Mode.PULL_DOWN);

			EN_Device1 = ioio_.openDigitalOutput(44, ReadDevice1.read());
			EN_Device2 = ioio_.openDigitalOutput(45, ReadDevice2.read());
			EN_Device3 = ioio_.openDigitalOutput(46, ReadDevice3.read());
			EN_Device4 = ioio_.openDigitalOutput(47, ReadDevice4.read());
			EN_Device5 = ioio_.openDigitalOutput(48, ReadDevice5.read());
			// Read state before

			if (ReadDevice1.read())
				ReadDeviceStatusBefore("On", 0);
			if (ReadDevice2.read())
				ReadDeviceStatusBefore("On", 1);
			if (ReadDevice3.read())
				ReadDeviceStatusBefore("On", 2);
			if (ReadDevice4.read())
				ReadDeviceStatusBefore("On", 3);
			if (ReadDevice5.read())
				ReadDeviceStatusBefore("On", 4);
			
			EN_OC = ioio_.openDigitalOutput(37, false);
			EN_LE = ioio_.openDigitalOutput(38,false);
			displaylabel("Connecting Success");
		}

		@Override
		public void loop() throws ConnectionLostException, InterruptedException {
			try {
				LEDSTATUS.write(false);				

				EN_Device1.write(cmdDevice1.isChecked());
				EN_Device2.write(cmdDevice2.isChecked());
				EN_Device3.write(cmdDevice3.isChecked());
				EN_Device4.write(cmdDevice4.isChecked());
				EN_Device5.write(cmdDevice5.isChecked());

				//EN_LE.write(true);
				
				latch();
				Thread.sleep(10);

			} catch (ConnectionLostException e) {
				ioio_.disconnect();
			}
		}

		@Override
		public void disconnected() {
			super.disconnected();
		}

		public void latch() throws ConnectionLostException, InterruptedException {
			if (en_latch) {
				EN_LE.write(false);				
				LEDSTATUS.write(true);
				
			} else {
				EN_LE.write(true);
				
			}
		}

		public void displaylabel(final String msg) {
			synchronized (msg) {
				runOnUiThread(new Runnable() {
					public void run() {
						Toast.makeText(getApplicationContext(), msg,
								Toast.LENGTH_LONG).show();
					}
				});
			}
		}

		public void ReadDeviceStatusBefore(final String label,
				final int deviceID) {
			runOnUiThread(new Runnable() {
				public void run() {
					switch (deviceID) {
					case 0:
						cmdDevice1.setChecked(label.equals("On"));
						if (label.equals("On"))
							txtDevice1.setText("ÍØ»¡Ã³ì·Õè 1 à»Ô´");
						break;
					case 1:
						cmdDevice2.setChecked(label.equals("On"));
						if (label.equals("On"))
							txtDevice2.setText("ÍØ»¡Ã³ì·Õè 2 à»Ô´");
						break;
					case 2:
						cmdDevice3.setChecked(label.equals("On"));
						if (label.equals("On"))
							txtDevice3.setText("ÍØ»¡Ã³ì·Õè 3 à»Ô´");
						break;
					case 3:
						cmdDevice4.setChecked(label.equals("On"));
						if (label.equals("On"))
							txtDevice4.setText("ÍØ»¡Ã³ì·Õè 4 à»Ô´");
						break;
					case 4:
						cmdDevice5.setChecked(label.equals("On"));
						if (label.equals("On"))
							txtDevice5.setText("ÍØ»¡Ã³ì·Õè 5 à»Ô´");
						break;
					}
				}
			});
		}

	}
	/************************** IOIO CLASS ****************************************/

}
