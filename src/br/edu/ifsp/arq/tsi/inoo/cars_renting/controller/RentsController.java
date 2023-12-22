package br.edu.ifsp.arq.tsi.inoo.cars_renting.controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import br.edu.ifsp.arq.tsi.inoo.cars_renting.model.Car;
import br.edu.ifsp.arq.tsi.inoo.cars_renting.model.Person;
import br.edu.ifsp.arq.tsi.inoo.cars_renting.model.Rent;

public class RentsController {

    private static RentsController instance;

    private ArrayList<Rent> rents;
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // formatação da data para o padrão brasileiro

    private RentsController() {
        rents = new ArrayList<>();
    }

    public static RentsController getInstance() {
        if (instance == null) {
            instance = new RentsController();
        }
        return instance;
    }

    // verifica se o carro está disponível para aluguel
    public boolean addRent(Person person, Car car, int qtyDaysRent) {
        if (car.isRented()) { // verifica se o carro está alugado
            System.out.println("O " + car.getModel() + " da placa: '" + car.getPlate() + "' já está alugado.");
            return false;
        }
    
        // cria um novo aluguel
        Rent newRent = new Rent(qtyDaysRent, person, car);

        rents.add(newRent); // adiciona o aluguel na lista de alugueis
    
        System.out.println("Aluguel cadastrado com sucesso!\nCódigo do aluguel: " + newRent.getNumber() + "\nCódigo do carro: " + car.getCode() + "\nCarro associado: " + car.getModel() + "\nPlaca: " + car.getPlate() + "\nValor total (" + newRent.getQtyDaysRent() + " dias): R$ " + newRent.partialAmountToPay() + "\nData de retorno máxima: " + newRent.getMaxDateReturn().format(dtf) + "\n");
        car.setRented(true); // marca o carro como alugado
        return true;
    }
    
    
    public boolean realizeCarReturn(int code, Car car) {
        for (Rent r : rents) {
            if (r.getCar().getCode() == code && r.returnCar()) {
                // Carro encontrado e devolvido com sucesso
                System.out.println(r.getCar().getModel() + " devolvido com sucesso no dia " + r.getReturnDate().format(dtf) + "!\nCódigo do aluguel: " + r.getNumber() + "\nPlaca: " + r.getCar().getPlate() + "\nValor total: R$ " + r.amountToPay() + "\n");
                return true;
            }
        }

        for(Rent r: rents) {
            if(r.getCar().getCode() == code && !r.returnCar()) {
                // carro encontrado, mas já foi devolvido
                System.out.println(r.getCar().getModel() + " já foi devolvido no dia " + r.getReturnDate().format(dtf) + "!\nCódigo do aluguel: " + r.getNumber() + "\nPlaca: " + r.getCar().getPlate() + "\nValor total: R$ " + r.amountToPay() + "\n");
                return false;
            } else if(r.getCar().getCode() == code && !r.getCar().isRented()) {
                // carro encontrado, mas não está alugado
                System.out.println(r.getCar().getModel() + " não está alugado!\nCódigo do aluguel: " + r.getNumber() + "\nPlaca: " + r.getCar().getPlate() + "\nValor total: R$ " + r.amountToPay() + "\n");
                return false;
            }
        }

        System.out.println("Carro com o código '" + code + "' não encontrado.");
        return false;
    }    
}
