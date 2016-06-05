package com.example.administrator.myfirstapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.content.CursorLoader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.myfirstapplication.R;

/**
 * Created by eternl on 2016/6/5.
 */
public class homework_content_activity extends BaseActivity {
    final int PICK_CONTACT = 0;
    EditText show;
    EditText phone;
    @Override
    protected void contectview(Bundle savedInstanceState) {
        setContentView(R.layout.homework_content);
        show =(EditText)findViewById(R.id.show);
        phone =(EditText)findViewById(R.id.phone);
    }
    public void content(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("vnd.android.cursor.item/phone");
        startActivityForResult(intent, PICK_CONTACT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (PICK_CONTACT):
                if (resultCode == Activity.RESULT_OK) {

                    Uri contactData = data.getData();
                    CursorLoader cursorLoader = new CursorLoader(this, contactData, null, null, null, null);

                    Cursor cursor = cursorLoader.loadInBackground();

                    if (cursor.moveToFirst()) {
                        String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                        String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                        String phoneNumber = "此联系人暂未输入电话号码";
                        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
                        if (phones.moveToFirst()) {
                            phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        }
                        phones.close();
                        show.setText(name);
                        phone.setText(phoneNumber);
                    }
                    cursor.close();
                }
                break;
        }
    }
}
