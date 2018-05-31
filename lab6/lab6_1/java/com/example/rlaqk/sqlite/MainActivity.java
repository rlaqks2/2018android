package com.example.rlaqk.sqlite;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    EditText inputText;
    Button saveButton,readButton,clearButton,finishButton;

    private String filename = "mysdfile.txt";
    private String filepath = "MyFileStorage";
    File myExternalFile;
    String myData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = (EditText) findViewById(R.id.txtData);


        saveButton = (Button) findViewById(R.id.writeBtn);//Write text and store text file
        saveButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = new FileOutputStream(myExternalFile);
                    fos.write(inputText.getText().toString().getBytes());//external write
                    fos.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }
                String data = inputText.getText().toString();
                inputText.setText(data);
            }
        });

        readButton = (Button) findViewById(R.id.readBtn);//read text file
        readButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis = new FileInputStream(myExternalFile);
                    DataInputStream in = new DataInputStream(fis);
                    BufferedReader br =
                            new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    while ((strLine = br.readLine()) != null) {
                        myData = myData + strLine;
                    }
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                inputText.setText(myData);
            }
        });

        clearButton = (Button) findViewById(R.id.clearBtn);//clear text
        clearButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText("");
                Toast.makeText(MainActivity.this,  "Done writing SD'"+filename+"'", Toast.LENGTH_SHORT).show();
            }
        });

        finishButton=(Button) findViewById(R.id.finishBtn);//finish
        finishButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {//finish button
                Toast.makeText(MainActivity.this,  "Done writing SD'"+filename+"'", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            saveButton.setEnabled(false);

        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }


    }
    private static boolean isExternalStorageReadOnly() {//external read
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {//external storage
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }


}