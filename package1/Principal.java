/**
 * Caso 1 Infraestructura Computacional "Mailbox"
 * 
 * @author Juan Miguel Vega Caro 201715344
 * @author  
 */
import java.util.Scanner; 
import java.io.File;
import java.util.ArrayList;


/**
 * Clase principal del Mailbox 
 */

public class Principal{


    static int readFile(ArrayList<Buzon> pBuzones, ArrayList<T> pThreads){
        //Create a the .config file 
        File file = new File("/home/themike/Documents/2022-1/Multithreading-Mailbox/Config/Settings.txt");

        int sumaTamaños = 0; 
        try{

            //Scanner who reads the file 
            Scanner scanFile = new Scanner(file);

            for(int i = 0; i < 4; i ++){
                String infoBuzon = scanFile.nextLine();
                String id = infoBuzon.split(" ")[0];
                int capacity = Integer.parseInt(infoBuzon.split(" ")[1]);
                Buzon current = new Buzon(id, capacity);

                pBuzones.add(current);

                sumaTamaños += capacity; 
            }

            for(int i = 0; i < 4; i ++){
                String infoThread = scanFile.nextLine(); 

                String id = infoThread.split(" ")[0];

                int delay = Integer.parseInt(infoThread.split(" ")[1]);

                boolean extractWay = Boolean.parseBoolean(infoThread.split(" ")[2]); 

                boolean insertWay = Boolean.parseBoolean(infoThread.split(" ")[3]); 
                
                //Initializes threads with rightBuffers 
                T thread = new T(id, delay, null, null, extractWay, insertWay); 
                
                pThreads.add(thread);
            }
            
            //Sets the buffers of the Threads
            pThreads.get(0).setLeft(pBuzones.get(3));

            pThreads.get(0).setRight(pBuzones.get(0)); 

            pThreads.get(1).setLeft(pBuzones.get(0)); 

            pThreads.get(1).setRight(pBuzones.get(1)); 

            pThreads.get(2).setLeft(pBuzones.get(1)); 

            pThreads.get(2).setRight(pBuzones.get(2)); 

            pThreads.get(3).setLeft(pBuzones.get(2)); 

            pThreads.get(3).setRight(pBuzones.get(3)); 


        }
        catch(Exception e ){
            e.printStackTrace();
        }

        return sumaTamaños;
    }


    public static void main(String[] args){
        
        //Starts dialog 
        System.out.println("Hola, bienvenido al caso 1 de Infraestructura computacional");
        System.out.println("Por favor digita el numero de mensajes que deseas transmitir");

        //Scan user input
        Scanner scanUser = new Scanner(System.in);

        //Reads the number of messages the program will handle
        int noMensajes = scanUser.nextInt();

        //ArrayList containing the messages of the system ( SYSTEM LOAD )
        ArrayList<Mensaje> ms = new ArrayList<Mensaje>();

        //FIlls the arrayList with the user messages (SYSTEM LOAD)
        for(int i = 0; i < noMensajes; i ++ ){
            Mensaje current = new Mensaje(); 
            ms.add(current); 
        }


        //ArrayList containing the buffers 
        ArrayList<Buzon> buzones = new ArrayList<Buzon>(); 

        //ArrayList containing the threads 
        ArrayList<T> threads = new ArrayList<T>(); 

        int sumaTamaños = readFile(buzones, threads); 

        if(noMensajes <= sumaTamaños ){
            //Creates the threads and start running them 

            //Set the load of the system through the first Thread 
            threads.get(0).setLoad(ms);

            for(int i = 0; i < threads.size(); i ++){ 
                threads.get(i).start(); 
            }
        }
        else{

            System.out.println("Error 404: El numero de mensajes excede la capacidad del sistema");
        
        }

    }

}
    