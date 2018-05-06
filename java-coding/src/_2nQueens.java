import javafx.util.Pair;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class _2nQueens {

    public static void main(String[] args) {

        System.out.println("Enter the size of array");
        Scanner sc=new Scanner(System.in);
        //System.out.println("Enter your rollno");
        int n=sc.nextInt();
        int[][] ar=new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ar[i][j]=0;
            }
        }

        HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();

//        for(int i=0; i<n; i++) {
//            hm.put(0, 1);
//          System.out.println("hm.size()="+hm.size());
//          hm.remove(0);
//        System.out.println("hm.size()="+hm.size());

        int[] count=new int[1];
        count[0]=0;
        _2nQueens obj=new _2nQueens();
            obj.recur(0, 0, ar, n, hm, count);
//        }


        System.out.println("count="+count[0]);
    }

    public  void recur(int x, int y, int[][] ar, int n, HashMap<Integer, Integer> hm, int[] count){




//            System.out.println();
//



            for (int j = 0; j < n; j++) {

                if (ar[y][j] == 0) {
                    hm.put(y, j);
                    int[][] arCopy=new int[n][n];
                    for(int i=0; i<n; i++){
                        System.out.println();

                        for(int k=0; k<n; k++) {
                            arCopy[i][k]= ar[i][k];

                        }
                    }

                    int x1 = -1, y1 = -1, x2 = -1, y2 = -1;

                    x=j;

                    if (y >= x) {
                        y1 = y - x;
                        x1 = 0;

                    } else if (x > y) {
                        x1 = x - y;
                        y1 = 0;
                    }

                    if (y + x <= n - 1) {

                        y2 = y + x;
                        x2 = 0;

                    } else if (y + x > n - 1) {
                        y2 = n - 1;
                        x2 = x - ((n - 1) - y);

                    }


//                    System.out.println("\n"+"x="+x+"  y="+y+"  x1="+(x1)+"  y1="+(y1) +"  x2="+(x2)+"  y2="+(y2));


                    for (int i = 0; i < n; i++) {
                        ar[y][i] = 1;
                        ar[i][x] = 1;
                        // System.out.println("x="+x+"  y="+y+"  x1+i="+(x1+i)+"  y1+i="+(y1+i));
                        if (x1 + i < n && y1 + i < n)
                            ar[y1 + i][x1 + i] = 1;
                        if (x2 + i < n && y2 - i >= 0)
                            ar[y2 - i][x2 + i] = 1;

                    }

//                    for(int i=0; i<n; i++){
//                        System.out.println();
//
//                        for(int k=0; k<n; k++) {
//                            System.out.print(ar[i][k]+" ");
//
//                        }
//                    }

                    if (hm.size() == n) {
                        ++count[0];
//                        System.out.println("hm.size()="+hm.size());

//                        for(int i=0; i<n; i++){
//                            System.out.println();
//
//                            for(int k=0; k<n; k++) {hm.size()
//                                System.out.print(ar[i][k]+" ");
//
//                            }
//                        }
//                        for (int i = 0; i < n; i++) {
//                            System.out.print(hm.get(i)+"   ");
//                        }
                    }

                    if (y + 1 < n) {
                        _2nQueens obj=new _2nQueens();

                        obj.recur(0, y + 1, ar, n, hm, count);
                    }


                    for(int i=0; i<n; i++){
                        System.out.println();

                        for(int k=0; k<n; k++) {
                            ar[i][k]=arCopy[i][k] ;

                        }
                    }

                    hm.remove(y);


                }

            }


    }



}
