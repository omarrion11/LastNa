package ucu.edu.ccs.ie_dictionary;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class WordAdapter extends ArrayAdapter<Words>{
	ArrayList<Words> Dictionarylist;
	LayoutInflater vi;
	int Resource;
	ViewHolder holder;
	
	public WordAdapter(Context context, int resource, ArrayList<Words> Dictionarylist) {
		super(context, resource, Dictionarylist);
		vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Resource = resource;
		this.Dictionarylist = Dictionarylist;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// convert view = design
		View v = convertView;
		if (v == null) {
			holder = new ViewHolder();
			v = vi.inflate(Resource, null);
		
			holder.name = (TextView) v.findViewById(R.id.name);
	
			v.setTag(holder);
		} else {
			holder = (ViewHolder) v.getTag();
		}

		holder.name.setText(Dictionarylist.get(position).getTitle());
		
		
		return v;

	}
	
	static class ViewHolder {
		
		public TextView name;
		

	}
	
	

}


