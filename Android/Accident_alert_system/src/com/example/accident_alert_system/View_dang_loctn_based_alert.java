package com.example.accident_alert_system;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class View_dang_loctn_based_alert extends Activity {
	ListView li;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_dang_loctn_based_alert);
		li=(ListView)findViewById(R.id.listView1);
		new getjson2().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_dang_loctn_based_alert, menu);
		return true;
	}
	
	private class getjson2 extends AsyncTask<Void, Void, Void>{
		ArrayList<HashMap<String,String>> al=new ArrayList<HashMap<String,String>>();
				@Override
				protected Void doInBackground(Void... params) {
					// TODO Auto-generated method stub
					String url = "http://192.168.43.159:8000/dangerous_location/android/";
					JSONArray jdata=JsonHandler.GetJson(url);
					if(jdata!=null)
					{
						try {
						for (int i = 0; i < jdata.length(); i++) {
		                    JSONObject c;
							c = jdata.getJSONObject(i);
		                    String alert = c.getString("alert");
		                    String date = c.getString("date");
		                    String time = c.getString("time");
		                    String location = c.getString("location");
		                    

		                    
		                    HashMap<String, String> contact =  new HashMap<String, String>();
		                    contact.put("alert", alert);
		                    contact.put("date", date);
		                    contact.put("time", time);
		                    contact.put("location", location);
		                   

		                   
		                    
//		                    if(h_id.equals(cid))
//		                    {
		                    al.add(contact);
//		                   }
		                   
		                }
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							Toast.makeText(getApplicationContext(), "Not  Registered yet...!", 3).show();
							
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
			         ListAdapter adapter = new SimpleAdapter(View_dang_loctn_based_alert.this, al,
			            R.layout.view_dang, new String[]{ "alert","date","time","location"}, 
			            new int[]{R.id.textView5, R.id.textView6,R.id.textView7,R.id.textView8});
			         li.setAdapter(adapter);
			      }
			}
	
	

}
