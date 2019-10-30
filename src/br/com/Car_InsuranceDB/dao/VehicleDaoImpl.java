package br.com.Car_InsuranceDB.dao;

import br.com.Car_InsuranceDB.Model.Insurance;
import br.com.Car_InsuranceDB.Model.Vehicle;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class VehicleDaoImpl implements Serializable {

    private List<Vehicle> dataVehicle;
    private Connection connection;
    private PreparedStatement prepared;
    private ResultSet result;
    private Vehicle vehicle;
    private InsuranceDaoImpl insuranceDao;
    private Insurance insurance;

    public void save(Vehicle vehicle) {
        String sql = "INSERT INTO Veiculo (modelo, fabricante, placa, ano, valor)"
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            connection = ConnectionFactory.openConnection();
            prepared = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepared.setString(1, vehicle.getModel());
            prepared.setString(2, vehicle.getManufacturer());
            prepared.setString(3, vehicle.getPlate());
            prepared.setString(4, vehicle.getYear());
            prepared.setString(5, vehicle.getValue());
            prepared.executeUpdate();
            result = prepared.getGeneratedKeys();
            result.next();
            vehicle.setId(result.getInt(1));
            insuranceDao = new InsuranceDaoImpl();
            insuranceDao.save(vehicle.getInsurance(), vehicle.getId(), connection);

        } catch (Exception e) {
            System.out.println("erro ao gravar veiculo " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
    }

    public void change(Vehicle vehicle) {
        String sql = "UPDATE Veiculo SET modelo = ?, fabricante = ?, "
                + "placa = ?, ano = ?, valor = ? WHERE idVeiculo = ?";
        try {
            connection = ConnectionFactory.openConnection();
            prepared = connection.prepareStatement(sql);
            prepared.setString(1, vehicle.getModel());
            prepared.setString(2, vehicle.getManufacturer());
            prepared.setString(3, vehicle.getPlate());
            prepared.setString(4, vehicle.getYear());
            prepared.setString(5, vehicle.getValue());
            prepared.setInt(6, vehicle.getId());
            prepared.executeUpdate();
            insuranceDao = new InsuranceDaoImpl();
            insuranceDao.change(vehicle.getInsurance(), connection);
        } catch (Exception e) {
            System.out.println("Erro ao alterar o veiculo" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Veiculo WHERE idVeiculo = ?";
        try {
            connection = ConnectionFactory.openConnection();
            prepared = connection.prepareStatement(sql);
            prepared.setInt(1, id);
            prepared.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao deletar o veiculo " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared);
        }

    }

    public Vehicle searchById(int id) {
        String sql = "SELECT * FROM Veiculo INNER JOIN Seguro ON Veiculo.idVeiculo = "
                + "Seguro.idSeguro WHERE Veiculo.idVeiculo = ?";
        try {
            connection = ConnectionFactory.openConnection();
            prepared = connection.prepareStatement(sql);
            prepared.setInt(1, id);
            result = prepared.executeQuery();
            result.next();
            vehicle = new Vehicle();
            vehicle.setId(result.getInt("Veiculo.idVeiculo"));
            vehicle.setModel(result.getString("modelo"));
            vehicle.setManufacturer(result.getString("fabricante"));
            vehicle.setPlate(result.getString("placa"));
            vehicle.setYear(result.getString("ano"));
            vehicle.setValue(result.getString("valor"));
            insurance = new Insurance();
            insurance.setId(result.getInt("Seguro.idVeiculo"));
            insurance.setName(result.getString("nome"));
            insurance.setValue(result.getString("valor"));
            insurance.setFranchise(result.getString("franquia"));
            insurance.setNumberPolicy(result.getString("numeroApolice"));
            vehicle.setInsurance(insurance);
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar veiculo pelo id " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return vehicle;
    }

    public List<Vehicle> listAll() {
        String sql = "SELECT * FROM Veiculo INNER JOIN Seguro ON Veiculo.idVeiculo = "
                + "Seguro.idVeiculo";
        dataVehicle = new ArrayList<>();
        try {
            connection = ConnectionFactory.openConnection();
            prepared = connection.prepareStatement(sql);
            result = prepared.executeQuery();
            while (result.next()) {
                vehicle = new Vehicle();
                vehicle.setId(result.getInt("Veiculo.idVeiculo"));
                vehicle.setModel(result.getString("modelo"));
                vehicle.setManufacturer(result.getString("fabricante"));
                vehicle.setPlate(result.getString("placa"));
                vehicle.setYear(result.getString("ano"));
                vehicle.setValue(result.getString("valor"));
                insurance = new Insurance();
                insurance.setId(result.getInt("Seguro.idVeiculo"));
                insurance.setName(result.getString("nome"));
                insurance.setValue(result.getString("valor"));
                insurance.setFranchise(result.getString("franquia"));
                insurance.setNumberPolicy(result.getString("numeroApolice"));
                vehicle.setInsurance(insurance);
                dataVehicle.add(vehicle);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar veiculo " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataVehicle;
    }

    public List<Vehicle> searchByModel(String model) {
        String query = "SELECT * FROM Veiculo INNER JOIN Seguro ON Veiculo.idVeiculo = "
                + "Seguro.idVeiculo WHERE modelo LIKE ?";
        dataVehicle = new ArrayList<>();
        try {
            connection = ConnectionFactory.openConnection();
            prepared = connection.prepareStatement(query);
            prepared.setString(1, "%" + model + "%");
            result = prepared.executeQuery();
            while (result.next()) {
                vehicle = new Vehicle();
                vehicle.setId(result.getInt("Veiculo.idVeiculo"));
                vehicle.setModel(result.getString("modelo"));
                vehicle.setManufacturer(result.getString("fabricante"));
                vehicle.setPlate(result.getString("placa"));
                vehicle.setYear(result.getString("ano"));
                vehicle.setValue(result.getString("valor"));
                insurance = new Insurance();
                insurance.setId(result.getInt("Seguro.idVeiculo"));
                insurance.setName(result.getString("nome"));
                insurance.setValue(result.getString("valor"));
                insurance.setFranchise(result.getString("franquia"));
                insurance.setNumberPolicy(result.getString("numeroApolice"));
                vehicle.setInsurance(insurance);
                dataVehicle.add(vehicle);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar Veiculo " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataVehicle;
    }

}
