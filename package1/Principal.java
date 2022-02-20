/**
 * Caso 1 Infraestructura Computacional "Mailbox"
 * 
 * @author Juan Miguel Vega Caro 201715344
 * @author  
 */
import java.util.Scanner; 
import java.util.ArrayList;

/**
 * Clase principal del Mailbox 
 */

public class Principal{


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Hola, bienvenido al caso 1 de Infraestructura computacional");
        System.out.println("Por favor digita el numero de mensajes que deseas transmitir");

        int noMensajes = scan.nextInt();

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
    