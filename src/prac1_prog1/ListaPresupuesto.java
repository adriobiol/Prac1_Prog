
package prac1_prog1;

import java.util.ArrayList;

public class ListaPresupuesto {
    private ArrayList<Presupuesto> lista;

    public ListaPresupuesto() {
        this.lista = new ArrayList<Presupuesto>();
    }

    public ArrayList<Presupuesto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Presupuesto> lista) {
        this.lista = lista;
    }
    public int numPresupuesto () {
        int size = lista.size();
        size = size + 1;
        return size;
    }
    public void registroPresupuesto(Presupuesto p){
        lista.add(p);
    }
    public void bajaPresupuesto(Presupuesto p){
        lista.remove(p);
    }
    public void comprobarEstados(){
        //Comprobar estados de los Presupuestos
    }

    
}
