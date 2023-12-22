package br.edu.ifsp.arq.tsi.inoo.cars_renting.controller;

import java.util.ArrayList;

import br.edu.ifsp.arq.tsi.inoo.cars_renting.model.Car;

public class CarsController {
    
    private static CarsController instance;

    private ArrayList<Car> cars; // lista de carros

    private CarsController() {
        cars = new ArrayList<>();
    }

    public static CarsController getInstance() {
        if (instance == null) {
            instance = new CarsController();
        }
        return instance;
    }

    // adiciona um carro na lista de carros
    public boolean addCar(Car car) {
        for (Car c : cars) {
            if (c.getPlate().equals(car.getPlate())) { // verifica se o carro já foi cadastrado
                System.out.println("Carro com a placa " + c.getPlate() + " já cadastrado no sistema.");
                return false;
            }
        }
        cars.add(car); // adiciona o carro na lista de carros
        car.setCode(); // define o código do carro
        
        System.out.println(car.getModel() + " cadastrado com sucesso!\nPlaca: " + car.getPlate() + "\nMarca: " + car.getMaker() + "\nAno: " + car.getYear() + "\nValor da diária: " + car.getValuePerDay() + "\nQuantidade de portas: " + car.getDoorsQty() + "\nAr condicionado: " + (car.isHasAC() ? "Sim" : "Não") + "\nCódigo: " + car.getCode() + "\n");
        return true;
    }

    // seleciona um carro pela placa
    public Car getCarByPlate(String plate) {
        for (Car c : cars) {
            if (c.getPlate().equals(plate)) { // verifica se a placa do carro é igual a placa passada como parametro
                return c;
            }
        }
        return null; // retorna nulo se não encontrar o carro
    }

    // seleciona um carro pelo código do carro
    public Car getCarByCode(int code) {
        for (Car c : cars) {
            if (c.getCode() == code) { // verifica se o código do carro é igual ao código passado como parametro
                return c;
            }
        }
        return null; // retorna nulo se não encontrar o carro
    }
}
