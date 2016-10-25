
package prac1_prog1;

import java.util.ArrayList;

public class ListaCliente {
    private ArrayList<Cliente> lista = new ArrayList<Cliente>();

    public ListaCliente() {
        this.lista = lista;
    }

    public ArrayList<Cliente> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Cliente> lista) {
        this.lista = lista;
    }
    public void registroCliente(Cliente c){
        lista.add(c);
        
    }
    public void bajaCliente(Cliente c){
        lista.remove(c);
    }
    public Cliente comprobarTelefono(int num){
        for (Cliente c : lista){
        if (c.getNumero()==num){
            return c;
        }
        }
        return null;
    }
}
