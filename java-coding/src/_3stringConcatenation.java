import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _3stringConcatenation {

    public static void main(String[] args) {

        System.out.println("Enter the string S");
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        System.out.println("Enter collection of strings one by one");
        ArrayList<String> arlString = new ArrayList<String>();

        int l = 0;
        while (true) {
            String T = sc.nextLine();
            System.out.println("here " + l);

            if (T != " ") {
                arlString.add(T);
                System.out.println("here in " + l + arlString.get(l));

            } else
                break;

            l++;
            if (l == 3)
                break;
        }
        System.out.println("here");
        int S_size = S.length();
        int T_size = arlString.get(0).length();
        int arlS_size = arlString.size();
        System.out.println("\narlString:\n" + arlString);
        HashMap<Character, ArrayList<Integer>> hm_S = new HashMap<Character, ArrayList<Integer>>();

        for (int i = 0; i < S_size; i++) {
            if (hm_S.get(S.charAt(i)) == null) {
                ArrayList<Integer> arl = new ArrayList<Integer>();
                arl.add(i);
                hm_S.put(S.charAt(i), arl);

            } else {
                ArrayList<Integer> arl = hm_S.get(S.charAt(i));
                arl.add(i);
                hm_S.put(S.charAt(i), arl);
            }
        }



        ArrayList<ArrayList<Integer>> arlFinal=new ArrayList<ArrayList<Integer>>();
        ArrayList<HashMap<Integer,Integer>> arlHashFinal=new ArrayList<HashMap<Integer,Integer>>();

        for(int i=0; i<arlS_size; i++){

            String T=arlString.get(i);
            System.out.println("\narlString.get("+i+")="+arlString.get(i));
            T_size=T.length();
            for (int j=0; j<T_size; j++) {
                ArrayList<Integer> arl2= hm_S.get(T.charAt(j));
                System.out.println("\n"+T.charAt(i)+": "+arl2);
                arlFinal.add(arl2);
                HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
                for (int k:arl2) {
                    hm.put(k, 1);
                }
                arlHashFinal.add(hm);
            }

        }
        boolean matchFound=true;
        ArrayList<ArrayList<Integer>> arlFinal_TstartIndices=new ArrayList<ArrayList<Integer>>();

        HashMap<Integer, ArrayList<Integer>> hm_TstartIndices=new HashMap<Integer, ArrayList<Integer>>();


        int arlFinalSize=arlFinal.size();

        int Tgroup_count=0;
        for(int i=0; i<arlFinalSize; i+=T_size){

                int TstartSize=arlFinal.get(i).size();
                ArrayList<Integer> arl_Tstart=arlFinal.get(i);
                ArrayList<Integer> arl_TstartIndices=new ArrayList<Integer>();

                for(int j=0; j<TstartSize; j++){
                    int value_Tstart=arl_Tstart.get(j);
                    int counter=1;
                    for(int k=1; k<T_size; k++){

                        if(arlHashFinal.get(k+i).get(value_Tstart+k)==null){
                           break;
                        }
                        else
                            counter++;
                    }
                    if(counter==T_size){
                        arl_TstartIndices.add(value_Tstart);
                    }

                }
                if(arl_TstartIndices.size()==0){
                    matchFound=false;
                }
                arlFinal_TstartIndices.add(arl_TstartIndices);
                for (int k:arl_TstartIndices) {

                    if(hm_TstartIndices.get(k)==null){
                        ArrayList<Integer> arl =new ArrayList<Integer>();
                        arl.add(Tgroup_count);
                        hm_TstartIndices.put(k,arl);
                    }
                    else {
                        ArrayList<Integer> arl =hm_TstartIndices.get(k);
                        arl.add(Tgroup_count);
                        hm_TstartIndices.put(k,arl);

                    }

                }
            Tgroup_count++;

        }

        System.out.println("arlFinal_TstartIndices:"+arlFinal_TstartIndices);


        HashMap<Integer, Integer> hm_T=new HashMap<Integer, Integer>();
        ArrayList<Integer> arl_TgroupIndicesAdded=new ArrayList<Integer>();
        ArrayList<Integer> arl_finalSolution=new ArrayList<Integer>();

        boolean firstMatchFound=false;
        int c=1;

        for(int i=0; i<S_size; i=i+c){

            if(hm_TstartIndices.get(i)!=null){


                c=T_size;

                ArrayList<Integer> arl_Tgroup=hm_TstartIndices.get(i);
                //System.out.println("\narl_finalSolution"+arl_finalSolution);

                int indexIn_arl_TgroupIndicesAdded=arlString.size();
                int TgroupIndex=-1;
                int count=0;
                for (int j:arl_Tgroup) {
                    if(hm_T.get(j)==null){
                        hm_T.put(j, arl_TgroupIndicesAdded.size());
                        arl_TgroupIndicesAdded.add(j);
                        break;
                    }
                    else {
                        if(hm_T.get(j)<indexIn_arl_TgroupIndicesAdded){
                            indexIn_arl_TgroupIndicesAdded=hm_T.get(j);
                            TgroupIndex=j;
                        }
                        count++;
                    }

                }
                if(count==arl_Tgroup.size()){
                     //index=hm_T.get(arl_Tgroup.get(0));
                    //int TgroupIndex=hm_T.get(indexIn_arl_TgroupIndicesAdded);
                    for(int k=0; k<=indexIn_arl_TgroupIndicesAdded; k++){
                        hm_T.put(arl_TgroupIndicesAdded.get(0), null);
                        arl_TgroupIndicesAdded.remove(0);
//                        hm_T.put(arl_Tgroup.get(0), null);
//                        arl_Tgroup.remove(0);
                    }
                    int j=0;
                    for (int k:arl_TgroupIndicesAdded) {
                        hm_T.put(k, j);
                        j++;
                    }
                    hm_T.put(TgroupIndex, arl_TgroupIndicesAdded.size());
                    arl_TgroupIndicesAdded.add(TgroupIndex);
                }

                System.out.println("\narl_startIndices"+arl_TgroupIndicesAdded);
                if(arl_TgroupIndicesAdded.size()==arlString.size()){
                    arl_finalSolution.add(i-T_size*(arlString.size()-1));
                    System.out.println("\narl_finalSolution"+arl_finalSolution);

                }

            }
            else{
                c=1;
                arl_TgroupIndicesAdded.clear();
                hm_T.clear();
            }


        }

        for(int p=0; p<S_size; p++){
            System.out.print(S.charAt(p) + "    ");

        }
        System.out.println();
            for(int p=0; p<S_size; p++){

             {
                if(p/10>0)
                    System.out.print(p + "   ");
                else
                    System.out.print(p + "    ");

            }

        }
        System.out.println("\nfinal solution:"+arl_finalSolution);










    }
    public static void help(){

        System.out.println("Enter the string S");
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        System.out.println("Enter collection of strings one by one");
        ArrayList<String> arlString = new ArrayList<String>();

        int l = 0;
        while (true) {
            String T = sc.nextLine();
            System.out.println("here " + l);

            if (T != " ") {
                arlString.add(T);
                System.out.println("here in " + l + arlString.get(l));

            } else
                break;

            l++;
            if (l == 2)
                break;
        }
        System.out.println("here");

        int S_size = S.length();
        int T_size = arlString.get(0).length();
        int arlS_size = arlString.size();
        System.out.println("\narlString:\n" + arlString);
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<Character, ArrayList<Integer>>();

        for (int i = 0; i < S_size; i++) {
            if (hm.get(S.charAt(i)) == null) {
                ArrayList<Integer> arl = new ArrayList<Integer>();
                arl.add(i);
                hm.put(S.charAt(i), arl);

            } else {
                ArrayList<Integer> arl = hm.get(S.charAt(i));
                arl.add(i);
                hm.put(S.charAt(i), arl);
            }
        }
        int[] arT_index=new int[S_size];
        int[] arT_group=new int[S_size];
        for(int p=0; p<S_size; p++){
            arT_group[p]=-1;
            arT_index[p]=-1;
        }



        ArrayList<ArrayList<Integer>> arlFinal=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arl =new ArrayList<Integer>();
        for(int i=0; i<arlS_size; i++){

            String T=arlString.get(i);
            System.out.println("\narlString.get("+i+")="+arlString.get(i));
             T_size=T.length();
            for (int j=0; j<T_size; j++) {
                ArrayList<Integer> arl2= hm.get(T.charAt(j));
                System.out.println("\n"+T.charAt(i)+": "+arl2);
                arlFinal.add(arl2);
                for (int k:arl2) {
                    arT_index[k]=j;
                    arT_group[k]=i;
                }
            }

        }

        System.out.println("\n arlFinal:\n"+arlFinal);
        for(int p=0; p<S_size; p++){
            if(arT_group[p]==-1) {
                if(p/10>0)
                System.out.print(" " + p + "   ");
                else
                    System.out.print(" " + p + "    ");

            }
            else {
                if(p/10>0)
                    System.out.print(p + "   ");
                else
                    System.out.print(p + "    ");

            }

        }
        System.out.println("\n arT_group:\n");


        for(int p=0; p<S_size; p++){
            System.out.print(arT_group[p]+"    ");

        }
        System.out.println();
        for(int p=0; p<S_size; p++){
            if(arT_index[p]/10==0)
                System.out.print(arT_index[p]+"    ");
            else
                System.out.print(arT_index[p]+"   ");

        }
        int count=0;
        int T_groupIndex=-2;
        int T_groupSize=0;
        int arlStrSize=arlString.size();
        ArrayList<Integer> arlStartIndex=new ArrayList<Integer>();
        ArrayList<Integer> arl_Tgroup=new ArrayList<Integer>();
        HashMap<Integer, Integer> hm_T=new HashMap<Integer, Integer>();

        for(int k=0; k<S_size; k++){

            if(T_groupIndex==arT_group[k] && arT_index[k]==arT_index[k-1]+1){
                if(arT_index[k]==arT_index[k-1]+1){
                    count++;

                    if(count==T_size){
                        T_groupSize++;
                        if(T_groupSize==arlStrSize){
                            arlStartIndex.add(k-(arlStrSize*T_size)+1);
                        }
                    }

                }

            }// qwertyabcdefabcqwedefabcababcdefty
            else {
                if(arT_index[k]==0 ){
                    if(hm_T.get(arT_group[k])==null){

                        if(count==T_size) {
                            hm_T.put(arT_group[k], arl_Tgroup.size());
                            arl_Tgroup.add(arT_group[k]);
                        }
                        else {
                            //int j=0;
                            for (int i:arl_Tgroup) {
                                hm_T.put(i, null);
                                //j++;
                            }
                            hm_T.put(arT_group[k], arl_Tgroup.size());
                            arl_Tgroup.add(arT_group[k]);
                            T_groupSize=arl_Tgroup.size()-1;
                            //count=0;
                        }
                    }
                    else{
                        int index=hm_T.get(arT_group[k]);
                        for(int i=0; i<=index; i++){
                            hm_T.put(arl_Tgroup.get(0), null);
                            arl_Tgroup.remove(0);
                        }
                        int j=0;
                        for (int i:arl_Tgroup) {
                            hm_T.put(i, j);
                            j++;
                        }
                        hm_T.put(arT_group[k], arl_Tgroup.size());
                        arl_Tgroup.add(arT_group[k]);
                        T_groupSize=arl_Tgroup.size()-1;


                    }
                    T_groupIndex = arT_group[k];
                    if (arT_group[k] < 0)
                        T_groupIndex = -2;
//                    if (count != T_size) {
//                        T_groupSize = 0;
//                    }
                    count = 0;
                    if (arT_group[k] >= 0)
                        count++;
                }
                else{
                    //int j=0;
                    for (int i:arl_Tgroup) {
                        hm_T.put(i, null);
                        //j++;
                    }
                    arl_Tgroup.clear();
                    count=0;
                    T_groupSize=0;




                }
            }
        }

        System.out.println("\nStart Indices:\n"+arlStartIndex);



//        ArrayList<Integer> arlCombinationIndex=new ArrayList<Integer>();
//        while(true){
//
//            int i=0;
//            while(true) {
//                String T = arlString.get(i);
//                int T_size = T.length();
//
//                for(int j=0; j<T_size; j++){
//
//                    ArrayList<Integer> arl3= arlFinal.get(j);
//                    //arlCombinationIndex.add(arl3.get())
//
//
//                }
//
//
//            }
//
//
//
//        }





    }

    public static void recur(/*String T,*/ int T_size,  ArrayList<ArrayList<Integer>> arlFinal, int prevIndex, int index, ArrayList<Integer> arlCombinationIndex){



        int size=arlFinal.get(index).size();

        int i_start=0;
        int remainder=0;
        int noIssueTill=0;
        if(arlCombinationIndex.size()>0){// && arlCombinationIndex.get(arlCombinationIndex.size()-1)==-1) {
            int combCurrentSize=arlCombinationIndex.size();
            noIssueTill=(combCurrentSize/T_size)*T_size;
            remainder=combCurrentSize-noIssueTill;
            if(remainder==0 && noIssueTill>0){
                noIssueTill=noIssueTill-T_size;
            }
            // noIssueTill is not index. Actual index will be = (noIssueTill-1). noIssueTill is a multiple of T_size.
            if(index+1<=remainder) {
                if (noIssueTill + index < arlCombinationIndex.size()) {
                    i_start = arlCombinationIndex.get(noIssueTill + index) + 1;
                }
            }else {
                if (noIssueTill > 0)
                    i_start = arlCombinationIndex.get(noIssueTill - T_size + index) + 1;
            }

        }
        for(int i=i_start; i<size; i++){

            int k = arlFinal.get(index).get(i);
            if(prevIndex!=-1) {
                if (k == prevIndex+1) {
                    if(index+1<=remainder){
                        arlCombinationIndex.add(noIssueTill+index, k);
                    }
                    else
                        arlCombinationIndex.add(k);
                }
                else if(k<prevIndex){
                    if(index+1<=remainder){
                        arlCombinationIndex.add(noIssueTill+index, k);
                    }
                    else {
                        arlCombinationIndex.add(k);
                    }
                    continue;

                }
                else if(k>prevIndex){
                    //arlCombinationIndex.add(-1);
                    return;
                }
            }
            else{
                arlCombinationIndex.add(k);

            }
            if(index<T_size) {
                recur(T_size, arlFinal, k, index + 1, arlCombinationIndex);
            }

            if(index>0){
                return;
            }



        }


    }

}
