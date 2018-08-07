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

    public String insereDado(int cnpj, String produto, String corredor, String prateleira, float preco){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BancoDado.getColunaCnpj(), cnpj);
        valores.put(BancoDado.getColunaProduto(), produto);
        valores.put(BancoDado.getColunaCorredor(), corredor);
        valores.put(BancoDado.getColunaPrateleira(), prateleira);
        valores.put(BancoDado.getColunaPreco(), preco);
        valores.put(BancoDado.getColunaEco(), 0);

        resultado = db.insert(BancoDado.getTabelaProduto(), null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public String insereDadoEco(int cnpj, String produto, String corredor, String prateleira, float preco){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BancoDado.getColunaCnpj(), cnpj);
        valores.put(BancoDado.getColunaProduto(), produto);
        valores.put(BancoDado.getColunaCorredor(), corredor);
        valores.put(BancoDado.getColunaPrateleira(), prateleira);
        valores.put(BancoDado.getColunaPreco(), preco);
        valores.put(BancoDado.getColunaEco(), 1);

        resultado = db.insert(BancoDado.getTabelaProduto(), null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public String insereEmpresa(String supermercado, String email, String rua, int num, String bairro, String cidade, int cnpj, String senha){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BancoDado.getColunaSupermercado(), supermercado);
        valores.put(BancoDado.getColunaEmail(), email);
        valores.put(BancoDado.getColunaRua(), rua);
        valores.put(BancoDado.getColunaNum(), num);
        valores.put(BancoDado.getColunaBairro(), bairro);
        valores.put(BancoDado.getColunaCidade(), cidade);
        valores.put(BancoDado.getColunaCnpj(), cnpj);
        valores.put(BancoDado.getColunaSenha(), senha);

        resultado = db.insert(BancoDado.getTabelaSupermercado(), null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }





}
