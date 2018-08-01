package br.com.icoddevelopers.findssp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;
import android.widget.Toast;

import br.com.icoddevelopers.findssp.views.CadastroProdutosActivity;

public class BancoDado extends SQLiteOpenHelper{

    private static final int VERSAO_BANCO = 1;
    private static final String NOME_BANCO = "banco_simples";

    public static String getTabelaProduto() {
        return TABELA_PRODUTO;
    }

    public static String getColunaSupermercado() {
        return COLUNA_SUPERMERCADO;
    }

    public static String getColunaProduto() {
        return COLUNA_PRODUTO;
    }

    public static String getColunaCorredor() {
        return COLUNA_CORREDOR;
    }

    public static String getColunaPrateleira() {
        return COLUNA_PRATELEIRA;
    }

    private static final String TABELA_PRODUTO = "tb_produto";

    private static final String COLUNA_SUPERMERCADO = "supermercado";
    private static final String COLUNA_PRODUTO = "produto";
    private static final String COLUNA_CORREDOR = "corredor";
    private static final String COLUNA_PRATELEIRA = "prateleira";


    public BancoDado(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String QUERY_COLUNA = "CREATE TABLE " + TABELA_PRODUTO + "("
                + COLUNA_SUPERMERCADO + " TEXT not null, "
                + COLUNA_PRODUTO + " TEXT not null, "
                + COLUNA_CORREDOR + " TEXT not null, "
                + COLUNA_PRATELEIRA + " TEXT not null);";

        db.execSQL(QUERY_COLUNA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    /* CRUD ABAIXO

    public void addProduto(ProdutosSupermercado produtosSupermercado){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUNA_SUPERMERCADO, produtosSupermercado.getSupermercado());
        values.put(COLUNA_PRODUTO, produtosSupermercado.getProduto());
        values.put(COLUNA_CORREDOR, produtosSupermercado.getCorredor());
        values.put(COLUNA_PRATELEIRA, produtosSupermercado.getPrateleira());

        db.insert(TABELA_PRODUTO, null, values);
        db.close();

    }*/

    public void list_Products(String supermercado , String produto, TextView produtoT, TextView corredorT, TextView prateleiraT){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT "
                + COLUNA_PRODUTO + ", "
                + COLUNA_CORREDOR + ", "
                + COLUNA_PRATELEIRA + " FROM " + TABELA_PRODUTO + " WHERE "
                + COLUNA_SUPERMERCADO + " like '%"
                + supermercado +"%' and "
                + COLUNA_PRODUTO + " like '%"
                + produto + "%';", null);
        produtoT.setText("");
        corredorT.setText("");
        prateleiraT.setText("");
        while (cursor.moveToNext()){
            produtoT.append(cursor.getString(0));
            corredorT.append(cursor.getString(1));
            prateleiraT.append(cursor.getString(2));
        }
    }


    public void list_Supermercado(String supermercado, TextView textView){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT " + COLUNA_SUPERMERCADO +" FROM " + TABELA_PRODUTO + " WHERE "
                + COLUNA_SUPERMERCADO + " like '%" + supermercado + "%';", null);
        textView.setText("");
        while (cursor.moveToNext()){
            textView.append(cursor.getString(0));
        }
    }


}
