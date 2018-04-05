package WebService;

import java.sql.*;

public class Conexao {
    private Connection conexao;
    private Statement st;
    public ResultSet rs;

    public void conecta(String url,String driver, String usuario, String senha){
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("Erro 1: "+e);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro 2: "+ex);
        }
    }

    public void desconecta(){
        try {
            conexao.close();
        } catch (SQLException e) {
        }
    }

    public void executaAtualizacao(String sql){
        try {
            st = conexao.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erro no comando "+ e);
        }
    }

    public void executaConsulta(String sql){
        try {
            st = conexao.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Erro no select "+ e);
        }
    }

}
