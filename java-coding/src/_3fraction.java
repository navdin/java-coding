import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class _3fraction {


    public static void main(String[] args) {

        System.out.println("Enter numerator");
        Scanner sc=new Scanner(System.in);
        int numer=sc.nextInt();
        System.out.println("Enter denominator");
        int denom=sc.nextInt();

        int[] ar=new int[2];
        HashMap<Integer, Integer> hm =new HashMap<Integer, Integer>();

        int zeros=0;
        int remainder=0;
        String s=(numer/denom)+".";
        int index=s.indexOf(".");
        boolean firstDecimal=true;
        while (true){
            index++;

            remainder=numer%denom;
            if(remainder==0){
                break;
            }
            else if(hm.get(remainder)==null){

                hm.put(remainder, index);

                    remainder = remainder * 10;
                    numer=remainder;
                    if(firstDecimal){
                        firstDecimal=false;
                    }
                    else
                        s+="0";
                    //zeros++;

            }
            else if(hm.get(remainder)!=null){
                index=hm.get(remainder);
                s=s.substring(0,index)+"("+s.substring(index)+")";
                break;
            }

            if(numer/denom>0)
                s+=(numer/denom);

        }

        System.out.println("s="+s);




    }


}
