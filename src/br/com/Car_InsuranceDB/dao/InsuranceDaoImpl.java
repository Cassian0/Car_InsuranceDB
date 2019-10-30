package br.com.Car_InsuranceDB.dao;

import br.com.Car_InsuranceDB.Model.Insurance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsuranceDaoImpl {

    private PreparedStatement prepared;

    public void save(Insurance insurance, int id, Connection connection) {
        String sql = "INSERT INTO Seguro( nome, valor, franquia, numeroApolice, idVeiculo)"
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            prepared = connection.prepareStatement(sql);
            prepared.setString(1, insurance.getName());
            prepared.setString(2, insurance.getValue());
            prepared.setString(3, insurance.getFranchise());
            prepared.setString(4, insurance.getNumberPolicy());
            prepared.setInt(5, id);
            prepared.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao gravar seguro " + e.getMessage());
        }
    }

    public void change(Insurance insurance, Connection connection) {
        String sql = "UPDATE Seguro SET nome = ?, valor = ?, franquia = ?, numeroApolice = ?"
                + " WHERE idSeguro = ?";
        try {
            prepared = connection.prepareStatement(sql);
            prepared.setString(1, insurance.getName());
            prepared.setString(2, insurance.getValue());
            prepared.setString(3, insurance.getFranchise());
            prepared.setString(4, insurance.getNumberPolicy());
            prepared.setInt(5, insurance.getId());
            prepared.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao alterar a seguro " + e.getMessage());
        }
    }

}
