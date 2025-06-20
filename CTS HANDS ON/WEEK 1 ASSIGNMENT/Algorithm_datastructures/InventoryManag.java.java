import java.util.HashMap;
import java.util.Map;

class Product {
    String productId;
    String productName;
    int quantity;
    double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}

class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.productId, product);
    }

    public void updateProduct(String productId, String productName, int quantity, double price) {
        Product product = products.get(productId);
        if (product != null) {
            product.productName = productName;
            product.quantity = quantity;
            product.price = price;
        }
    }

    public void deleteProduct(String productId) {
        products.remove(productId);
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }
}

public class InventoryManag{
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Product p1 = new Product("1", "Product 1", 10, 100.0);
        inventory.addProduct(p1);
        Product p2 = new Product("2", "Product 2", 20, 200.0);
        inventory.addProduct(p2);

        System.out.println("Added products.");
        System.out.println("Product 1: " + inventory.getProduct("1").productName);
        System.out.println("Product 2: " + inventory.getProduct("2").productName);

        inventory.updateProduct("1", "Updated Product 1", 15, 150.0);
        System.out.println("Updated Product 1: " + inventory.getProduct("1").productName);

        inventory.deleteProduct("2");
        System.out.println("Deleted Product 2. Exists: " + (inventory.getProduct("2") != null));
    }
}
