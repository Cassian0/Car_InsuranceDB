package br.com.Car_InsuranceDB.Model;

public class Vehicle {

    private Integer id;
    private String model; // MODELO
    private String manufacturer; // FABRICANTE
    private String plate; //PLACA
    private String year; // ANO
    private String value; // VALOR
    private Insurance insurance; // SEGURO

    public Vehicle() {
    }

    public Vehicle(Integer id, String model, String manufacturer, String plate, String year, String value) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.plate = plate;
        this.year = year;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    }



