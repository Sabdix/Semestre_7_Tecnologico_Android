
package com.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.mainprincipal.R;
import java.util.ArrayList;

/**
 *
 * @author sabdi
 */
public abstract class AdapterCategory extends BaseAdapter {
    
    protected Activity activity;
    protected ArrayList<Category> items;
    
    public AdapterCategory(Activity activity, ArrayList<Category> items) {
        this.activity = activity;
        this.items = items;
    }

    public int getCount() {
        return items.size();
    }
    
    public void clear() {
        items.clear();
    }
    
    public void addAll(ArrayList<Category> category) {
        for (int i=0; i<category.size(); i++) {
            items.add(category.get(i));
        }
    }

    public Object getItem(int position) {
        return items.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
       View v = convertView;
       
       if (convertView == null) {
           LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           v = inf.inflate(R.layout.renglon_video, null);
       }
       
       renglonLista(v, position);
       
       return v;
    }
    
    abstract public void renglonLista(View view, int pos);
    
}
