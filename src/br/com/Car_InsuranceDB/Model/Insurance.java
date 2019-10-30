package br.com.Car_InsuranceDB.Model;


public class Insurance {

    private Integer id;
    private String name; // NOME
    private String value; //VALOR
    private String franchise;// FRANQUIA
    private String numberPolicy;// NUMERO APOLICE

    public Insurance() {
    }

    public Insurance(String name, String value, String franchise, String numberPolicy) {
        this.name = name;
        this.value = value;
        this.franchise = franchise;
        this.numberPolicy = numberPolicy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public String getNumberPolicy() {
        return numberPolicy;
    }

    public void setNumberPolicy(String numberPolicy) {
        this.numberPolicy = numberPolicy;
    }


}
