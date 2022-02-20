/**
 * Caso 1 Infraestructura Computacional "Mailbox"
 * 
 * @author Juan Miguel Vega Caro 201715344
 * @author  
 */
import java.util.ArrayList;
import java.util.LinkedList; 

/**
 * Clase mensaje, contiene las firmas de los buzones.
 */
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
