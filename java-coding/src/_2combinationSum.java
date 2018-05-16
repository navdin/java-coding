import java.util.ArrayList;
import java.util.Scanner;

public class _2combinationSum {

    public static void main(String[] args) {

        System.out.println("Enter the size of array");
        Scanner sc=new Scanner(System.in);
        //System.out.println("Enter your rollno");
        int size=sc.nextInt();
        int[] ar=new int[size];
        System.out.println("Enter "+size+ " numbers one by one");
        for(int i=0; i<size; i++){
            ar[i]=sc.nextInt();
        }
        System.out.println("Enter target number");
        int target=sc.nextInt();
        ArrayList<Integer> arl=new ArrayList<Integer>();
        for(int i=0; i<size; i++){
           //arl.add(ar[i]);
           int n=target/ar[i];
           for(int j=1; j<=n; j++){
               arl.add(ar[i]);
           }
        }
        System.out.println(arl);
        int sizeFinal=arl.size();
        ArrayList<Integer> arl_Now=new ArrayList<Integer>();

        //_2combinationSum.recur(arl, arl_Now, 0, sizeFinal);

    }
    public static void recur(ArrayList<Integer> arl, ArrayList<Integer> arl_Now, int startIndex, int sizeFinal){

        for(int i=startIndex; i<sizeFinal; i++){
            arl_Now.add(arl.get(i));
            System.out.println();
            for (int k:arl_Now) {
                System.out.print(k+" ");
            }
        }

        if(arl_Now.size()>0) {
            int removedItem = arl_Now.get(arl_Now.size() - 1);
//        System.out.println("\narl_Now.size()"+arl_Now.size());
            arl_Now.remove(arl_Now.size() - 1);
//        System.out.println("arl_Now.size() after removing"+arl_Now.size());
            startIndex = arl.lastIndexOf(removedItem);
            startIndex += 1;
//        System.out.println("startIndex="+startIndex);
//        System.out.println("sizeFinal="+sizeFinal);

            recur(arl, arl_Now, startIndex, sizeFinal);
        }

    }



}
