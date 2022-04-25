package com.example.infoproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;

public class addTovarPage extends AppCompatActivity {

    TextView id_goods,name_goods,unit,provider_goods,id_document,price,number_kol,sum_goods,type_doc,data_d;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tovar_page);

        id_goods = findViewById(R.id.Id_txt);
        name_goods = findViewById(R.id.Name_txt);
        unit = findViewById(R.id.Edin_txt);
        provider_goods = findViewById(R.id.Post_txt);
        id_document = findViewById(R.id.Numer_doc_txt);
        price = findViewById(R.id.Chena_txt);
        number_kol = findViewById(R.id.KolTovara_txt);
        sum_goods = findViewById(R.id.Summa_txt);
        type_doc = findViewById(R.id.Type_txt);
        data_d = findViewById(R.id.DataPrib_txt);

        findViewById(R.id.button_addTovar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Id = Integer.parseInt(id_goods.getText().toString());
                String Name = name_goods.getText().toString();
                String Edin = unit.getText().toString();
                String Post = provider_goods.getText().toString();
                String Id_doc = id_document.getText().toString();
                String Price = price.getText().toString();
                String Number_kol = number_kol.getText().toString();
                String Summa = sum_goods.getText().toString();
                String Type_doc = type_doc.getText().toString();
                String Data_d = data_d.getText().toString();

                dbHandler = new DBHandler(addTovarPage.this);
                boolean insert = dbHandler.insertIntoData(Id,Name,Edin,Post,Id_doc,Price,Number_kol,Summa, Type_doc,Data_d);
                if (insert == true){
                    Toast.makeText(addTovarPage.this, "Yes", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(addTovarPage.this, "No", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}