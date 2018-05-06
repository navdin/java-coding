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

//        for(int i=0; i<size; i++) {
//            System.out.println();
//            for (int j = 0; j < size; j++) {
//                System.out.print(charAr[i][j]+"  ");
//            }
//        }


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






        _2soduku.recur(ar1, ar2);

        //Charset.forName()


        // 1 2 0 4 0 0 0 0 0
        // 0 2 0 4 0 0 7 0 0
        // 0 2 0 4 0 0 7 0 0
        // 1 2 0 0 0 0 0 0 0
        // 

    }

    public static void recur(ArrayList<Integer> ar1, ArrayList<Integer> arPrev){


        boolean changed=false;

        for (int i:ar1) {
            if(changed){
                System.out.println();
                for (int k : arPrev) {
                    System.out.print(k);
                }
            }
            System.out.print(i);
            ArrayList<Integer> ar2=new ArrayList<Integer>();
            //ArrayList<Integer> ar3=new ArrayList<Integer>();
            for (int j:ar1) {
                if(j==i){
                    arPrev.add(j);

                }
                if(j!=i){
                    ar2.add(j);
                }
            }
            _2soduku.recur(ar2, arPrev);

            arPrev.remove(arPrev.size()-1);
            changed=true;

        }


    }



}
