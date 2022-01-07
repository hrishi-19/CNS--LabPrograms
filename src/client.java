import java.net.*;
import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;

public class client
{
    public static void main(String args[]) throws Exception
    {
        int Entry = 1;
        Scanner Read = new Scanner(System.in);
        System.out.println("Enter Server Address: ");
        String address = Read.nextLine();
        while (Entry == 1)
        {
            Socket sock = new Socket(address, 5119);
            System.out.print("Client /> ");
            String Command = Read.nextLine();
            if (Command.equals("exit"))
            {
                Entry = 0;
                break;
            }
            OutputStream ostream = sock.getOutputStream();
            PrintWriter pwrite = new PrintWriter(ostream, true);
            pwrite.println(Command);

            InputStream istream = sock.getInputStream();
            BufferedReader socketRead = new BufferedReader(new
                    InputStreamReader(istream));
            String FileContent="";
            String Temp;

            while ((Temp = socketRead.readLine()) != null)
            {
                pwrite.println(Temp);
                FileContent+=Temp;
            }
            System.out.println("File : "+Command+" Received.");
            FileWriter Writer = new FileWriter("Client"+Command);
            Writer.write(FileContent);
            Writer.close();
            pwrite.close();
            socketRead.close();
            sock.close();

        }
        Read.close();
    }
}