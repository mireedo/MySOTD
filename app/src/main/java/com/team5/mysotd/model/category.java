package com.team5.mysotd.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by gifary on 7/1/2015.
 */
public class category extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MySotd.db";
    public static final String CATEGORY_TABLE_NAME = "category";
    public static final String CATEGORY_COLUMN_IDCATEGORY = "idCategory";
    public static final String CATEGORY_COLUMN_CATEGORYNAME = "categoryName";
    public static final String CATEGORY_COLUMN_NOTE = "note";

   private HashMap hp;


    public category(Context ctx){
        super(ctx, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table category " +
                        "(idCategory integer primary key, categoryName text,note text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS category");
        onCreate(db);
    }

    public boolean insertCategory  (String categoryName, String note)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("categoryName", categoryName);
        contentValues.put("note", note);

        db.insert("category", null, contentValues);
        return true;
    }
    /*public Cursor getData(int idCategory){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from category where idCategory="+idCategory+"", null );
        return res;
    }*/
    /*
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CATEGORY_TABLE_NAME);
        return numRows;
    }*/
    public boolean updateCategory (Integer idCategory, String categoryName, String note)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("categoryName", categoryName);
        contentValues.put("note", note);
        db.update("category", contentValues, "idCategory = ? ", new String[] { Integer.toString(idCategory) } );
        return true;
    }

    public Integer deleteCategory (Integer idCategory)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("category",
                "idCategory = ? ",
                new String[] { Integer.toString(idCategory) });
    }
    public ArrayList getAllCategory()
    {
        ArrayList array_list = new ArrayList();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from category", null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(CATEGORY_COLUMN_CATEGORYNAME)));
            res.moveToNext();
        }
        return array_list;
    }


}
