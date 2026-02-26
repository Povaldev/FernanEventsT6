package Modelo.Entradas;

public class Premium extends Entrada{

    private double precio;
    private int entradasRestantes;

    public Premium(double precio, int entradasRestantes){
        super(precio, entradasRestantes);
    }
}
