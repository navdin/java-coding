package src;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class _4merge_K_sortedLists {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> arlSuper = new ArrayList<ArrayList<Integer>>();
        System.out.println("Enter number of lists");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1; i<=n; i++){
            System.out.println("Enter number of numbers in list "+i);
            int listCount=sc.nextInt();
            System.out.println("Enter numbers one by one in this list "+i);
            ArrayList<Integer> arl=new ArrayList<Integer>();
            for(int j=0; j<listCount; j++){
                //System.out.println();
                arl.add(sc.nextInt());

            }
            arlSuper.add(arl);
        }

        for (int i: _4merge_K_sortedLists.merge(arlSuper)) {
            System.out.println(i+"   ");
        }



    }


    public static ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> arlSuper){

        ArrayList<Integer> arlFinal=new ArrayList<Integer>();
        _4nMaxPairCombinations.StartNode startNode=new _4nMaxPairCombinations.StartNode();
        startNode.heapDepth=0;
        startNode.nodeCount=0;

        _4nMaxPairCombinations.lowTopHeap=true;
        int index_arl=0;

        int index_arlSuper=0;
        for (ArrayList<Integer> arl : arlSuper) {

            Integer value=arl.get(index_arl);
            if(value!=null){
                _4nMaxPairCombinations.Node node=new _4nMaxPairCombinations.Node();
                node.value=value;
                node.index_arlSuper=index_arlSuper;
                node.index_arl=0;
                _4nMaxPairCombinations.addNode(startNode, node);
                index_arlSuper++;

            }

        }
        System.out.println("startNode.value ="+startNode.value);
        System.out.println("startNode.nodeLeft.value ="+startNode.nodeLeft.value);


        while(true) {



            _4nMaxPairCombinations.Node priorityNode=_4nMaxPairCombinations.removePriority(startNode);
            if(priorityNode==null){
                return arlFinal;
            }
            System.out.println("priorityNode.value after returning="+priorityNode.value);
            arlFinal.add(priorityNode.value);

            if(priorityNode.index_arl+1<arlSuper.get(priorityNode.index_arlSuper).size()) {
                Integer value = arlSuper.get(priorityNode.index_arlSuper).get(priorityNode.index_arl + 1);
                System.out.println("newNode value="+value);

                if (value != null) {
                    _4nMaxPairCombinations.Node node = new _4nMaxPairCombinations.Node();
                    node.value = value;
                    node.index_arlSuper = priorityNode.index_arlSuper;
                    node.index_arl = priorityNode.index_arl + 1;
                    _4nMaxPairCombinations.addNode(startNode, node);

                }
            }


        }
    }

}