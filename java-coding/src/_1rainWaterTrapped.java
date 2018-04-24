import java.util.Scanner;

public class _1rainWaterTrapped {

    public static void main(String[] args){

        System.out.println("Enter the size of array");
        Scanner sc=new Scanner(System.in);
        //System.out.println("Enter your rollno");
        int size=sc.nextInt();
        int[] ar=new int[size];
        System.out.println("Enter "+size+ " numbers one by one");
        for(int i=0; i<size; i++){
            ar[i]=sc.nextInt();
        }

        for(int i=0; i<size; i++){
            System.out.print( ar[i]);
        }

        



    }

}
