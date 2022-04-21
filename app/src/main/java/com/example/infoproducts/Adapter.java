package com.example.infoproducts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import  androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    private Context context;
    private ArrayList id_goods,name_goods,unit,provider_goods,id_document,price,number_kol,sum_goods,type_doc,data_d;

    Activity activity;

    public Adapter(Activity activity){

    }

    public Adapter(Context context,ArrayList Id_goods,  ArrayList Name_goods, ArrayList Unit, ArrayList Provider_goods, ArrayList Id_document, ArrayList Price, ArrayList Number_kol, ArrayList Sum_goods, ArrayList Type_doc, ArrayList Data_d) {
        this.context = context;
        id_goods= Id_goods;
        name_goods = Name_goods;
        unit = Unit;
        provider_goods = Provider_goods;
        id_document = Id_document;
        price = Price;
        number_kol = Number_kol;
        sum_goods = Sum_goods;
        type_doc = Type_doc;
        data_d = Data_d;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate((R.layout.usere), parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.txtId.setText(String.valueOf(id_goods.get(position)));
        holder.txtNaz.setText(String.valueOf(name_goods.get(position)));
        holder.txtEdiTovara.setText(String.valueOf(unit.get(position)));
        holder.txtPost.setText(String.valueOf(provider_goods.get(position)));
        holder.txtNomerdoc.setText(String.valueOf(id_document.get(position)));
        holder.txtChena.setText(String.valueOf(price.get(position)));
        holder.txtkol.setText(String.valueOf(number_kol.get(position)));
        holder.txtSumGood.setText(String.valueOf(sum_goods.get(position)));
        holder.txtstatus.setText(String.valueOf(type_doc.get(position)));
        holder.txtdatapri.setText(String.valueOf(data_d.get(position)));

    }

    @Override
    public int getItemCount() {
        return id_goods.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtId,txtNaz,txtEdiTovara,txtPost,txtNomerdoc,txtChena,txtkol,txtSumGood,txtstatus,txtdatapri;
        CardView mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId= itemView.findViewById(R.id.id_tovara);
            txtNaz = itemView.findViewById(R.id.name_lable);
            txtEdiTovara = itemView.findViewById(R.id.edizm_lable);
            txtPost = itemView.findViewById(R.id.postavhik_lable);
            txtNomerdoc = itemView.findViewById(R.id.id_doc_lable);
            txtChena = itemView.findViewById(R.id.chena_lable);
            txtkol = itemView.findViewById(R.id.kolvo_lable);
            txtSumGood = itemView.findViewById(R.id.summa_lable);
            txtstatus = itemView.findViewById(R.id.status_doc);
            txtdatapri = itemView.findViewById(R.id.datetime_tovara);


            mainLayout = itemView.findViewById(R.id.MainLayout);
        }
    }
}