package Modelo.Usuario;

public class Asistente extends Usuario implements Bloqueable{

    public Asistente(String nombre, String contrasena, String correo) {
        super(nombre, contrasena, correo);



    }

    @Override
    public void bloquear() {

    }

    @Override
    public void desbloquear() {

    }
}
