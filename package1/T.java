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

        this.load = new ArrayList<Mensaje>();

        this.id = pId; 

        this.delay = pDelay;

        this.leftBuffer = pLeftBuffer;

        this.rightBuffer = pRightBuffer;

        this.extractWay = pExtractWay; 

        this.insertWay = pInsertWay;

    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                      RUN                                                              /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void run(){

        // Checks if the thread is the first one 
        if(!load.isEmpty()){


            System.out.println(extractWay + "," +  insertWay);

            //If the thread is the first one, loads up the messages in the cycle 
            for(int i = 0; i < load.size(); i ++){

                try {

					sleep(delay); // thread performs the programmed delay
					

				} catch (InterruptedException e) {
					// Handles exception
					e.printStackTrace();
				}

                if(insertWay){ // If the thread have activeInsert, activeInsert each message into the cycle 

                    //SIGNS The message 
                    sign(load.get(i));


                    rightBuffer.insertarActivo(load.get(i));


                    //PRINTS 
                    System.out.println("/// " + load.get(i).darMensaje() + " ///");

                    load.remove(i); //Removes the message from the load ArrayList
                }
                else{  //If the thread has passiveInsert, passiveInsert each message into the cycle
                    //SIGNS The message 
                    sign(load.get(i));

                    rightBuffer.insertarPasivo(load.get(i));

                    //PRINTS
                    System.out.println("/// " + load.get(i).darMensaje() + " ///");

                    load.remove(i); //Removes the message from the load ArrayList
                }
                
            }

            //MANDAR MENSAJE FIN AL FINAL
            
            Mensaje end = new Mensaje(); //Sends the last message who kills the existing threads 

            end.firmar("FIN");
            
            System.out.println("/// " + "El thread 1 escribio FIN" + " ///"); 

            try {

                sleep(delay); // thread performs the programmed delay
            

            } catch (InterruptedException e) {
                // Handles exception
                e.printStackTrace();
            }

            

            if(insertWay){
                rightBuffer.insertarActivo(end);

            }
            else{
                rightBuffer.insertarPasivo(end);

            }
        
        }


        // If the thread isn't the first one 
        Mensaje current; 
        boolean isLast = false; 

        // while(true){

            if(extractWay){

                try {

                    sleep(delay); // thread performs the programmed delay
                
    
                } catch (InterruptedException e) {
                    // Handles exception
                    e.printStackTrace();
                }

                current = leftBuffer.extraerActivo(this);

                isLast = (current.darMensaje().contains("FIN")) ? true : false;


                if(insertWay){
                    //SIGN the message 

                    

                    sign(current);


                    rightBuffer.insertarActivo(current);

                    

                    System.out.println("/// " + current.darMensaje() + " ///");
                   
                }
                else{
                    //SIGN the message 
                    sign(current);
                    rightBuffer.insertarPasivo(current);

                    System.out.println("/// " + current.darMensaje() + " ///");
                   
                }

                if(isLast){
                    
                    // break;
                
                }
            }
            else{
                current = leftBuffer.extraerPasivo();
                isLast = (current.darMensaje().contains("FIN")) ? true : false; 


                if(insertWay){
                    //SIGN the message 
                    sign(current);
                    rightBuffer.insertarActivo(current);

                    System.out.println("/// " + current.darMensaje() + " ///");

                }
                else{
                    //SIGN the message 
                    sign(current);
                    rightBuffer.insertarPasivo(current);

                    System.out.println("/// " + current.darMensaje() + " ///");

                }

                if(isLast){

                    // break;
                }
            }
        
        }



    // }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////                                                    METHODS                                                            /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Cada thread firma los mensajes que va recibiendo 
     * @param pMensaje
    */
    public void sign(Mensaje pMensaje){


        String rec = (extractWay) ? "Activa" : "Pasiva"; 

        String se = (insertWay) ? "Activa" : "Pasiva"; 

        String firma = "ID: " + id + " , " + "Extraccion: " + rec + " , " + "Insercion: " + se;
        
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

