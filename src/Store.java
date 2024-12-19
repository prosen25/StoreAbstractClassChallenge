import java.util.ArrayList;

record OrderItem(int quantity, ProductForSale product){}

public class Store {

    private static ArrayList<ProductForSale> storeProduct = new ArrayList<>();

    public static void main(String[] args) {

        storeProduct.add(new ArtObject("Oil Painting", 1350, "Impressionistic work by ABF painted in 2010"));
        storeProduct.add(new ArtObject("Sculpture", 2000, "Bronze work by JKF, produced in 1950"));
        storeProduct.add(new Furniture("Desk", 500, "Mahogany Desk"));
        storeProduct.add(new Furniture("Lamp", 200, "Tiffany Lamp with Hummingbirds"));

        listProducts();

        System.out.println("\nOrder 1");
        var order1 = new ArrayList<OrderItem>();
        addItemOrder(order1, 1, 2);
        addItemOrder(order1, 0, 1);
        printOrder(order1);

        System.out.println("\nOrder 2");
        var order2 = new ArrayList<OrderItem>();
        addItemOrder(order2, 3, 5);
        addItemOrder(order2, 0, 1);
        addItemOrder(order2, 2, 2);
        printOrder(order2);
    }

    public static void listProducts() {
        for (var item : storeProduct) {
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemOrder(ArrayList<OrderItem> order, int orderIndex, int quantity) {
        order.add(new OrderItem(quantity, storeProduct.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order) {
        double salesTotal = 0;
        for (var item : order) {
            item.product().printPricedItem(item.quantity());
            salesTotal += item.product().getSalesPrice(item.quantity());
        }
        System.out.printf("Sales Total = £%6.2f %n", salesTotal);
    }
}