package br.com.icoddevelopers.findssp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDado extends SQLiteOpenHelper{

    private static final int VERSAO_BANCO = 1;
    private static final String NOME_BANCO = "banco_simples";

    private static final String TABELA_PRODUTO = "tb_produto";

    private static final String COLUNA_SUPERMERCADO = "supermercado";
    private static final String COLUNA_PRODUTO = "produto";
    private static final String COLUNA_PRECO = "preco";
    private static final String COLUNA_CORREDOR = "corredor";
    private static final String COLUNA_PRATELEIRA = "prateleira";


    public BancoDado(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String QUERY_COLUNA = "CREATE TABLE " + TABELA_PRODUTO + "("
                + COLUNA_SUPERMERCADO + " varchar(50) not null, "
                + COLUNA_PRODUTO + " varchar(30) not null, "
                + COLUNA_PRECO + " double(8,2), "
                + COLUNA_CORREDOR + " varchar(30) not null, "
                + COLUNA_PRATELEIRA + " varchar(30) not null);";

        db.execSQL(QUERY_COLUNA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    /* CRUD ABAIXO */

    public void addProduto(ProdutosSupermercado produtosSupermercado){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUNA_PRODUTO, produtosSupermercado.getProduto());
        values.put(COLUNA_SUPERMERCADO, produtosSupermercado.getSupermercado());
        values.put(COLUNA_PRECO, produtosSupermercado.getPreco());
        values.put(COLUNA_CORREDOR, produtosSupermercado.getCorredor());
        values.put(COLUNA_PRATELEIRA, produtosSupermercado.getPrateleira());

        db.insert(TABELA_PRODUTO, null, values);
        db.close();

    }

    public void recebeProduto(ProdutosSupermercado produtosSupermercado){
        SQLiteDatabase db =  this.getReadableDatabase();

        ContentValues values = new ContentValues();


    }
}
