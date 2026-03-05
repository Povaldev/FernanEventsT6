package Modelo.Entradas;

public class Entrada {
    public Entrada[] entradas;
    private double precio;
    private int stock;

    public Entrada(double precio, int stock){
        this.precio = precio;
        this.stock = stock;
        this.entradas = new Entrada[stock];
    }

    public boolean compraEntrada(){
        this.stock--;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}
