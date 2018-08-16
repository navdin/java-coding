package src;

import java.util.ArrayList;
import java.util.Scanner;

public class _5nextRightPointersTree {

    public static class Node{
        int value;
        Node nodeLeft;
        Node nodeRight;
        Node nodeSide;
    }

    public static void main(String[] args) {

        System.out.println("Enter number of nodes for tree");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("Enter "+n+" values one by one to form a tree");
        Node startNode=new Node();
        for(int i=0; i<n; i++){
            int value=sc.nextInt();
            if(i==0){
                startNode.value=value;
            }
            else{
                Node atNode=startNode;
                Node newNode=new Node();
                newNode.value=value;
                while(true) {
                    if (value < atNode.value) {
                        if(atNode.nodeLeft==null) {
                            atNode.nodeLeft = newNode;
                            break;
                        }
                        else
                            atNode = atNode.nodeLeft;
                    }
                    else if(value>atNode.value){
                        if(atNode.nodeRight==null) {
                            atNode.nodeRight=newNode;
                            break;
                        }
                        else
                            atNode = atNode.nodeRight;                    }
                }
            }
        }
        Node atNode=startNode;
        ArrayList<Integer> arl=new ArrayList<Integer>();
        inOrder(atNode,arl);
        atNode=startNode;
        populateNextRight(atNode);

        inOrder(startNode,arl);


    }

    public static void populateNextRight(Node atNode){
        //if(atNode.nodeRight)
        Node newLevelLeftMostNode=atNode;
        System.out.println("start");


            Node atNodeLeft=null;//=atNode.nodeLeft;
            Node atNodeRight=null;//=atNode.nodeRight;

            while (true){
                if(atNode.nodeLeft!=null){

                    if(atNodeLeft==null) {
                        atNodeLeft = atNode.nodeLeft;
                    }
                    else if(atNodeLeft!=null){
                        atNodeRight=atNode.nodeLeft;
                        atNodeLeft.nodeSide=atNodeRight;
                        System.out.println(atNodeLeft.value+"-->"+atNodeLeft.nodeSide.value);

                        atNodeLeft=atNodeRight;
                        atNodeRight=null;
//                        if(atNode.nodeSide!=null){
//                            atNode=atNode.nodeSide;
//                        }

                    }
//                    if(atNode.nodeRight!=null){
//
//                    }
//                    else if(atNode.nodeSide!=null){
//                        atNode=atNode.nodeSide;
//                    }
//                    else if(atNode.nodeSide==null){
//                        if(atNodeLeft!=null) {
//                            atNodeLeft.nodeSide = null;
//                        }
//                        atNodeLeft=atNodeRight=null;
//                        if(newLevelLeftMostNode.nodeLeft!=null){
//                            atNode=newLevelLeftMostNode.nodeLeft;
//                        }
//                        else if(newLevelLeftMostNode.nodeRight!=null){
//                            atNode=newLevelLeftMostNode.nodeRight;
//                        }
//
//                    }
                }
                if(atNode.nodeRight!=null){

                    if(atNodeLeft==null){
                        atNodeLeft=atNode.nodeRight;
                    }
                    else {
                        atNodeRight = atNode.nodeRight;
                        atNodeLeft.nodeSide=atNodeRight;
                        atNodeLeft=atNodeRight;
                        atNodeRight=null;
                    }
                }
                if(atNode.nodeSide!=null){
                    atNode=atNode.nodeSide;
                    if(atNodeLeft==null && atNodeRight==null){
                        newLevelLeftMostNode=atNode;
                    }
                }
                else if(atNode.nodeSide==null){
                    if(atNodeLeft!=null) {
                        atNodeLeft.nodeSide = null;
                    }
                    atNodeLeft=atNodeRight=null;
                    if(newLevelLeftMostNode.nodeLeft!=null){
                        atNode=newLevelLeftMostNode.nodeLeft;
                    }
                    else if(newLevelLeftMostNode.nodeRight!=null){
                        atNode=newLevelLeftMostNode.nodeRight;
                    }
                    else {
                        break;
                    }
                    newLevelLeftMostNode=atNode;
                }
            }


    }

    public static void inOrder(Node startNode, ArrayList<Integer> arl){

        //Node node=startNode;

        if(startNode.nodeLeft!=null){
            inOrder(startNode.nodeLeft, arl);
        }
//            else {
//                System.out.println(startNode.value);
//                return;
//            }
        if(startNode.nodeSide!=null)
            System.out.println(startNode.value+"-->"+startNode.nodeSide.value);
        else
            System.out.println(startNode.value+"-->null");

        arl.add(startNode.value);
        if(startNode.nodeRight!=null){
            inOrder(startNode.nodeRight, arl);
        }

        //return arl;

    }


}
