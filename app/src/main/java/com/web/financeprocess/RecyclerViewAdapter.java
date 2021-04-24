package com.web.financeprocess;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemHolder> {

     ArrayList<EditModel> itemsName=new ArrayList<>();
     OnItemClickListener onItemClickListener;
     LayoutInflater layoutInflater;
    Context context;
    public ArrayList<RecyclerViewAdapter.ItemHolder> cellviews = new ArrayList<>();
    RecyclerViewAdapter.ItemHolder ownAdapter;
//    public RecyclerViewAdapter(Context context){
//        layoutInflater = LayoutInflater.from(context);
//        itemsName = new ArrayList<String>();
//    }

    public RecyclerViewAdapter(ArrayList<EditModel> itemsName, Context context) {
        this.itemsName = itemsName;

        this.context = context;
        cellviews=new ArrayList<>();
    }

    @Override
    public RecyclerViewAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_transactioneport,parent,false);
        ownAdapter=new RecyclerViewAdapter.ItemHolder(v);
        return ownAdapter;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ItemHolder holder, int position) {
        holder.setItemName(itemsName.get(position));
//        ownAdapter.textItemName.setText((CharSequence) itemsName.get(position));
//        ownAdapter.textItemName.setText("id");

        ownAdapter.textItemName.setText((CharSequence) itemsName.get(position));

    }

    @Override
    public int getItemCount() {
        return itemsName.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener = listener;
    }

    public OnItemClickListener getOnItemClickListener(){
        return onItemClickListener;
    }

    public interface OnItemClickListener{
        public void onItemClick(ItemHolder item, int position);
    }



    public  class ItemHolder extends RecyclerView.ViewHolder {

        TextView textItemName;

        public ItemHolder(View itemView) {
            super(itemView);
            SharedPreferences data= PreferenceManager.getDefaultSharedPreferences(context);
            String dataset=data.getString("id","");

//            textItemName = (TextView) itemView.findViewById(R.id.list_complain_no);
            textItemName.setText(dataset);
        }


        public void setItemName(EditModel name){
            textItemName.setText((CharSequence) name);
        }

        public CharSequence getItemName(){
            return textItemName.getText();
        }
    }}