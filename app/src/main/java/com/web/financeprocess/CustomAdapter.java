package com.web.financeprocess;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomAdapter extends ArrayAdapter<EditModel> implements View.OnClickListener{

     ArrayList<EditModel> dataSet=new ArrayList<>();
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView mobile;
        TextView beneficiary;
        TextView amount;
    }

    public CustomAdapter(ArrayList<EditModel> data, Context context) {
        super(context, R.layout.activity_transactioneport, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        EditModel dataModel=(EditModel) object;


    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        EditModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_transactioneport, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.customer_id);
            viewHolder.mobile = (TextView) convertView.findViewById(R.id.mobile);
            viewHolder.amount = (TextView) convertView.findViewById(R.id.amount);
            viewHolder.beneficiary = (TextView) convertView.findViewById(R.id.beneficiary_name);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }


        lastPosition = position;

        viewHolder.txtName.setText((dataModel.getEditTextValue()));
        viewHolder.mobile.setText((dataModel.getMobile_no()));
        viewHolder.amount.setText((dataModel.getAmount()));
        viewHolder.beneficiary.setText((dataModel.getBeneficiary()));

        return convertView;
    }
}
