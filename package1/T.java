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

            //If the thread is the first one, loads up the messages in the cycle 
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

                    String msg = "Thread:  %d - escribio: %s - forma activa";
                    System.out.println("");
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println(String.format(msg,this.id,load.get(i).darMensaje()));// thread shows on the console the type of insertion
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println("");                    

                    load.remove(i); //Removes the message from the load ArrayList
                }
                else{  //If the thread has passiveInsert, passiveInsert each message into the cycle
                    //SIGNS The message 
                    sign(load.get(i));

                    rightBuffer.insertarPasivo(load.get(i));

                    String msg = "Thread:  %d - escribio: %s - forma pasiva";
                    System.out.println(""); 
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println(String.format(msg,this.id,load.get(i).darMensaje())); // thread shows on the console the type of insertion
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println("");


                    load.remove(i); //Removes the message from the load ArrayList
                }
                
            }

            //MANDAR MENSAJE FIN AL FINAL
            
            Mensaje end = new Mensaje(); //Sends the last message who kills the existing threads 

            end.firmar("FIN");
            System.out.println("Thread " + id + ":" +  " Escribió " + " " + "FIN" );

            try {

                sleep(delay); // thread performs the programmed delay
                System.out.println("Thread " + id + ":" +  " delayed" + " " + delay );

            } catch (InterruptedException e) {
                // Handles exception
                e.printStackTrace();
            }

            

            if(insertWay){
                rightBuffer.insertarActivo(end);


                String msg = "Thread:  %d - escribio FIN : %s - forma activa";
                System.out.println("");
                System.out.println("/////////////////////////////////////////////////////////////////////////");
                System.out.println(String.format(msg,this.id, end.darMensaje())); // thread shows on the console the type of insertion
                System.out.println("/////////////////////////////////////////////////////////////////////////");
                System.out.println("");

            }
            else{
                rightBuffer.insertarPasivo(end);

                String msg = "Thread:  %d - escribio FIN : %s - forma pasiva";
                System.out.println("");
                System.out.println("/////////////////////////////////////////////////////////////////////////");
                System.out.println(String.format(msg,this.id, end.darMensaje())); // thread shows on the console the type of insertion
                System.out.println("/////////////////////////////////////////////////////////////////////////");
                System.out.println("");
            }



        }


        //If the thread isn't the first one 
        Mensaje current; 
        boolean isLast = false; 

        while(true){

            if(extractWay){

                try {

                    sleep(delay); // thread performs the programmed delay
                    System.out.println("Thread " + id + ":" +  " delayed" + " " + delay );
    
                } catch (InterruptedException e) {
                    // Handles exception
                    e.printStackTrace();
                }

                current = leftBuffer.extraerActivo();

                isLast = (current.darMensaje().equals("FIN")) ? true : false;

                String msg = "Thread:  %d - recibio : %s - forma activa";
                System.out.println("");
                System.out.println("/////////////////////////////////////////////////////////////////////////");
                System.out.println(String.format(msg,this.id, current.darMensaje())); // thread shows on the console the type of insertion
                System.out.println("/////////////////////////////////////////////////////////////////////////");
                System.out.println("");



                if(insertWay){
                    //SIGN the message 
                    sign(current);
                    rightBuffer.insertarActivo(current);

                    String msg3 = "Thread:  %d - escribio : %s - forma activa";
                    System.out.println("");
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println(String.format(msg3,this.id, current.darMensaje())); // thread shows on the console the type of insertion
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println("");
                   
                }
                else{
                    //SIGN the message 
                    sign(current);
                    rightBuffer.insertarPasivo(current);

                    String msg3 = "Thread:  %d - escribio : %s - forma pasiva";
                    System.out.println("");
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println(String.format(msg3,this.id, current.darMensaje())); // thread shows on the console the type of insertion
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println("");
                   
                }

                if(isLast){
                    
                    System.out.println("");
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println("Thread " +  this.id + " " + "termino proceso");
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println("");

                    break;
                
                }
            }
            else{
                current = leftBuffer.extraerPasivo();
                isLast = (current.darMensaje().equals("FIN")) ? true : false; 


                String msg = "Thread:  %d - recibio : %s - forma pasiva";
                System.out.println("");
                System.out.println("/////////////////////////////////////////////////////////////////////////");
                System.out.println(String.format(msg,this.id, current.darMensaje())); // thread shows on the console the type of insertion
                System.out.println("/////////////////////////////////////////////////////////////////////////");
                System.out.println("");

                if(insertWay){
                    //SIGN the message 
                    sign(current);
                    rightBuffer.insertarActivo(current);

                    String msg3 = "Thread:  %d - escribio : %s - forma activa";
                    System.out.println("");
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println(String.format(msg3,this.id, current.darMensaje())); // thread shows on the console the type of insertion
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println("");
                }
                else{
                    //SIGN the message 
                    sign(current);
                    rightBuffer.insertarPasivo(current);

                    String msg3 = "Thread:  %d - escribio : %s - forma pasiva";
                    System.out.println("");
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println(String.format(msg3,this.id, current.darMensaje())); // thread shows on the console the type of insertion
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println("");
                }

                if(isLast){

                    System.out.println("");
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println("Thread " +  this.id + " " + "termino proceso");
                    System.out.println("/////////////////////////////////////////////////////////////////////////");
                    System.out.println("");


                    break;
                }
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