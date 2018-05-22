import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _3windowString {

    public static void main(String[] args) {

        System.out.println("Enter the string S");
        Scanner sc=new Scanner(System.in);
        String S=sc.nextLine();
        System.out.println("Enter the string T");
        String T=sc.nextLine();

        int S_size=S.length();
        int T_size=T.length();
        HashMap<Character, ArrayList<Integer>> hm=new HashMap<Character, ArrayList<Integer>>();

        for (int i=0; i<S_size; i++) {
            if(hm.get(S.charAt(i))==null){
                ArrayList<Integer> arl=new ArrayList<Integer>();
                arl.add(i);
                hm.put(S.charAt(i), arl);

            }
            else {
                ArrayList<Integer> arl=hm.get(S.charAt(i));
                arl.add(i);
                hm.put(S.charAt(i), arl);
            }
        }

        int minIndex=-1, maxIndex=-1;

        ArrayList<ArrayList<Integer>> arlFinal=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arl =new ArrayList<Integer>();
        for(int i=0; i<T_size; i++){

            ArrayList<Integer> arl2= hm.get(T.charAt(i));
            arlFinal.add(arl2);
        }
//        int counter=1;
//        while(true){
//
//            for (ArrayList<Integer> arl: arlFinal) {
//
//               int xi= arl.get(counter);
//               if(minIndex==-1 && maxIndex==-1){
//                   minIndex=xi;
//                   maxIndex=xi;
//               }
//
//               if(xi<minIndex){
//                   minIndex=xi;
//               }
//               else if(xi>maxIndex){
//                   maxIndex=xi;
//               }
//
//
//            }
//
//
//
//        }

        System.out.println("\narlFinal="+arlFinal+"\n");
        int[] minMaxMindiff=new int[3];
        Integer min=arlFinal.size();
        minMaxMindiff[0]=min;
        Integer max=-1;
        minMaxMindiff[1]=max;
        Integer minDiff=S_size;
        minMaxMindiff[2]=minDiff;

        //recur2(arl);
        recur(arlFinal, arl, arlFinal.size(), minMaxMindiff, 0  );
        System.out.println("min="+minMaxMindiff[0]+"   max="+minMaxMindiff[1]);
        System.out.println("combination="+arl);




    }

    public static void recur2(ArrayList<Integer> combination){
        combination.add(1);
        combination.add(2);

    }

    public static void recur(ArrayList<ArrayList<Integer>> arlFinal, ArrayList<Integer> combination, int size,int[] minMaxMindiff, int startIndex){

        ArrayList<Integer> arl=arlFinal.get(startIndex);
        int arlSize=arl.size();

        for(int i=0; i<arlSize; i++){

            boolean found=false;
            for (int k:combination) {
                if(k==arl.get(i)){
                    found=true;
                    break;
                }
            }
            if(found){
                continue;
            }
            combination.add(arl.get(i));

            if(startIndex<(size-1)){
                System.out.println("\ncombination"+combination+"   min="+minMaxMindiff[0]+"   max="+minMaxMindiff[1]+" minDiff="+minMaxMindiff[2]+"  startIndex="+startIndex);

                recur(arlFinal, combination, size, minMaxMindiff, startIndex+1);
            }
            if(startIndex==size-1) {
                System.out.println("\ncombination"+combination+"   min="+minMaxMindiff[0]+"   max="+minMaxMindiff[1]);

                int min2 = combination.get(0), max2 = combination.get(0);
                for (int j : combination) {
                    if (j < min2) {
                        min2 = j;
                    } else if (j > max2) {
                        max2 = j;
                    }
                }
                System.out.println("(max2="+max2+"-min2="+min2+")="+(max2-min2)+"<minDiff="+minMaxMindiff[2]);
                if (max2 - min2 < minMaxMindiff[2]) {
                    minMaxMindiff[2] = max2 - min2;
                    minMaxMindiff[1] = max2;
                    minMaxMindiff[0] = min2;
                }
            }
//            arlFinal=[[0, 13, 14], [1, 7, 12, 16], [6, 11, 15], [1, 7, 12, 16]]
            combination.remove(combination.size()-1);

        }


    }



}
