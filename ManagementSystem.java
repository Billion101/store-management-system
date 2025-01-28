import java.util.*;

public class ManagementSystem {

    // Product Class
    static class Product {
        String productName;
        String productID;
        double price;
        int stockQuantity;

        public Product(String productName, String productID, double price, int stockQuantity) {
            this.productName = productName;
            this.productID = productID;
            this.price = price;
            this.stockQuantity = stockQuantity;
        }

        @Override
        public String toString() {
            return "Product ID: " + productID + ", Name: " + productName + ", Price: " + price + ", Stock: " + stockQuantity;
        }
    }

    // Customer Class
    static class Customer {
        String customerName;
        String customerID;
        String address;
        String phone;

        public Customer(String customerName, String customerID, String address, String phone) {
            this.customerName = customerName;
            this.customerID = customerID;
            this.address = address;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Customer ID: " + customerID + ", Name: " + customerName + ", Address: " + address + ", Phone: " + phone;
        }
    }

    // Invoice Class
    static class Invoice {
        String invoiceID;
        Customer customer;
        List<Product> productList;
        double totalAmount;

        public Invoice(String invoiceID, Customer customer, List<Product> productList, double totalAmount) {
            this.invoiceID = invoiceID;
            this.customer = customer;
            this.productList = productList;
            this.totalAmount = totalAmount;
        }

        @Override
        public String toString() {
            return "Invoice ID: " + invoiceID + "\nCustomer: " + customer + "\nProducts: " + productList + "\nTotal Amount: " + totalAmount;
        }
    }

    // Main Logic
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();

        while (true) {
            System.out.println("\nManagement System Options:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. List Products");
            System.out.println("5. Add Customer");
            System.out.println("6. Update Customer");
            System.out.println("7. Delete Customer");
            System.out.println("8. List Customers");
            System.out.println("9. Create Invoice");
            System.out.println("10. List Invoices");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Product
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Product ID: ");
                    String productID = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Stock Quantity: ");
                    int stock = scanner.nextInt();
                    products.add(new Product(productName, productID, price, stock));
                    System.out.println("Product added successfully.");
                    break;

                case 2: // Update Product
                    System.out.print("Enter Product ID to Update: ");
                    String updateID = scanner.nextLine();
                    for (Product p : products) {
                        if (p.productID.equals(updateID)) {
                            System.out.print("Enter New Name: ");
                            p.productName = scanner.nextLine();
                            System.out.print("Enter New Price: ");
                            p.price = scanner.nextDouble();
                            System.out.print("Enter New Stock: ");
                            p.stockQuantity = scanner.nextInt();
                            System.out.println("Product updated successfully.");
                            break;
                        }
                    }
                    break;

                case 3: // Delete Product
                    System.out.print("Enter Product ID to Delete: ");
                    String deleteID = scanner.nextLine();
                    products.removeIf(p -> p.productID.equals(deleteID));
                    System.out.println("Product deleted successfully.");
                    break;

                case 4: // List Products
                    System.out.println("Product List:");
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;

                case 5: // Add Customer
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Customer ID: ");
                    String customerID = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    customers.add(new Customer(customerName, customerID, address, phone));
                    System.out.println("Customer added successfully.");
                    break;

                case 6: // Update Customer
                    System.out.print("Enter Customer ID to Update: ");
                    String updateCustomerID = scanner.nextLine();
                    for (Customer c : customers) {
                        if (c.customerID.equals(updateCustomerID)) {
                            System.out.print("Enter New Name: ");
                            c.customerName = scanner.nextLine();
                            System.out.print("Enter New Address: ");
                            c.address = scanner.nextLine();
                            System.out.print("Enter New Phone: ");
                            c.phone = scanner.nextLine();
                            System.out.println("Customer updated successfully.");
                            break;
                        }
                    }
                    break;

                case 7: // Delete Customer
                    System.out.print("Enter Customer ID to Delete: ");
                    String deleteCustomerID = scanner.nextLine();
                    customers.removeIf(c -> c.customerID.equals(deleteCustomerID));
                    System.out.println("Customer deleted successfully.");
                    break;

                case 8: // List Customers
                    System.out.println("Customer List:");
                    for (Customer c : customers) {
                        System.out.println(c);
                    }
                    break;

                case 9: // Create Invoice
                    System.out.print("Enter Invoice ID: ");
                    String invoiceID = scanner.nextLine();
                    System.out.print("Enter Customer ID: ");
                    String custID = scanner.nextLine();
                    Customer invoiceCustomer = null;
                    for (Customer c : customers) {
                        if (c.customerID.equals(custID)) {
                            invoiceCustomer = c;
                            break;
                        }
                    }
                    if (invoiceCustomer == null) {
                        System.out.println("Customer not found.");
                        break;
                    }

                    List<Product> invoiceProducts = new ArrayList<>();
                    double total = 0;
                    while (true) {
                        System.out.print("Enter Product ID to Add (or type 'done'): ");
                        String prodID = scanner.nextLine();
                        if (prodID.equals("done")) break;

                        for (Product p : products) {
                            if (p.productID.equals(prodID)) {
                                invoiceProducts.add(p);
                                total += p.price;
                                break;
                            }
                        }
                    }

                    invoices.add(new Invoice(invoiceID, invoiceCustomer, invoiceProducts, total));
                    System.out.println("Invoice created successfully.");
                    break;

                case 10: // List Invoices
                    System.out.println("Invoices:");
                    for (Invoice i : invoices) {
                        System.out.println(i);
                    }
                    break;

                case 0: // Exit
                    System.out.println("Exiting System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Option. Try Again.");
            }
        }
    }
}

