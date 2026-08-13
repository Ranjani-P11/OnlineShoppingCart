import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class OnlineShoppingCart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> cart = new ArrayList<>();

        HashMap<String, Double> price = new HashMap<>();

        
        HashMap<String, Integer> quantity = new HashMap<>();

        price.put("Laptop", 50000.0);
        price.put("Phone", 20000.0);
        price.put("Headphones", 2000.0);
        price.put("Mouse", 800.0);

        int choice;

        do {
            System.out.println("\n===== ONLINE SHOPPING CART =====");
            System.out.println("1. Add Item");
            System.out.println("2. View Cart");
            System.out.println("3. Calculate Total");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Items:");
                    System.out.println("Laptop - Rs.50000");
                    System.out.println("Phone - Rs.20000");
                    System.out.println("Headphones - Rs.2000");
                    System.out.println("Mouse - Rs.800");

                    System.out.print("Enter item name: ");
                    String item = sc.nextLine();

                    if (price.containsKey(item)) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();

                        if (!cart.contains(item)) {
                            cart.add(item);
                            quantity.put(item, qty);
                        } else {
                            quantity.put(item, quantity.get(item) + qty);
                        }

                        System.out.println("Item added successfully!");
                    } else {
                        System.out.println("Item not available.");
                    }
                    break;

                case 2:
                    System.out.println("\n===== YOUR CART =====");

                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        for (String i : cart) {
                            System.out.println(i + " | Quantity: "
                                    + quantity.get(i)
                                    + " | Price: Rs."
                                    + price.get(i));
                        }
                    }
                    break;

                case 3:
                    double total = 0;

                    for (String i : cart) {
                        total += price.get(i) * quantity.get(i);
                    }

                    System.out.println("Total Price = Rs." + total);
                    break;

                case 4:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}