package ucu.edu.ccs.ie_dictionary;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView lstview;
	ArrayList<Words> Dictionarylist;
	WordAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Dictionarylist = new ArrayList<Words>();
		new JSONAsyncTask().execute("http://ucu-ie-dictionary.netii.net/meanings2.json");

		lstview = (ListView) findViewById(R.id.lstview);
		adapter = new WordAdapter(MainActivity.this,R.layout.list, Dictionarylist);
		lstview.setAdapter(adapter);
		
		
		
		lstview.setOnItemClickListener(new OnItemClickListener(){

			
			
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				

				String title = Dictionarylist.get(position).getTitle();
	

				
				Intent intent = new Intent(MainActivity.this, Wordsearch.class);

				intent.putExtra("name", title);
				
				
				startActivity(intent);
				
				
			}

			});

		
	}
	
	
	

	






class JSONAsyncTask extends AsyncTask<String, Void, String> {

		ProgressDialog dialog;

		@Override
		protected String doInBackground(String... urls) {

			try {
				HttpGet httppost = new HttpGet(urls[0]);
				HttpClient httpclient = new DefaultHttpClient();
				HttpResponse response = httpclient.execute(httppost);

				HttpEntity entity = response.getEntity();
				String data = EntityUtils.toString(entity, "UTF-8");

				JSONObject collectionObject = new JSONObject(data);
				JSONArray bookarray = collectionObject.getJSONArray("word");

				for (int i = 0; i < bookarray.length(); i++) {
					JSONObject object = bookarray.getJSONObject(i);

					Words word = new Words();

			
					word.setTitle(object.getString("name"));
					
					

					Dictionarylist.add(word);

				}

			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
			
			
			
			

		}
		
		

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog = new ProgressDialog(MainActivity.this);
			dialog.setTitle("Loading");
			dialog.setMessage("Please wait...");
			dialog.show();
			dialog.setCancelable(false);
		}

		protected void onPostExecute(String result) {
			dialog.cancel();
			adapter.notifyDataSetChanged();
			
			
				

			
			
		}
		
		
	}


	
}