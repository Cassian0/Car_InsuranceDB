
package br.com.Car_InsuranceDB.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionFactory {
    

   // METODO UTILIZADO PARA ABRIR CONEXÃO COM O BANCO

    public static Connection openConnection() throws Exception { // METODO UTILIZADO PARA ABRIR CONEXÃO COM O BANCO
        // FORNAME É O METODO DENTRO DA CLASSE (CLASS)
        Class.forName("com.mysql.jdbc.Driver");
        // IMPORTAR DRIVER JDBC DA BIBLIOTECA
        return DriverManager.
                getConnection("jdbc:mysql://localhost:3306/SistemaVeiculo",
                        "root", "");
    }

    // ABRE CONEXÃO COM O BANCO DE DADOS E PREPARA AS INSTRUÇÕES DO MYSQL
    public static void closeConnection(Connection conn, PreparedStatement ps) {
        close(conn, ps, null);
    }

    public static void closeConnection(Connection conn, PreparedStatement ps, // PREPARED UTILIZADO EM CONJUNTO COM O INSERT COM O BANCO DE DADOS
            ResultSet rs) { // PEGAR O QUE VEM DO SELECT DO BANCO DE DADOS
        close(conn, ps, rs);
    }

    private static void close(Connection conn, PreparedStatement ps,
            ResultSet rs) {
        try {
            conn.close();
            ps.close();
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqlE) {
            System.out.println("Erro ao fechar conexão " + sqlE.getMessage());
        }
    }

}
    

