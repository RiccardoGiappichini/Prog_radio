package webradio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    
    public static void main(String[] args) {
    
        int porta = 2000;
        InetAddress ipClient;
        int portaClient;
        DatagramSocket dSocket;
        DatagramPacket dPacketIn;
        DatagramPacket dPacketOut;
        byte[] buffer;
        Date data = new Date();
        String messaggioIn;
        String messaggioOut;
        String messaggio = data.toString();
        try 
        {
            dSocket = new DatagramSocket(porta);
            System.out.println("apertura porta 2000");
            
            while(true)
                {
                    System.out.println("server in ascolto sulla porta " + porta + "/n");
                    buffer = new byte[256];
                    dPacketIn = new DatagramPacket(buffer, buffer.length);
                    dSocket.receive(dPacketIn);
                    ipClient = dPacketIn.getAddress();
                    portaClient = dPacketIn.getPort();
                    messaggioIn = new String(dPacketIn.getData(), 0, dPacketIn.getLength());
                    dPacketOut = new DatagramPacket(messaggio.getBytes(), messaggio.length(), ipClient, portaClient );
                    dSocket.send(dPacketOut);
                    System.out.println(messaggioIn);        
                }
       
        }
        catch (SocketException ex)
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        }     
    }
