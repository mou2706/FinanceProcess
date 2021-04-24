package com.web.financeprocess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transfer_amount extends AppCompatActivity {
    EditText electivity_no,et_amt,customer_id,mobile_no;
    String beneficiary;
     String consumerId,et_amount,beneficiary_list;
     String mobileNo;
     ImageView backimage;
    private String inCode;
    private String consumerMobile;
    private String consumerName;
    private String dueDate;
    private String amt;
    Button btn_transfer_amount;
     RecyclerView myRecyclerView;
     LinearLayoutManager linearLayoutManager;
     RecyclerViewAdapter myRecyclerViewAdapter;
    Spinner spinner;
    String text="";
    String[] spinnerItems = new String[]{
            "Select Beneficiary(s)",
            "parna",
            "Aneshwa",
            "Ira",
            "Soumita"
    };
    List<String> spinnerlist;
    ArrayAdapter<String> arrayadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_amount);

        customer_id=findViewById(R.id.customer_id);
        btn_transfer_amount=findViewById(R.id.btn_transfer_amount);
        mobile_no=findViewById(R.id.mobile_no);
        et_amt=findViewById(R.id.et_amt);
        spinner=findViewById(R.id.beneficiary);
        backimage=findViewById(R.id.backimage);
        backimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Transfer_amount.this,Home_page.class));
            }
        });

//        getdata();
        btn_transfer_amount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumerId = customer_id.getText().toString();
                mobileNo = mobile_no.getText().toString();
                et_amount = et_amt.getText().toString();
                beneficiary = spinner.getSelectedItem().toString();
                SharedPreferences data= PreferenceManager.getDefaultSharedPreferences(Transfer_amount.this);
                SharedPreferences.Editor editor=data.edit();
                editor.putString("id", consumerId);
                editor.putString("mobile_no", mobileNo);
                editor.putString("et_amount", et_amount);
                editor.putString("beneficiary_name", beneficiary);
                editor.commit();

//        consumerMobile = electricity_recharge_et_mobile.getText().toString();
//        amt = dth_recharge_et_amt.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("id",consumerId);
                bundle.putString("mobile_no",mobileNo);
                bundle.putString("et_amount",et_amount);
                editor.putString("beneficiary_name", beneficiary);

                Intent intent = new Intent(Transfer_amount.this, Transactioneport.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        init_spinner();
    }
    private void init_spinner() {

        spinnerlist = new ArrayList<>(Arrays.asList(spinnerItems));

        arrayadapter = new ArrayAdapter<String>(Transfer_amount.this,android.R.layout.simple_spinner_dropdown_item,spinnerlist){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    //Disable the  item of spinner.
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent)
            {
                View spinnerview = super.getDropDownView(position, convertView, parent);

                TextView spinnertextview = (TextView) spinnerview;

                if(position == 0) {

                    spinnertextview.setTextColor(Color.parseColor("#bcbcbb"));
                }
                else {

                    spinnertextview.setTextColor(Color.BLACK);

                }
                return spinnerview;
            }
        };

        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayadapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String beneficiary_item=spinner.getSelectedItem().toString();
                Intent intent=new Intent(Transfer_amount.this,Transactioneport.class);
                intent.putExtra("beneficiary_name", beneficiary_item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


//    private void getdata() {
//
//        LoginDataBaseAdapter dbManager = new LoginDataBaseAdapter(getApplicationContext());
//        dbManager.open();
//
//
//
//
//    }


}