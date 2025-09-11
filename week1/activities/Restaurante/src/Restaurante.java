import java.util.*;

public class Restaurante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> menu = new HashMap<>();
        menu.put("Menú especial", 18000);
        menu.put("Robalo", 32000);
        menu.put("Hamburguesa", 30000);
        menu.put("Papas fritas", 8000);

        // Pedidos de clientes
        HashMap<String, ArrayList<String>> pedidos = new HashMap<>();

        int opcion; // variable de control del menú

        do {
            // Mostrar menú principal
            System.out.println("\n--- Restaurant ---");
            System.out.println("1. Mostrar menú");
            System.out.println("2. Registrar pedido");
            System.out.println("3. Ver cuenta de un cliente");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- MENÚ ---");
                    for (Map.Entry<String, Integer> plato : menu.entrySet()) {
                        System.out.println(plato.getKey() + " - $" + plato.getValue());
                    }
                    break;

                case 2:
                    System.out.print("Nombre del cliente: ");
                    String cliente = sc.nextLine();

                    pedidos.putIfAbsent(cliente, new ArrayList<>());

                    String respuesta;
                    do {
                        System.out.println("\n¿Qué plato desea pedir?");
                        for (String plato : menu.keySet()) {
                            System.out.println("- " + plato);
                        }
                        String pedido = sc.nextLine();

                        if (menu.containsKey(pedido)) {
                            pedidos.get(cliente).add(pedido);
                            System.out.println("✅ Pedido agregado: " + pedido);
                        } else {
                            System.out.println("❌ Plato no existe en el menú.");
                        }

                        System.out.print("¿Desea pedir otro plato? (s/n): ");
                        respuesta = sc.nextLine();
                    } while (respuesta.equalsIgnoreCase("s")); // el cliente puede seguir pidiendo
                    break;

                case 3:
                    System.out.print("Nombre del cliente: ");
                    String nombreCliente = sc.nextLine();

                    if (pedidos.containsKey(nombreCliente)) {
                        int total = 0;
                        System.out.println("\n--- Cuenta de " + nombreCliente + " ---");
                        for (String plato : pedidos.get(nombreCliente)) {
                            int precio = menu.get(plato);
                            System.out.println(plato + " - $" + precio);
                            total += precio;
                        }
                        System.out.println("TOTAL: $" + total);
                    } else {
                        System.out.println("❌ Cliente no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("👋 Gracias por usar el sistema.");
                    break;

                default:
                    System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 4); // se repite hasta que elija salir

        sc.close();
    }
}