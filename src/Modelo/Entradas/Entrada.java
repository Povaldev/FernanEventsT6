package Modelo.Entradas;

public class Entrada {
    public static Entrada[] entradas = new Entrada[60];
    private static int cantidadEntradasCreadas;

    private int EventoID, stock;
    private double precio;
    private String descripcion;
    private TipoEntrada tipoEntrada;

    public Entrada(TipoEntrada tipoEntrada, double precio, String descripcion, int stock, int EventoID){
        this.tipoEntrada = tipoEntrada;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.EventoID = EventoID;
    }

    public static void creaEntrada(Entrada entrada){
        entradas[getCantidadEntradasCreadas()] = entrada;
    }

    public boolean compraEntrada(){
        if (getStock()>0){
            this.stock--;
            return true;
        }
        return false;
    }



    public static int getCantidadEntradasCreadas() {
        return cantidadEntradasCreadas;
    }

    public int getEventoID() {
        return EventoID;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public static void setCantidadEntradasCreadas(int cantidadEntradasCreadas) {
        Entrada.cantidadEntradasCreadas = cantidadEntradasCreadas;
    }

    public void setEventoID(int eventoID) {
        EventoID = eventoID;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }
}