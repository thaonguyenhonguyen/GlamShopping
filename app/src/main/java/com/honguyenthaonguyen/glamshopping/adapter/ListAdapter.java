package com.honguyenthaonguyen.glamshopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.honguyenthaonguyen.glamshopping.ItemSetting;
import com.honguyenthaonguyen.glamshopping.R;

import java.util.List;

/**
 * Created by NGUYEN on 6/14/2016.
 */
public class ListAdapter extends ArrayAdapter<ItemSetting> {

    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<ItemSetting> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.fragment_settings_item, null);
        }

        ItemSetting p = getItem(position);

        if (p != null) {
            // Anh xa + Gan gia tri
            TextView tt1 = (TextView) v.findViewById(R.id.textViewItemName);
            tt1.setText(p.title);
        }

        return v;
    }

}
