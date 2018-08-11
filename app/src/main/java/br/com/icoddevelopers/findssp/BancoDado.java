package br.com.icoddevelopers.findssp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.icoddevelopers.findssp.views.CadastroProdutosActivity;

public class BancoDado extends SQLiteOpenHelper{

    private static final int VERSAO_BANCO = 1;
    private static final String NOME_BANCO = "banco_simples";
    public Context ctx;


    public static String getTabelaProduto() {
        return TABELA_PRODUTO;
    }

    public static String getTabelaSupermercado() {
        return TABELA_SUPERMERCADO;
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

    public static String getColunaPreco() {
        return COLUNA_PRECO;
    }

    public static String getColunaEco() {
        return COLUNA_ECO;
    }

    public static String getColunaCnpj() {
        return COLUNA_CNPJ;
    }

    public static String getColunaEmail() {
        return COLUNA_EMAIL;
    }

    public static String getColunaRua() {
        return COLUNA_RUA;
    }

    public static String getColunaBairro() {
        return COLUNA_BAIRRO;
    }

    public static String getColunaCidade() {
        return COLUNA_CIDADE;
    }

    public static String getColunaNum() {
        return COLUNA_NUM;
    }

    private static final String TABELA_PRODUTO = "tb_produto";
    private static final String TABELA_SUPERMERCADO = "tb_supermercado";

    private static final String COLUNA_SUPERMERCADO = "supermercado";
    private static final String COLUNA_PRODUTO = "produto";
    private static final String COLUNA_CORREDOR = "corredor";
    private static final String COLUNA_PRATELEIRA = "prateleira";
    private static final String COLUNA_PRECO = "preco";
    private static final String COLUNA_ECO = "ECO";
    private static final String COLUNA_CNPJ = "CNPJ";
    private static final String COLUNA_EMAIL = "EMAIL";
    private static final String COLUNA_RUA = "RUA";
    private static final String COLUNA_BAIRRO = "BAIRRO";
    private static final String COLUNA_CIDADE = "CIDADE";
    private static final String COLUNA_NUM = "NUM";
    private static final String COLUNA_SENHA = "SENHA";

    public static String getColunaSenha() {
        return COLUNA_SENHA;
    }

    private  final String TABELA_P = "CREATE TABLE " + TABELA_PRODUTO + "("
            + COLUNA_PRODUTO + " VARCHAR(30) not null, "
            + COLUNA_CORREDOR + " VARCHAR(30) not null, "
            + COLUNA_PRATELEIRA + " VARCHAR(30) not null, "
            + COLUNA_PRECO + " DOUBLE(8.2), "
            + COLUNA_ECO + " BOOLEAN, "
            + COLUNA_CNPJ + " INTEGER(14), "
            + "FOREIGN KEY (" + COLUNA_CNPJ + ") REFERENCES "
            + TABELA_SUPERMERCADO + " (" + COLUNA_CNPJ + "));";

    private final String TABELA_CADASTRO_EMPRESA = "CREATE TABLE " + TABELA_SUPERMERCADO + "("
            + COLUNA_SUPERMERCADO + " VARCHAR(50) NOT NULL, "
            + COLUNA_EMAIL + " VARCHAR(50) UNIQUE NOT NULL, "
            + COLUNA_RUA + " VARCHAR(50) NOT NULL, "
            + COLUNA_NUM + " INTEGER(8), "
            + COLUNA_BAIRRO + " VARCHAR(30) NOT NULL, "
            + COLUNA_CIDADE + " VARCHAR(30) NOT NULL, "
            + COLUNA_CNPJ + " INTEGER(14) PRIMARY KEY, "
            + COLUNA_SENHA + " VARCHAR(50) NOT NULL); ";

    public BancoDado(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABELA_CADASTRO_EMPRESA);
        db.execSQL(TABELA_P);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void list_Products(int cnpj, String produto, TextView produtoT, TextView corredorT, TextView prateleiraT, TextView preco){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT "
                + COLUNA_PRODUTO + ", "
                + COLUNA_CORREDOR + ", "
                + COLUNA_PRATELEIRA + ", "
                + COLUNA_PRECO + " FROM " + TABELA_PRODUTO + " WHERE "
                + COLUNA_CNPJ + " = "
                + cnpj + " AND "
                + COLUNA_PRODUTO + " LIKE '%"
                + produto + "%' and " + COLUNA_ECO +" = 0;", null);
        produtoT.setText("");
        corredorT.setText("");
        prateleiraT.setText("");
        preco.setText("");
        while (cursor.moveToNext()){
            produtoT.append(cursor.getString(0));
            corredorT.append(cursor.getString(1));
            prateleiraT.append(cursor.getString(2));
            preco.append(cursor.getString(3));
        }
    }

    public void list_All_Products(int cnpj, String produto, TextView produtoT, TextView corredorT, TextView prateleiraT, TextView preco){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT "
                + COLUNA_PRODUTO + ", "
                + COLUNA_CORREDOR + ", "
                + COLUNA_PRATELEIRA + ", "
                + COLUNA_PRECO + " FROM " + TABELA_PRODUTO + " WHERE "
                + COLUNA_CNPJ + " = "
                + cnpj + " AND "
                + COLUNA_PRODUTO + " LIKE '%"
                + produto + "%';", null);
        produtoT.setText("");
        corredorT.setText("");
        prateleiraT.setText("");
        preco.setText("");
        while (cursor.moveToNext()){
            produtoT.append(cursor.getString(0));
            corredorT.append(cursor.getString(1));
            prateleiraT.append(cursor.getString(2));
            preco.append(cursor.getString(3));
        }
    }

    public void list_ProductsEco(int cnpj, String produto, TextView produtoT, TextView corredorT, TextView prateleiraT, TextView preco){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT "
                + COLUNA_PRODUTO + ", "
                + COLUNA_CORREDOR + ", "
                + COLUNA_PRATELEIRA + ", "
                + COLUNA_PRECO + " FROM " + TABELA_PRODUTO + " WHERE "
                + COLUNA_CNPJ + " = "
                + cnpj + " AND "
                + COLUNA_PRODUTO + " LIKE '%"
                + produto + "%' and " + COLUNA_ECO +" = 1;", null);
        produtoT.setText("");
        corredorT.setText("");
        prateleiraT.setText("");
        preco.setText("");
        while (cursor.moveToNext()){
            produtoT.append(cursor.getString(0));
            corredorT.append(cursor.getString(1));
            prateleiraT.append(cursor.getString(2));
            preco.append(cursor.getString(3));
        }
    }

    public void list_Supermercado(String supermercado, TextView sup,TextView cnp){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT " + COLUNA_SUPERMERCADO + ", "
                + COLUNA_CNPJ + " FROM " + TABELA_SUPERMERCADO + " WHERE "
                + COLUNA_SUPERMERCADO + " like '" + supermercado + "%';", null);
        sup.setText("");
        cnp.setText("");
        while (cursor.moveToNext()){
            sup.append(cursor.getString(0));
            cnp.append(cursor.getString(1));
        }
    }

    public Boolean verificar_login(String login, String senha){
        boolean have = false;
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT " + COLUNA_EMAIL +", " + COLUNA_SENHA +" FROM " + TABELA_SUPERMERCADO + " WHERE "
                + COLUNA_EMAIL + " = '" + login + "' and " + COLUNA_SENHA + " = '"
                + senha + "';", null);

        while (cursor.moveToNext()){
            if(login.equals(cursor.getString(0)) && senha.equals(cursor.getString(1))){
                have = true;
                break;
            }
        }
        return  have;
    }

    public void verificar_cnpj(String email, TextView cnpj){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT " + COLUNA_CNPJ + " FROM " + TABELA_SUPERMERCADO + " WHERE "
                + COLUNA_EMAIL + " = '" + email + "';", null);
        cnpj.setText("");
        while (cursor.moveToNext()){
            cnpj.append(cursor.getString(0));
        }
    }

    public void verificar_empresa(String email, TextView empresa){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT " + COLUNA_SUPERMERCADO + " FROM " + TABELA_SUPERMERCADO + " WHERE "
                + COLUNA_EMAIL + " = '" + email + "';", null);
        empresa.setText("");
        while (cursor.moveToNext()){
            empresa.append(cursor.getString(0));
        }
    }

    public void conta(int cnpjS, TextView empresa, TextView cnpj, TextView email, TextView rua, TextView numero, TextView bairro, TextView cidade){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT " + COLUNA_SUPERMERCADO + ", "
                + COLUNA_CNPJ + ", "
                + COLUNA_EMAIL + ", "
                + COLUNA_RUA + ", "
                + COLUNA_NUM + ", "
                + COLUNA_BAIRRO + ", "
                + COLUNA_CIDADE + " FROM " + TABELA_SUPERMERCADO + " WHERE "
                + COLUNA_CNPJ + " = " + cnpjS + ";", null);
        empresa.setText("");
        cnpj.setText("");
        email.setText("");
        rua.setText("");
        numero.setText("");
        bairro.setText("");
        cidade.setText("");
        while (cursor.moveToNext()){
            empresa.append(cursor.getString(0));
            cnpj.append(cursor.getString(1));
            email.append(cursor.getString(2));
            rua.append(cursor.getString(3));
            numero.append(cursor.getString(4));
            bairro.append(cursor.getString(5));
            cidade.append(cursor.getString(6));
        }
    }

    public boolean verificarEmail(String email){
        boolean have = false;
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT "
                + COLUNA_EMAIL + " FROM "
                + TABELA_SUPERMERCADO + " WHERE "
                + COLUNA_EMAIL + " = '"
                + email + "';", null);

        while (cursor.moveToNext()){
            if(email.equals(cursor.getString(0))){
                have = true;
                break;
            }
        }
        return  have;
    }

    public boolean verificarCNPJ(Long cnpj){
        boolean have = false;
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT "
                + COLUNA_CNPJ + " FROM "
                + TABELA_SUPERMERCADO + " WHERE "
                + COLUNA_CNPJ + " = "
                + cnpj + ";", null);

        while (cursor.moveToNext()){
            if(cnpj == cursor.getLong(cursor.getColumnIndex(COLUNA_CNPJ))){
                have = true;
                break;
            }
        }
        return have;
    }

    public ArrayList<ProdutosSupermercado> listAllProducts(int cnpj){
        ArrayList<ProdutosSupermercado> allProdutos = new ArrayList<>();
        String sql = "SELECT * FROM " + TABELA_PRODUTO
                + " WHERE " + COLUNA_CNPJ + " = " + cnpj + " AND " + COLUNA_ECO + " = 0;";

        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()) {
            ProdutosSupermercado produtoAtual = new ProdutosSupermercado();
            produtoAtual.setProduto(cursor.getString(cursor.getColumnIndex(COLUNA_PRODUTO)));
            produtoAtual.setCorredor(cursor.getString(cursor.getColumnIndex(COLUNA_CORREDOR)));
            produtoAtual.setPrateleira(cursor.getString(cursor.getColumnIndex(COLUNA_PRATELEIRA)));
            produtoAtual.setPreco(cursor.getString(cursor.getColumnIndex(COLUNA_PRECO)));

            allProdutos.add(produtoAtual);
        }

        return allProdutos;
    }

    public ArrayList<ProdutosSupermercado> listProducts(int cnpj, String produto){
        ArrayList<ProdutosSupermercado> allProdutos = new ArrayList();
        String sql = "SELECT * FROM " + TABELA_PRODUTO
                + " WHERE " + COLUNA_CNPJ + " = " + cnpj +" AND "+COLUNA_PRODUTO+" LIKE '%"+produto+"%'"+ " AND " + COLUNA_ECO + " = 0;";

        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null);

        while (cursor.moveToNext()){
            ProdutosSupermercado produtoAtual = new ProdutosSupermercado();
            produtoAtual.setProduto(cursor.getString(cursor.getColumnIndex(COLUNA_PRODUTO)));
            produtoAtual.setCorredor(cursor.getString(cursor.getColumnIndex(COLUNA_CORREDOR)));
            produtoAtual.setPrateleira(cursor.getString(cursor.getColumnIndex(COLUNA_PRATELEIRA)));
            produtoAtual.setPreco(cursor.getString(cursor.getColumnIndex(COLUNA_PRECO)));

            allProdutos.add(produtoAtual);
        }

        return allProdutos;
    }
}
