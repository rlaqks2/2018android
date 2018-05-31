package com.example.rlaqk.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String userSN, userName;
    EditText StudentNumber,Name;
    Button Read, Save, Clear;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentNumber = (EditText)findViewById(R.id.sn);
        Name=(EditText)findViewById(R.id.name);

        Read=(Button)findViewById(R.id.read);
        Save=(Button)findViewById(R.id.save);
        Clear=(Button)findViewById(R.id.clear);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=Name.getText().toString();
                userSN=StudentNumber.getText().toString();
                sharedPreferences();
            }
        });

        Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applySharedPreference();
            }
        });

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentNumber.setText("");
                Name.setText("");
            }
        });


    }
    public void sharedPreferences(){
        sh_Pref=getSharedPreferences("Student",MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("StudentSN",userSN);
        toEdit.putString("StudentName",userName);
        toEdit.commit();
    }
    public  void applySharedPreference(){
        sh_Pref=getSharedPreferences("Student",MODE_PRIVATE);//Load shared preference
        if(sh_Pref!=null&&sh_Pref.contains("StudentName")){
            String name=sh_Pref.getString("StudentName","");
            String sn=sh_Pref.getString("StudentSN","");
            Name.setText(name);
            StudentNumber.setText(sn);
        }
    }


}
