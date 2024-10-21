package parcial;

import javax.swing.*;

public class Parcial {

    // Variables globales
    private static int opc = 0, tam = 0, bus = -1, pos = -1;
    private static String res = "", men = "";
    private static int[] idProducto = null;
    private static String[] nombreProducto = null;
    private static int[] cantidad = null;
    private static double[] precio = null;
    private static String[] proveedor = null;
    private static String[] fechaEntrada = null;
    private static String[] fechaSalida = null;

    public static void main(String[] args) {
        do {
            String input = JOptionPane.showInputDialog(
                    "Gestión de Almacén\n"
                    + "[1] Registrar Productos\n"
                    + "[2] Mostrar Productos\n"
                    + "[3] Buscar Producto\n"
                    + "[4] Actualizar Producto\n"
                    + "[5] Eliminar Producto\n"
                    + "[6] Ordenar Productos\n"
                    + "[7] Salir\n"
                    + "Seleccione una opción:");
            
            if (input == null) {
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "¿Estas seguro que deseas salir?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    break;
                } else {
                    continue;
                }
            }

            try {
                opc = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número.");
                continue;
            }

            switch (opc) {
                case 1:
                    registrarProductos();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    buscarProducto();
                    break;
                case 4:
                    actualizarProducto();
                    break;
                case 5:
                    eliminarProducto();
                    break;
                case 6:
                    ordenarProductos();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        } while (opc != 7);
    }

    // Método para registrar productos
    public static void registrarProductos() {
        try {
            tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de productos a registrar:"));
            idProducto = new int[tam];
            nombreProducto = new String[tam];
            cantidad = new int[tam];
            precio = new double[tam];
            proveedor = new String[tam];
            fechaEntrada = new String[tam];
            fechaSalida = new String[tam];

            for (int i = 0; i < tam; i++) {
                idProducto[i] = i + 1;
                nombreProducto[i] = JOptionPane.showInputDialog("Ingrese el nombre del producto " + (i + 1) + ":");
                cantidad[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto:"));
                precio[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
                proveedor[i] = JOptionPane.showInputDialog("Ingrese el proveedor del producto:");
                fechaEntrada[i] = JOptionPane.showInputDialog("Ingrese la fecha de entrada (dd/mm/aaaa):");
                fechaSalida[i] = JOptionPane.showInputDialog("Ingrese la fecha de salida (dd/mm/aaaa):");
            }
            JOptionPane.showMessageDialog(null, "Productos registrados exitosamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos. Por favor, intente nuevamente.");
        }
    }

    // Método para mostrar productos
    public static void mostrarProductos() {
        if (tam == 0 || idProducto == null) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }
        res = "Lista de Productos\n";
        for (int i = 0; i < tam; i++) {
            res += "ID: " + idProducto[i]
                    + ", Nombre: " + nombreProducto[i]
                    + ", Cantidad: " + cantidad[i]
                    + ", Precio: " + precio[i]
                    + ", Proveedor: " + proveedor[i]
                    + ", Fecha Entrada: " + fechaEntrada[i]
                    + ", Fecha Salida: " + fechaSalida[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, res);
    }

    // Método para buscar un producto por ID
    public static void buscarProducto() {
        if (tam == 0 || idProducto == null) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }
        try {
            bus = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a buscar:"));
            pos = -1;
            for (int i = 0; i < tam; i++) {
                if (idProducto[i] == bus) {
                    pos = i;
                    break;
                }
            }
            if (pos != -1) {
                JOptionPane.showMessageDialog(null, "Producto encontrado:\n"
                        + "ID: " + idProducto[pos]
                        + ", Nombre: " + nombreProducto[pos]
                        + ", Cantidad: " + cantidad[pos]
                        + ", Precio: " + precio[pos]
                        + ", Proveedor: " + proveedor[pos]
                        + ", Fecha Entrada: " + fechaEntrada[pos]
                        + ", Fecha Salida: " + fechaSalida[pos]);
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, intente nuevamente.");
        }
    }

    // Método para actualizar un producto
    public static void actualizarProducto() {
        if (tam == 0 || idProducto == null) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }
        try {
            bus = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a actualizar:"));
            pos = -1;
            for (int i = 0; i < tam; i++) {
                if (idProducto[i] == bus) {
                    pos = i;
                    break;
                }
            }
            if (pos != -1) {
                nombreProducto[pos] = JOptionPane.showInputDialog("Ingrese el nuevo nombre del producto:");
                cantidad[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad del producto:"));
                precio[pos] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio del producto:"));
                proveedor[pos] = JOptionPane.showInputDialog("Ingrese el nuevo proveedor del producto:");
                fechaEntrada[pos] = JOptionPane.showInputDialog("Ingrese la nueva fecha de entrada (dd/mm/aaaa):");
                fechaSalida[pos] = JOptionPane.showInputDialog("Ingrese la nueva fecha de salida (dd/mm/aaaa):");
                JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos. Por favor, intente nuevamente.");
        }
    }

    // Método para eliminar un producto
    public static void eliminarProducto() {
        if (tam == 0 || idProducto == null) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }
        try {
            bus = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a eliminar:"));
            pos = -1;
            for (int i = 0; i < tam; i++) {
                if (idProducto[i] == bus) {
                    pos = i;
                    break;
                }
            }
            if (pos != -1) {
                int[] idProductoTemp = new int[tam - 1];
                String[] nombreProductoTemp = new String[tam - 1];
                int[] cantidadTemp = new int[tam - 1];
                double[] precioTemp = new double[tam - 1];
                String[] proveedorTemp = new String[tam - 1];
                String[] fechaEntradaTemp = new String[tam - 1];
                String[] fechaSalidaTemp = new String[tam - 1];

                int j = 0;
                for (int i = 0; i < tam; i++) {
                    if (i != pos) {
                        idProductoTemp[j] = idProducto[i];
                        nombreProductoTemp[j] = nombreProducto[i];
                        cantidadTemp[j] = cantidad[i];
                        precioTemp[j] = precio[i];
                        proveedorTemp[j] = proveedor[i];
                        fechaEntradaTemp[j] = fechaEntrada[i];
                        fechaSalidaTemp[j] = fechaSalida[i];
                        j++;
                    }
                }
                tam--;
                idProducto = idProductoTemp;
                nombreProducto = nombreProductoTemp;
                cantidad = cantidadTemp;
                precio = precioTemp;
                proveedor = proveedorTemp;
                fechaEntrada = fechaEntradaTemp;
                fechaSalida = fechaSalidaTemp;

                JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos. Por favor, intente nuevamente.");
        }
    }

    // Método para ordenar productos
    public static void ordenarProductos() {
        if (tam == 0 || idProducto == null) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }
        try {
            int opcionOrden = Integer.parseInt(JOptionPane.showInputDialog(
                    "Seleccione el campo por el cual desea ordenar:\n"
                    + "[1] ID\n"
                    + "[2] Nombre\n"
                    + "[3] Cantidad\n"
                    + "[4] Precio\n"
                    + "[5] Proveedor"));
            
            String estadoOriginal = "Estado original:\n";
            for (int i = 0; i < tam; i++) {
                estadoOriginal += "ID: " + idProducto[i]
                        + ", Nombre: " + nombreProducto[i]
                        + ", Cantidad: " + cantidad[i]
                        + ", Precio: " + precio[i]
                        + ", Proveedor: " + proveedor[i]
                        + ", Fecha Entrada: " + fechaEntrada[i]
                        + ", Fecha Salida: " + fechaSalida[i] + "\n";
            }

            for (int i = 0; i < tam - 1; i++) {
                for (int j = i + 1; j < tam; j++) {
                    boolean intercambio = false;
                    switch (opcionOrden) {
                        case 1: // Ordenar por ID
                            if (idProducto[i] > idProducto[j]) {
                                intercambio = true;
                            }
                            break;
                        case 2: // Ordenar por Nombre
                            if (nombreProducto[i].compareToIgnoreCase(nombreProducto[j]) > 0) {
                                intercambio = true;
                            }
                            break;
                        case 3: // Ordenar por Cantidad
                            if (cantidad[i] > cantidad[j]) {
                                intercambio = true;
                            }
                            break;
                        case 4: // Ordenar por Precio
                            if (precio[i] > precio[j]) {
                                intercambio = true;
                            }
                            break;
                        case 5: // Ordenar por Proveedor
                            if (proveedor[i].compareToIgnoreCase(proveedor[j]) > 0) {
                                intercambio = true;
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida.");
                            return;
                    }
                    if (intercambio) {
                        intercambiarProductos(i, j);
                    }
                }
            }
            
            String estadoOrdenado = "Estado ordenado:\n";
            for (int i = 0; i < tam; i++) {
                estadoOrdenado += "ID: " + idProducto[i]
                        + ", Nombre: " + nombreProducto[i]
                        + ", Cantidad: " + cantidad[i]
                        + ", Precio: " + precio[i]
                        + ", Proveedor: " + proveedor[i]
                        + ", Fecha Entrada: " + fechaEntrada[i]
                        + ", Fecha Salida: " + fechaSalida[i] + "\n";
            }

            JOptionPane.showMessageDialog(null, "Productos ordenados exitosamente.");
            // Mostrar los estados original y ordenado
            JOptionPane.showMessageDialog(null, estadoOriginal);
            JOptionPane.showMessageDialog(null, estadoOrdenado);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos. Por favor, intente nuevamente.");
        }
    }
    
    private static void intercambiarProductos(int i, int j) {
        // Intercambiar ID
        int tempID = idProducto[i];
        idProducto[i] = idProducto[j];
        idProducto[j] = tempID;
        // Intercambiar Nombre
        String tempNombre = nombreProducto[i];
        nombreProducto[i] = nombreProducto[j];
        nombreProducto[j] = tempNombre;
        // Intercambiar Cantidad
        int tempCantidad = cantidad[i];
        cantidad[i] = cantidad[j];
        cantidad[j] = tempCantidad;
        // Intercambiar Precio
        double tempPrecio = precio[i];
        precio[i] = precio[j];
        precio[j] = tempPrecio;
        // Intercambiar Proveedor
        String tempProveedor = proveedor[i];
        proveedor[i] = proveedor[j];
        proveedor[j] = tempProveedor;
        // Intercambiar Fecha Entrada
        String tempFechaEntrada = fechaEntrada[i];
        fechaEntrada[i] = fechaEntrada[j];
        fechaEntrada[j] = tempFechaEntrada;
        // Intercambiar Fecha Salida
        String tempFechaSalida = fechaSalida[i];
        fechaSalida[i] = fechaSalida[j];
        fechaSalida[j] = tempFechaSalida;
    }
}
