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


    public BTArrayAdapter(Context context, List<BTDeviceRO> values) {
        super(context, R.layout.list_bt_rssi, values);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BTDeviceRO btDeviceRO = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_bt_rssi, parent,false);
        }

        TextView textView_name = (TextView) convertView.findViewById(R.id.list_bt_name);
        TextView textView_rssi = (TextView) convertView.findViewById(R.id.list_rssi);

        textView_name.setText(btDeviceRO.getBtName());
        textView_rssi.setText(btDeviceRO.getRssiValue());

        return convertView;
    }
}