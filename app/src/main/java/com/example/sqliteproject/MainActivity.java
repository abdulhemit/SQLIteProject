package com.example.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Musicians",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY,name VARCHAR,age INT)");

            //database.execSQL("INSERT INTO musicians (name , age) VALUES ('ibrahim',22)");
            //database.execSQL("INSERT INTO musicians (name , age) VALUES ('abdusalam',26)");
            //database.execSQL("INSERT INTO musicians (name , age) VALUES ('imran',19)");

            //database.execSQL("UPDATE musicians SET age = 20 WHERE name = 'imran'");
            //database.execSQL("UPDATE musicians SET name = 'muhammet ali' WHERE id = 3");

            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name = 'imran'",null);
            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name LIKE 'm%'",null);
            Cursor cursor = database.rawQuery("SELECT * FROM musicians ",null);

            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");
            int idIx = cursor.getColumnIndex("id");

            while (cursor.moveToNext()){
                System.out.println("id: "+cursor.getInt(idIx));
                System.out.println("name: "+ cursor.getString(nameIx));
                System.out.println("age: "+cursor.getInt(ageIx));

            }
            cursor.close();



        }catch (Exception e){
            e.printStackTrace();

        }

    }
}