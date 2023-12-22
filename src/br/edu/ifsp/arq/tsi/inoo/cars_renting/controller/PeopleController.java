package br.edu.ifsp.arq.tsi.inoo.cars_renting.controller;

import java.util.ArrayList;

import br.edu.ifsp.arq.tsi.inoo.cars_renting.model.LegalPerson;
import br.edu.ifsp.arq.tsi.inoo.cars_renting.model.Person;

public class PeopleController {
    
    private static PeopleController instance;

    private ArrayList<Person> people;

    private PeopleController() {
        people = new ArrayList<>();
    }

    public static PeopleController getInstance() {
        if (instance == null) {
            instance = new PeopleController();
        }
        return instance;
    }

    // adiciona uma pessoa na lista de pessoas
    public boolean addPerson(Person person) {
        for (Person p : people) {
            if (p.getId().equals(person.getId())) { // verifica se a pessoa já foi cadastrada (CPF/CNPJ)
                System.out.println("Cliente com o " + (person.isNatural() ? "CPF" : "CNPJ") + ": " + p.getId() + " já foi cadastrado no sistema.");
                return false;
            }
        }
        
        people.add(person); // adiciona a pessoa na lista de pessoas
        person.setCode(); // define o código da pessoa
    
        System.out.println("Cliente cadastrado com sucesso!\nNome: " + person.getName() + "\nIdentificador " + (person.isNatural() ? "CPF" : "CNPJ") + ": " + person.getId() + "\n" + (person.isNatural() ? "" : "Razão social: " + ((person instanceof LegalPerson) ? ((LegalPerson) person).getCompanyName() + "\n" : "")) + "Código: " + person.getCode() + "\n");
        return true;
    }
    
    // seleciona uma pessoa pelo CPF/CNPJ
    public Person getPersonById(String id) {
        for (Person p : people) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null; // retorna nulo se não encontrar a pessoa
    }
}
