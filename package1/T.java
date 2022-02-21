/**
 * Caso 1 Infraestructura Computacional "Mailbox"
 * 
 * @author Juan Miguel Vega Caro 201715344
 * @author  
 */

import java.util.ArrayList;

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



    //Boolean var thar represents the type of extraction operation
    private boolean extractWay; 

    
    //Boolean var that represents the type of insertion operation 
    private boolean insertWay;
    

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
     * @param pExtractWay
     * @param pInsertWay
     */
    public T(String pId, int pDelay, Buzon pLeftBuffer, Buzon pRightBuffer, boolean pExtractWay, boolean pInsertWay ){

        this.id = pId; 

        this.delay = pDelay;

        this.leftBuffer = pLeftBuffer;

        this.rightBuffer = pRightBuffer;

        this.extractWay = pInsertWay; 

        this.insertWay = pInsertWay;

    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                      RUN                                                              /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void run(){

        // Checks if the thread is the first one 
        if(!load.isEmpty()){

            for(int i = 0; i < load.size(); i ++){

                try {

					sleep(delay); // thread performs the programmed delay
					System.out.println("Thread " + id + ":" +  " delayed" + " " + delay );

				} catch (InterruptedException e) {
					// Handles exception
					e.printStackTrace();
				}

                if(insertWay){ // If the thread have activeInsert, activeInsert each message into the cycle 

                    //SIGNS The message 
                    sign(load.get(i));

                    rightBuffer.insertarActivo(load.get(i));

                    


                    load.remove(i); //Removes the message from the load ArrayList
                }
                else{  //If the thread has passiveInsert, passiveInsert each message into the cycle
                    //SIGNS The message 
                    sign(load.get(i));

                    rightBuffer.insertarPasivo(load.get(i));

                    load.remove(i); //Removes the message from the load ArrayList
                }
                
            }
            Mensaje end = new Mensaje(); //Sends the last message who kills the existing threads 

            end.firmar("FIN");

            if(insertWay){
                rightBuffer.insertarActivo(end);
            }
            else{
                rightBuffer.insertarPasivo(end);
            }
        }

        
                    //If the thread isn't the first one || The thread is the last one 
        Mensaje current; 
        boolean isLast = false; 

        while(true){

            if(extractWay){
                current = leftBuffer.extraerActivo();
                isLast = (current.darMensaje().equals("FIN")) ? true : false; 

                if(insertWay){
                    //SIGN the message 
                    sign(current);
                    rightBuffer.insertarActivo(current);
                   
                }
                else{
                    //SIGN the message 
                    sign(current);
                    rightBuffer.insertarPasivo(current);
                   
                }

                if(isLast){break;}
            }
            else{
                current = leftBuffer.extraerPasivo();
                isLast = (current.darMensaje().equals("FIN")) ? true : false; 


                if(insertWay){
                    //SIGN the message 
                    sign(current);
                    rightBuffer.insertarActivo(current);
                }
                else{
                    //SIGN the message 
                    sign(current);
                    rightBuffer.insertarPasivo(current);
                }

                if(isLast){break;}
            }
        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                    METHODS                                                            /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Cada thread firma los mensajes que va recibiendo 
     * @param pMensaje
    */
    public void sign(Mensaje pMensaje){

        String rec = (extractWay == true) ? "Active" : "Passive"; 

        String se = (insertWay == true) ? "Active" : "Passive"; 

        String firma = "ID: " + id + " , " + "Extracted: " + rec + " , " + "Inserted: " + se;
        
        pMensaje.firmar(firma);

    }

    /**
     * Sets the leftBuffer of the thread
     * @param pLeft
     */
    public void setLeft(Buzon pLeft){
        this.leftBuffer = pLeft; 
    }

    /**
     * Sets the rightBuffer of the thread
     * @param pRight
     */
    public void setRight(Buzon pRight){
        this.rightBuffer = pRight; 
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                 LOAD(optional)                                                        /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setLoad(ArrayList<Mensaje> pLoad){
        this.load = pLoad; 
    }


}