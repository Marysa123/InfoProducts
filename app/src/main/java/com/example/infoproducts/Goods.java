package com.example.infoproducts;

import android.provider.BaseColumns;


public class Goods {
    private Goods() {
    }
    public static final  class  UserDetails implements BaseColumns{
        public static final String TABLE_NAME = "Goods";
        public static final String COL_ID_GOODS = "id_goods";
        public static final String COL_NAME_GOODS = "name_goods";
        public static final String COL_UNIT = "unit";
        public static final String COL_PROVIDER_GOODS = "provider_goods";
        public static final String COL_ID_DOCUMENT = "document";
        public static final String COL_PRICE = "price";
        public static final String COL_NUMBER_KOL = "number";
        public static final String COL_SUM_GOODS = "sum_goods";
        public static final String COL_TYPE_DOC = "type_doc";
        public static final String COL_DATE_D = "date_d";

    }
}
