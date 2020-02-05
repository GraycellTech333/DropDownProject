package com.example.dropdownlistproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<SpinnerModel> {
    private Context mContext;
    private ArrayList<SpinnerModel> listState;
    private MyAdapter myAdapter;
    private boolean isFromView = false;

    public MyAdapter(Context context, int resource, List<SpinnerModel> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.listState = (ArrayList<SpinnerModel>) objects;
        this.myAdapter = this;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(final int position, View convertView,
                              ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            LayoutInflater layoutInflator = LayoutInflater.from(mContext);
            convertView = layoutInflator.inflate(R.layout.item_list, null);
            holder = new ViewHolder();
            holder.mTextView = (TextView) convertView
                    .findViewById(R.id.text_data);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mTextView.setText(listState.get(position).getTitle());


        return convertView;
    }

    private class ViewHolder {
        private TextView mTextView;
    }
}
