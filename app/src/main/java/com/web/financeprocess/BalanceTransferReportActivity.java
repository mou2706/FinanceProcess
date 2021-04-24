package com.web.financeprocess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BalanceTransferReportActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemClickListener {
    ListView mlist;
    ArrayList<EditModel> itemsName = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    CustomAdapter adapter;
    ImageView backimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_transfer_report);
        mlist = findViewById(R.id.rechargereport_recyclerview);
        backimage = findViewById(R.id.backimage);
        backimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BalanceTransferReportActivity.this,Transfer_amount.class));
            }
        });
        itemsName = new ArrayList<EditModel>();
        itemsName.clear();
        SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(BalanceTransferReportActivity.this);
        String dataset = data.getString("id", "");
        String mobile = data.getString("mobile_no", "");
        String beneficiary = data.getString("beneficiary_name", "");
        String amount = data.getString("et_amount", "");
        itemsName.add(new EditModel("2", "9999999999", "hhhhh", "6000"));

        itemsName.add(new EditModel(dataset, mobile, beneficiary, amount));


        adapter = new CustomAdapter(itemsName, BalanceTransferReportActivity.this);
        mlist.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(RecyclerViewAdapter.ItemHolder item, int position) {
        Toast.makeText(this,
                "Remove " + position + " : " + item.getItemName(),
                Toast.LENGTH_SHORT).show();

    }
}