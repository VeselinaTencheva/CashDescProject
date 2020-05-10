package entities;

public class NotEnoughItemsException extends Exception {
    private int count;
    private Goods goods;
    public NotEnoughItemsException(){
    }

    public int getCount() {
        return count;
    }

    public Goods getGoods() {
        return goods;
    }

    public NotEnoughItemsException(int count, Goods goods) {
        this.count = count;
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "NotEnoughItemsException{" +
                "The items of : " + goods.getName() +" in the shop are not enough with: " + count +
                '}';
    }
}