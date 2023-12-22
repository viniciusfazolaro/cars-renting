package br.edu.ifsp.arq.tsi.inoo.cars_renting.view;

import java.util.Scanner;

import br.edu.ifsp.arq.tsi.inoo.cars_renting.controller.CarsController;
import br.edu.ifsp.arq.tsi.inoo.cars_renting.controller.PeopleController;
import br.edu.ifsp.arq.tsi.inoo.cars_renting.controller.RentsController;
import br.edu.ifsp.arq.tsi.inoo.cars_renting.model.Car;
import br.edu.ifsp.arq.tsi.inoo.cars_renting.model.Person;

public class RentApp {
    public static void main() {

        // limpando o terminal
        ClearConsole.clearConsole();

        // instanciando o scanner
        Scanner sc = new Scanner(System.in);

        // declaração e inicialização de variáveis
        String id = "", plate = "";
        int qtyDaysRent = 0;

        // instanciando os controllers
        RentsController rentsController = RentsController.getInstance();
        PeopleController peopleController = PeopleController.getInstance();
        CarsController carsController = CarsController.getInstance();

        System.out.println("----- Cadastro de Aluguel -----");
        System.out.println("Digite o CPF/CNPJ do cliente: ");
        id = sc.nextLine();
        Person person = peopleController.getPersonById(id);
        if (person == null) {
            System.out.println("Cliente não encontrado!");
        } else {
            System.out.println("Digite a placa do carro: ");
            plate = sc.nextLine();
            Car car = carsController.getCarByPlate(plate);
            if (car == null) {
                // limpa o terminal
                ClearConsole.clearConsole();
                System.out.println("Carro não encontrado!");
            } else {
                System.out.println("Digite a quantidade de dias do aluguel: ");
                qtyDaysRent = sc.nextInt();
                // limpa o terminal
                ClearConsole.clearConsole();
                addRent(rentsController, qtyDaysRent, person, car);
            }
        }

        System.out.println("Pressione ENTER para continuar...");
        sc.nextLine();
        sc.nextLine();
    }

    private static void addRent(RentsController rentsController, int qtyDaysRent, Person person, Car car) {
        try {
            if (!rentsController.addRent(person, car, qtyDaysRent)) {
                throw new Exception("Erro ao cadastrar o aluguel.\n");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
