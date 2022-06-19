package dhj.gdpu.contentproviderdemo.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbUtils extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DBName = "Contacts.db";
    private Context context;

    public DbUtils(Context context) {
        super(context, DBName, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table Contacts (\n" +
                        "id integer primary key autoincrement,\n" +
                        "name text,\n" +
                        "phone text,\n" +
                        "sex integer\n)"
        );
        sqLiteDatabase.execSQL(
                "INSERT INTO Contacts (name,phone,sex)" +
                        "VALUES ('xxx','12345678910',0)");
        sqLiteDatabase.execSQL(
                "INSERT INTO Contacts (name,phone,sex)" +
                        "VALUES ('小明','12312312310',0)");
        sqLiteDatabase.execSQL(
                "INSERT INTO Contacts (name,phone,sex)" +
                        "VALUES ('小红','11122233310',1)");
        sqLiteDatabase.execSQL(
                "INSERT INTO Contacts (name,phone,sex)" +
                        "VALUES ('小丽','12311122210',1)");
        sqLiteDatabase.execSQL(
                "INSERT INTO Contacts (name,phone,sex)" +
                        "VALUES ('小王','11100022211',0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Contacts");
        onCreate(sqLiteDatabase);
    }
}
