package br.com.icoddevelopers.findssp.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.icoddevelopers.findssp.constants.DataBaseConstants;

public class GuestDataBase extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BancoSSB.db";

    private static final String SQL_CREATETABLE_GUEST =
            "CREATE TABLE " + DataBaseConstants.GUEST.TABLE_NAME + " ("
            + DataBaseConstants.GUEST.COLLUMNS.ID + "integer primary key autoincrement, "
            + DataBaseConstants.GUEST.COLLUMNS.NAME + "text not null, "
            + DataBaseConstants.GUEST.COLLUMNS.CORREDOR + "text not null"
            + DataBaseConstants.GUEST.COLLUMNS.PRATELEIRA + "text);";

    public GuestDataBase(Context context) {
        super(context, this.DATABASE_NAME, null, this.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATETABLE_GUEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
