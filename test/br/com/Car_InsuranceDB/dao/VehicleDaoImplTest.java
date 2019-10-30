
package br.com.Car_InsuranceDB.dao;

import br.com.Car_InsuranceDB.dao.VehicleDaoImpl;
import br.com.Car_InsuranceDB.Model.Insurance;
import br.com.Car_InsuranceDB.Model.Vehicle;
import br.com.Car_InsuranceDB.util.GenerateNumberPolicy;
import java.util.List;


public class VehicleDaoImplTest {

    private VehicleDaoImpl vehicleDao;
    private Vehicle vehicle;
    private Insurance insurance;
    private List<Vehicle> dataVehicle;

    public VehicleDaoImplTest() {
        vehicleDao = new VehicleDaoImpl();
    }

    //@Test
    public void testSave() {
        System.out.println("Salvar");
        vehicle = new Vehicle(null, "corsa", "chevrolet", "MDC-1234", "2005", "9000");
        GenerateNumberPolicy generator = new GenerateNumberPolicy();
        insurance = new Insurance("Liberty", "200", "1500", generator.generatePolicy(vehicle.getPlate()));
        vehicle.setInsurance(insurance);
        vehicleDao.save(vehicle);
    }

    //@Test
    public void testChange() {
        System.out.println("Alterar");
        int id = 1;
        vehicle = new Vehicle(id, "onix", "chevrolet", "MDC-4564", "2010", "20000");
        GenerateNumberPolicy generator = new GenerateNumberPolicy();
        insurance = new Insurance("TokyoMarine", "150", "1000", generator.generatePolicy(vehicle.getPlate()));
        insurance.setId(id);
        vehicle.setInsurance(insurance);
        vehicleDao.change(vehicle);
    }

    //@Test
    public void testDelete() {
        System.out.println("Deletar");
        int id = 3;
        vehicleDao.delete(id);
    }

    // @Test
    public void testSearchById() {
        System.out.println("Pesquisar Por Id:");
        int id = 2;
        vehicle = vehicleDao.searchById(id);
        System.out.println("ID: " + vehicle.getId());
        System.out.println("Modelo: " + vehicle.getModel());
        System.out.println("Fabricante: " + vehicle.getManufacturer());
        System.out.println("Placa: " + vehicle.getPlate());
        System.out.println("Ano: " + vehicle.getYear());
        System.out.println("Valor: " + vehicle.getValue());
        System.out.println("ID Seguro: " + vehicle.getInsurance().getId());
        System.out.println("Nome do Seguro: " + vehicle.getInsurance().getName());
        System.out.println("Valor: " + vehicle.getInsurance().getValue());
        System.out.println("Franquia: " + vehicle.getInsurance().getFranchise());
        System.out.println("Numero da Apolice: " + vehicle.getInsurance().getNumberPolicy());

    }

    // @Test
    public void testListAll() {
        System.out.println("Listar Todos");
        dataVehicle = vehicleDao.listAll();
        for (Vehicle vehicle1 : dataVehicle) {
            System.out.println("ID: " + vehicle1.getId());
            System.out.println("Modelo: " + vehicle1.getModel());
            System.out.println("Fabricante: " + vehicle1.getManufacturer());
            System.out.println("Placa: " + vehicle1.getPlate());
            System.out.println("Ano: " + vehicle1.getYear());
            System.out.println("Valor: " + vehicle1.getValue());
            System.out.println("ID Seguro: " + vehicle1.getInsurance().getId());
            System.out.println("Nome do Seguro: " + vehicle1.getInsurance().getName());
            System.out.println("Valor: " + vehicle1.getInsurance().getValue());
            System.out.println("Franquia: " + vehicle1.getInsurance().getFranchise());
            System.out.println("Numero da Apolice: " + vehicle1.getInsurance().getNumberPolicy());
            System.out.println();

        }

    }

//     @Test
    public void testSearchByModel() {
        System.out.println("Pesquisar Por Modelo:");
        String model = "ix";
        dataVehicle = vehicleDao.searchByModel(model);
        for (Vehicle veiculo1 : dataVehicle) {
            System.out.println("ID: " + veiculo1.getId());
            System.out.println("Modelo: " + veiculo1.getModel());
            System.out.println("Fabricante: " + veiculo1.getManufacturer());
            System.out.println("Placa: " + veiculo1.getPlate());
            System.out.println("Ano: " + veiculo1.getYear());
            System.out.println("Valor: " + veiculo1.getValue());
            System.out.println("ID Seguro: " + veiculo1.getInsurance().getId());
            System.out.println("Nome do Seguro: " + veiculo1.getInsurance().getName());
            System.out.println("Valor: " + veiculo1.getInsurance().getValue());
            System.out.println("Franquia: " + veiculo1.getInsurance().getFranchise());
            System.out.println("Numero da Apolice: " + veiculo1.getInsurance().getNumberPolicy());
            System.out.println();

        }

    }
}
