/**
 * Caso 1 Infraestructura Computacional "Mailbox"
 * 
 * @author Juan Miguel Vega Caro 201715344
 * @author  
 */
import java.util.ArrayList;
import java.lang.InterruptedException;

/**
 * Clase Buzon, en este caso la clase buzon actua como buffer, es el encargado de "Producir" y "Consumir" los mensajes 
 */

public class Buzon {

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                 ATRIBUTES                                                             /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //List that stores the buffer messages
    ArrayList<Mensaje> buzz = new ArrayList<Mensaje>();


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


    
    public synchronized void insertarActivo(Mensaje pMensaje){
        while(true){

            while(buzz.size() != capacity){
                buzz.add(pMensaje);
            }

        }
    }

    public synchronized void insertarPasivo(Mensaje pMensaje){
        if(buzz.size() == capacity){
            try{
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        buzz.add(pMensaje);

        if(buzz.size() == 1){
            notify();
        }
    }


    public synchronized Mensaje extraerActivo(Mensaje pMensaje){
        while(true){

            while(buzz.size()!= 0){
                Mensaje aux = buzz.get(0);
                buzz.remove(0);
                return aux; 
            }
        }
    }


    public synchronized Mensaje extraerPasivo(Mensaje pMensaje){
        if(buzz.size()==0){
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        Mensaje aux = buzz.get(0);
        buzz.remove(0); 

        if(buzz.size() == capacity-1){
            notify();
        }

        return aux; 

    }

    
}