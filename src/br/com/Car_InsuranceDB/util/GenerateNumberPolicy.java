package br.com.Car_InsuranceDB.util;

import br.com.Car_InsuranceDB.dao.VehicleDaoImpl;
import br.com.Car_InsuranceDB.Model.Vehicle;
import java.util.Calendar;
import java.util.List;

public class GenerateNumberPolicy {

    private List<Vehicle> dataVehicle;
    private Vehicle vehicle;

    public String generatePolicy(String plate) {
        VehicleDaoImpl vehicleDao = new VehicleDaoImpl();
        dataVehicle = vehicleDao.listAll();
        String numPolicy = "";
        if (dataVehicle.isEmpty()) {
            numPolicy = plate + currentYear() + 0;
        } else {
            vehicle = dataVehicle.get(dataVehicle.size() - 1);
            numPolicy = plate + currentYear() + vehicle.getId();
        }
        return numPolicy;
    }

    private String currentYear() {
        Calendar calendar = Calendar.getInstance();
        return Integer.toString(calendar.get(Calendar.YEAR));
    }
}
