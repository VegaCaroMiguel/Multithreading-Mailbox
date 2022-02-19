/**
 * Caso 1 Infraestructura Computacional "Mailbox"
 * 
 * @author Juan Miguel Vega Caro 201715344
 * @author  
 */
import java.util.ArrayList;
import java.util.LinkedList; 

/**
 * Clase Thread
 */
public class T extends Thread{

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                 ATRIBUTES                                                             /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 

    //Int value which represents the delay in millis of the thread 
    private int delay; 

    //Buzon object that represents the left mailbox of the thread
    private Buzon left;
    
    //Buzon object that represents the left mailbox of the thread
    private Buzon right;

    //Boolean var that represents the type of receive operation 
    private boolean receive;

    //Boolean var thar represents the type of send operation
    private boolean send; 

    

    //Special attribute for No.1 Threads, that specify the total ammount of messages the mailboxes will handle.
    private int load; 


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                 CONSTRUCTOR                                                           /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Instanciate a new thread
     * @param pDelay
     * @param pLeft
     * @param pRight
     */
    public T(int pDelay, Buzon pLeft, Buzon pRight){
        this.delay = pDelay;

        this.left = pLeft;

        this.right = pRight;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                 LOAD(optional)                                                        /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setLoad(int pLoad){
        this.load = pLoad; 
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                      RUN                                                              /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void run(){
        
    }

}