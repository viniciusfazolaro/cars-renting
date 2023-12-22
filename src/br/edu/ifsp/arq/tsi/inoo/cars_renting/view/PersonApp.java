package br.edu.ifsp.arq.tsi.inoo.cars_renting.view;

import java.util.Scanner;

import br.edu.ifsp.arq.tsi.inoo.cars_renting.controller.PeopleController;
import br.edu.ifsp.arq.tsi.inoo.cars_renting.model.LegalPerson;
import br.edu.ifsp.arq.tsi.inoo.cars_renting.model.NaturalPerson;
import br.edu.ifsp.arq.tsi.inoo.cars_renting.model.Person;

public class PersonApp {
    public static void main() {

        // limpando o terminal
        ClearConsole.clearConsole();

        // instanciando o scanner
        Scanner sc = new Scanner(System.in);

        // declaração e inicialização de variáveis
        String name = "", cpf = "", cnpj = "", companyName = "";
        int option = -1;

        // instanciando o controller
        PeopleController peopleController = PeopleController.getInstance();

        // entrada de dados

        System.out.println("----- Cadastro de Pessoas -----");

        System.out.print("Nome: ");
        name = sc.nextLine();

        System.out.println("Tipo de pessoa: ");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        do {
            System.out.print("Opção: ");
            option = sc.nextInt();

            if (option < 1 || option > 2) {
                System.out.println("Opção inválida!");
            }
        } while (option < 1 || option > 2);


        // limpa o buffer do teclado
        sc.nextLine();

        
        if (option == 1) {
            System.out.print("CPF: ");
            cpf = sc.nextLine();
            // limpa o terminal
            ClearConsole.clearConsole();
            addPerson(peopleController, new NaturalPerson(name, cpf));
        } else {
            System.out.print("CNPJ: ");
            cnpj = sc.nextLine();
            
            System.out.print("Nome da empresa: ");
            companyName = sc.nextLine();
            // limpa o terminal
            ClearConsole.clearConsole();
            addPerson(peopleController, new LegalPerson(name, cnpj, companyName));
        }

        System.out.println("Pressione ENTER para continuar...");
        sc.nextLine();
    }

    private static void addPerson(PeopleController peopleController, Person person) {
        try {
            if (!peopleController.addPerson(person)) {
                throw new Exception("Erro ao cadastrar a pessoa.\n");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}