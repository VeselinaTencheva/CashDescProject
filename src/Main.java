import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import entities.*;

public class Main {
    public static void main(String[] args) {
        Cashier c = new Cashier("John ");
        Cashier c1=new Cashier("Nancy");
        Goods oreo = new Goods("oreo", 1.50, LocalDate.of(2019,12,5));
        Goods milka = new Goods("milka", 1.40, LocalDate.of(2019,4,4));
        Goods strawberries = new Goods("Strawberries", 4.5, LocalDate.of(2019,12,12));
        Goods milk = new Goods("milk", 1.1, LocalDate.of(2020,1,1));

        Shop s1 = new Shop();
        s1.addCashier(c);
        s1.addGoods(oreo, 3);
        s1.addGoods(milka, 19);
        s1.addGoods(milk, 30);
        s1.addGoods(strawberries, 15);

        try {
            s1.addGoodsToReceipt(2, oreo);
            s1.addGoodsToReceipt(1, milka);
            s1.addGoodsToReceipt(1, strawberries);
            s1.addGoodsToReceipt(1, milk);
            s1.addReceipt(s1.MakeReceipt(c, "15/12/2018 08:16"));

            s1.addGoodsToReceipt(3, strawberries);
            s1.addReceipt(s1.MakeReceipt(c1, "15/12/2018 10:30"));
            s1.addGoodsToReceipt(1, strawberries);
            s1.addGoodsToReceipt(4, milka);
            s1.addReceipt(s1.MakeReceipt(c, "15/12/2018 15:56"));


        } catch (NotEnoughItemsException e) {
            System.err.println("Exception caught: " + e);
        }

        s1.WriteFiles();
        System.out.println(s1.getTotalProfit());
        String FileName = "1.txt";
        s1.ReadFiles(FileName);
        CashDesc cd1 = new CashDesc(s1.getListOfReceipts().get(0),s1);
        CashDesc cd2 = new CashDesc(s1.getListOfReceipts().get(1),s1);
        Thread thread1 = new Thread(cd1, "CashDesc1");
        Thread thread2 = new Thread(cd2, "CashDesc2");
        System.out.println("Threads started!");

         thread1.setPriority(Thread.MIN_PRIORITY);
         thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();

        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " state: " + Thread.currentThread().getState());
    }
}
