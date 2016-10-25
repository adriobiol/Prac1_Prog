package prac1_prog1;

public class Presupuesto {

    private int numpres;
    private String concepto;
    private double precio;
    private int telefono;
    private int estado;

    public Presupuesto() {
    }

    public Presupuesto(int numpres, String concepto, double precio, int telefono, int estado) {
        this.numpres = numpres;
        this.concepto = concepto;
        this.precio = precio;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getNumpres() {
        return numpres;
    }

    public String getConcepto() {
        return concepto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNumpres(int numpres) {
        this.numpres = numpres;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
