public class Mensaje {
    private String mensaje; 

    public String darMensaje(){
        return mensaje;
    }

    public void firmar(String pMensaje){
        this.mensaje = pMensaje;
    }

    public Mensaje(String pMensaje){

    }
}
