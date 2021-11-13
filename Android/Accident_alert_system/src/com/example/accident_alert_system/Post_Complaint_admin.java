package com.example.accident_alert_system;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.accident_alert_system.Register.savejson;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Post_Complaint_admin extends Activity {
	EditText cmp;
	Button brse,post,reply;
    ImageView img;
    ListView li;
    protected static final int CAMERA_REQUEST = 0;

	protected static final int PICK_IMAGE_REQUEST = 0;
	Bitmap bitmap;
	String img_str,s;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post__complaint_admin);
		cmp=(EditText)findViewById(R.id.editText1);
		brse=(Button)findViewById(R.id.button2);
		post=(Button)findViewById(R.id.button1);
		reply=(Button)findViewById(R.id.button3);
		img=(ImageView)findViewById(R.id.imageView1);
		li=(ListView)findViewById(R.id.listView1);
		
		brse.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent cameraIntent = new Intent(
						android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(cameraIntent, CAMERA_REQUEST);
				
			}
		});
		post.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!cmp.getText().toString().equals("")) 
				{
				    new savejson().execute();
				}
				else
				{

		        	 Toast.makeText(getApplicationContext(), "ALL FIELDS ARE MANDATORY", 3).show();
				}
			}
		});
		reply.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new getjson2().execute();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.post__complaint_admin, menu);
		return true;
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		
		if (requestCode == CAMERA_REQUEST
				&& resultCode == Activity.RESULT_OK) {
			Bitmap photo = (Bitmap) data.getExtras().get("data");
			img.setImageBitmap(photo);
			try {
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				photo.compress(Bitmap.CompressFormat.JPEG, 90, stream);
				byte[] image = stream.toByteArray();
				img_str = Base64.encodeToString(image, 0);
			} catch (Exception e) {
				// TODO: handle exception
			}
		
			
		}
		
			
	}
	

	 public class savejson extends AsyncTask<Void, Void, Void>{
			@Override
			protected Void doInBackground(Void... params) {
				// TODO Auto-generated method stub
				String url = "http://192.168.43.159:8000/complaint/android/";
				JSONObject jobj= new JSONObject();
		        try {
		            
		        	jobj.put("u_id",Login.uid);
					jobj.put("complaint",cmp.getText().toString());
					jobj.put("image",img_str);
//					jobj.put("reply","pending");
					
					  
					
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
		    
		         
		        	 Toast.makeText(getApplicationContext(), "success", 3).show();

//		        	 Intent ii=new Intent(getApplicationContext(),.class);
//		        	 startActivity(ii);
		     
		      }
		}
		
	 private class getjson2 extends AsyncTask<Void, Void, Void>{
			ArrayList<HashMap<String,String>> al=new ArrayList<HashMap<String,String>>();
					@Override
					protected Void doInBackground(Void... params) {
						// TODO Auto-generated method stub
						String url = "http://192.168.43.159:8000/complaint/android/";
						JSONArray jdata=JsonHandler.GetJson(url);
						if(jdata!=null)
						{
							try {
							for (int i = 0; i < jdata.length(); i++) {
			                    JSONObject c;
								c = jdata.getJSONObject(i);
			                    String complaint = c.getString("complaint");
			                    String date = c.getString("date");
			                    String reply = c.getString("reply");
			                    String idd = c.getString("u_id");

			                    

			                    
			                    HashMap<String, String> contact =  new HashMap<String, String>();
			                    contact.put("complaint", complaint);
			                    contact.put("date", date);
			                    contact.put("reply", reply);
			                    contact.put("u_id", idd);

			                    
			                    if(idd.equals(Login.uid))
//			                    if(Login.uid.equals(u_id))
			                    {
			                    al.add(contact);
			                   }
			                   
			                }
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								Toast.makeText(getApplicationContext(), "No Doctors Registered yet...!", 3).show();
								
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
				         ListAdapter adapter = new SimpleAdapter(Post_Complaint_admin.this, al,
				            R.layout.reply, new String[]{ "complaint","date","reply"}, 
				            new int[]{R.id.textView4, R.id.textView5,R.id.textView6});
				         li.setAdapter(adapter);
				      }
				}
}
