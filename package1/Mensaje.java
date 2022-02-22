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

    /**
     * String with the message content 
     */
    private String mensaje = ""; 


    /**
     * Returns the message content 
     * @return mensaje
     */
    public String darMensaje(){
        return mensaje;
    }

    /**
     * Updates the message content 
     * @param pMensaje
     */
    public void firmar(String pMensaje){
        this.mensaje += (pMensaje + "\n"); 
    }

}
