
package prac1_prog1;

import java.util.ArrayList;

public class ListaPresupuesto {
    private ArrayList<Presupuesto> lista;

    public ListaPresupuesto() {
        this.lista = lista;
    }

    public ArrayList<Presupuesto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Presupuesto> lista) {
        this.lista = lista;
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
