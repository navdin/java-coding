import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _3longestSubtringWithoutRepeat {

    public static void main(String[] args) {

        System.out.println("Enter the string S");
        Scanner sc=new Scanner(System.in);
        String S=sc.nextLine();
        HashMap<Character, ArrayList<Integer>> hm=new HashMap<Character, ArrayList<Integer>>();

        int longest=0;
        int S_size=S.length();
        int min=-1, longer=0, minLonger=0;

        for(int i=0; i<S_size; i++){
            if(hm.get(S.charAt(i))==null){
                longer++;
                ArrayList<Integer> arl=new ArrayList<Integer>();
                arl.add(i);
                hm.put(S.charAt(i),arl);
            }
            else{
                ArrayList<Integer> arl=hm.get(S.charAt(i));
                int matchIndex=arl.get(arl.size()-1);
                arl.add(i);
                hm.put(S.charAt(i), arl);
                if(minLonger<=matchIndex) {


                    if (longer > longest) {
                        longest = longer;
                        min = minLonger;
                    }
                    minLonger = matchIndex + 1;
                    longer = i - matchIndex;
                }
                else{
                    longer++;
                }
            }
        }
        if(longer>longest){
            longest = longer;
            min = minLonger;
        }

        System.out.println("\nlongest="+longest+"   min="+min);

    }


}
