package br.edu.ifsp.arq.tsi.inoo.cars_renting.model;

public class LegalPerson extends Person {

    protected String cnpj;
    protected String companyName;

    public LegalPerson(String name, String cnpj, String companyName) {
        super(name);
        this.cnpj = cnpj;
        this.companyName = companyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String getId() {
        return cnpj;
    }

    @Override
    public boolean isNatural() {
        return false;
    }
}
