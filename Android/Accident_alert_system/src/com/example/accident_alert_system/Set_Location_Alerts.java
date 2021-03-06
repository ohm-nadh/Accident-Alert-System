package com.example.accident_alert_system;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.accident_alert_system.Post_Complaint_admin.savejson;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.DialogInterface;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Set_Location_Alerts extends Activity implements OnInitListener {
	TextView myLabel;

	BluetoothAdapter mBluetoothAdapter;
	BluetoothSocket mmSocket;
	BluetoothDevice mmDevice;
	OutputStream mmOutputStream;
	InputStream mmInputStream;
	Thread workerThread;
	byte[] readBuffer;
	int readBufferPosition;
	int counter;
	String outp = "";
	volatile boolean stopWorker;
	EditText iptxt;
	
	double lat,lon;
	
	private TextToSpeech repeatTTS;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set__location__alerts);
		
		
		 repeatTTS = new TextToSpeech(this, this);

		Button openButton = (Button) findViewById(R.id.button1);
		Button closeButton = (Button) findViewById(R.id.button3);
		iptxt = (EditText) findViewById(R.id.editText1);

		repeatTTS.speak("Keep Distance....",
				TextToSpeech.QUEUE_FLUSH, null);

		Gpstracker g=new Gpstracker(getApplicationContext());
		 lat=g.getLatitude();
		 lon=g.getLongitude();
		 
	 	 Toast.makeText(getApplicationContext(), lat+ " "+lon, 3).show();


		myLabel = (TextView) findViewById(R.id.textView1);
		//outtext = (TextView) findViewById(R.id.textView2);
	
		openButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				try {
					findBT();
					openBT();
				} catch (IOException ex) {
				}

			}
		});
		

		closeButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				try {
					closeBT();
				} catch (IOException ex) {
				}

			}
		});
	}

	
	
	

	void findBT() throws IOException {
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		if (mBluetoothAdapter == null) {
			myLabel.setText("No bluetooth adapter available");
		}

		if (!mBluetoothAdapter.isEnabled()) {
			Intent enableBluetooth = new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableBluetooth, 0);
		}

		Set<BluetoothDevice> pairedDevices = mBluetoothAdapter
				.getBondedDevices();
		if (pairedDevices.size() > 0) {
			for (BluetoothDevice device : pairedDevices) {
				if (device.getName().equals("HC-05")) {
					mmDevice = device;
					break;
				}
			}
		}
		myLabel.setText("Bluetooth Device Found");

	}

	void openBT() throws IOException {
		UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // Standard
																				// SerialPortService
																				// ID
		mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
		mmSocket.connect();
		mmOutputStream = mmSocket.getOutputStream();
		mmInputStream = mmSocket.getInputStream();

		beginListenForData();

		myLabel.setText("Bluetooth Opened");
	}

	void beginListenForData() {
		final Handler handler = new Handler();
		final byte delimiter = 10; // This is the ASCII code for a newline
									// character

		stopWorker = false;
		readBufferPosition = 0;
		readBuffer = new byte[1024];
		workerThread = new Thread(new Runnable() {
			public void run() {
				while (!Thread.currentThread().isInterrupted() && !stopWorker) {
					try {
						int bytesAvailable = mmInputStream.available();

						if (bytesAvailable > 0) {
							byte[] packetBytes = new byte[bytesAvailable];
							int byts = mmInputStream.read(packetBytes);
							final String strReceived = new String(packetBytes,
									0, byts);
							handler.post(new Runnable() {
								public void run() {
									outp = outp + strReceived.trim();
									iptxt.setText(outp);
									
									
									if (strReceived.contains("B") ) {
										
										
										new savejson().execute();
																		
									}
									
										if (strReceived.contains("O") ) {
										
										
										//beep
											
											repeatTTS.speak("Keep Distance....",
													TextToSpeech.QUEUE_FLUSH, null);
														
											 Toast.makeText(getApplicationContext(), "Vehicle Infront...", 3).show();
									}
										
										if (strReceived.contains("A") ) {
											
//											//motification
											
											
											ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 200);
											toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 100); 
											
											
											showAlertDialog();
											
											
											
//											new savejson().execute();
																			
										}

								}
							});

						}
					} catch (IOException ex) {
						Toast.makeText(getApplicationContext(), "stop", 5)
								.show();
						stopWorker = true;
					}
				}
			}
		});

		workerThread.start();
	}
//	private void sendSMS(String phoneNumber, String message) {
//		Toast.makeText(getApplicationContext(), "gshg", 3).show();
//	    SmsManager sms = SmsManager.getDefault();
//	    sms.sendTextMessage(phoneNumber, null, message, null, null);
//	}
//	void sendData(String msg) throws IOException {
//		// String msg = myTextbox.getText().toString();
//		// msg += "\n";
//		mmOutputStream.write(msg.getBytes());
//		myLabel.setText(msg);
//	}

	void closeBT() throws IOException {
		stopWorker = true;
		mmOutputStream.close();
		mmInputStream.close();
		mmSocket.close();
		myLabel.setText("Bluetooth Closed");
	}

	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.set__location__alerts, menu);
		return true;
	}
	public class savejson extends AsyncTask<Void, Void, Void>{
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			String url = "http://192.168.43.159:8000/complaint/android2/";
			JSONObject jobj= new JSONObject();
	        try {
	        	
	        	

	   
				jobj.put("lat",lat);
				jobj.put("lon", lon);
				
				jobj.put("uid", Login.uid);
				
				
				  
				
				JsonHandler.Postjson(url, jobj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null; 
		}
		
		@Override
	      protected void onPostExecute(Void result) {
	         super.onPostExecute(result);
	    
	         
	        	 Toast.makeText(getApplicationContext(), "Alert Send...", 3).show();

	     
	      }
	}
	@Override
	public void onInit(int arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	public void showAlertDialog() {
		AlertDialog dialog = new AlertDialog.Builder(this)
        .setTitle("Alert...")
        .setMessage("Do you really want to send alert..?")
        .setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO: Add positive button action code here
            	
            	 Toast.makeText(getApplicationContext(), "Dismissed", 3).show();
            	 
            	 
            }
        })
        .setNegativeButton("Send", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
			   	            	 
            	 
            		new savejson().execute();
         		
			}
		})
        .create();
dialog.setOnShowListener(new DialogInterface.OnShowListener() {
    private static final int AUTO_DISMISS_MILLIS = 6000;
    @Override
    public void onShow(final DialogInterface dialog) {
        final Button defaultButton = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_NEGATIVE);
        final CharSequence negativeButtonText = defaultButton.getText();
        new CountDownTimer(AUTO_DISMISS_MILLIS, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                defaultButton.setText(String.format(
                        Locale.getDefault(), "%s (%d)",
                        negativeButtonText,
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) + 1 //add one so it never displays zero
                ));
            }
            @Override
            public void onFinish() {
                if (((AlertDialog) dialog).isShowing()) {
                    dialog.dismiss();
                    
                	new savejson().execute();
                }
            }
        }.start();
    }
});
dialog.show();


	}

}
