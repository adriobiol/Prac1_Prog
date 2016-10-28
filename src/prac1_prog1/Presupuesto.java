package prac1_prog1;

public class Presupuesto {

    private int numpres;
    private String concepto;
    private double precio;
    private int estado;

    public Presupuesto() {
    }

    public Presupuesto(int numpres, String concepto, double precio, int estado) {
        this.numpres = numpres;
        this.concepto = concepto;
        this.precio = precio;
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
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

    @Override
    public String toString() {
        return "Presupuesto{" + "numpres=" + numpres + ", concepto=" + concepto + ", precio=" + precio + ", estado=" + estado + '}';
    }


}
