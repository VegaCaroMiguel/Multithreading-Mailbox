import java.util.ArrayList;
import java.util.LinkedList; 

public class Buzon {

    LinkedList<Mensaje> list = new LinkedList<Mensaje>(); 

    private int capacity; 


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