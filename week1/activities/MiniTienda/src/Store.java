import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Store {
    // Estructuras de datos principales
    private static ArrayList<String> nombresProductos = new ArrayList<>();
    private static double[] precios = new double[0]; // Array vacío inicialmente
    private static HashMap<String, Integer> stock = new HashMap<>();
    private static double totalCompras = 0.0; // Acumulado de compras en la sesión

    public static void main(String[] args) {
        // Menú principal en un bucle do-while hasta que se elija salir
        int opcion;
        do {
            String menu = "Mini-Tienda\n" +
                    "1. Agregar producto\n" +
                    "2. Listar inventario\n" +
                    "3. Comprar producto\n" +
                    "4. Mostrar estadísticas (más barato y más caro)\n" +
                    "5. Buscar producto por nombre\n" +
                    "6. Salir con ticket final\n" +
                    "Elige una opción:";
            String input = JOptionPane.showInputDialog(menu);
            if (input == null) { // Si se presiona Cancelar o se cierra la ventana, salir
                opcion = 6;
            } else {
                try {
                    opcion = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    opcion = 0; // Opción inválida
                }
            }

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    listarInventario();
                    break;
                case 3:
                    comprarProducto();
                    break;
                case 4:
                    mostrarEstadisticas();
                    break;
                case 5:
                    buscarProducto();
                    break;
                case 6:
                    salirConTicket();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intenta de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 6);
    }

    // Método utilitario para agregar producto
    private static void addProducto(String nombre, double precio, int cantidadStock) {
        nombresProductos.add(nombre);
        expandPrecios(precio);
        stock.put(nombre, cantidadStock);
    }

    // Método utilitario para expandir el array de precios
    private static void expandPrecios(double nuevoPrecio) {
        double[] nuevosPrecios = new double[precios.length + 1];
        // Copiar elementos existentes usando bucle for
        for (int i = 0; i < precios.length; i++) {
            nuevosPrecios[i] = precios[i];
        }
        nuevosPrecios[precios.length] = nuevoPrecio;
        precios = nuevosPrecios;
    }

    // Método utilitario para encontrar índice de nombre en ArrayList
    private static int indexOfNombre(String nombre) {
        for (int i = 0; i < nombresProductos.size(); i++) {
            if (nombresProductos.get(i).equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    // Opción 1: Agregar producto con validaciones
    private static void agregarProducto() {
        // Solicitar nombre del producto
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        if (nombre == null) {
            JOptionPane.showMessageDialog(null, "Agregado de producto cancelado. Regresando al menú.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre inválido o vacío. Regresando al menú.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Verificar si ya existe (no duplicados)
        if (indexOfNombre(nombre) != -1) {
            JOptionPane.showMessageDialog(null, "El producto ya existe. Regresando al menú.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Solicitar precio del producto
        String precioStr = JOptionPane.showInputDialog("Ingrese el precio del producto:");
        if (precioStr == null) {
            JOptionPane.showMessageDialog(null, "Agregado de producto cancelado. Regresando al menú.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        double precio;
        try {
            precio = Double.parseDouble(precioStr);
            if (precio <= 0) {
                JOptionPane.showMessageDialog(null, "Precio debe ser positivo. Regresando al menú.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Precio inválido. Regresando al menú.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Solicitar stock inicial
        String stockStr = JOptionPane.showInputDialog("Ingrese el stock inicial:");
        if (stockStr == null) {
            JOptionPane.showMessageDialog(null, "Agregado de producto cancelado. Regresando al menú.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int cantidadStock;
        try {
            cantidadStock = Integer.parseInt(stockStr);
            if (cantidadStock < 0) {
                JOptionPane.showMessageDialog(null, "Stock no puede ser negativo. Regresando al menú.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Stock inválido. Regresando al menú.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Agregar producto si todas las validaciones pasan
        addProducto(nombre, precio, cantidadStock);
        JOptionPane.showMessageDialog(null, "Producto agregado exitosamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }

    // Opción 2: Listar inventario
    private static void listarInventario() {
        if (nombresProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El inventario está vacío.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder inventario = new StringBuilder("Inventario:\n");
        // Recorrer con bucle for-each para nombres y sincronizar con precios y stock
        int index = 0;
        for (String nombre : nombresProductos) {
            inventario.append("Nombre: ").append(nombre)
                    .append(", Precio: $").append(String.format("%.2f", precios[index]))
                    .append(", Stock: ").append(stock.get(nombre)).append("\n");
            index++;
        }
        JOptionPane.showMessageDialog(null, inventario.toString(), "Inventario", JOptionPane.INFORMATION_MESSAGE);
    }

    // Opción 3: Comprar producto
    private static void comprarProducto() {
        if (nombresProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos en el inventario.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto a comprar:");
        if (nombre == null) {
            JOptionPane.showMessageDialog(null, "Compra cancelada. Regresando al menú.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int index = indexOfNombre(nombre);
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado. Regresando al menú.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad a comprar:");
        if (cantidadStr == null) {
            JOptionPane.showMessageDialog(null, "Compra cancelada. Regresando al menú.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadStr);
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(null, "Cantidad debe ser positiva. Regresando al menú.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad inválida. Regresando al menú.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int stockActual = stock.get(nombre);
        if (cantidad > stockActual) {
            JOptionPane.showMessageDialog(null, "Stock insuficiente. Regresando al menú.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirmar compra
        int confirm = JOptionPane.showConfirmDialog(null, "¿Confirmar compra de " + cantidad + " unidades de " + nombre + " por $" + String.format("%.2f", precios[index] * cantidad) + "?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            stock.put(nombre, stockActual - cantidad);
            totalCompras += precios[index] * cantidad;
            JOptionPane.showMessageDialog(null, "Compra realizada exitosamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Compra cancelada. Regresando al menú.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Opción 4: Mostrar estadísticas (precio min y max)
    private static void mostrarEstadisticas() {
        if (precios.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos para mostrar estadísticas.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        double minPrecio = precios[0];
        double maxPrecio = precios[0];
        String minNombre = nombresProductos.get(0);
        String maxNombre = nombresProductos.get(0);

        // Recorrer array de precios con bucle for
        for (int i = 1; i < precios.length; i++) {
            if (precios[i] < minPrecio) {
                minPrecio = precios[i];
                minNombre = nombresProductos.get(i);
            }
            if (precios[i] > maxPrecio) {
                maxPrecio = precios[i];
                maxNombre = nombresProductos.get(i);
            }
        }

        String stats = "Producto más barato: " + minNombre + " ($" + String.format("%.2f", minPrecio) + ")\n" +
                "Producto más caro: " + maxNombre + " ($" + String.format("%.2f", maxPrecio) + ")";
        JOptionPane.showMessageDialog(null, stats, "Estadísticas", JOptionPane.INFORMATION_MESSAGE);
    }

    // Opción 5: Buscar producto por nombre (coincidencias parciales)
    private static void buscarProducto() {
        String busqueda = JOptionPane.showInputDialog("Ingrese el nombre o parte del nombre a buscar:");
        if (busqueda == null) {
            JOptionPane.showMessageDialog(null, "Búsqueda cancelada. Regresando al menú.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (busqueda.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Búsqueda inválida. Regresando al menú.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringBuilder resultados = new StringBuilder("Resultados de búsqueda:\n");
        boolean encontrado = false;
        // Recorrer con bucle for-each
        int index = 0;
        for (String nombre : nombresProductos) {
            if (nombre.toLowerCase().contains(busqueda.toLowerCase())) {
                resultados.append("Nombre: ").append(nombre)
                        .append(", Precio: $").append(String.format("%.2f", precios[index]))
                        .append(", Stock: ").append(stock.get(nombre)).append("\n");
                encontrado = true;
            }
            index++;
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontraron productos. Regresando al menú.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, resultados.toString(), "Resultados", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Opción 6: Salir con ticket final
    private static void salirConTicket() {
        String ticket = "Ticket final:\nTotal acumulado de compras: $" + String.format("%.2f", totalCompras);
        JOptionPane.showMessageDialog(null, ticket, "Ticket Final", JOptionPane.INFORMATION_MESSAGE);
    }
}