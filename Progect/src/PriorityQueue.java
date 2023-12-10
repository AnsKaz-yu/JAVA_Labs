import java.util.ArrayList;

class PriorityQueue {
    private ArrayList<Node> data;
    private int nElements;

    public PriorityQueue() {
        data = new ArrayList<Node>();
        nElements = 0;
    }

    public void insert(Node newRoot) {//вставка
        if (nElements == 0)
            data.add(newRoot);
        else {
            for (int i = 0; i < nElements; i++) {
                if (data.get(i).getCount() > newRoot.getCount()) {
                    data.add(i, newRoot);
                    break;
                }
                if (i == nElements - 1)
                    data.add(newRoot);
            }
        }
        nElements++;
    }

    public Node remove() {
        Node tmp = data.get(0);
        data.remove(0);
        nElements--;
        return tmp;
    }

    public int size(){
        return nElements;
    }
}