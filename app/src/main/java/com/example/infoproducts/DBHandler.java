package com.example.infoproducts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "Goods.db";
    public  static  final int DB_VERSION = 1;


    public DBHandler(Context context) {

        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String USER_TABLE = "CREATE TABLE "+ Goods.UserDetails.TABLE_NAME+" ( "+
                Goods.UserDetails.COL_ID_GOODS+" INTEGER PRIMARY KEY,"+
                Goods.UserDetails.COL_NAME_GOODS+" TEXT,"+
                Goods.UserDetails.COL_UNIT+" TEXT,"+
                Goods.UserDetails.COL_PROVIDER_GOODS+" TEXT,"+
                Goods.UserDetails.COL_ID_DOCUMENT+" TEXT,"+
                Goods.UserDetails.COL_PRICE+" TEXT,"+
                Goods.UserDetails.COL_NUMBER_KOL+" TEXT,"+
                Goods.UserDetails.COL_SUM_GOODS+" TEXT,"+
                Goods.UserDetails.COL_TYPE_DOC+" TEXT,"+
                Goods.UserDetails.COL_DATE_D+" TEXT )";

        sqLiteDatabase.execSQL(USER_TABLE);
    }

    //----------------------------INSERT

    public boolean insertIntoData(Integer id,String name,String unit,String provider,String id_doc,String price,String number_kol,String summa,String type,String data_d){

        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Goods.UserDetails.COL_ID_GOODS,id);
        contentValues.put(Goods.UserDetails.COL_NAME_GOODS,name);
        contentValues.put(Goods.UserDetails.COL_UNIT,unit);
        contentValues.put(Goods.UserDetails.COL_PROVIDER_GOODS,provider);
        contentValues.put(Goods.UserDetails.COL_ID_DOCUMENT,id_doc);
        contentValues.put(Goods.UserDetails.COL_PRICE,price);
        contentValues.put(Goods.UserDetails.COL_NUMBER_KOL,number_kol);
        contentValues.put(Goods.UserDetails.COL_SUM_GOODS,summa);
        contentValues.put(Goods.UserDetails.COL_TYPE_DOC,type);
        contentValues.put(Goods.UserDetails.COL_DATE_D,data_d);

        long result = db.insert("Goods",null,contentValues);
        if (result == -1){
            return false;
        }
        else{
            return true;
        }





    }




    public Cursor getdata(){
        String query = "SELECT * FROM " + Goods.UserDetails.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists user");
    }
}
