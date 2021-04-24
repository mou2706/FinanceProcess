package com.web.financeprocess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home_page extends AppCompatActivity implements View.OnClickListener {
    TextView tv_transaction, tv_trans_report;
    TextView tv_personal_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        tv_transaction = findViewById(R.id.tv_transaction);
        tv_trans_report = findViewById(R.id.tv_Transac_report);

        tv_transaction.setOnClickListener(this);
        tv_trans_report.setOnClickListener(this);
        tv_trans_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_page.this, BalanceTransferReportActivity.class));
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.tv_transaction:
                changefragment(v);

                break;

            case R.id.tv_trans_report:
                changefragment(v);


        }
    }

    public void changefragment(View view) {

        if (view == findViewById(R.id.tv_transaction)) {
            startActivity(new Intent(Home_page.this, Transfer_amount.class));


        }
        if (view == findViewById(R.id.tv_Transac_report)) {
            startActivity(new Intent(Home_page.this, BalanceTransferReportActivity.class));


        }

    }

}