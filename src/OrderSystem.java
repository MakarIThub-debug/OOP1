import java.util.ArrayList;
import java.util.List;

public class OrderSystem {

    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    static class Customer {
        private String name;
        private List<Order> orderHistory;

        public Customer(String name) {
            this.name = name;
            this.orderHistory = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public List<Order> getOrderHistory() {
            return orderHistory;
        }

        public void addOrder(Order order) {
            orderHistory.add(order);
        }
    }

    static class Order {
        private Customer customer;
        private List<Product> products;

        public Order(Customer customer) {
            this.customer = customer;
            this.products = new ArrayList<>();
        }

        public Customer getCustomer() {
            return customer;
        }

        public List<Product> getProducts() {
            return products;
        }

        public void addProduct(Product product) {
            products.add(product);
        }

        public double getTotalCost() {
            double total = 0;
            for (Product product : products) {
                total += product.getPrice();
            }
            return total;
        }
    }

    public static void main(String[] args) {
        // Create some products
        Product apple = new Product("Apple", 1.0);
        Product banana = new Product("Banana", 0.5);
        Product orange = new Product("Orange", 0.75);

        // Create a customer
        Customer john = new Customer("John Doe");

        // Create an order for John
        Order johnOrder = new Order(john);
        johnOrder.addProduct(apple);
        johnOrder.addProduct(banana);
        johnOrder.addProduct(orange);

        // Add the order to John's history
        john.addOrder(johnOrder);

        // Print John's order history and total cost
        System.out.println("Order History for " + john.getName() + ":");
        for (Order order : john.getOrderHistory()) {
            System.out.println("Order total cost: " + order.getTotalCost());
            for(Product product : order.getProducts()){
                System.out.println(product.getName()+ " - " + product.getPrice());
            }
            System.out.println("----");
        }
    }
}
