package Modelo.Usuario;

public class Organizador extends Usuario implements Bloqueable{


    public Organizador(String nombre, String contrasena, String correo) {
        super(nombre, contrasena, correo);




    }

    @Override
    public void bloquear() {

    }

    @Override
    public void desbloquear() {

    }
}
