package dhj.gdpu.contentproviderdemo.dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dhj.gdpu.contentproviderdemo.DB.DbUtils;
import dhj.gdpu.contentproviderdemo.entity.Person;

public class PersonDao {
    private Context context;
    private DbUtils dbUtils;
    private SQLiteDatabase sqLiteDatabase;

    public PersonDao(Context context) {
        this.context = context;
        dbUtils = new DbUtils(context);
        sqLiteDatabase = dbUtils.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<Person> getList(){
        List<Person> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query("contacts",null,null,null,null,null,null);
        if(cursor.moveToFirst()) {
            do {
                list.add(new Person(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("phone")),
                        cursor.getInt(cursor.getColumnIndex("sex"))
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }
}
