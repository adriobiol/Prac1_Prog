package prac1_prog1;

import java.util.ArrayList;

public class ListaPresupuesto {

    private ArrayList<Presupuesto> lista;

    public ListaPresupuesto() {
        lista = new ArrayList<>();
    }

    public ArrayList<Presupuesto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Presupuesto> lista) {
        this.lista = lista;
    }

    public void registroPresupuesto(Presupuesto p) {
        lista.add(p);
    }
    


}
