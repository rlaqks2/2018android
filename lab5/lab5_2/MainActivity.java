package com.example.rlaqk.lab5_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editTxt;
    TextView txt;
    TextView result_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        editTxt=findViewById(R.id.input_Num);
        txt=findViewById(R.id.txt);
        result_txt=findViewById(R.id.txt1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTask().execute();//AsyncTask 함수 사용
            }
        });
    }
    private class CountDownTask extends AsyncTask<Void,Integer,Void> {
        String number="";
        int result=1;
        @Override
        protected void onPreExecute(){

        }
        @Override
        protected  Void doInBackground(Void...params){

            int num = Integer.parseInt(editTxt.getText().toString());//숫자 받기

            for(int i=num;i>0;i--){
                try{Thread.sleep(500);
                    publishProgress(i);
                }catch (Exception e){}//0미만 catch
            }
            return null;
        }
        @Override
        protected  void onProgressUpdate(Integer... values){
            number=number+Integer.toString(values[0].intValue())+" ";//count
            result=result*values[0];//factor
            txt.setText(number);//wait number
            result_txt.setText("=?");
        }
        @Override
        protected void onPostExecute(Void aVoid){
            int numb=Integer.parseInt(editTxt.getText().toString());
            String Result=String.valueOf(result);//
            result_txt.setText(Result);//print result.
        }

    }

}
