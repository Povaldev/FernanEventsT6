package Modelo.Entradas;

public class VIP extends Entrada{

    private double precio;
    private int entradasRestantes;

    public VIP(double precio, int entradasRestantes){
        super(precio, entradasRestantes);
    }

    public boolean compraEntrada(){
        this.setEntradasRestantes(getEntradasRestantes()-1);
    }


}
