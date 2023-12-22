package br.edu.ifsp.arq.tsi.inoo.cars_renting.view;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option = 0;

        do {
            Menu.main();
            
            option = sc.nextInt();
            sc.nextLine(); // limpa o buffer do teclado
            

            switch (option) {
            case 1:
                CarApp.main();
                break;
            case 2:
                PersonApp.main();
                break;
            case 3:
                RentApp.main();
                break;
            case 4:
                ReturnCarApp.main();
                break;
            case 5:
                ClearConsole.clearConsole();
                System.out.println("Saindo...");
                System.out.println("Pressione ENTER para continuar...");
                sc.nextLine();
                break;
            default:
                ClearConsole.clearConsole();
                System.out.println("Opção inválida!");
                System.out.println("Pressione ENTER para continuar...");
                sc.nextLine();
                break;
            }
        } while (option != 5);

        sc.close();
    }
}
