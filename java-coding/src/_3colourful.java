import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _3colourful {


    public static void main(String[] args) {


        HashMap<Integer,Integer> hm=new HashMap<Integer, Integer>();
        ArrayList<Integer>  arl_Now=new ArrayList<Integer>();
        ArrayList<Integer>  arl=new ArrayList<Integer>();

//        hm.put(0,1);
//        hm.put(10,2);
//        hm.put(100,3);
//        System.out.println("hm.get(100)"+2);




        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=sc.nextInt();
        int[]  ar=new int[1];



        int nCopy=n;
        int i=0;
        while(true){
            //System.out.println("ar[i]"+(n-((int)(n/10))*10));
            //ar[i]=(n-((int)(n/10))*10);
            arl.add((n-((int)(n/10))*10));
            n=(n/10);
            i++;
            if(n==0)
                break;
        }

        // 436
        // 4
        // 43
        // 436
        // 46
        // 3
        // 36
        // 6

        // 364
        // 3
        // 36
        // 364
        // 34
        // 6
        // 64
        // 4


        System.out.println();
        System.out.println();


        for (int j:arl) {
            System.out.println(j);
        }
//        for (int j = 0; j < n; j++) {
//            System.out.println(ar[j]+"  ");
//        }
        System.out.println(_3colourful.recur(ar, arl, arl_Now, arl.size(),0, hm));


    }
    public static int recur(int[]  ar, ArrayList<Integer>  arl, ArrayList<Integer>  arl_Now, int n, int startIndex, HashMap<Integer,Integer> hm){

        for(int i=startIndex; i<n; i++){
            arl_Now.add(arl.get(i));
            //arl_Now.add(ar[i]);

            int prod=1;
            for (int j:arl_Now) {
                prod*=j;
                //System.out.print(j);
            }
//            System.out.println("\nprod="+prod);
//            System.out.println("hm.get("+prod+")="+hm.get(prod));


            if(hm.get(prod)==null){
                hm.put(prod, 1);

            }else{
                System.out.println("reached here");
                return 0;

            }
        }

        int returned=1;
        if(arl_Now.size()>0) {
            int removedItem = arl_Now.get(arl_Now.size() - 1);
            //System.out.println("\nremovedItem"+removedItem);

            startIndex = arl.lastIndexOf(removedItem);
            arl_Now.remove(arl_Now.size() - 1);
            ++startIndex;
           // System.out.println("startIndex"+startIndex);

            returned = recur(ar, arl, arl_Now, n, startIndex, hm);
        }
        return returned;
    }




}
