package com.example.rlaqk.lab3_2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button btn;
    CheckBox chkEmail;
    CheckBox chkSMS;
    RadioButton radioMan;
    RadioButton radioGirl;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit=(EditText)findViewById(R.id.edit);
        radioMan=(RadioButton)findViewById(R.id.radio1);//남
        radioGirl=(RadioButton)findViewById(R.id.radio2);//여
        chkSMS=(CheckBox)findViewById(R.id.check1);//sms
        chkEmail=(CheckBox)findViewById(R.id.check2);//email
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),NewActivity.class);//new activity 넘기기

                String mail="";//check 항목 string으로 저장
                if(chkEmail.isChecked() && chkSMS.isChecked()){
                    mail="SMS, e-mail";
                }
                else if(chkEmail.isChecked()){
                    mail="e-mail";
                }
                else if(chkSMS.isChecked()){
                    mail="SMS";
                }

                String sex="";//radio check항목 저장
                if(radioMan.isChecked()){
                    sex="남";
                }
                else if(radioGirl.isChecked()){
                    sex="여";
                }

                Bundle   bundle = new Bundle();//bundle생성
                bundle.putString("sex",sex);//성별
                bundle.putString("send",mail);//수신
                bundle.putString("name",edit.getText().toString());//이름
                intent.putExtras(bundle);//bundle로 묶은 후 보내기
                startActivity(intent);//보내기
            }
        });

    }
}
