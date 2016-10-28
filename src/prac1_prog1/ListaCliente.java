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

    public void registroCliente(Cliente c) {
        lista.add(c);

    }

    public Cliente obtCliente(int num) {
        for (Cliente c : lista) {
            if (c.getNumero() == num) {
                return c;
            }
        }
        return null;
    }

    public boolean numExistente(int numero) {
        boolean result = true;
        for (Cliente c : lista) {
            if (c.getNumero() == numero) {
                result = false;
            }
        }
        return result;
    }
}
