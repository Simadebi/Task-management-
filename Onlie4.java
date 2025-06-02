import java.util.*;

class User {
    private String userId;
    private String name;
    private String email;
    private Account account;
    private List<Order> orders = new ArrayList<>();

    public User(String userId, String name, String email, Account account) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.account = account;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void viewOrders() {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}

class Account {
    private String username;
    private String password;
    private String email;

    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}

class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }
    public String toString() {
        return name + " ($" + price + ")";
    }
}

class ShoppingCart {
    private String cartId;
    private List<Product> items = new ArrayList<>();

    public ShoppingCart(String cartId) {
        this.cartId = cartId;
    }

    public void addProduct(Product product) {
        items.add(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }

    public List<Product> getItems() {
        return items;
    }

    public void viewCart() {
        for (Product p : items) {
            System.out.println(p);
        }
    }
}

class Order {
    private String orderId;
    private Date date;
    private String status;
    private List<Product> products;
    private Shipment shipment;

    public Order(String orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
        this.date = new Date();
        this.status = "Processing";
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public String toString() {
        return "Order ID: " + orderId + ", Status: " + status + ", Products: " + products;
    }
}

class Shipment {
    private String shipmentId;
    private String address;
    private Date deliveryDate;

    public Shipment(String shipmentId, String address, Date deliveryDate) {
        this.shipmentId = shipmentId;
        this.address = address;
        this.deliveryDate = deliveryDate;
    }
}

public class OnlineShopping {
    public static void main(String[] args) {
        Account acc = new Account("john_doe", "1234", "john@example.com");
        User user = new User("U001", "John Doe", "john@example.com", acc);

        Product p1 = new Product("P101", "Laptop", 1200.00);
        Product p2 = new Product("P102", "Mouse", 25.50);

        ShoppingCart cart = new ShoppingCart("C001");
        cart.addProduct(p1);
        cart.addProduct(p2);

        System.out.println("Cart Items:");
        cart.viewCart();
        System.out.println("Total Price: $" + cart.getTotalPrice());

        Order order = new Order("O1001", cart.getItems());
        Shipment shipment = new Shipment("S2001", "123 Main St", new Date());
        order.setShipment(shipment);

        user.addOrder(order);
        System.out.println("\nUser Orders:");
        user.viewOrders();
    }
}