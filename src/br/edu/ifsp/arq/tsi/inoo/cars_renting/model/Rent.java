package br.edu.ifsp.arq.tsi.inoo.cars_renting.model;

import java.time.LocalDate;
import java.time.Period;

public class Rent {

    private static int count = 1;
    private int number;
    private LocalDate realizationDate;
    private int qtyDaysRent;
    private LocalDate maxDateReturn;
    private LocalDate returnDate = LocalDate.now();
    private Person person;
    private Car car;
    private boolean returned = false;

    public Rent(int qtyDaysRent, Person person, Car car) {
        this.number = count++;
        this.realizationDate = LocalDate.now();
        this.qtyDaysRent = qtyDaysRent;
        this.maxDateReturn = realizationDate.plusDays(qtyDaysRent);
        this.person = person;
        this.car = car;
    }

    public int getNumber() {
        return number;
    }

    public LocalDate getRealizationDate() {
        return realizationDate;
    }

    public void setRealizationDate(LocalDate realizationDate) {
        this.realizationDate = realizationDate;
    }

    public int getQtyDaysRent() {
        return qtyDaysRent;
    }

    public void setQtyDaysRent(int qtyDaysRent) {
        this.qtyDaysRent = qtyDaysRent;
    }

    public LocalDate getMaxDateReturn() {
        return maxDateReturn;
    }

    public void setMaxDateReturn(LocalDate maxDateReturn) {
        this.maxDateReturn = maxDateReturn;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        if (returnDate.isAfter(maxDateReturn)) {
            this.returnDate = maxDateReturn;
        } else {
            this.returnDate = returnDate;
        }
    }

    public Person getPerson() {
        return person;
    }

    public Person setPerson(Person person) {
        return this.person = person;
    }

    public Car getCar() {
        return car;
    }

    public Car setCar(Car car) {
        return this.car = car;
    }

    public boolean returnCar() {
        if (returned) {
            return false; // o carro foi devolvido anteriormente
        }
    
        // verifica se o carro já foi devolvido em outro método
        if (car.isRented()) {
            returned = true;
            car.setRented(false); // marcar o carro como disponível
            return true; // devolução bem-sucedida
        } else {
            return false; // o carro não está alugado, não pode ser devolvido
        }
    }    

    public double amountToPay() { // calcula o valor total a ser pago baseado nos dias que o carro ficou alugado
        Period period = Period.between(realizationDate, returnDate);
        int days = period.getDays();
        return car.getValuePerDay() * days;
    }

    public double partialAmountToPay() { // calcula o valor parcial a ser pago baseado nos dias que o usuário informou que o carro ficaria alugado
        return car.getValuePerDay() * qtyDaysRent;
    }

}