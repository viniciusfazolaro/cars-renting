package br.edu.ifsp.arq.tsi.inoo.cars_renting.model;

public class NaturalPerson extends Person {

    protected String cpf;

    public NaturalPerson(String name, String cpf) {
        super(name);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getId() {
        return cpf;
    }

    @Override
    public boolean isNatural() {
        return true;
    }

}
