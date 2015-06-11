package com.caciones.rssibtv1.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.caciones.rssibtv1.R;
import com.caciones.rssibtv1.RO.BTDeviceRO;

public class BTArrayAdapter extends ArrayAdapter<BTDeviceRO> {
    private final Context context;
    private final BTDeviceRO[] BtDevice;

    public BTArrayAdapter(Context context, BTDeviceRO[] values) {
        super(context, R.layout.list_bt_rssi, values);
        this.context = context;
        this.BtDevice = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_bt_rssi, parent, false);

        TextView textView_name = (TextView) rowView.findViewById(R.id.list_bt_name);
        TextView textView_rssi = (TextView) rowView.findViewById(R.id.list_rssi);

        textView_name.setText(BtDevice[position].getBtName());
        textView_rssi.setText(BtDevice[position].getRssiValue());


        return rowView;
    }
}