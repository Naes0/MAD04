package com.example.seano.mad04;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.seano.mad04.FactionSchema.FactionTable;

public class FactionDbHelper extends SQLiteOpenHelper
{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "faction.db";

    public FactionDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + FactionTable.NAME + "(" + "_id integer primary key autoincrement, " +
                    FactionTable.Cols.id + "," +
                    FactionTable.Cols.name + "," +
                    FactionTable.Cols.strength + "," +
                    FactionTable.Cols.relationship + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {

    }
}

