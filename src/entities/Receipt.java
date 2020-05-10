package entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Receipt implements getProfit {
    private static int counter = 0;
    private int idNumber;
    private Cashier cashier;
    private String date;
    private List<Goods> listOfGoods;
    public Receipt(){
        counter++;
    }

    public Receipt(Cashier cashier, String date) {
        counter++;
        this.idNumber = counter;
        this.cashier = cashier;
        this.date = date;
        this.listOfGoods = new ArrayList<>();
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Receipt.counter = counter;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Goods> getListOfGoods() {
        return listOfGoods;
    }

    public void setListOfGoods(List<Goods> listOfGoods) {
        this.listOfGoods = listOfGoods;
    }

    public void addGoodToReceipt(Goods good, int cnt){
        for(int i=0;i<cnt;i++){
            listOfGoods.add(good);
        }
    }

    public String getIdNumberOfReceipt(){
        return getIdNumber()+".txt";
    }

    @Override
    public double getTotalProfit() {
        double sum=0;
        for(Goods g:listOfGoods)
        {
            sum+=g.getPrice();
        }
        return sum;
    }

    public  void writeGoods(String outputFilename) {

        try (FileWriter fout = new FileWriter(new File(outputFilename), false)) {

            if (this != null) {
                fout.append(this.toString() + System.lineSeparator());
                fout.close();
            }
        } catch (IOException e) {
            System.out.println("IOException " + e);
        }

    }

    public  void ReadGoods(String outputFilename)  {
        try (FileReader fis = new FileReader(new File(outputFilename))) {
            BufferedReader bufferedReader = new BufferedReader(fis);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line=this.toString();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("IOException " + e);
        }
    }

    public String ShowReceipt() {
        System.out.println(this.toString());
        for (Goods g : listOfGoods) {
            System.out.println("Item: "+ g.getName() + " Price: "+g.getPrice()+" BGN.");
        }
        return ("Total sum: " + getTotalProfit() +" BGN");
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "idNumber=" + idNumber +
                ", cashier=" + cashier +
                ", date=" + date +
                ", listOfGoods=" + listOfGoods +
                '}';
    }


}