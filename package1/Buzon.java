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

    //id of the Buffer
    public String id; 

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                 CONSTRUCTOR                                                           /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Construct the buffer 
     * @param pCapacity
     */
    public Buzon(String pId,int pCapacity){
        this.id = pId; 

         this.capacity = pCapacity; 
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                    METHODS                                                            /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Busy wait message insertion 
     * @param pMensaje
     */
    public synchronized void insertarActivo(Mensaje pMensaje){

            while(buzz.size() != capacity){ //Checks if the buffer its full, and if it's not, inserts a message


                buzz.add(pMensaje);


                if(buzz.size() ==1){ //Notify the waiting Consumers that there are resources available 
                    notify();
                }
            }
        }


    /**
     * Passive wait message Insertion 
     * @param pMensaje
     */
    public synchronized void insertarPasivo(Mensaje pMensaje){

        if(buzz.size() == capacity){ //Checks if the buffer its full, and if it is full, sends the thread to sleep 
            try{
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        buzz.add(pMensaje); // If there is space available in the buffer the message is added 

        if(buzz.size() == 1){ // Notify the waiter consumers that there are resources available  
            notify();
        }
    }

    /**
     * Busy wait message extraction 
     * @param pMensaje
     * @return The extrected message 
     */
    public synchronized Mensaje extraerActivo(T pThread){
        

        while(buzz.size() == 0){ //Checks if the buffer its full, and if it's not, inserts a message
            pThread.yield();

        }


        Mensaje extracted = buzz.get(0);

        
         
        if(buzz.size() ==1){ //Notify the waiting Consumers that there are resources available 
            notify();
        }

        return extracted;    
    }

    /**
     * Passive wait extraction
     * @param pMensaje
     * @return The extracted message 
     */
    public synchronized Mensaje extraerPasivo(){
        if(buzz.size()==0){ //Check if the buffer is empty 
            try{
                wait(); // If the buffer is empty, go to sleep 
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        Mensaje aux = buzz.get(0);
        buzz.remove(0);  //If the bufer isnt empty, extract the message 

        if(buzz.size() == capacity-1){ //Check if the buffer was full 
            notify(); //If the buffer was full, notify the waiting producer 
        }

        return aux; 

    }
   
}