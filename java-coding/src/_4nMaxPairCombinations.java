public class _4nMaxPairCombinations {

    public static class Node{
        Node nodeLeft;
        Node nodeRight;
        int value;
    }
    public static class StartNode{
        int nodeCount;
        int heapDepth;
        Node nodeLeft;
        Node nodeRight;
        int value;
    }
    //int a=5;

    public static void main(String[] args) {

        // 13 10 8 6 4 3 2 1 1
        //

        //  13+3               10+4                8+6


        _4nMaxPairCombinations mp=new _4nMaxPairCombinations();
        StartNode startNode=new StartNode();
        startNode.heapDepth=0;
        startNode.nodeCount=1;
        int heapDepth=startNode.heapDepth;
        int nodeCount=startNode.nodeCount;



    }

    public static void addNode(StartNode startNode, Node node, int heapDepth, int nodeCount){


        Node atNode=null;//=new Node();
        int nodeCountLastLevel=1;
        for(int i=0; i<heapDepth; i++){
            nodeCountLastLevel=nodeCountLastLevel*2;
        }
        int heapFullCount=nodeCountLastLevel*2-1;
        int posLastLevel=0;
        if(heapFullCount==nodeCount){
            posLastLevel=1;
            startNode.heapDepth++;
        }
        else {
            posLastLevel=nodeCount-nodeCountLastLevel-1;
        }
        int countLastLevel=nodeCountLastLevel;

        while(true) {
            countLastLevel=countLastLevel/2;
            if(posLastLevel>countLastLevel){

                posLastLevel=posLastLevel-countLastLevel;

                if(atNode==null){
                    if(posLastLevel==1){
                        startNode.nodeRight=node;
                        break;
                    }
                    atNode=startNode.nodeRight;
                }
                else {
                    if(posLastLevel==1){
                        startNode.nodeRight=node;
                        break;
                    }
                    atNode=atNode.nodeRight;
                }


            }
            else {

                if(atNode==null){
                    if(posLastLevel==1){
                        startNode.nodeLeft=node;
                        break;
                    }
                    atNode=startNode.nodeLeft;
                }
                else {
                    if(posLastLevel==1){
                        atNode.nodeLeft=node;
                        break;
                    }
                    atNode=atNode.nodeLeft;
                }
            }
        }




    }

}
