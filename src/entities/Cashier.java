package entities;

//save information about id and name of the cashier
public class Cashier {

    private String name;
    private static int counter = 0;
    private int idNumber;

    public Cashier(){
        counter++;
        idNumber=counter;
        name="";
    }

    public Cashier(String name) {
        this.name = name;
        counter++;
        idNumber=counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  int getIdnumber() {
        return idNumber;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "name='" + name + '\'' +
                ", idNumber=" + idNumber +
                '}';
    }
}