package entities;

public class CashDesc implements Runnable {
    private Receipt receipt;
    private Shop shop;

    public CashDesc(Receipt Receipt, Shop shop) {
        this.receipt=Receipt;
        this.shop=shop;
    }

    @Override
    public void run() {

        for (int i = 0; i <receipt.getListOfGoods().size(); i++) {
            if(shop.areThereEnoughGoods(receipt.getListOfGoods().get(i),1))
            {
                System.out.println(Thread.currentThread().getName() + ": "  + " " + "Cashier : " + receipt.getCashier().getName()+ " "
                        + receipt.getListOfGoods().get(i).getName() + "  " +" Total : " + receipt.getTotalProfit());
                System.out.println("true");
            }
            else
                System.out.println("False" + receipt.getListOfGoods().get(i)  );
        }

    }
}
