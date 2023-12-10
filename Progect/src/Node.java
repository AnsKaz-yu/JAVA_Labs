public class Node {
    private int count;
    private char letter;
    private Node leftChild;
    private Node rightChild;

    public Node(char letter, int count){
        this.letter = letter;
        this.count = count;
    }

    public Node(){};

    public void addChild(Node newChild){
        if (leftChild == null){
            leftChild = newChild;

        }
        else {
            if (leftChild.getCount() <= newChild.getCount()) {
                rightChild = newChild;
            }
            else{
                rightChild = leftChild;
                leftChild = newChild;
            }
        }
        count += newChild.count;
    }

    public int getCount(){
        return count;
    }

    public boolean isLeaf(){
        return leftChild == null && rightChild == null;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node child){
        this.leftChild = child;
    }
    public void setRightChild(Node child){
        this.rightChild = child;
    }

    public void setLetter(char letter){
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }
}
