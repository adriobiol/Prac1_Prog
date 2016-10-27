package prac1_prog1;

import ocutilidades.Fichero;
import ocutilidades.EntradaDatos;


public class Programa {

    private static ListaCliente Clientes;
    private static Fichero miFichero;
    public static void main(String[] args) {
        miFichero = new Fichero("clientes.xml");
        Clientes = (ListaCliente) miFichero.leer();
        if (Clientes == null){
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
                    presupuestoPendiente();
                    break;
                case 4:
                    listadoPresupuesto();
                    break;
                case 5:
                    presupuestoRechazado();
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
    private static void altaCliente(int numero) {
        String nombre = EntradaDatos.pedirCadena("Introduce el nombre");
        String apellidos = EntradaDatos.pedirCadena("Introduce el apellido");
        boolean VIP = EntradaDatos.pedirBoolean("¿El cliente es VIP? (Y/N)"); 
        Cliente c = new Cliente(nombre, apellidos, numero, VIP);
        System.out.println(nombre + apellidos + numero + VIP);
        Clientes.registroCliente(c);
        miFichero.grabar(Clientes);
        
    }
    private static void altaTelefono(){
        boolean result = false;
        int numero = 0;
        while (result==false){
        numero = EntradaDatos.pedirEntero("Introduce el número de teléfono");
        result = comprobarTelefono(numero);
    }
        altaCliente(numero);
    }
      private static void altaPresupuesto() { 
        int numero = EntradaDatos.pedirEntero("Introduce el número de teléfono del cliente");  
        Cliente c = Clientes.comprobarTelefono(numero);
        if (c == null){
            System.out.println("El número no está registrado, así que debe registrar al cliente");
            altaCliente(numero);
        }
        else{
           String concepto = EntradaDatos.pedirCadena("Introduce el concepto"); 
           double precio = EntradaDatos.pedirDouble("Introduce el precio");
           //Estado del pedido 0= pendiente 1=aceptado 2=rechazado
           int estado = 0;
           int numpres = Clientes.getLista().numPresupuesto();
           Presupuesto p = new Presupuesto (numpres, concepto, precio, numero, estado);
           Presupuestos.registroPresupuesto(p);
           miFichero1.grabar(Presupuestos);
        }
}
      private static void presupuestoPendiente() {
          
    }
      private static void listadoPresupuesto() {

    } 
      private static void presupuestoRechazado() {

    } 
      private static void listadoCliente() {

    } 
      private static void cambiarEstado() {

    }     
      //Comprobar num telefono
      private static boolean comprobarTelefono(int numero){
         String num = Integer.toString(numero);
         int cantidad = num.length();
         if (cantidad==9){
             return true;
         }
         else {
             return false;
         }  
      }
}
