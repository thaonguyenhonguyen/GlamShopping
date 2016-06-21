package com.honguyenthaonguyen.glamshopping;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.honguyenthaonguyen.glamshopping.adapter.ListAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 13/06/2016.
 */
public class FragmentSettings extends Fragment{

    ListView listViewItemsSetting;
    ArrayList<ItemSetting> arrayListSettingsItems;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings,container,false);
        listViewItemsSetting = (ListView) view.findViewById(R.id.listViewItemsSetting);

        arrayListSettingsItems = new ArrayList<ItemSetting>();
        arrayListSettingsItems.add(new ItemSetting("Email"));
        arrayListSettingsItems.add(new ItemSetting("Terms & Conditions"));
        arrayListSettingsItems.add(new ItemSetting("Push Notifications"));
        arrayListSettingsItems.add(new ItemSetting("Email Notification"));
        arrayListSettingsItems.add(new ItemSetting("Credit Card"));


        ListAdapter adapter = new ListAdapter(
                view.getContext(),
                android.R.layout.activity_list_item,
                arrayListSettingsItems
        );

        listViewItemsSetting.setAdapter(adapter);
        return view;
    }
}

