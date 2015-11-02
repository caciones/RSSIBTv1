package com.caciones.rssibtv1.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.caciones.rssibtv1.R;
import com.caciones.rssibtv1.RO.BTDeviceRO;

import java.util.List;

public class BTArrayAdapter extends ArrayAdapter<BTDeviceRO> {


    public BTArrayAdapter(Context c, List<BTDeviceRO> values) {
        super(c, R.layout.list_bt_rssi, values);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BTDeviceRO btDeviceRO = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_bt_rssi, parent,false);
        }

        TextView textView_name = (TextView) convertView.findViewById(R.id.list_item_name);
        TextView textView_rssi = (TextView) convertView.findViewById(R.id.list_item_rssi);
        TextView textView_address = (TextView) convertView.findViewById(R.id.list_item_address);

        textView_name.setText(btDeviceRO.getBtName());
        textView_rssi.setText(String.valueOf(btDeviceRO.getRssiValue()));
        textView_address.setText(btDeviceRO.getAddress());

        return convertView;
    }
}
