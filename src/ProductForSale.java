public abstract class ProductForSale {

    protected String type;
    protected double price;
    protected String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public void printPricedItem(int quantity) {
        System.out.printf("%2d x %s (%s) at £%8.2f each %n", quantity, type, description, price);
    }

    public double getSalesPrice(int quantity) {
        return quantity * price;
    }

    public abstract void showDetails();
}
