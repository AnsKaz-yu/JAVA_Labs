import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class HuffmanTree {
    FileInputHelper inputHelper;
    FileOutputHelper outputHelper;
    private String mode;
    private String filename;
    private String codingString; //закодированное сообщение
    private String decodingString; //декодированное сообщение
    private Node huffmanTree;//дерево Хаффмана
    private Map<Character, Integer> freqMap;//частотная таблица
    private Map<Character, String> encodingMap;//кодировочная таблица
    private Map<String, Character> decodingMap;//кодировочная таблица наоборот
    private PriorityQueue p_queue; //приоритетная очередь

    public HuffmanTree(String _mode, String _filename) throws IOException {
        mode = _mode;
        filename = _filename;
        inputHelper = new FileInputHelper();
        outputHelper = new FileOutputHelper();
        freqMap = new HashMap<>();
        encodingMap = new HashMap<>();
        p_queue = new PriorityQueue();
        codingString = "";
        decodingString = "";
    }

    public void enabling() throws IOException {
        switch (mode.toLowerCase()){
            case "info":
                start_info();
                break;
            case "code":
                start_code();
                break;
            case "decode":
                start_decode();
                break;
        }
        inputHelper.close();
        outputHelper.close();
    }

    //coding functions
    private void start_code() throws IOException {
        outputHelper.setFileName("output.ark");
        inputHelper.setFilename(filename);
        decodingString = inputHelper.readText();
        FillInFreqMap();
        MakeStartNodes();
        MakeHuffmanTree();
        GetEncodingMap();
        CodeString();
        outputHelper.writeEncodingMap(encodingMap);
        outputHelper.writeCodingText(codingString);
    }

    private void FillInFreqMap(){
        for (int i = 0; i < decodingString.length(); i++){
            char _char = decodingString.charAt(i);
            int _count_char = freqMap.getOrDefault(_char, 0);
            freqMap.put(_char, _count_char + 1);
        }
    }

    private void MakeStartNodes() {
        for (Map.Entry<Character, Integer> item : freqMap.entrySet()){
            Node new_node = new Node(item.getKey(), item.getValue());
            p_queue.insert(new_node);
        }
    }

    private void MakeHuffmanTree() {
        while (p_queue.size() != 1){
            Node n_node = new Node();
            n_node.addChild(p_queue.remove());
            n_node.addChild(p_queue.remove());
            p_queue.insert(n_node);
        }
        huffmanTree = p_queue.remove();
    }

    private void GetEncodingMap() {
        GetEncodingMap(huffmanTree, "");
    }

    private void GetEncodingMap(Node node, String code) {
        if (node.isLeaf()){
            char _char = node.getLetter();
            encodingMap.put(_char, code);
            return;
        }
        GetEncodingMap(node.getLeftChild(), code + "0");
        GetEncodingMap(node.getRightChild(), code + "1");
    }

    private void CodeString(){
        for (int i = 0; i < decodingString.length(); i++){
            char _char = decodingString.charAt(i);
            codingString = codingString.concat(encodingMap.get(_char));
        }
    }

    //decoding functions
    private void start_decode() throws IOException {
        outputHelper.setFileName("output.txt");
        inputHelper.setFilename(filename);
        decodingMap = inputHelper.readDecodingTree();
        codingString = inputHelper.readCodingText();
        DecodeString();
        outputHelper.writeString(decodingString);
        inputHelper.close();
        outputHelper.close();
    }

    private void DecodeString() {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < codingString.length(); i++){
            code.append(codingString.charAt(i));
            if (decodingMap.containsKey(code.toString())){
                Character _char = decodingMap.get(code.toString());
                decodingString = decodingString.concat(_char.toString());
                code = new StringBuilder();
            }
        }
    }

    //info functions
    private void start_info() throws IOException {
        start_decode();
        double sizeBefore = outputHelper.getFileSizeBytes();
        double sizeAfter = inputHelper.getFileSizeBytes();
        double ratio = sizeBefore / sizeAfter;
        System.out.println("The size of file before coding: " + sizeBefore + "bytes");
        System.out.println("The size of file after coding: " + sizeAfter + "bytes");
        System.out.println("The file compression ratio: " + ratio);
        System.out.println();
        System.out.println("Coding tree structure:");
        rebuildHuffmanTree();
        printHuffmanTree();
    }

    private void rebuildHuffmanTree() {
        huffmanTree = new Node();
        Node current;
        for (Map.Entry<String, Character> item : decodingMap.entrySet()){
            current = huffmanTree;
            String code = item.getKey();
            Character _char = item.getValue();
            for (int i = 0; i < code.length(); i++){
                char c = code.charAt(i);
                Node _new;
                if (c=='0'){
                    _new = current.getLeftChild();
                    if (_new == null){
                        _new = new Node();
                        current.setLeftChild(_new);
                    }
                }
                else{
                    _new = current.getRightChild();
                    if (_new == null){
                        _new = new Node();
                        current.setRightChild(_new);
                    }
                }
                current = _new;
            }
            current.setLetter(_char);
        }
    }

    private void printHuffmanTree() {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(huffmanTree);
        int row = 1;
        int next_row = 0;
        while (!queue.isEmpty()){
            Node n = queue.pollFirst();
            if (n == null) continue;
            next_row += (n.getLeftChild() != null ? 1 : 0);
            next_row += (n.getRightChild() != null ? 1 : 0);
            row--;

            if (n.getLetter() != '\u0000') {
                System.out.print(n.getLetter() + ", ");
            }
            else {
                System.out.print("-, ");
                queue.offer(n.getLeftChild());
                queue.offer(n.getRightChild());
            }

            if (row == 0){
                System.out.println();
                row = next_row;
                next_row = 0;
            }
        }
    }

}
