package br.com.icoddevelopers.findssp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;

public class BancoController{

    private SQLiteDatabase db;
    private BancoDado banco;

    public BancoController(Context context){
        banco = new BancoDado(context);
    }

    public String insereDado(String supermercado, String produto, String corredor, String prateleira, float preco){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BancoDado.getColunaSupermercado(), supermercado);
        valores.put(BancoDado.getColunaProduto(), produto);
        valores.put(BancoDado.getColunaCorredor(), corredor);
        valores.put(BancoDado.getColunaPrateleira(), prateleira);
        valores.put(BancoDado.getColunaPreco(), preco);

        resultado = db.insert(BancoDado.getTabelaProduto(), null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }





}
