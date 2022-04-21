package com.example.infoproducts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ArrayInfo extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> id_goods,name_goods,unit,provider_goods,id_document,price,number_kol,sum_goods,type_doc,data_d;

    DBHandler dbHandler;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_info);

        setContentView(R.layout.activity_array_info);
        recyclerView = findViewById(R.id.recyclesview);
        dbHandler = new DBHandler(this);
        id_goods = new ArrayList<>();
        name_goods = new ArrayList<>();
        unit = new ArrayList<>();
        provider_goods = new ArrayList<>();
        id_document = new ArrayList<>();
        price = new ArrayList<>();
        number_kol = new ArrayList<>();
        sum_goods = new ArrayList<>();
        type_doc = new ArrayList<>();
        data_d = new ArrayList<>();

        adapter = new Adapter( this ,id_goods,name_goods,unit,provider_goods,id_document,price,number_kol,sum_goods,type_doc,data_d);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        displaydata();
    }

    @SuppressLint("Range")
    private void displaydata() {
        Cursor cursor = dbHandler.getdata();
        if (cursor.getCount()==0 && cursor.moveToFirst()) {
            Toast.makeText(this, "No Entry Exists", Toast.LENGTH_SHORT).show();

        }
        else{
            if (cursor != null)
                if (cursor.moveToFirst()) {
                    do {
                        id_goods.add(cursor.getString(cursor.getColumnIndex(Goods.UserDetails.COL_ID_GOODS)));
                        name_goods.add(cursor.getString(cursor.getColumnIndex(Goods.UserDetails.COL_NAME_GOODS)));
                        unit.add(cursor.getString(cursor.getColumnIndex(Goods.UserDetails.COL_UNIT)));
                        provider_goods.add(cursor.getString(cursor.getColumnIndex(Goods.UserDetails.COL_PROVIDER_GOODS)));
                        id_document.add(cursor.getString(cursor.getColumnIndex(Goods.UserDetails.COL_ID_DOCUMENT)));
                        price.add(cursor.getString(cursor.getColumnIndex(Goods.UserDetails.COL_PRICE)));
                        number_kol.add(cursor.getString(cursor.getColumnIndex(Goods.UserDetails.COL_NUMBER_KOL)));;
                        sum_goods.add(cursor.getString(cursor.getColumnIndex(Goods.UserDetails.COL_SUM_GOODS)));;
                        type_doc.add(cursor.getString(cursor.getColumnIndex(Goods.UserDetails.COL_TYPE_DOC)));;
                        data_d.add(cursor.getString(cursor.getColumnIndex(Goods.UserDetails.COL_DATE_D)));;


                    } while (cursor.moveToNext());
                }
            }
    }   }