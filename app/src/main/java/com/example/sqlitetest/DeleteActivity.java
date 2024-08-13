package com.example.sqlitetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.sqlitetest.util.ToastUtil;

public class DeleteActivity extends AppCompatActivity {

    private EditText etName;
    private SQLiteOH sqLiteOH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        etName = findViewById(R.id.et_name);
        sqLiteOH = new SQLiteOH(this);
    }

    public void delete(View view) {
        String name = etName.getText().toString().trim();

        long row = sqLiteOH.deleteFromDbByName(name);
        if(row > 0){
            ToastUtil.toastLong(this,"删除成功,删了"+row+"条数据");
        }else {
            ToastUtil.toastLong(this,"删除失败");
        }
    }
}
