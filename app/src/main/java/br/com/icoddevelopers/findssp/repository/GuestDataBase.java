/*
package br.com.icoddevelopers.findssp.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.icoddevelopers.findssp.constants.DataBaseConstants;

public class GuestDataBase extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BancoSSB.db";

    // TABELA SUPERMERCADO
    private static final String SQL_CREATE_TABLE_SUPERMERCADO =
            "CREATE TABLE " + DataBaseConstants.GUEST.TABLE_NAME + " ("
            + DataBaseConstants.GUEST.COLLUMNS.ID_SUPERMERCADO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DataBaseConstants.GUEST.COLLUMNS.NOME_SUPERMERCADO + " CHARACTER(50) NOT NULL );";

    // TABELA ENDERECO
    private static final String SQL_CREATE_TABLE_ENDERECO =
            "CREATE TABLE " + DataBaseConstants.GUEST.COLLUMNS.ENDERECO +" ( "
            + DataBaseConstants.GUEST.COLLUMNS.ID_SUPERMERCADO + " INTEGER, "
            + DataBaseConstants.GUEST.COLLUMNS.ESTADO + " CHARACTER(50), "
            + DataBaseConstants.GUEST.COLLUMNS.CIDADE + " CHARACTER(100) NOT NULL, "
            + DataBaseConstants.GUEST.COLLUMNS.BAIRRO + " CHARACTER (50), "
            + DataBaseConstants.GUEST.COLLUMNS.RUA + " CHARACTER(100), "
            + DataBaseConstants.GUEST.COLLUMNS.NUMERO_ENDERECO + " INTEGER(6),"
            + "FOREIGN KEY (" + DataBaseConstants.GUEST.COLLUMNS.ID_SUPERMERCADO
            + ") REFERENCES " + DataBaseConstants.GUEST.TABLE_NAME
            + "(" + DataBaseConstants.GUEST.COLLUMNS.ID_SUPERMERCADO + "));";

    // TABELA CONTATO
    private final String SQL_CREATE_TABLE_CONTATO =
            "CREATE TABLE " + DataBaseConstants.GUEST.COLLUMNS.CONTATO + " ( "
            + DataBaseConstants.GUEST.COLLUMNS.ID_SUPERMERCADO + " INTEGER, "
            + DataBaseConstants.GUEST.COLLUMNS.EMAIL + " CHARACTER(100), "
            + DataBaseConstants.GUEST.COLLUMNS.DDD + " INTEGER(3), "
            + DataBaseConstants.GUEST.COLLUMNS.TELEFONE + " INTEGER(8), "
            + DataBaseConstants.GUEST.COLLUMNS.CELULAR + " INTEGER(9), "
            + "FOREIGN KEY (" + DataBaseConstants.GUEST.COLLUMNS.ID_SUPERMERCADO
            + ") REFERENCES " + DataBaseConstants.GUEST.TABLE_NAME
            + "(" + DataBaseConstants.GUEST.COLLUMNS.ID_SUPERMERCADO + "));";

    // TABELA CORREDOR
    private final  String SQL_CREATE_TABLE_CORREDOR =
            "CREATE TABLE " + DataBaseConstants.GUEST.COLLUMNS.CORREDOR + " ( "
            + DataBaseConstants.GUEST.COLLUMNS.ID_CORREDOR + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DataBaseConstants.GUEST.COLLUMNS.ID_SUPERMERCADO + " INTEGER, "
            + DataBaseConstants.GUEST.COLLUMNS.NOME_CORREDOR + " CHARACTER(30) NOT NULL, "
            + DataBaseConstants.GUEST.COLLUMNS.CORREDOR_DESCRICAO + " CHARACTER(50), "
            + "FOREIGN KEY (" + DataBaseConstants.GUEST.COLLUMNS.ID_SUPERMERCADO
            + ") REFERENCES " + DataBaseConstants.GUEST.TABLE_NAME
            + " (" + DataBaseConstants.GUEST.COLLUMNS.ID_SUPERMERCADO + "));";

    // TABELA PRATELEIRA
    private final String SQL_CREATE_TABLE_PRATELEIRA =
            "CREATE TABLE " + DataBaseConstants.GUEST.COLLUMNS.PRATELEIRA + " ( "
            + DataBaseConstants.GUEST.COLLUMNS.ID_PRATELEIRA + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DataBaseConstants.GUEST.COLLUMNS.ID_CORREDOR + " INTEGER, "
            + DataBaseConstants.GUEST.COLLUMNS.NOME_PRATELEIRA + " CHARACTER(30) NOT NULL,"
            + DataBaseConstants.GUEST.COLLUMNS.PRATELEIRA_DESCRICAO + " CHARACTER(50), "
            + "FOREIGN KEY (" + DataBaseConstants.GUEST.COLLUMNS.ID_CORREDOR
            + ") REFERENCES " + DataBaseConstants.GUEST.COLLUMNS.CORREDOR
            + " (" + DataBaseConstants.GUEST.COLLUMNS.ID_CORREDOR + "));";

    // TABELA PRODUTO
    private final String SQL_CREATE_TABLE_PRODUTO =
            "CREATE TABLE " + DataBaseConstants.GUEST.COLLUMNS.PRODUTO + " ( "
            + DataBaseConstants.GUEST.COLLUMNS.ID_PRATELEIRA + " INTEGER, "
            + DataBaseConstants.GUEST.COLLUMNS.PRODUTO_NOME + " CHARACTER(30) NOT NULL, "
            + DataBaseConstants.GUEST.COLLUMNS.PRODUTO_DESCRICAO + " CHARACTER(50), "
            + DataBaseConstants.GUEST.COLLUMNS.PRECO_PRODUTO + " DOUBLE(8,2), "
            + "FOREIGN KEY (" + DataBaseConstants.GUEST.COLLUMNS.ID_PRATELEIRA
            + ") REFERENCES " + DataBaseConstants.GUEST.COLLUMNS.CORREDOR
            + " (" + DataBaseConstants.GUEST.COLLUMNS.ID_CORREDOR + "));";

    private static final String DROP_TABLE_GUEST = "DROP TABLE IF EXISTS" + DataBaseConstants.GUEST.TABLE_NAME;

    public GuestDataBase(Context context) {
        super(context, this.DATABASE_NAME, null, this.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_SUPERMERCADO);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_ENDERECO);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_CONTATO);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_CORREDOR);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_PRATELEIRA);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_PRODUTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // sqLiteDatabase.execSQL(DROP_TABLE_GUEST);
        // sqLiteDatabase.execSQL(SQL_CREATE_TABLE_GUEST);
    }
}
*/