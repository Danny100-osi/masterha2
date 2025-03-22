import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Utilizamos listas para almacenar los datos del inventario
        ArrayList<String> nombres = new ArrayList<>();  // Para almacenar los nombres de los productos
        ArrayList<Integer> cantidades = new ArrayList<>();  // Para almacenar las cantidades
        ArrayList<Double> precios = new ArrayList<>();  // Para almacenar los precios

        while (true) {
            // Menú de opciones
            System.out.println("----- Menú de Inventario -----");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Mostrar Inventario");
            System.out.println("4. Buscar Producto");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    // Agregar producto
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();  // Limpiar el buffer de entrada

                    // Agregar al inventario
                    nombres.add(nombre);
                    cantidades.add(cantidad);
                    precios.add(precio);
                    System.out.println("Producto agregado exitosamente.");
                    break;

                case 2:
                    // Eliminar producto
                    System.out.print("Nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < nombres.size(); i++) {
                        if (nombres.get(i).equalsIgnoreCase(nombreEliminar)) {
                            nombres.remove(i);
                            cantidades.remove(i);
                            precios.remove(i);
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    // Mostrar inventario
                    if (nombres.isEmpty()) {
                        System.out.println("El inventario está vacío.");
                    } else {
                        System.out.println("----- Inventario -----");
                        for (int i = 0; i < nombres.size(); i++) {
                            System.out.println("Producto: " + nombres.get(i) + ", Cantidad: " + cantidades.get(i) + ", Precio: " + precios.get(i));
                        }
                    }
                    break;

                case 4:
                    // Buscar producto
                    System.out.print("Nombre del producto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    boolean encontradoProducto = false;
                    for (int i = 0; i < nombres.size(); i++) {
                        if (nombres.get(i).equalsIgnoreCase(nombreBuscar)) {
                            System.out.println("Producto encontrado: ");
                            System.out.println("Producto: " + nombres.get(i) + ", Cantidad: " + cantidades.get(i) + ", Precio: " + precios.get(i));
                            encontradoProducto = true;
                            break;
                        }
                    }
                    if (!encontradoProducto) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5:
                    // Salir
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        }
    }
}
