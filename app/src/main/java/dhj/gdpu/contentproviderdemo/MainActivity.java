package dhj.gdpu.contentproviderdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import dhj.gdpu.contentproviderdemo.adapter.ItemAdapter;
import dhj.gdpu.contentproviderdemo.dao.PersonDao;
import dhj.gdpu.contentproviderdemo.entity.Person;

public class MainActivity extends AppCompatActivity {

    private List<Person> list;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        list = new ArrayList<>();
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        PersonDao personDao = new PersonDao(MainActivity.this);
        list = personDao.getList();
        itemAdapter = new ItemAdapter(MainActivity.this, R.layout.item_layout, list);
        listView.setAdapter(itemAdapter);
//        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
//        } else {
//            readContacts();
//        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case 1:
//                if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    readContacts();
//                }
//                break;
//        }
//    }
//
//    @SuppressLint("Range")
//    private void readContacts() {
//        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
//        if (cursor.moveToFirst()) {
//            do {
//                list.add(new Person(null, cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)), cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)), null));
//            } while (cursor.moveToNext());
//        }
//        itemAdapter.notifyDataSetChanged();
//        cursor.close();
//    }
}