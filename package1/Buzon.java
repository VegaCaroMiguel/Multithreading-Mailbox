/**
 * Caso 1 Infraestructura Computacional "Mailbox"
 * 
 * @author Juan Miguel Vega Caro 201715344
 * @author  
 */
import java.util.ArrayList;
import java.util.LinkedList; 

/**
 * Clase Buzon, en este caso la clase buzon actua como buffer, es el encargado de "Producir" y "Consumir" los mensajes 
 */

public class Buzon {

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                 ATRIBUTES                                                             /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //List that stores the buffer messages
    LinkedList<Mensaje> list = new LinkedList<Mensaje>(); 

    //Capacity of each buffer 
    private int capacity; 

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                 CONSTRUCTOR                                                           /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Construct the buffer 
     * @param pCapacity
     */
    public Buzon(int pCapacity){
         this.capacity = pCapacity; 
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                    METHODS                                                            /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    
    public synchronized void producirActivo(Mensaje pMensaje){
        
    }

    public synchronized void producirPasivo(Mensaje pMensaje){

    }


    public synchronized void consumirActivo(Mensaje pMensaje){

    }


    public synchronized void consumirPasivo(Mensaje pMensaje){

    }


    public boolean hayMensajes(){
        return list.size() > 0 ;
    }
    
}