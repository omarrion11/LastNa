package ucu.educcs.englishilokanodictionary;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ListView lv;
	EditText txtsearch;

	ArrayAdapter<String> adapter;
	ArrayList<HashMap<String, String>> wordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        
        String dictionary[] = { "Angry", "Ascend", "Again", "Afternoon",
				"Arrive", "Air", "Alone", "Athletes Foot","Baby","Book","Birthday","Bread Fruit","Beautiful"
				,"But","Bright","Baptism"
		 };
        
        
        
        lv = (ListView) findViewById(R.id.lv);
       
		txtsearch = (EditText) findViewById(R.id.txtsearch);

		adapter = new ArrayAdapter<String>(this, R.layout.list_item,
				R.id.word, dictionary);
		lv.setAdapter(adapter);

		txtsearch.addTextChangedListener(new TextWatcher() {

			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub

			}

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			public void onTextChanged(CharSequence cs, int arg1, int arg2,
					int arg3) {
				MainActivity.this.adapter.getFilter().filter(cs);

			}
		});
        
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				String select = (String) (lv.getItemAtPosition(position));

				if (select.equals("Angry")) {
					Intent intent = new Intent(getApplicationContext(),
							Angry.class);
					startActivity(intent);
				} else if (select.equals("Ascend")) {
					Intent intent = new Intent(getApplicationContext(),
							Ascend.class);
					startActivity(intent);
				}else if (select.equals("Again")) {
						Intent intent = new Intent(getApplicationContext(),
								Again.class);
						startActivity(intent);
				}else if (select.equals("Afternoon")) {
					Intent intent = new Intent(getApplicationContext(),
							Afternoon.class);
					startActivity(intent);
				}else if (select.equals("Arrive")) {
					Intent intent = new Intent(getApplicationContext(),
							Arrive.class);
					startActivity(intent);
				}else if (select.equals("Air")) {
					Intent intent = new Intent(getApplicationContext(),
							Air.class);
					startActivity(intent);
				}else if (select.equals("Alone")) {
					Intent intent = new Intent(getApplicationContext(),
							Alone.class);
					startActivity(intent);
				}else if (select.equals("Athletes Foot")) {
					Intent intent = new Intent(getApplicationContext(),
							Athletes_foot.class);
					startActivity(intent);
				}else if (select.equals("Baby")) {
					Intent intent = new Intent(getApplicationContext(),
							Baby.class);
					startActivity(intent);
				}else if (select.equals("Book")) {
					Intent intent = new Intent(getApplicationContext(),
							Book.class);
					startActivity(intent);
				}else if (select.equals("Birthday")) {
					Intent intent = new Intent(getApplicationContext(),
							Birthday.class);
					startActivity(intent);
				}else if (select.equals("Bread Fruit")) {
					Intent intent = new Intent(getApplicationContext(),
							Bread_fruit.class);
					startActivity(intent);
        
        
    }


			}
		});


    
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
