import java.util.Scanner;

public class _1nearestSmallerElement {

    public static void main(String[] args) {

        System.out.println("Enter the size of array");
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter your rollno");
        int size = sc.nextInt();
        int[] ar = new int[size];
        System.out.println("Enter " + size + " numbers one by one");
        for (int i = 0; i < size; i++) {
            ar[i] = sc.nextInt();
        }

        for (int i = 0; i < size; i++) {
            System.out.print(ar[i]+"  ");
        }
        int[] arOut=new int[size];
        arOut[0]=-1;
        for(int i=1; i<size; i++){

            for(int j=i-1; j>=0; j--){
                if(j==0 && ar[j]>=ar[i]){
                    arOut[i]=-1;
                }
                else if(ar[j]<ar[i]){
                    arOut[i]=ar[j];
                    break;
                }
                else if(ar[j]>=ar[i] && arOut[j]<arOut[i]){
                        arOut[i] = arOut[j];
                        break;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(arOut[i]+"  ");
        }

    }

}
