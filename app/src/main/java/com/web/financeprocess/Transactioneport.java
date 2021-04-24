package com.web.financeprocess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Transactioneport extends AppCompatActivity {
    TextView customer_id,mobile,amount,beneficiary_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactioneport);
        customer_id = findViewById(R.id.customer_id);
        mobile = findViewById(R.id.mobile);
        amount = findViewById(R.id.amount);
        beneficiary_name = findViewById(R.id.beneficiary_name);
        setdata();

    }


    private void setdata() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String id = bundle.getString("id");
            String mobile_no = bundle.getString("mobile_no");
            String amount_details = bundle.getString("et_amount");
            String beneficiary_name_ = bundle.getString("beneficiary_name");
            SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(Transactioneport.this);

            String beneficiary = data.getString("beneficiary_name", "");

            customer_id.setText(id);
            mobile.setText(mobile_no);
            amount.setText(amount_details);
            beneficiary_name.setText(beneficiary);


        }


    }
}