package com.example.seano.mad04;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.seano.mad04.FactionSchema.FactionTable;
public class FactionDB
{
    private SQLiteDatabase db;
    public FactionDB(Context context)
    {
        this.db = new FactionDbHelper(context.getApplicationContext()).getWritableDatabase();
    }

    public void addFaction(Faction faction)
    {
        ContentValues cv = new ContentValues();
        cv.put(FactionTable.Cols.id, faction.getId());
        cv.put(FactionTable.Cols.name, faction.getName());
        cv.put();
    }
}
