package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop implements getProfit {
    private List<Goods> listOfGoods;
    private List<Cashier>listOfCashiers;
    private List<Receipt>listOfReceipts;
    private  List<Goods> listOfSoldGoods;
    public Shop(){
        listOfCashiers=new ArrayList<Cashier>();
        listOfGoods=new ArrayList<Goods>();
        listOfReceipts=new ArrayList<Receipt>();
        listOfSoldGoods=new ArrayList<Goods>();
    }
    public void addCashier(Cashier c){
        if(!listOfCashiers.contains(c))
            listOfCashiers.add(c);
        else
            System.out.println("This cashier already work in this shop");
    }
    public void addReceipt(Receipt c){
        if(!listOfReceipts.contains(c))
            listOfReceipts.add(c);
        else
            System.out.println("This receipt already exist");
    }
    public void addGoods(Goods g, int cnt){
        for(int i=0;i<cnt;i++)
            listOfGoods.add(g);
    }
    public void addGoodsInSold(Goods g,int count){
        for(int i=0;i<count;i++)
            listOfSoldGoods.add(g);
    }
    public List<Receipt> getListOfReceipts(){
        return listOfReceipts;
    }
    public void removeGoods(Goods g, int cnt) {
        for(int i=0;i<cnt;i++)
            listOfGoods.remove(g);
    }
    private int countOfGoodsInList(Goods g){
        int CountOfGoodsInList=0;
        for(Goods goods:listOfGoods){
            if(goods.getName()==g.getName())
                CountOfGoodsInList++;
        }
        return CountOfGoodsInList;
    }
    public boolean areThereEnoughGoods(Goods good,int count){
        return countOfGoodsInList(good)>count;

    }
    public void addGoodsToReceipt(int count, Goods g) throws NotEnoughItemsException {
        if(!areThereEnoughGoods(g,count))
        {
            throw new NotEnoughItemsException(count-countOfGoodsInList(g),g);
        }
        else {

            removeGoods(g, count);
            addGoodsInSold(g,count);
        }
    }
    public Receipt MakeReceipt(Cashier cashier,String time){
        Receipt receipt=new Receipt(cashier,time);
        for(Goods g:listOfSoldGoods){
            receipt.addGoodToReceipt(g,1);
        }
        listOfSoldGoods.removeAll(listOfSoldGoods);

        return receipt;

    }
    public void WriteFiles(){
        for(Receipt receipt:listOfReceipts){
            String outputFilename=receipt.getIdNumberOfReceipt();
            try (FileWriter fout = new FileWriter(new File(outputFilename), false)) {

                if (this != null) {
                    fout.append(receipt.toString() + System.lineSeparator());
                    fout.close();
                }
            } catch (IOException e) {
                System.out.println("IOException " + e);
            }

        }
    }
    public void ReadFiles(String name) {

        try {
            File input = new File(name);
            Scanner sc = new Scanner(input);
            while(sc.hasNextLine()) {
                String s = sc.nextLine();
                System.out.println(s);
            }
        }
        catch(FileNotFoundException e) {
            System.err.println("File not found. Please scan in new file.");
        }

    }
    @Override
    public double getTotalProfit() {
        double sum=0;
        for(Receipt r:listOfReceipts)
            sum+=r.getTotalProfit();
        return sum;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "listOfGoods=" + listOfGoods +
                ", listOfCashiers=" + listOfCashiers +
                ", listOfReceipts=" + listOfReceipts +
                '}';
    }

}