import java.util.Scanner;

public class crc {
    void div(int a[], int k) {
        int gp[] = {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1};
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (a[i] == gp[0]) {
                for (int j = 0; j < 17; j++) {
                    a[j] = a[j] ^ gp[count];
                }
                count = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[100];
        int[] b = new int[100];
        int len, k,flag=0;
        crc obj=new crc();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of dataframe");
        len = in.nextInt();

        System.out.println("enter the data");
        for (int i = 0; i < len; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < 16; i++) {
            a[len++] = 0;
        }
        k=len-16;
        for(int i=0;i<len;i++){
            b[i]=a[i];
        }
        obj.div(a,k);
        for(int i=0;i<len;i++){
            b[i]=a[i]^b[i];
        }
        System.out.println("the transimitted data is");
        for (int i = 0; i < len; i++) {
            System.out.print(a[i]+ " ");
        }
        System.out.println();
        System.out.println("enter the recieved data");
        for (int i = 0; i < len; i++) {
            a[i] = in.nextInt();
        }
        obj.div(a,k);
        for (int i = 0; i < len; i++) {
            if(a[i]!=0) flag=1;
                break;
        }
        if(flag==1) System.out.println("error");
        else System.out.println("no error");
        in.close();




    }
}
