package com.example.projectchermanin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputMoney;
    private EditText inputInfo;
    private Button btnOk;
    private CheckBox bankCardChkBx;
    private CheckBox mobilePhoneChkBx;
    private CheckBox cashAddressChkBx;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews(){
        inputMoney = findViewById(R.id.inputMoney);
        inputInfo = findViewById(R.id.inputInfo);
        btnOk = findViewById(R.id.btnOK);
        bankCardChkBx = findViewById(R.id.bankCardChkBx);
        mobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        cashAddressChkBx = findViewById(R.id.cashAddressChkBx);
        bankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        cashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Оплата составляет: " + inputMoney.getText().toString() + " " + s + " " + inputInfo.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
    private void resetCheckBoxes() {
        bankCardChkBx.setChecked(false);
        mobilePhoneChkBx.setChecked(false);
        cashAddressChkBx.setChecked(false);
    }
    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                switch(compoundButton.getId()) {
                    case R.id.bankCardChkBx:
                        resetCheckBoxes();
                        bankCardChkBx.setChecked(true);
                        inputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                        s = getString(R.string.bank_CardChkBx);
                        break;
                    case R.id.mobilePhoneChkBx:
                        resetCheckBoxes();
                        mobilePhoneChkBx.setChecked(true);
                        inputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                        s = getString(R.string.mobile_PhoneChkBx);
                        break;
                    case R.id.cashAddressChkBx:
                        resetCheckBoxes();
                        cashAddressChkBx.setChecked(true);
                        inputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                        s = getString(R.string.cash_AddressChkBx);
                        break;
                    default:
                }
            }
        }
    };
}