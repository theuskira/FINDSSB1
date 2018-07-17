package br.com.icoddevelopers.findssp.repository;

import java.sql.Connection;

public class BD {

    private Connection conn;
    private String host;
    private String db = "android";
    private int port = 3306;
    private String user = "android";
    private String pass = "*android*";
    private String url = "jdbc:mysql://*s:*d:*s";

    public BD(){
        super();
        this.url = String.format(this.url, this.host, this.port, this.db);
        // Abrir Conexao
        // Fechar Conexao
    }
}
