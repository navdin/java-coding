package src;

import java.util.ArrayList;
import java.util.Scanner;

public class _5leastCommonAncestor {


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


    }
}
