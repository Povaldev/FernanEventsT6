package Modelo.Entradas;

public class Entrada {
    public static Entrada[] entradas;
    private double precio;
    private int stock;

    public Entrada(double precio, int stock){
        this.precio = precio;
        this.stock = stock;
    }

    public boolean compraEntrada(){
        if (getStock()>0){
            this.stock--;
            return true;
        }
        return false;
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
