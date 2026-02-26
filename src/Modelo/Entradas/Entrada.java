package Modelo.Entradas;

public class Entrada {
    private double precio;
    private int entradasRestantes;

    public Entrada(double precio, int entradasRestantes){
        this.precio = precio;
        this.entradasRestantes = entradasRestantes;
    }

    public boolean compraEntrada(){
        this.entradasRestantes--;
    }

    public double getPrecio() {
        return precio;
    }

    public int getEntradasRestantes() {
        return entradasRestantes;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEntradasRestantes(int entradasRestantes) {
        this.entradasRestantes = entradasRestantes;
    }


}
