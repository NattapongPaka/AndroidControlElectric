package com.example.androidcontrolelectric;

import ioio.lib.api.AnalogInput;
import ioio.lib.api.DigitalInput;
import ioio.lib.api.DigitalInput.Spec.Mode;
import ioio.lib.api.DigitalOutput;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.BaseIOIOLooper;
import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

/*******************************************************************************************
 * 
 * Main Android Activity
 * 
 ********************************************************************************************/
public class MainActivity extends IOIOActivity {

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

	public ToggleButton cmdDevice1;
	public ToggleButton cmdDevice2;
	public ToggleButton cmdDevice3;
	public ToggleButton cmdDevice4;
	public ToggleButton cmdDevice5;

	public ToggleButton[] cmdDevice = new ToggleButton[] { cmdDevice1,
			cmdDevice2, cmdDevice3, cmdDevice4, cmdDevice5 };

	public TextView txtElectric;
	public TextView txtAmpere;
	public TextView txtWatt;

	public int Ampere;
	public int Electic;
	public int Watt;
	public int Voltage = 220;

	public int countDevice = 1;
	public int Device_ID = 0;

	public Boolean ExitApp;
	public Boolean ResumeApp;

	// public ProgressDialog dialogPro2;
	public ProgressDialog dialogConnectingIOIO;

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// Toast.makeText(getApplicationContext(), "Resume",
		// Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		// Toast.makeText(getApplicationContext(), "Pause",
		// Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		InitialSetting();

		dialogConnectingIOIO = new ProgressDialog(this);
		dialogConnectingIOIO.setMessage("Connecting IOIO ...");
		dialogConnectingIOIO.show();
	}

	@Override
	protected IOIOLooper createIOIOLooper() {
		// TODO Auto-generated method stub
		return new looper();
	}

	/************************************
	 * Test Function
	 * 
	 * @param title
//	 * @param Device
	 */
	public void ViewMore() {
		final Dialog dialog = new Dialog(MainActivity.this);
		// dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
		dialog.setContentView(R.layout.activity_view3);
		dialog.setTitle(" แสดงรายละเอียดเครื่องใช้ไฟฟ้า ");

		dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
				WindowManager.LayoutParams.MATCH_PARENT);
		dialog.show();
	}

	public void More(String title, String Device) {
		final Dialog dialog = new Dialog(MainActivity.this);
		dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);

		dialog.setContentView(R.layout.activity_view3);
		dialog.setTitle(title);
		dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
				WindowManager.LayoutParams.MATCH_PARENT);
		TextView device = (TextView) dialog.findViewById(R.id.txt_device_name);
		/*************************************************************/
		txtWatt = (TextView) dialog.findViewById(R.id.txtwatt);
		txtAmpere = (TextView) dialog.findViewById(R.id.txtamp);
		txtElectric = (TextView) dialog.findViewById(R.id.txtElectic);
		/*************************************************************/

		device.setText(Device);
		dialog.show();

		dialog.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,
				R.drawable.ic_launcher);
	}

	public void InitialSetting() {

		// Create Variable
		// *****************************************************
		countDevice = 1;
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
				// More("แสดงรายละเอียดอุปกรณ์", "อุปกรณ์ 1");
				ViewMore();
			}
		});

		viewDevice2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// More("แสดงรายละเอียดอุปกรณ์", "อุปกรณ์ 2");
				ViewMore();
			}
		});

		viewDevice3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// More("แสดงรายละเอียดอุปกรณ์", "อุปกรณ์ 3");
				ViewMore();
			}
		});

		viewDevice4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// More("แสดงรายละเอียดอุปกรณ์", "อุปกรณ์ 4");
				ViewMore();
			}
		});

		viewDevice5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// More("แสดงรายละเอียดอุปกรณ์", "อุปกรณ์ 5");
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
					txtDevice1.setText("อุปกรณ์ที่ 1 เปิด");
				} else
					txtDevice1.setText("อุปกรณ์ที่ 1 ปิด");
			}
		});

		cmdDevice2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					txtDevice2.setText("อุปกรณ์ที่ 2 เปิด");
				} else
					txtDevice2.setText("อุปกรณ์ที่ 2 ปิด");
			}
		});

		cmdDevice3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					txtDevice3.setText("อุปกรณ์ที่ 3 เปิด");
				} else
					txtDevice3.setText("อุปกรณ์ที่ 3 ปิด");
			}
		});

		cmdDevice4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					txtDevice4.setText("อุปกรณ์ที่ 4 เปิด");
				} else
					txtDevice4.setText("อุปกรณ์ที่ 4 ปิด");
			}
		});

		cmdDevice5.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					txtDevice5.setText("อุปกรณ์ที่ 5 เปิด");
				} else
					txtDevice5.setText("อุปกรณ์ที่ 5 ปิด");
			}
		});

	}

	@Override
	public void onBackPressed() {
		ExitApp = true;

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("ออกจากแอพพลิเคชั่นหรือไม่")

				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								MainActivity.super.onBackPressed();
								finish();
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();

	}

	/*******************************************************************************************
	 * 
	 * Main Class IOIO Acvitity
	 * 
	 ********************************************************************************************/
	public class looper extends BaseIOIOLooper {

		public DigitalOutput PStatus;

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
		public DigitalInput[] ReadDevice = new DigitalInput[5];

		public int P_ReadState = 3;
		public int i = 0;

		@Override
		protected void setup() throws ConnectionLostException,
				InterruptedException {
			/****************************************************************
			 * Init AnalogInput
			 *****************************************************************/
			AN1 = ioio_.openAnalogInput(31);
			AN2 = ioio_.openAnalogInput(32);
			AN3 = ioio_.openAnalogInput(33);
			AN4 = ioio_.openAnalogInput(34);
			AN5 = ioio_.openAnalogInput(35);
			/****************************************************************
			 * Init DigitalOutput
			 *****************************************************************/
			EN_Device1 = ioio_.openDigitalOutput(44,
					DigitalOutput.Spec.Mode.NORMAL, false);
			EN_Device2 = ioio_.openDigitalOutput(45,
					DigitalOutput.Spec.Mode.NORMAL, false);
			EN_Device3 = ioio_.openDigitalOutput(46,
					DigitalOutput.Spec.Mode.NORMAL, false);
			EN_Device4 = ioio_.openDigitalOutput(47,
					DigitalOutput.Spec.Mode.NORMAL, false);
			EN_Device5 = ioio_.openDigitalOutput(48,
					DigitalOutput.Spec.Mode.NORMAL, false);

			PStatus = ioio_.openDigitalOutput(0,
					DigitalOutput.Spec.Mode.NORMAL, false);

			// Enable data to ic latch 74ls373
			EN_LE = ioio_.openDigitalOutput(38, DigitalOutput.Spec.Mode.NORMAL,
					true);

			// Read state before
			for (i = 0; i < ReadDevice.length; i++) {
				ReadDevice[i] = ioio_.openDigitalInput(P_ReadState + i,
						Mode.PULL_DOWN);
				if (ReadDevice[i].read()) {
					ReadDeviceStatusBefore("On", i);
				} else {
					ReadDeviceStatusBefore("Off", i);
				}
			}

			// Show message connecting ioio success
			runOnUiThread(new Runnable() {
				public void run() {
					dialogConnectingIOIO.dismiss();
					Toast.makeText(getBaseContext(), "Connecting Seccess",
							Toast.LENGTH_LONG).show();
				}
			});
		}

		public void ReadDeviceStatusBefore(final String label,
				final int deviceID) {
			runOnUiThread(new Runnable() {

				public void run() {
					switch (deviceID) {
					case 0:
						cmdDevice1.setChecked(label.equals("On"));
						if (label.equals("On"))
							txtDevice1.setText("อุปกรณ์ที่ 1 เปิด");
						break;
					case 1:
						cmdDevice2.setChecked(label.equals("On"));
						if (label.equals("On"))
							txtDevice2.setText("อุปกรณ์ที่ 2 เปิด");
						break;

					case 2:
						cmdDevice3.setChecked(label.equals("On"));
						if (label.equals("On"))
							txtDevice3.setText("อุปกรณ์ที่ 3 เปิด");
						break;
					case 3:
						cmdDevice4.setChecked(label.equals("On"));
						if (label.equals("On"))
							txtDevice4.setText("อุปกรณ์ที่ 4 เปิด");
						break;
					case 4:
						cmdDevice5.setChecked(label.equals("On"));
						if (label.equals("On"))
							txtDevice5.setText("อุปกรณ์ที่ 5 เปิด");
						break;
					}
				}
			});
		}

		@Override
		public void disconnected() {
			// TODO Auto-generated method stub
			super.disconnected();
		}

		@Override
		public void loop() throws ConnectionLostException, InterruptedException {
			// TODO Auto-generated method stub
			try {
				if (ExitApp == true) {
					PStatus.write(false);
					EN_LE.write(false);
					ExitApp = false;
					DisplayLabel("LATCH ON");
				}
				
				PStatus.write(true);

				// Set device enable
				EN_Device1.write(cmdDevice1.isChecked());
				EN_Device2.write(cmdDevice2.isChecked());
				EN_Device3.write(cmdDevice3.isChecked());
				EN_Device4.write(cmdDevice4.isChecked());
				EN_Device5.write(cmdDevice5.isChecked());

				if (cmdDevice1.isChecked())
					DisplayLabel("Btn1_Click");
				// Get Amp

				// Get Watt

				Thread.sleep(10);
			} catch (InterruptedException e) {
				// PStatus.write(false);
				// EN_LE.write(false);
				ioio_.disconnect();
			} catch (ConnectionLostException ex) {
				// PStatus.write(false);
				// EN_LE.write(false);
				ioio_.disconnect();
			}
		}

		public void DisplayLabel(final String msg) {
			runOnUiThread(new Runnable() {
				public void run() {
					Toast.makeText(getApplicationContext(), msg,
							Toast.LENGTH_LONG).show();
				}
			});
		}
	}
}
