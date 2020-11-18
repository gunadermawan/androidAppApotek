package com.example.gunderhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class menu_tampil_input extends AppCompatActivity {
    databaseHelper bd;
    ListView listView;
    EditText editText;
    Button tblTambah;

    ArrayAdapter adapter;

    ArrayList<String> listviewku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tampil_input);

        listView = findViewById(R.id.listObat);
        editText = findViewById(R.id.input2);
        tblTambah = findViewById(R.id.tblSubmit);
        bd = new databaseHelper(this);
        listviewku = new ArrayList<>();
        tampil_obat();

    }

    public void tampil_obat() {
        Cursor cursor = bd.tampilObat();
        if (cursor.getCount() == 0 ) {
            Toast.makeText(this, "DAFTAR MASIH KOSONG !", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                listviewku.add((cursor.getInt(0))+" "+cursor.getString(1));
            }
            adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,listviewku);
            listView.setAdapter(adapter);
        }
    }

    public void dashboard(View view) {
        Intent intent = new Intent(menu_tampil_input.this,MainActivity.class);
        startActivity(intent);
    }
}