package com.example.rlaqk.lab6_3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    MySQLiteOpenHelper helper;
    EditText Name, SN;
    Button Add, Delete;
    ListView listItem;
    String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=(EditText)findViewById(R.id.name);
        SN=(EditText)findViewById(R.id.sn);

        Add=(Button)findViewById(R.id.add);
        Delete=(Button)findViewById(R.id.delete);
        listItem=(ListView)findViewById(R.id.list_item);

        helper = new MySQLiteOpenHelper(MainActivity.this,"student.db",null,1);

        Add.setOnClickListener(new View.OnClickListener() {//Add data
            @Override
            public void onClick(View v) {
                String getName, getSN;
                getName = Name.getText().toString();
                getSN=SN.getText().toString();
                if(getName.length()==0 || getSN.length()==0)//if name or student number don`t receive data, toast message send.
                    Toast.makeText(MainActivity.this, "모든 항목을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                else {//database insert and listview add
                    insert(getName, getSN);
                    invalidate();
                }
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {//Delete database
            @Override
            public void onClick(View v) {
                String getName, getSN;
                getName = Name.getText().toString();
                getSN=SN.getText().toString();

                if(getName.length() == 0)//if name don`t receive data, toast message send.
                    Toast.makeText(MainActivity.this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                else{//database delete and listview delete.
                    delete(getName);
                    invalidate();
                }
            }
        });
    }
    public void insert(String name, String sn){
        db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("name",name);
        values.put("studentNo",sn);
        db.insert("student",null,values);
    }
    public void delete (String name){
        db=helper.getWritableDatabase();
        db.delete("student","name=?",new String[]{name});
        Log.i("db1",name+"정상적으로 삭제 되었습니다.");
    }
    public void select(){//
        db = helper.getReadableDatabase();//Read database
        Cursor c = db.query("student",null,null,null,null,null,null);

        data = new String[c.getCount()];//Store data for array.
        int count = 0;

        while(c.moveToNext()){
            data[count] = c.getString(c.getColumnIndex("name"))+" "+
                    c.getString(c.getColumnIndex("studentNo"));
            count++;
        }
        c.close();
    }
    private void invalidate(){//Store list view add
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data);
        listItem.setAdapter(adapter);
    }
}
