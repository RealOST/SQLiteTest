package com.example.sqlitetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button insert;
    private Button delete;
    private Button update;
    private Button select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert = (Button) findViewById(R.id.btn_insert);
        delete = (Button) findViewById(R.id.btn_delete);
        update = (Button) findViewById(R.id.btn_update);
        select = (Button) findViewById(R.id.btn_select);
    }

    public void insertDate(View view){
        Intent intent = new Intent(this,InsertActivity.class);
        startActivity(intent);
    }

    public void deleteDate(View view){
        Intent intent = new Intent(this,DeleteActivity.class);
        startActivity(intent);
    }

    public void updateDate(View view){
        Intent intent = new Intent(this,UpdateActivity.class);
        startActivity(intent);
    }

    public void selectDate(View view){
        Intent intent = new Intent(this,QueryActivity.class);
        startActivity(intent);
    }

    /*private void setListeners(){
        OnClick onClick = new OnClick();
        insert.setOnClickListener(onClick);
        delete.setOnClickListener(onClick);
        update.setOnClickListener(onClick);
        select.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_insert:
                    intent = new Intent(MainActivity.this,.class);
                    break;
                case R.id.btn_delete:
                    intent = new Intent(MainActivity.this,.class);
                    break;
                case R.id.btn_update:
                    intent = new Intent(MainActivity.this,.class);
                    break;
                case R.id.btn_select:
                    intent = new Intent(MainActivity.this,.class);
                    break;
            }
            startActivity(intent);
        }
    }*/
}