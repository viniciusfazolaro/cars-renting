package br.edu.ifsp.arq.tsi.inoo.cars_renting.view;

import java.time.LocalDate;
import java.util.Scanner;

import br.edu.ifsp.arq.tsi.inoo.cars_renting.controller.CarsController;
import br.edu.ifsp.arq.tsi.inoo.cars_renting.model.Car;

public class CarApp {
    public static void main() {

        LocalDate atualDate = LocalDate.now();
        int maxYear = atualDate.getYear();

        // limpando o terminal
        ClearConsole.clearConsole();

        // instanciando o scanner
        Scanner sc = new Scanner(System.in);

        // declaração e inicialização de variáveis
        String maker = "", model = "", plate = "";
        int year = -1, doorsQty = 0, hasACOption = -1;
        double valuePerDay = 0;

        // instanciando o controller
        CarsController carsController = CarsController.getInstance();

        // entrada de dados

        System.out.println("----- Cadastro de Carros -----");

        System.out.print("Marca: ");
        maker = sc.nextLine();

        System.out.print("Modelo: ");
        model = sc.nextLine();

        do{
            System.out.print("Ano: ");
            year = sc.nextInt();

            if(year < 1886){
                System.out.println("Ano inválido! O primeiro carro foi fabricado em 1886.");
            } else if(year > maxYear) {
                System.out.println("Ano inválido! O ano não pode ser maior que o ano atual.");
            }
            
        } while (year < 1886 || year > maxYear);
        
        System.out.print("Placa: ");
        // limpa o buffer do teclado
        sc.nextLine();
        plate = sc.nextLine();

        System.out.print("Quantidade de portas: ");
        doorsQty = sc.nextInt();
        
        do{
            System.out.print("Ar condicionado (1 - Sim | 2 - Não): ");
            hasACOption = sc.nextInt();

            if(hasACOption < 1 || hasACOption > 2){
                System.out.println("Opção inválida!");
            }
        } while (hasACOption < 1 || hasACOption > 2);

        System.out.print("Valor da diária: ");
        valuePerDay = sc.nextDouble();

        // chamada do método para adicionar o carro

        // limpa o terminal
        ClearConsole.clearConsole();

        addCar(carsController, maker, model, year, plate, doorsQty, hasACOption == 1 ? true : false, valuePerDay);

        System.out.println("Pressione ENTER para continuar...");
        sc.nextLine();
        sc.nextLine();
    }

    private static void addCar(CarsController carsController, String maker, String model, int year, String plate, int doorsQty, boolean hasAC, double valuePerDay) {
        try {
            if (!carsController.addCar(new Car(maker, model, year, plate, doorsQty, hasAC, valuePerDay))) {
                throw new RuntimeException("Erro ao cadastrar o carro.\n");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
