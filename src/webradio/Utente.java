
package webradio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utente {

    static String  Nome;
    static String Cognome;
    static String Nickname;
    static String Password;
    static String Preferenza1;
    static String Preferenza2;
    static String Preferenza3;
    
    public static void main(String[] args) {
        int porta = 2000;
        InetAddress ip = null;
        DatagramSocket dSocket = null;
        String messaggio="";
        byte[] buffer = null;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
        }
                try 
        {           
            buffer = new byte[256];
            System.out.println("server raggiunto");
            dSocket = new DatagramSocket();                  
        }
        catch (SocketException ex) 
        {
                Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
        }
        registrati(dSocket, ip, porta);
        setPreferenze();
        scrivi(dSocket, ip, porta, messaggio);
        leggi(dSocket, ip, porta, buffer);
        
        

    }
    
   public static void scrivi(DatagramSocket dSocket, InetAddress ip, int porta, String messaggio)
   {
        DatagramPacket dPacketOut;      
       
        try 
        {
            dPacketOut = new DatagramPacket(messaggio.getBytes(), messaggio.length(), ip, porta );
            dSocket.send(dPacketOut);
        } catch (IOException ex) 
        {
            Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
   
    public static String leggi(DatagramSocket dSocket, InetAddress ip, int porta, byte[] buffer)
   
    {
        DatagramPacket dPacketIn;
        String messaggioIn = null;
   
        try 
        {
            dPacketIn = new DatagramPacket(buffer, buffer.length);
            dSocket.receive(dPacketIn);
            messaggioIn = new String(dPacketIn.getData(), 0, dPacketIn.getLength());
        } catch (IOException ex) {
            Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messaggioIn;
    }
    
  
   
   public static void registrati(DatagramSocket dSocket, InetAddress ip, int porta)
   {       
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci nome");
        Nome = input.next();
        System.out.println("inserisci cognome");
        Cognome = input.next();
        System.out.println("inserisci nickname");
        Nickname = input.next();
        System.out.println("inserisci password");
        Password = input.next();
        scrivi(dSocket, ip, porta, Nome);
        scrivi(dSocket, ip, porta, Cognome);
        scrivi(dSocket, ip, porta, Nickname);
        scrivi(dSocket, ip, porta, Password);
        
    }
   
   public static void accedi(DatagramSocket dSocket, InetAddress ip, int porta)
   {       
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci nickname");
        Nickname = input.next();
        System.out.println("inserisci password");
        Password = input.next();
        scrivi(dSocket, ip, porta, Nome);
        scrivi(dSocket, ip, porta, Cognome);
        scrivi(dSocket, ip, porta, Nickname);
        scrivi(dSocket, ip, porta, Password);
    }
    
   public static void setPreferenze()
   {
       
       Scanner input = new Scanner(System.in);
       
       while(Preferenza1 == null){
        System.out.println("inserisci la tua prima scelta musicale, scrivi 1 per rock, 2 per pop, 3 per rap, 4 per trap e 5 per indie");
        String scelta = input.next();

       switch(scelta){
           case "1":
           Preferenza1 = "rock";    
           break;
           case "2":
           Preferenza1 = "pop";               
           break;
           case "3":
           Preferenza1 = "rap";
           break;
           case "4":
           Preferenza1 = "trap";    
           break;
           case "5":
           Preferenza1 = "indie";    
           break;
           default:
           System.out.println("codice invalido, riprova");
       }
       }
       
       while(Preferenza2 == null || Preferenza2.equals(Preferenza1)){
        System.out.println("inserisci la tua seconda scelta musicale, scrivi 1 per rock, 2 per pop, 3 per rap, 4 per trap e 5 per indie");
        String scelta = input.next();

       switch(scelta){
           case "1":
           Preferenza2 = "rock";    
           break;
           case "2":
           Preferenza2 = "pop";               
           break;
           case "3":
           Preferenza2 = "rap";
           break;
           case "4":
           Preferenza2 = "trap";    
           break;
           case "5":
           Preferenza2 = "indie";    
           break;
           default:
           System.out.println("codice invalido, riprova");
       }
       }
       
       while(Preferenza3 == null || Preferenza3.equals(Preferenza1) || Preferenza3.equals(Preferenza2)){
        System.out.println("inserisci la tua seconda scelta musicale, scrivi 1 per rock, 2 per pop, 3 per rap, 4 per trap e 5 per indie");
        String scelta = input.next();

       switch(scelta){
           case "1":
           Preferenza3 = "rock";    
           break;
           case "2":
           Preferenza3 = "pop";               
           break;
           case "3":
           Preferenza3 = "rap";
           break;
           case "4":
           Preferenza3 = "trap";    
           break;
           case "5":
           Preferenza3 = "indie";    
           break;
           default:
           System.out.println("codice invalido, riprova");
       }
       }
       
   }
   
}
