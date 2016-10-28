package prac1_prog1;

import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private String apellidos;
    private int numero;
    private boolean VIP;
    private ListaPresupuesto lista;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, int numero, boolean VIP) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numero = numero;
        this.VIP = VIP;
        this.lista = new ListaPresupuesto();
    }

    public ListaPresupuesto getLista() {
        return lista;
    }

    public void setLista(ListaPresupuesto lista) {
        this.lista = lista;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isVIP() {
        return VIP;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", numero=" + numero + ", VIP=" + VIP + ", lista=" + lista + '}';
    }
    

}
