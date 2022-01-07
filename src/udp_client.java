
import  java.io.*;
import java.net.*;

public class udp_client {
    public static DatagramSocket client_socket;
    public static DatagramPacket dp;
    public  static BufferedReader br;
    public static InetAddress ia;
    public static byte buf[]=new byte[1024];
    public static int cport=3000,sport=8000;

    public static void main(String[] args) throws IOException {
        client_socket=new DatagramSocket(cport);
        dp=new DatagramPacket(buf,buf.length);
        br=new BufferedReader(new InputStreamReader(System.in));
        ia=InetAddress.getLocalHost();
        System.out.println("client listening");
        System.out.println();
        System.out.println("enter the msg");
        while(true){
            String s1=new String(br.readLine());
            buf=s1.getBytes();
            if(s1.equals("exit")){
                System.out.println("terminated");
                client_socket.send(new DatagramPacket(buf,s1.length(),ia,sport));
                break;
            }
            client_socket.send(new DatagramPacket(buf,s1.length(),ia,sport));
            client_socket.receive(dp);
            String s4=new String(dp.getData(),0,dp.getLength());
            System.out.println("server said:"+ s4);
        }
    }

}
