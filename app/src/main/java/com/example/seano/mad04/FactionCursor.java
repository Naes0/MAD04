package com.example.seano.mad04;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.seano.mad04.FactionSchema.FactionTable;

public class FactionCursor extends CursorWrapper
{
    public FactionCursor(Cursor cursor)
    {
        super(cursor);
    }

    public Faction getFaction()
    {
        int id = getInt(getColumnIndex(FactionTable.Cols.id));
        String name = getString(getColumnIndex(FactionTable.Cols.name));
        int strength = getInt(getColumnIndex(FactionTable.Cols.strength));
        int relationship = getInt(getColumnIndex(FactionTable.Cols.relationship));
        return new Faction(id, name, strength, relationship);
    }
}
