import  java.io.*;
import java.net.*;
import java.io.FileWriter;
import java.net.ServerSocket;
public class server {
    public static void main(String[] args) throws IOException {
        int data=1;
        ServerSocket serShock=new ServerSocket(5119);
        while (data==1){
            System.out.println("Server ready for connection");
            Socket sock=serShock.accept();
            System.out.println("Connection established/waiting for client");
            InputStream isStream= sock.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(isStream));
            String fname=br.readLine();
            if(fname.equals("exit")){
                continue;
            }
            BufferedReader contentRead=new BufferedReader(new FileReader(fname));
            OutputStream ostream= sock.getOutputStream();
            PrintWriter pwrite=new PrintWriter(ostream,true);
            String str;
            while((str=contentRead.readLine())!=null){
                pwrite.println(str);
            }
            System.out.println("File contents sent successfully");
            pwrite.close();
            br.close();
            contentRead.close();
            sock.close();


        }
        serShock.close();
    }
}
