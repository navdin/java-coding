import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _2soduku {

    public static void main(String[] args) {

        int size=9;
        char[][] charAr=new char[size][size];



        Scanner sc=new Scanner(System.in);
//        //sc.useDelimiter("");
//
//        System.out.println("Enter "+(size*size)+ " numbers one by one");

//        charAr[0][0]=sc.next().charAt(0);
//
//        System.out.println("enter ="+charAr[0][0]);



//        for(int i=0; i<size; i++){
//            System.out.println("enter line");
//            for(int j=0; j<size; j++){
//
//                charAr[i][j]=sc.next().charAt(0);
//
//            }
//        }



        System.out.println("Enter 1 to save");
        if(sc.nextInt()==1 ) {
//            try {
//                ObjectOutputStream out = new ObjectOutputStream(
//                        new FileOutputStream("myarray.ser")
//                );
//                out.writeObject(charAr);
//                out.flush();
//                out.close();
//            } catch (Exception e) {
//
//            }
        }else {

            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("myarray.ser"));
                charAr = (char[][]) in.readObject();
                in.close();
            } catch (Exception e) {

            }
        }

        for(int i=0; i<size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print(charAr[i][j]+"  ");
            }
        }
        System.out.println();
        System.out.println();



        HashMap<Integer, Integer> ar=new HashMap<Integer, Integer>();
        ar.put(1,1);
        ar.put(2,2);
        ar.put(3,3);
        ar.put(4,4);
        ar.put(5,5);

        ArrayList<Integer> ar1=new ArrayList<Integer>();
        ArrayList<Integer> ar2=new ArrayList<Integer>();

        ar1.add(1);
        ar1.add(2);
        ar1.add(3);
        //ar1.add(4);
//        ar1.add(5);




//        int  a=6;
//        System.out.println("a="+a);
//
//        String b=(a)+"";
//        char c=b.charAt(0);
//        System.out.println("b="+b);
//        System.out.println("c="+c);




        int final_K=-1,final_l=-1;
        boolean found=false;
        for(int i=8; i>=0; i--){
            for(int j=8; j>=0; j--){

                if(charAr[i][j]=='.');{
                    final_K=i;
                    final_l=j;
                    found=true;
                    break;
                }

            }
            if(found)
                break;

        }
        System.out.println("final_K="+final_K+" final_l="+final_l);
        int[] done=new int[1];
        done[0]=0;
        _2soduku.recur(charAr,0, 0, final_K, final_l,  done);

        for(int i=0; i<size; i++){
            System.out.println();
            for(int j=0; j<size; j++){

                System.out.print(charAr[i][j]+" ");

            }
        }

//        _2soduku.recur(ar1, ar2);

        //Charset.forName()


        // 1 2 0 4 0 0 0 0 0
        // 0 2 0 4 0 0 7 0 0
        // 0 2 0 4 0 0 7 0 0
        // 1 2 0 0 0 0 0 0 0
        // 

    }

    public static void recur(char[][] charAr, int k, int l, int final_k, int final_l, int[] done){


        boolean found=false;

        for(int i=k; i<9; i++){
            for(int j=0; j<9; j++){

                if(charAr[i][j]=='.'){
                    k=i;
                    l=j;
                    found=true;
                    break;
                }


            }
            if(found) {
                found=false;
                break;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("k="+k+"  l="+l+"  charAr[k][i]="+( charAr[k][l]));



//        ArrayList<Integer> list=new ArrayList<Integer>();
        int[] list=new int[9];

        for(int i=0; i<9; i++){
            list[i]=i+1;
        }
        for(int i=0; i<9; i++){
            if(charAr[k][i]!='.') {
                //System.out.println("k="+k+"i="+i+"charAr[k][i]"+( charAr[k][i]));
                list[Integer.parseInt(String.valueOf(charAr[k][i]))  - 1] = 0;
            }

            if(charAr[i][l]!='.') {
                //System.out.println("k="+k+" i="+i+" charAr[k][i]"+( charAr[k][i]));
                list[ Integer.parseInt(String.valueOf(charAr[i][l]))  - 1] = 0;
            }
        }
        int k_start=(k/3);
        k_start=k_start*3;
        int l_start=(l/3);
        l_start=l_start*3;

        for(int i=k_start; i<=k_start+2; i++){
            for(int j=l_start; j<=l_start+2; j++) {
                if(charAr[i][j]!='.')
                    list[Integer.parseInt(String.valueOf(charAr[i][j]))-1]=0;
            }

        }
        System.out.println();
//        for(int i=0;i<9; i++){
//            System.out.print(list[i]+"  ");
//        }

        boolean functionReturned=false;
        for(int i=0; i<9; i++){
            boolean numFound=false;

            if(functionReturned && list[i]!=0){
                for(int m=0; m<9; m++) {
                    if (charAr[k][m] == (list[i] + "").charAt(0)) {
                        numFound = true;
                        break;
                        //System.out.println("k="+k+"i="+i+"charAr[k][i]"+( charAr[k][i]));
                        //list[Integer.parseInt(String.valueOf(charAr[k][i]))  - 1] = 0;
                    }

                    if (charAr[m][l] == (list[i] + "").charAt(0)) {
                        numFound = true;
                        break;
                        //System.out.println("k="+k+" i="+i+" charAr[k][i]"+( charAr[k][i]));
                        //list[ Integer.parseInt(String.valueOf(charAr[i][l]))  - 1] = 0;
                    }
                }


                for(int m=k_start; m<=k_start+2; m++){
                    for(int n=l_start; n<=l_start+2; n++) {
                        if(charAr[m][n]==(list[i] + "").charAt(0)){
                            numFound = true;
                                break;
                            }
                        }
                        if(numFound)
                            break;
                }
            }


            if(!numFound && list[i]!=0){
                charAr[k][l]=((list[i])+"").charAt(0);
                System.out.println("\ncharAr["+k+"]["+l+"]="+charAr[k][l]);
                if(k==8 && l==6){

                    for(int y=0; y<9; y++){
                        System.out.println();
                        for(int z=0; z<9; z++){

                            System.out.print(charAr[y][z]+" ");

                        }
                    }
                    done[0]=1;
                    return;
                }
                System.out.println("\n_2soduku.recur(charAr,"+ k+","+ l+")\n");
                _2soduku.recur(charAr, k, l, final_k, final_l, done);
                if(done[0]==1){
                    System.out.println("done[0]="+done[0]);
                    return;
                }
                functionReturned=true;

                charAr[k][l]='.';
                System.out.println("function returned to (k="+k+", l="+l+")");
            }
        }

//        for (int i:ar1) {
//            if(changed){
//                System.out.println();
//                for (int k : arPrev) {
//                    System.out.print(k);
//                }
//            }
//            System.out.print(i);
//            ArrayList<Integer> ar2=new ArrayList<Integer>();
//            //ArrayList<Integer> ar3=new ArrayList<Integer>();
//            for (int j:ar1) {
//                if(j==i){
//                    arPrev.add(j);
//
//                }
//                if(j!=i){
//                    ar2.add(j);
//                }
//            }
//            _2soduku.recur(ar2, arPrev);
//
//            arPrev.remove(arPrev.size()-1);
//            changed=true;
//
//        }


    }

//    public static void recur(ArrayList<Integer> ar1, ArrayList<Integer> arPrev){
//
//
//        boolean changed=false;
//
//        for (int i:ar1) {
//            if(changed){
//                System.out.println();
//                for (int k : arPrev) {
//                    System.out.print(k);
//                }
//            }
//            System.out.print(i);
//            ArrayList<Integer> ar2=new ArrayList<Integer>();
//            //ArrayList<Integer> ar3=new ArrayList<Integer>();
//            for (int j:ar1) {
//                if(j==i){
//                    arPrev.add(j);
//
//                }
//                if(j!=i){
//                    ar2.add(j);
//                }
//            }
//            _2soduku.recur(ar2, arPrev);
//
//            arPrev.remove(arPrev.size()-1);
//            changed=true;
//
//        }
//
//
//    }



}
