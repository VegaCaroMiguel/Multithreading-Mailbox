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


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                 CONSTRUCTOR                                                           /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 
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
    /////                                                      RUN                                                              /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void run(){
        
    }

}