package duke.choice;

public class Clothing implements Comparable<Clothing> {
    private String description;
    private double price;
    private String size="M";
    public final static double minPrice=10;
    public final static double tax=0.2;

    public Clothing(String description, double price, String aSize) {
        this.description = description;
        this.price = price;
        size=aSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {

        return price+(price * getTax());
    }

    public void setPrice(double price) {
        this.price = (price < minPrice)? minPrice :price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public double getTax() {
        return tax;
    }

    @Override
    public String toString(){
        return getDescription() + ", Price: " + getPrice() + "size :" + getSize() ;
    }
    @Override
    public int compareTo(Clothing c){
        return this.description.compareTo(c.description);
    }
}
