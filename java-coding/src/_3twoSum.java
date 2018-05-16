import java.util.HashMap;
import java.util.Scanner;

class _3twoSum {

    int a=10;
    public static class values{
        int index;
        int sum;
    }
    public static void main(String[] args) {

        HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();

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

        int[] arResult=new int[2];
        arResult[0]=-1;

        for(int i=0; i<size; i++) {
            if (hm.get(ar[i])==null) {
                hm.put(target - ar[i], i);
            }else{
                int index= hm.get(ar[i]);
                arResult[0]=index+1;
                arResult[1]=i+1;
                break;
            }
        }
        if(arResult[0]==-1){
            System.out.println("Not Found");
        }
        else{
            System.out.println("Result\n");
            System.out.print(arResult[0]+ "  "+arResult[1]);

        }



    }

}
