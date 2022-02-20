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
 
    //Id del thread
    private String id; 

    //Int value which represents the delay in millis of the thread 
    private int delay; 

    //Buzon object that represents the left mailbox of the thread
    private Buzon leftBuffer;
    
    //Buzon object that represents the left mailbox of the thread
    private Buzon rightBuffer;

    //Boolean var that represents the type of receive operation 
    private boolean receiveWay;

    //Boolean var thar represents the type of send operation
    private boolean sendWay; 

    

    //Special attribute for No.1 Threads, that specify the total ammount of messages the mailboxes will handle.
    ArrayList<Mensaje> load; 


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                 CONSTRUCTOR                                                           /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Instanciate a new thread
     * 
     * @param pId
     * @param pDelay
     * @param pLeftBuffer
     * @param pRightBuffer
     * @param pReceiveWay
     * @param pSendWay
     */
    public T(String pId, int pDelay, Buzon pLeftBuffer, Buzon pRightBuffer, boolean pReceiveWay, boolean pSendWay ){

        this.id = pId; 

        this.delay = pDelay;

        this.leftBuffer = pLeftBuffer;

        this.rightBuffer = pRightBuffer;

        this.receiveWay = pReceiveWay; 

        this.sendWay = pSendWay;

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                    METHODS                                                            /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Cada thread firma los mensajes que va recibiendo 
     * @param pMensaje
     */
    public void firmar(Mensaje pMensaje){

        String rec = (receive == true) ? "Active" : "Passive"; 

        String se = (send == true) ? "Active" : "Passive"; 

        String firma = "ID: " + id + " , " + "RECEIVED: " + rec + " , " + "SENT: " + se;
        
        pMensaje.firmar(firma);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                 LOAD(optional)                                                        /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setLoad(ArrayList<Mensaje> pLoad){
        this.load = pLoad; 
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                      RUN                                                              /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void run(){
        while(true){

        }
    }

}