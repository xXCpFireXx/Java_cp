import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Restaurant {
    public static void main(String[] args) {

        ArrayList<String> menu = new ArrayList<>();
        menu.add("Menú especial - $18000");
        menu.add("Robalo - $32000");
        menu.add("Hamburguesa - $25000");
        menu.add("Adiccion Papas fritas - $7000");

        HashMap<Integer, ArrayList<String>> orders = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int customerId = 1;
        int optionMenu = 0;

        do {
            System.out.println("\n--- Restaurant ---");
            System.out.println("1. Add Order \n2. Show Menu \n3. Check Payment \n4. Show Unpaid \n5. Exit");
            System.out.print("Choose an option: ");
            optionMenu = sc.nextInt();

            switch (optionMenu) {
                case 1:
                    ArrayList<String> order = new ArrayList<>();
                    System.out.println("\n-------- Menu --------");
                    for (int i = 0; i < menu.size(); i++) {
                        System.out.println((i + 1) + ". " + menu.get(i));
                    }
                    System.out.println("Enter item number (0 to finish): ");

                    double total = 0.0;

                    int optionItem;
                    do {
                        optionItem = sc.nextInt();
                        if (optionItem > 0 && optionItem <= menu.size()) {
                            String selected = menu.get(optionItem - 1);
                            order.add(selected);
                            total += Double.parseDouble(selected.split("\\$")[1]);
                        } else if (optionItem != 0) {
                            System.out.print("Invalid dish. Try again: ");
                        }
                    } while (optionItem != 0);

                    order.add("Total: $" + total);
                    order.add("Paid: No");
                    orders.put(customerId, order);
                    System.out.println("Order added for Customer " + customerId);
                    System.out.println(orders);
                    customerId++;
                    break;

                case 2:
                    System.out.println("\n-------- Menu --------");
                    for (String dish : menu) {
                        System.out.println(dish);
                    }
                    break;

                case 3:
                    System.out.println("-------- Check Payment --------");
                    System.out.print("Enter Customer ID: ");
                    int id = sc.nextInt();

                    if (orders.containsKey(id)) {
                        ArrayList<String> details = orders.get(id);
                        for (String detail : details) {
                            System.out.println(detail);
                        }

                        String paid = details.get(details.size() - 1);

                        if (paid.equals("Paid: No")) {

                            System.out.print("Mark as paid? (y/n): ");
                            String answer = sc.next().toLowerCase();

                            if (answer.equals("y")) {
                                details.set(details.size() - 1, "Paid: Yes");
                                System.out.println("Payment confirmed.");
                            }
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    System.out.println("-------- Unpaid Orders--------");
                    for (Integer idOrder : orders.keySet()) {
                        String paid = orders.get(idOrder).get(orders.get(idOrder).size() - 1);
                        if (paid.equals("Paid: No")) {
                            System.out.println("Customer " + idOrder + ": " + orders.get(idOrder));
                        }
                    }
                    break;
            }
        } while (optionMenu != 5);
        System.out.println("Good Bye!");
    }
}
