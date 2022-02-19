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
    //Almacena los mensajes del buzon
    LinkedList<Mensaje> list = new LinkedList<Mensaje>(); 

    //Capacidad maxima de cada buzon 
    private int capacity; 

    //
    public Buzon(int pCapacity){
         this.capacity = pCapacity; 
    }

    public synchronized void producir(){

    }

    public synchronized void consumir(){

    }

    public boolean hayMensajes(){
        return list.size() > 0 ;
    }
    
}