import java.util.*;
import java.io.*;
public class rsa
{

    static int gcd(int m,int n){
        while(n!=0){
            int r=m%n;
            m=n;
            n=r;
        }
        return m;
    }

    public static void main(String[] args) {
        int p=0,q=0,n=0,e=0,d=0,phi=0;
        int[]nummes=new int[100];
        int[]encrypt=new int[100];
        int[]decrypt=new int[100];
        int i=0,j=0,nofelm=0;
        Scanner in=new Scanner(System.in);
        System.out.println("enter msg");
        String str= in.nextLine();
        System.out.println("enter p and q");
        p=in.nextInt();
        q=in.nextInt();
        n=p*q;
        phi=(p-1)*(q-1);
        for(i=2;i<phi;i++){
            if(gcd(i,phi)==1)
                break;
        }
        e=i;
        for(i=2;i<phi;i++){
            if((e*i-1)%phi==0){
                break;
            }
        }
        d=i;
        for(i=0;i<str.length();i++){
            char c=str.charAt(i);
            int a=(char)c;
            nummes[i]=a-96;

        }
        nofelm=str.length();
        for( i=0;i<nofelm;i++){
            encrypt[i]=1;
            for(j=0;j<e;j++){
                encrypt[i]=(encrypt[i]*nummes[i])%n;
            }

        }
        System.out.println("enceryted msg");
        for(i=0;i<nofelm;i++){
            System.out.print(encrypt[i]);
            System.out.print(encrypt[i]);
        }
        for(i=0;i<nofelm;i++){
            System.out.print((char)(encrypt[i]+96));
        }
        for( i=0;i<nofelm;i++){
            decrypt[i]=1;
            for(j=0;j<d;j++){
                decrypt[i]=(decrypt[i]*encrypt[i])%n;
            }

        }
        System.out.println("decrypted msg");
        for(i=0;i<nofelm;i++){
            System.out.print((char)(decrypt[i]+96));
        }



    }
}
