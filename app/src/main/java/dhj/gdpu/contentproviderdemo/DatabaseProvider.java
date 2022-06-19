package dhj.gdpu.contentproviderdemo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import dhj.gdpu.contentproviderdemo.DB.DbUtils;

public class DatabaseProvider extends ContentProvider {

    private static final int contacts = 0;
    private static final int contactsItem = 1;
    private DbUtils dbUtils;
    private static final String AUTHORITY = "dhj.gdpu.providertest.provider";
    private static UriMatcher uriMatcher;

    public DatabaseProvider() {
    }

    static {//初始化
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "Contacts", contacts);
        uriMatcher.addURI(AUTHORITY, "Contacts/#", contactsItem);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        String type = "";
        switch (uriMatcher.match(uri)) {
            case contacts:
                type = "vnd.android.cursor.dir/vnd." + AUTHORITY + ".Contacts";
                break;
            case contactsItem:
                type = "vnd.android.cursor.item/vnd." + AUTHORITY + ".Contacts";
                break;
        }
        return type;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        dbUtils = new DbUtils(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        SQLiteDatabase database = dbUtils.getReadableDatabase();
        Cursor cursor = null;//用于返回的Cursor对象
        switch (uriMatcher.match(uri)) {
            case contacts:
                cursor = database.query("Contacts", projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            case contactsItem:
                String queryId = uri.getPathSegments().get(1);//用于查询的id
                cursor = database.query("Contacts", projection, "id=?", new String[]{queryId},
                        null, null, sortOrder);
                break;
        }
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}