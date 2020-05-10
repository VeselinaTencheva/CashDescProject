package entities;

import java.time.LocalDate;

public class Goods {
    private static  int counter = 0;
    private int idNumber;
    private String name;
    private double price;
    private LocalDate expirationDate;

    public Goods() {
        counter++;
        this.idNumber = counter;
        this.name="";
        this.price=0.0;
        expirationDate=null;
    }

    public Goods(String name, double price, LocalDate expirationDate) {

        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
        counter++;
        this.idNumber = counter;
    }


    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Goods.counter = counter;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "idNumber=" + idNumber +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expirationDate=" + expirationDate +
                '}';
    }
}