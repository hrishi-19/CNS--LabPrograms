import java.util.*;
public class leakeyBucket {
    public static void main(String[] args) {

        int intr,overflow=0,out=50,buffer=300;
        int str,rem=0;
        Scanner in= new Scanner(System.in);
       while(true){
           intr=in.nextInt();
           if(intr+rem>buffer){
               overflow=intr+rem-buffer;
               str=intr+rem;
               rem=str-out-overflow;

           }
           else {
               overflow=0;
               str=intr+rem;
               rem=str-out;
           }
           System.out.println(intr);
           System.out.println(overflow);
           System.out.println(rem);
           System.out.println(str);
       }
    }
}
