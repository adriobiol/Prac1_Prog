package prac1_prog1;

import ocutilidades.Fichero;
import ocutilidades.EntradaDatos;

public class Programa {

    private static ListaCliente Clientes;
    private static Fichero miFichero;

    public static void main(String[] args) {
        miFichero = new Fichero("clientes.xml");
        Clientes = (ListaCliente) miFichero.leer();
        if (Clientes == null) {
            Clientes = new ListaCliente();
        }
        int opcion;
        do {
            mostrarMenu();
            opcion = EntradaDatos.pedirEntero("Escoge una opción");
            switch (opcion) {
                case 1:
                    altaTelefono();
                    break;
                case 2:
                    altaPresupuesto();
                    break;
                case 3:
                    Presupuestos(0);
                    break;
                case 4:
                    PresupuestosCliente();
                    break;
                case 5:
                    Presupuestos(2);
                    break;
                case 6:
                    listadoCliente();
                    break;
                case 7:
                    cambiarEstado();
                    break;
                case 8:
                    System.out.println("Has salido del programa");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 8);
    }

    private static void mostrarMenu() {
        System.out.println("*** OPCIONES ***");
        System.out.println("1. Alta cliente");
        System.out.println("2. Nuevo presupuesto");
        System.out.println("3. Presupuestos pendientes");
        System.out.println("4. Listado de presupuestos de un cliente");
        System.out.println("5. Listado de presupuestos rechazados");
        System.out.println("6. Listado de clientes");
        System.out.println("7. Cambiar estado de un presupuesto.");
        System.out.println("8. Salir");
    }
    //Opción 1
    private static void altaTelefono() {
        boolean result = false;
        boolean result2 = false;
        int numero = 0;
        while (result == false) {
            numero = EntradaDatos.pedirEntero("Introduce el número de teléfono");
            result = comprobarTelefono(numero);
            if (result == true) {
                result2 = Clientes.numExistente(numero);
                if (result2 == false) {
                    System.out.println("Número ya existente");
                    result = false;
                }
            }
        }
        altaCliente(numero);
    }

    private static void altaCliente(int numero) {
        String nombre = EntradaDatos.pedirCadena("Introduce el nombre");
        String apellidos = EntradaDatos.pedirCadena("Introduce el apellido");
        boolean VIP = EntradaDatos.pedirBoolean("¿El cliente es VIP? (Y/N)");
        Cliente c = new Cliente(nombre, apellidos, numero, VIP);
        System.out.println(nombre + apellidos + numero + VIP);
        Clientes.registroCliente(c);
        miFichero.grabar(Clientes);
        System.out.println("Presupuesto dado de alta con éxito");
    }
    //Opción 2
    private static void altaPresupuesto() {
        int numero = EntradaDatos.pedirEntero("Introduce el número de teléfono del cliente");
        Cliente c = Clientes.obtCliente(numero);
        if (c == null) {
            System.out.println("El número no está registrado, así que debe registrar al cliente");
            altaCliente(numero);
        } else {
            String concepto = EntradaDatos.pedirCadena("Introduce el concepto");
            double precio = EntradaDatos.pedirDouble("Introduce el precio");
            precio = precio * 1.21;
            if (c.isVIP() == true) {
                precio = precio * 0.95;
            }
            System.out.println("El precio total es: " + precio);
            int estado = Estado();
            int numpres = pedirNumPresupuesto();
            Presupuesto p = new Presupuesto(numpres, concepto, precio, estado);
            c.getLista().registroPresupuesto(p);
            miFichero.grabar(Clientes);
            System.out.println("Presupuesto dado de alta con éxito");

        }
    }
    //Opción 3 y 5
    private static void Presupuestos(int tipo) {
        for (Cliente c : Clientes.getLista()) {
            System.out.println("Presupuestos de " + c.getNombre() + " " + c.getApellidos());
            for (Presupuesto p : c.getLista().getLista()) {
                if (p.getEstado() == tipo) {
                    System.out.println(p);
                }
            }
        }

    }
    //Opción 4
    private static void PresupuestosCliente() {
        boolean result = false;
        Cliente c = new Cliente();
        while (result == false) {
            int numero = EntradaDatos.pedirEntero("Introduce el número del cliente del que quieres hacer la consulta");
            c = Clientes.obtCliente(numero);
            if (c == null) {
                System.out.println("El número no está registrado");
            } else {
                result = true;
            }
        }
        System.out.println("Presupuestos de " + c.getNombre() + " " + c.getApellidos());
        for (Presupuesto p : c.getLista().getLista()) {
            System.out.println(p);
        }

    }
    //Opción 6
    private static void listadoCliente() {
        System.out.println("Listado de clientes");
        for (Cliente c : Clientes.getLista()) {
            System.out.println(c);
            int i = 0;
            for (Presupuesto p : c.getLista().getLista()) {
                i++;
            }
            System.out.println("Número de presupuestos: " + i);
        }
    }
    //Opción 7
    private static void cambiarEstado() {
        boolean error = true;
        int numero = 0;
        Presupuesto p1 = new Presupuesto();
        while (error == true) {
            numero = EntradaDatos.pedirEntero("Introduce el número de presupuesto");
            for (Cliente c : Clientes.getLista()) {
                for (Presupuesto p : c.getLista().getLista()) {
                    if (p.getEstado() == numero) {
                        error = false;
                        p1 = p;
                    } else {
                        System.out.println("El número no existe");
                    }
                }
            }
            System.out.println("El estado actual del presupuesto número " + p1.getNumpres() + " es " + p1.getEstado());
            System.out.println("¿Cual es su nuevo estado?");
            int estado = Estado();
            p1.setEstado(estado);
            System.out.println("Estado modificado con éxito");
            miFichero.grabar(Clientes);
        }

    }
    
    //Submétodos
    //Pedir número de presupuesto

    private static int pedirNumPresupuesto() {
        int presupuesto = 0;
        boolean error = false;
        while (error == false) {
            presupuesto = EntradaDatos.pedirEntero("Introduce el número de presupuesto");
            for (Cliente c : Clientes.getLista()) {
                for (Presupuesto p : c.getLista().getLista()) {
                    if (p.getNumpres() == presupuesto) {
                        error = true;
                        System.out.println("El número indicado ya existe, prueba de nuevo");
                    }
                }
            }
        }
        return presupuesto;
    }
    //Pedir estado

    private static int Estado() {
        boolean result = false;
        int estado = 3;
        while (result == false) {
            estado = EntradaDatos.pedirEntero("Introduce el estado (0 = Pendiente, 1 = Aceptado, 2 = Rechazado)");
            if (estado == 0 || estado == 1 || estado == 2) {
                result = true;
            }
        }
        return estado;
    }
    //Comprobar num telefono

    private static boolean comprobarTelefono(int numero) {
        String num = Integer.toString(numero);
        int cantidad = num.length();
        if (cantidad == 9) {
            return true;
        } else {
            return false;
        }
    }
}
