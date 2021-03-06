package com.example.accident_alert_system;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.location.Location;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Home_Page extends Activity {
	Button loc,vloc,vdang,comp,hosp,vio,log,b7;
	
	double lat,lon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home__page);
		loc=(Button)findViewById(R.id.button1);
		vloc=(Button)findViewById(R.id.button2);
		vdang=(Button)findViewById(R.id.button3);
		comp=(Button)findViewById(R.id.button4);
		hosp=(Button)findViewById(R.id.button5);
		vio=(Button)findViewById(R.id.button6);
		log=(Button)findViewById(R.id.button9);
		
		
		 Gpstracker gp=new Gpstracker(getApplicationContext());
			lat=gp.getLatitude();
			lon=gp.getLongitude();
		
		new getjson2().execute();
		
		loc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(), Set_Location_Alerts.class);
				startActivity(i);
			}
		});
		
		

		
		vloc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(), View_Location_Based_Alert.class);
				startActivity(i);
				
			}
		});
		
		vdang.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(), View_dang_loctn_based_alert.class);
				startActivity(i);
				
			}
		});
		comp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(), Post_Complaint_admin.class);
				startActivity(i);
				
			}
		});
		hosp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(), View_nearest_hospital_details.class);
				startActivity(i);
			}
		});
		
		vio.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(), View_traffic_violation_details.class);
				startActivity(i);
			}
		});
		log.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Login.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);
			
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home__page, menu);
		return true;
	}

	private class getjson2 extends AsyncTask<Void, Void, Void>{
		ArrayList<HashMap<String,String>> al=new ArrayList<HashMap<String,String>>();
				@Override
				protected Void doInBackground(Void... params) {
					// TODO Auto-generated method stub
					String url = "http://192.168.43.159:8000/dangerous_location/android2/";
					JSONArray jdata=JsonHandler.GetJson(url);
					if(jdata!=null)
					{
						try {
						for (int i = 0; i < jdata.length(); i++) {
		                    JSONObject c;
							c = jdata.getJSONObject(i);
							
									


		                    String latitude = c.getString("latitude");
		                    String longtitude = c.getString("longtitude");
		                    
		                    
		                    HashMap<String, String> contact =  new HashMap<String, String>();
		                    contact.put("latitude", latitude);
		                    contact.put("longtitude", longtitude);
		                    
		                   
					
						
							double lat2=Double.parseDouble(contact.get("latitude"));
							double lon2=Double.parseDouble(contact.get("longtitude"));
//							
							Location locationA = new Location("point A");
							Location locationB = new Location("point B");
//							
//							
//										
										locationA.setLatitude(lat);
										locationA.setLongitude(lon);
										locationB.setLatitude(lat2);
										locationB.setLongitude(lon2);
//						
//										
										float distance = locationA.distanceTo(locationB);
										float kmm = distance / 1000;
										if (kmm < 100 )
										{
//											
											   addNotification();
										}
		                 
		                    	

		                    
		                }
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						
						}
					}
					else
					{
						
					}
					return null;
				}
				
				@Override
			      protected void onPostExecute(Void result) {
			         super.onPostExecute(result);
			         
			       
			      }
			}


private void addNotification() {
 AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
 audioManager.setStreamVolume(
			AudioManager.STREAM_RING, 10,
			AudioManager.FLAG_ALLOW_RINGER_MODES
					| AudioManager.FLAG_PLAY_SOUND);
  NotificationCompat.Builder builder =
     new NotificationCompat.Builder(this)
     .setSmallIcon(R.drawable.l)
     .setContentTitle("Alert")
     .setContentText("Dangerous Area");

  Intent notificationIntent = new Intent(this,View_Location_Based_Alert.class);
  PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
     PendingIntent.FLAG_UPDATE_CURRENT);
  builder.setContentIntent(contentIntent);

  // Add as notification
  NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
  manager.notify(0, builder.build());
}


}
