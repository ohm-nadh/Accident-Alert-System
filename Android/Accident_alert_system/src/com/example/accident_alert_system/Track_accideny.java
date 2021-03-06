package com.example.accident_alert_system;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Track_accideny extends Activity {
	ListView l1;
	String rid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_track_accideny);
		
		

		l1=(ListView)findViewById(R.id.listView1);
		
		new getjson2().execute();
		
		
		l1.setOnItemClickListener(new OnItemClickListener() {


			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				
				HashMap<String,String> hmap=(HashMap<String, String>)arg0.getItemAtPosition(arg2);
				String lat=hmap.get("latitude");
				rid=hmap.get("r_id");
				String lon=hmap.get("longtitude");
				
				

				String	url="https://www.google.co.in/maps/place/"+lat+"+"+lon+"/@"+lat+","+lon+",19z";
	           	 try{
	            		 Intent i = new Intent(Intent.ACTION_VIEW);
					i.setData(Uri.parse(url));
					startActivity(i);
					
					new savejson().execute();
					
	           	     }
	            catch (Exception e) {
			// TODO: handle exception
	          	  	Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
	            }
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.track_accideny, menu);
		return true;
	}

	
	

	

	private class getjson2 extends AsyncTask<Void, Void, Void>{
		ArrayList<HashMap<String,String>> al=new ArrayList<HashMap<String,String>>();
				@Override
				protected Void doInBackground(Void... params) {
					// TODO Auto-generated method stub
					String url = "http://192.168.43.159:8000/complaint/android2/";
					JSONArray jdata=JsonHandler.GetJson(url);
					if(jdata!=null)
					{
						try {
						for (int i = 0; i < jdata.length(); i++) {
		                    JSONObject c;
							c = jdata.getJSONObject(i);
							
									
		                    String r_id = c.getString("r_id");	                    
		                    String name = c.getString("name");
		                    String place = c.getString("place");
		                    String accident_alert = c.getString("accident_alert");
		                    String time = c.getString("time");	                    
		                    String date = c.getString("date");
		                    String latitude = c.getString("latitude");
		                    String longtitude = c.getString("longtitude");

		                    
		                    HashMap<String, String> contact =  new HashMap<String, String>();
		                    contact.put("r_id", r_id);
		                    contact.put("name", name);
		                    contact.put("place", place);
		                    contact.put("accident_alert", accident_alert);
		                    contact.put("time", time);
		                    contact.put("date", date);
		                    contact.put("latitude", latitude);
		                    contact.put("longtitude", longtitude);
	
		                    	al.add(contact);
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
			         
			         Toast.makeText(getApplicationContext(), "Click to Track...", Toast.LENGTH_LONG).show();
			         
			         ListAdapter adapter = new SimpleAdapter(Track_accideny.this, al,
			            R.layout.accident, new String[]{ "name","place","accident_alert","time","date"}, 
			               new int[]{R.id.textView5,R.id.textView6,R.id.textView7,R.id.textView8,R.id.textView10});
			         l1.setAdapter(adapter);
			      }
			}
	
	public class savejson extends AsyncTask<Void, Void, Void>{
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			String url = "http://192.168.43.159:8000/complaint/android3/";
			JSONObject jobj= new JSONObject();
	        try {
	        	
	        	

	   
				
				jobj.put("rid", rid);
				
				
				  
				
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
	    
	         
	        	 Toast.makeText(getApplicationContext(), "Data Cleared...", 3).show();

	     
	      }
	}
}
