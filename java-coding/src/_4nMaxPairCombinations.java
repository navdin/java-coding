package src;

import java.util.Scanner;


public class _4nMaxPairCombinations {
    public static class Node{
        Node nodeLeft;
        Node nodeRight;
        Integer value;
        int index_arlSuper;
        int index_arl;
    }
    public static class StartNode extends Node{
        int nodeCount;
        int heapDepth;
        //        Node nodeLeft;
//        Node nodeRight;
        int lastLevelCount;
        int lastLevelCapacity;
//        int value;
    }
    public static boolean lowTopHeap=false;
    //int a=5;
    public static void main(String[] args) {
        // 13 10 8 6 4 3 2 1 1
        //
        //  13+3               10+4                8+6
        _4nMaxPairCombinations mp=new _4nMaxPairCombinations();
        StartNode startNode=new StartNode();
        startNode.heapDepth=0;
        startNode.nodeCount=0;
        int heapDepth=startNode.heapDepth;
        int nodeCount=startNode.nodeCount;
        //boolean lowTopHeap=true;
        System.out.println("Enter 1st int array count ");
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int[] ar1=new int[n1];
        System.out.println("Enter 1st int array elements ");
        for(int i=0; i<n1; i++){
            ar1[i]=sc.nextInt();
            //System.out.println();
        }
        System.out.println("Enter 2nd int array count ");
        int n2=sc.nextInt();
        int[] ar2=new int[n2];
        System.out.println("Enter 2nd int array elements ");
        for(int i=0; i<n2; i++){
            ar2[i]=sc.nextInt();
            //System.out.println();
        }

        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                Node node=new Node();
                node.value=ar1[i]+ar2[j];
                System.out.println(ar1[i]+" "+ar2[j]);
                addNode(startNode,node);//, ar1[i]+" "+ar2[j]);
            }
        }
        System.out.println("Enter number of highest elements needed:");
        int n=sc.nextInt();
        for(int i=0; i<n; i++) {
            System.out.println(removePriority(startNode).value);
        }
    }
    public static void addNode(StartNode startNode, Node node){//, String s){
        if(startNode.nodeCount==0){
            startNode.value=node.value;
            startNode.index_arl=node.index_arl;
            startNode.index_arlSuper=node.index_arlSuper;
            startNode.nodeCount++;
            startNode.lastLevelCount++;
            startNode.lastLevelCapacity=1;

            //startNode.heapDepth++;
            return;
        }
        startNode.nodeCount++;
        Node atNode=(Node) startNode;//=new Node();
        int nodeCountLastLevel=1;
//        for(int i=0; i<heapDepth; i++){
//            nodeCountLastLevel=nodeCountLastLevel*2;
//        }
        int heapFullCount=nodeCountLastLevel*2-1;
        int posLastLevel=0;
        //int lastLevelCapacity=startNode.lastLevelCapacity;
        if(startNode.lastLevelCount==startNode.lastLevelCapacity){
            posLastLevel=1;
            startNode.heapDepth++;
            startNode.lastLevelCount=1;
            startNode.lastLevelCapacity=startNode.lastLevelCapacity*2;
        }
        else {
            posLastLevel=++startNode.lastLevelCount;
            //posLastLevel=nodeCount-nodeCountLastLevel-1;
        }
        int lastLevelCapacity=startNode.lastLevelCapacity;
        while(true) {
//            System.out.println("inside true "+s+" lastLevelCapacity"+lastLevelCapacity+
//                    "  lastLevelCount"+startNode.lastLevelCount);

            if(lowTopHeap) {
                if (node.value < atNode.value) {
                    int newNodeValue = node.value;
                    int  index_arl=node.index_arl;
                    int  index_arlSuper=node.index_arlSuper;

                    node.value = atNode.value;
                    node.index_arl=atNode.index_arl;
                    node.index_arlSuper=atNode.index_arlSuper;

                    atNode.value = newNodeValue;
                    atNode.index_arl=index_arl;
                    atNode.index_arlSuper=index_arlSuper;
                }
            }
            else if (node.value > atNode.value) {
                int newNodeValue = node.value;
                int  index_arl=node.index_arl;
                int  index_arlSuper=node.index_arlSuper;

                node.value = atNode.value;
                node.index_arl=atNode.index_arl;
                node.index_arlSuper=atNode.index_arlSuper;

                atNode.value = newNodeValue;
                atNode.index_arl=index_arl;
                atNode.index_arlSuper=index_arlSuper;

            }
            lastLevelCapacity=lastLevelCapacity/2;
            if(posLastLevel>lastLevelCapacity){

                if(posLastLevel==2 && lastLevelCapacity==1){
                    atNode.nodeRight=node;
                    break;
                }
                atNode=atNode.nodeRight;
                posLastLevel=posLastLevel-lastLevelCapacity;


//                if(atNode==null){
//                    if(posLastLevel==1){
//                        startNode.nodeRight=node;
//                        break;
//                    }
//                    atNode=startNode.nodeRight;
//                }
//                else {
//                    if(posLastLevel==1){
//                        atNode.nodeRight=node;
//                        break;
//                    }
//                    atNode=atNode.nodeRight;
//                }
            }
            else {
                if(posLastLevel==1 && lastLevelCapacity==1){
                    atNode.nodeLeft=node;
                    break;
                }
                atNode=atNode.nodeLeft;
//                if(atNode==null){
//                    if(posLastLevel==1){
//                        startNode.nodeLeft=node;
//                        break;
//                    }
//                    atNode=startNode.nodeLeft;
//                }
//                else {
//                    if(posLastLevel==1){
//                        atNode.nodeLeft=node;
//                        break;
//                    }
//                    atNode=atNode.nodeLeft;
//                }
            }
        }
    }
    public static Node removePriority(StartNode startNode){
        int lastLevelCapacity=startNode.lastLevelCapacity;
        int posLastLevel=startNode.lastLevelCount;
        Node atNode=(Node)startNode;
        System.out.println("startNode.nodeCount="+startNode.nodeCount);

        if(startNode.nodeCount==0){
            return null;
        }

        if(startNode.nodeCount==1){
            startNode.nodeCount--;
            startNode.lastLevelCount--;
            return atNode;
        }
        Integer highPriorityValue=startNode.value;
        Node priorityNode=new Node();
        priorityNode.value=startNode.value;
        priorityNode.index_arl=startNode.index_arl;
        priorityNode.index_arlSuper=startNode.index_arlSuper;
        System.out.println("priorityNode.value="+priorityNode.value);


        while (true) {
//            System.out.println("heapDepth="+startNode.heapDepth);
//            System.out.println("lastLevelCapacity="+lastLevelCapacity);

            lastLevelCapacity=lastLevelCapacity/2;
            if (posLastLevel>lastLevelCapacity) {
                if(posLastLevel==2 && lastLevelCapacity==1){
                    startNode.value=atNode.nodeRight.value;
                    startNode.index_arl=atNode.nodeRight.index_arl;
                    startNode.index_arlSuper=atNode.nodeRight.index_arlSuper;

                    atNode.nodeRight=null;
                    break;
                }
                atNode=atNode.nodeRight;
                posLastLevel=posLastLevel-lastLevelCapacity;

            }
            else {
                if(posLastLevel==1 && lastLevelCapacity==1){
                    startNode.value=atNode.nodeLeft.value;
                    startNode.index_arl=atNode.nodeLeft.index_arl;
                    startNode.index_arlSuper=atNode.nodeLeft.index_arlSuper;
                    atNode.nodeLeft=null;
                    break;
                }
                atNode=atNode.nodeLeft;
            }
        }
        startNode.nodeCount--;
        startNode.lastLevelCount--;
        if(startNode.lastLevelCount==0){
            startNode.lastLevelCount=startNode.lastLevelCapacity/2;
            startNode.lastLevelCapacity=startNode.lastLevelCapacity/2;
            startNode.heapDepth--;
        }
        atNode=(Node)startNode;
        while (true) {
            if (lowTopHeap) {
                if ((atNode.nodeRight == null) || atNode.nodeLeft.value < atNode.nodeRight.value) {
                    if (atNode.nodeLeft == null) {
                        break;
                    }
                    if (atNode.value > atNode.nodeLeft.value) {
                        int value = atNode.value;
                        int  index_arl=atNode.index_arl;
                        int  index_arlSuper=atNode.index_arlSuper;

                        atNode.value = atNode.nodeLeft.value;
                        atNode.index_arl=atNode.nodeLeft.index_arl;
                        atNode.index_arlSuper=atNode.nodeLeft.index_arlSuper;

                        atNode.nodeLeft.value = value;
                        atNode.nodeLeft.index_arl=index_arl;
                        atNode.nodeLeft.index_arlSuper=index_arlSuper;

                        atNode = atNode.nodeLeft;
                    } else
                        break;
                } else {
                    if (atNode.value > atNode.nodeRight.value) {

                        int value = atNode.value;
                        int  index_arl=atNode.index_arl;
                        int  index_arlSuper=atNode.index_arlSuper;

                        atNode.value = atNode.nodeRight.value;
                        atNode.index_arl=atNode.nodeRight.index_arl;
                        atNode.index_arlSuper=atNode.nodeRight.index_arlSuper;

                        atNode.nodeRight.value = value;
                        atNode.nodeRight.index_arl=index_arl;
                        atNode.nodeRight.index_arlSuper=index_arlSuper;

                        atNode = atNode.nodeRight;
                    } else
                        break;
                }
            }
            else{
                if ((atNode.nodeRight == null) || atNode.nodeLeft.value >= atNode.nodeRight.value) {
                    if (atNode.nodeLeft == null) {
                        break;
                    }
                    if (atNode.value < atNode.nodeLeft.value) {
                        int value = atNode.value;
                        int  index_arl=atNode.index_arl;
                        int  index_arlSuper=atNode.index_arlSuper;

                        atNode.value = atNode.nodeLeft.value;
                        atNode.index_arl=atNode.nodeLeft.index_arl;
                        atNode.index_arlSuper=atNode.nodeLeft.index_arlSuper;

                        atNode.nodeLeft.value = value;
                        atNode.nodeLeft.index_arl=index_arl;
                        atNode.nodeLeft.index_arlSuper=index_arlSuper;
                        atNode = atNode.nodeLeft;
                    } else
                        break;
                } else {
                    if (atNode.value < atNode.nodeRight.value) {
                        int value = atNode.value;
                        int  index_arl=atNode.index_arl;
                        int  index_arlSuper=atNode.index_arlSuper;

                        atNode.value = atNode.nodeRight.value;
                        atNode.index_arl=atNode.nodeRight.index_arl;
                        atNode.index_arlSuper=atNode.nodeRight.index_arlSuper;

                        atNode.nodeRight.value = value;
                        atNode.nodeRight.index_arl=index_arl;
                        atNode.nodeRight.index_arlSuper=index_arlSuper;
                        atNode = atNode.nodeRight;
                    } else
                        break;
                }

            }
        }
        return priorityNode;
    }
}
