package com.example.seano.mad04;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import  com.example.seano.mad04.FactionSchema.FactionTable;

/**
 * Maintains the overall dataset; specifically of course all the different factions.
 */

public class FactionList
{
    private List<Faction> factions = new ArrayList<>();
    private SQLiteDatabase db;

    public FactionList(Context context)
    {
        this.db = new FactionDbHelper(context.getApplicationContext()).getWritableDatabase();
    }

    public void load()
    {
        FactionCursor cursor = new FactionCursor(db.query(FactionTable.NAME, null, null, null, null ,null,null));
        try
        {
            cursor.moveToFirst();
            while(!cursor.isAfterLast())
            {
                factions.add(cursor.getFaction());
                cursor.moveToNext();
            }
        }
        finally
        {
            cursor.close();
        }
    }

    public int size()
    {
        return factions.size();
    }

    public Faction get(int i)
    {
        return factions.get(i);
    }

    public int add(Faction faction)
    {
        factions.add(faction);
        ContentValues cv = new ContentValues();
        cv.put(FactionSchema.FactionTable.Cols.id, faction.getId());
        cv.put(FactionSchema.FactionTable.Cols.name, faction.getName());
        cv.put(FactionSchema.FactionTable.Cols.strength, faction.getStrength());
        cv.put(FactionSchema.FactionTable.Cols.relationship, faction.getRelationship());
        db.insert(FactionSchema.FactionTable.NAME, null, cv);

        return factions.size() - 1; // Return insertion point
    }

    public void edit(Faction faction)
    {
        ContentValues cv = new ContentValues();
        cv.put(FactionSchema.FactionTable.Cols.id, faction.getId());
        cv.put(FactionSchema.FactionTable.Cols.name, faction.getName());
        cv.put(FactionSchema.FactionTable.Cols.strength, faction.getStrength());
        cv.put(FactionSchema.FactionTable.Cols.relationship, faction.getRelationship());
        String[] whereValue = {};
        db.update(FactionTable.NAME, cv, FactionTable.Cols.id + " = " + faction.getId(), whereValue);
    }

    public void remove(Faction faction)
    {
        String[] whereValue = {};
        db.delete(FactionTable.NAME, FactionTable.Cols.id + " = " + faction.getId(), whereValue);
        factions.remove(faction);
    }
}
