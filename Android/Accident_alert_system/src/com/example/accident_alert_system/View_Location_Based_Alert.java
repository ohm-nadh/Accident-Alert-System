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

public class View_Location_Based_Alert extends Activity {
	ListView li;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view__location__based__alert);
		li=(ListView)findViewById(R.id.listView1);
		new getjson2().execute();
		
		li.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				HashMap<String,String> hmap=(HashMap<String, String>)arg0.getItemAtPosition(arg2);
				String lat=hmap.get("latitude");
				String lon=hmap.get("longtitude");
				
				

				String	url="https://www.google.co.in/maps/place/"+lat+"+"+lon+"/@"+lat+","+lon+",19z";
	           	 try{
	            		 Intent i = new Intent(Intent.ACTION_VIEW);
					i.setData(Uri.parse(url));
					startActivity(i);
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
		getMenuInflater().inflate(R.menu.view__location__based__alert, menu);
		return true;
	}
	private class getjson2 extends AsyncTask<Void, Void, Void>{
		ArrayList<HashMap<String,String>> al=new ArrayList<HashMap<String,String>>();
				@Override
				protected Void doInBackground(Void... params) {
					// TODO Auto-generated method stub
					String url = "http://192.168.43.159:8000/location/android/";
					JSONArray jdata=JsonHandler.GetJson(url);
					if(jdata!=null)
					{
						try {
						for (int i = 0; i < jdata.length(); i++) {
		                    JSONObject c;
							c = jdata.getJSONObject(i);
		                    String latitude = c.getString("latitude");
		                    String longtitude = c.getString("longtitude");
		                    String location = c.getString("location");
		                    
		                    
		                    HashMap<String, String> contact =  new HashMap<String, String>();
		                    contact.put("latitude", latitude);
		                    contact.put("longtitude", longtitude);
		                    contact.put("location", location);
		                    

		                   
		                    
		                   // if(h_id.equals(cid))
//		                    {
		                    al.add(contact);
//		                   }
		                   
		                }
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							Toast.makeText(getApplicationContext(), "Not Registered yet...!", 3).show();
							
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
			         ListAdapter adapter = new SimpleAdapter(View_Location_Based_Alert.this, al,
			            R.layout.view_loc, new String[]{ "latitude","longtitude","location"}, 
			            new int[]{R.id.textView4, R.id.textView5,R.id.textView6,});
			         li.setAdapter(adapter);
			      }
			}
	
}
