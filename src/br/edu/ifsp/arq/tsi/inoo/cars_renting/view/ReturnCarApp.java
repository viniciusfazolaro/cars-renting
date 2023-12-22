package br.edu.ifsp.arq.tsi.inoo.cars_renting.view;

import java.util.Scanner;

import br.edu.ifsp.arq.tsi.inoo.cars_renting.controller.CarsController;
import br.edu.ifsp.arq.tsi.inoo.cars_renting.controller.RentsController;
import br.edu.ifsp.arq.tsi.inoo.cars_renting.model.Car;

public class ReturnCarApp {
    public static void main() {

        // limpando o terminal
        ClearConsole.clearConsole();

        // instanciando o scanner
        Scanner sc = new Scanner(System.in);

        // declaração e inicialização de variáveis
        

        // instanciando os controllers
        RentsController rentsController = RentsController.getInstance();
        CarsController carsController = CarsController.getInstance();

        System.out.println("----- Devolução de Carros -----");
        System.out.println("Digite o código do carro: ");
        int code = sc.nextInt();
        Car car = carsController.getCarByCode(code);
        if (car == null) {
            System.out.println("Carro não encontrado!");
        } else {
            realizeCarReturn(rentsController, code, car);
        }
        System.out.println("Pressione ENTER para continuar...");
        sc.nextLine();
        sc.nextLine();
    }

    private static void realizeCarReturn(RentsController rentsController, int code, Car car) {
        try {
            if (!rentsController.realizeCarReturn(code, car)) {
                throw new Exception("Erro ao devolver o carro.\n");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
