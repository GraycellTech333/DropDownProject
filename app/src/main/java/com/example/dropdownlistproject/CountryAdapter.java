package com.example.dropdownlistproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyHolder> {

    private ArrayList<String> arrayList;
    ArrayList<SpinnerModel> listVOs1= new ArrayList<SpinnerModel>();


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return null != arrayList ? arrayList.size() : 0;
    }

    public void update(ArrayList<String> arralist, ArrayList<SpinnerModel> listVOs) {
        if (arralist != null && arralist.size() > 0) {
            this.arrayList = arralist;
            this.listVOs1=listVOs;
            notifyDataSetChanged();
        }
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView mTvName;
        private Spinner mSpinner;
        private Context mContext;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            this.mContext=itemView.getContext();
            mTvName = (TextView) itemView.findViewById(R.id.text_data);
            mSpinner = (Spinner) itemView.findViewById(R.id.spinner);
        }

        public void bindData(int position) {
            if (arrayList != null && arrayList.size() > 0) {
                SpinnerModel model=listVOs1.get(position);
                Log.e("TitleOned",""+model.title);

                MyAdapter myAdapter = new MyAdapter(mContext, 0,
                        listVOs1);
                mSpinner.setAdapter(myAdapter);

                setonclick(position);
            }

        }

        private void setonclick(int position) {
            mTvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v != null) {

                    }

                }
            });
        }
    }


}
