package duke.choice;

public class Customer {
    private String name;
    private String size;

    private Clothing[] items;

    public Customer(String name, int measurement) {
        this.name = name;
        setSize(measurement);
    }

    public void addItems(Clothing[] someitems) {
        items = someitems;

    }

    public Clothing[] getItems() {
        return items;
    }

    public double getTotalClothingCost() {
        double total = 0.0;

        for (Clothing item : items) {
            if (item.getSize().equals(size)) {
                total += item.getPrice();
            }
        }
        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSize(int measurement) {
        switch (measurement) {
            case 1:
            case 2:
            case 3:
                setSize("M");
                break;
            case 4:
            case 5:
            case 6:
                setSize("L");
                break;
            case 7:
            case 8:
            case 9:
                setSize("XL");
                break;
            case 10:
            case 11:
            case 12:
                setSize("XLL");
                break;
            default:
                setSize("S");
        }

    }
}
