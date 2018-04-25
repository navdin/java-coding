import java.util.Scanner;

public class _1rainWaterTrapped {

    public static void main(String[] args){

        System.out.println("Enter the size of array");
        Scanner sc=new Scanner(System.in);
        //System.out.println("Enter your rollno");
        int size=sc.nextInt();
        int[] ar=new int[size];
        System.out.println("Enter "+size+ " numbers one by one");
        for(int i=0; i<size; i++){
            ar[i]=sc.nextInt();
        }

        for(int i=0; i<size; i++){
            System.out.print( ar[i]);
        }
        int width=1;




        int vol=0, volExclude=0;
        int lastHighest=0, highestIndex=-1;
        int lastHigh=0, highIndex=-1;
        int highCount=0;

        int highest=0;
        int nextHigh=0, nextHighIndex=-1;
        for(int i=0; i<size; i++){
            if(highest<ar[i]){
                highest=ar[i];
                highestIndex=nextHighIndex= i;
            }
        }
        int start=-1, end=-1;
        while(true){
            start=nextHighIndex;
            end=size-1;
            volExclude=0;
            int vol2=0;
            for(int i=start+1; i<=end; i++){
                vol2+=ar[i];
                if(ar[i]>=nextHigh){
                    volExclude=vol2;
                    nextHigh=ar[i];
                    nextHighIndex=i;
                }
            }

            int volAdd=(nextHighIndex-start)*nextHigh-volExclude;
            if(volAdd>0)
                vol+=volAdd;
//            System.out.println("start+1 ="+(start+1)+"  end="+end);
            nextHigh=0;
            if(start+1>=end ){
               break;
            }

        }

        nextHighIndex=highestIndex;
        while(true){
            start=nextHighIndex;
            end=0;
            volExclude=0;
            int vol2=0;
            for(int i=start-1; i>=end; i--){
                vol2+=ar[i];
                if(ar[i]>=nextHigh){
                    volExclude=vol2;
                    nextHigh=ar[i];
                    nextHighIndex=i;
                }
            }

            int volAdd=(nextHighIndex-start)*nextHigh-volExclude;
            if(volAdd>0)
                vol+=volAdd;
            nextHigh=0;

            if(start-1<=end ){
                break;
            }

        }

        System.out.println("vol is "+vol);
//
//        boolean pass=false;
//        for(int i=0; i<size; i++){
//            int val=ar[i];
//
//            int prev=ar[i-1];
//            int post=ar[i+1];
//            if(i==0 || i==(size-1)){
//                if(i==0){
//                    if(ar[i+1]<=ar[i]){
//                        pass=true;
//                    }
//                }else if(i==(size-1)){
//                    if(ar[i]>=ar[i-1]){
//                        pass=true;
//                    }
//                }
//
//            }
//            else if(ar[i]>ar[i-1] && ar[i]>ar[i+1] || pass ){
//                pass=false;
//                if(lastHighest==0) {
//                    lastHigh = lastHighest = ar[i];
//                    lastHigh= lastHighest= i;
//                    volExclude+=ar[i];
//                    continue;
//                }
//
//                if(ar[i]>=lastHighest) {
//                    vol += (lastHighest ) * (i - highestIndex)*width;
//                    lastHighest=lastHigh=ar[i];
//                    highCount=0;
//                }
//                else if(ar[i]<=lastHigh){
//                    highCount++;
//                    vol += (ar[i]) * (i - highIndex);
//
//                }
//                else if(ar[i]>lastHigh){
//                    if(highCount>0){
//                        for(int j=highIndex-1; j>=highestIndex; j--){
//                            if(ar[j]>=ar[i]){
//                                vol += (ar[i]) * (i - j)*width;
//                                if(j==highestIndex){
//                                    highCount=0;
//                                }
//                                break;
//                            }
//                        }
//                    }else{
//
//                        vol += (lastHighest - ar[i]) * (i - highestIndex)*width;
//
//
//                    }
//                }
//
//                lastHigh=ar[i];
//                highIndex=i;
//            }
//            else{
//                lastHighest=ar[i];
//            }
//        }



    }

}
