import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _3pointsOnStraightLine {

    public static void main(String[] args) {


        System.out.println("Enter the size of array");
        Scanner sc=new Scanner(System.in);
        //System.out.println("Enter your rollno");
        int size=sc.nextInt();
        int[] arX=new int[size];
        int[] arY=new int[size];

        System.out.println("Enter "+size+ " numbers one by one X-axis");
        for(int i=0; i<size; i++) {
            arX[i] = sc.nextInt();
        }

        System.out.println("Enter "+size+ " numbers one by one Y-axis");
        for(int i=0; i<size; i++) {
            arY[i] = sc.nextInt();
        }
        Integer[] ar= new Integer[2];
        ArrayList<Integer> arl=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> arlFinal=new ArrayList<ArrayList<Integer>>();
        HashMap<Double, ArrayList<ArrayList<Integer>>> hm=new HashMap<Double, ArrayList<ArrayList<Integer>>>();
        int index=0;
        int X=arX[index];
        int Y=arY[index];
        while(true){





        }


    }


}
