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


    static void readFile(ArrayList<Buzon> pBuzones, ArrayList<Mensaje> pMensajes){
        //Create a the .config file 
        File file = new File("C:\\Users\\jm.vegac\\Multithreading-Mailbox\\Config\\Settings.txt");

        try{

            //Scanner who reads the file 
            Scanner scanFile = new Scanner(file);

            for(int i = 0; i < 4; i ++){
                String infoBuzon = scanFile.nextLine();
                String id = infoBuzon.split("")[0];
                int capacity = Integer.parseInt(infoBuzon.split(" ")[1]);
                Buzon current = new Buzon(id, capacity);
            }

            for(int i = 0; i < 4; i ++){
                
            }

        }
        catch(Exception e ){
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        
        //Starts dialog 
        System.out.println("Hola, bienvenido al caso 1 de Infraestructura computacional");
        System.out.println("Por favor digita el numero de mensajes que deseas transmitir");

        //Scan user input
        Scanner scanUser = new Scanner(System.in);

        //Reads the number of messages the program will handle
        int noMensajes = scanUser.nextInt();

        ArrayList<Mensaje> ms = new ArrayList<Mensaje>();


        for(int i = 0; i < noMensajes; i ++ ){
            Mensaje current = new Mensaje(); 
            ms.add(current); 
        }

        Buzon bz1 = new Buzon(); 

        Buzon bz2 = new Buzon(); 

        Buzon bz3 = new Buzon();

        Buzon bz4 = new Buzon(); 

        for(int i = 0; i < 4; i ++){ 
            
            new T().start(); 
        }
    }

}
    