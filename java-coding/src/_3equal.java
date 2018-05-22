import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _3equal {

    public static void main(String[] args) {

        HashMap<Integer, ArrayList<Integer>> hm= new HashMap<Integer, ArrayList<Integer>>();

//        Integer n=1;
//        System.out.println("n="+n);
//
//        if(n==n){
//            return;
//        }
        ArrayList<Integer> arl=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> arlFinal= new ArrayList<ArrayList<Integer>>();
        System.out.println("Enter the size of array");
        Scanner sc=new Scanner(System.in);
        //System.out.println("Enter your rollno");
        int size=sc.nextInt();
        int[] ar=new int[size];
        System.out.println("Enter "+size+ " numbers one by one");
        for(int i=0; i<size; i++){
            ar[i]=sc.nextInt();
            if(hm.get(ar[i])!=null){
                ArrayList<Integer> arl2=hm.get(ar[i]);
                arl2.add(i);
                hm.put(ar[i], arl2);
            }
            else {
                ArrayList<Integer> arl2=new ArrayList<Integer>();
                arl2.add(i);
                hm.put(ar[i], arl2);
            }
        }







    }



}
