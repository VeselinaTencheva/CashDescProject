package entities;

import java.io.Serializable;

public class GoodsSelling implements Serializable {
    Receipt receipt;
    Shop shop;

    public GoodsSelling(Receipt receipt, Shop shop) {
        this.receipt = receipt;
        this.shop = shop;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public Shop getShop() {
        return shop;
    }


    public void run() {
        boolean isSold=true;
        for (Goods g : receipt.getListOfGoods()) {
            isSold = shop.areThereEnoughGoods(g,1);
        }
        if (isSold) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
