import  java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class udp_server {
    public static DatagramSocket server_socket;
    public static DatagramPacket dp;
    public static InetAddress ia;
    public static BufferedReader br;
    public static byte buf[]=new byte[1024];
    public static int cport=3000,sport=8000;

    public static void main(String[] args) throws IOException {
        server_socket=new DatagramSocket(sport);
        dp=new DatagramPacket(buf,buf.length);
        br=new BufferedReader(new InputStreamReader(System.in));
        ia= InetAddress.getLocalHost();
        System.out.println("server running");
        while (true){
            server_socket.receive(dp);
            String s2=new String(dp.getData(),0,dp.getLength());
            System.out.println("cliet said: " +s2);
            String s3=new String(br.readLine());
            buf=s3.getBytes();
            server_socket.send(new DatagramPacket(buf,s3.length(),ia,cport));

        }


    }
}
