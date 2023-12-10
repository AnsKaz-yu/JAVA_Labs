import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.println("Choose a mode:");
            System.out.println("Code - the application encodes the file. The output is an encoded file containing the encoding tree and the directly encoded data.");
            System.out.println("Decode - the application receives an encoded file as input, and the output is the decoded source file.");
            System.out.println("Info - an encoded file is received at the input and the application displays the encoding tree, the compression ratio of the file, its initial and final (after encoding) sizes.");
            Scanner in = new Scanner(System.in);
            String mode = in.next();
            System.out.println("Enter the input file name: ");
            String filename = in.next();
            System.out.println("\nYour mode: " + mode);
            System.out.println("Your input file: " + filename + "\n");

            switch (mode.toLowerCase()){
                case "code": {
                    System.out.println("\nStarting to encode the file...");
                    HuffmanTree MyTree = new HuffmanTree(mode, filename);
                    MyTree.enabling();
                    System.out.println("The result is added to output.ark");
                    break;
                }
                case "decode": {
                    System.out.println("\nStarting to decode the file...");
                    HuffmanTree MyTree = new HuffmanTree(mode, filename);
                    MyTree.enabling();
                    System.out.println("The result is added to output.txt");
                    break;
                }
                case "info": {
                    System.out.println("\nStarting to analyze the file...");
                    HuffmanTree MyTree = new HuffmanTree(mode, filename);
                    System.out.println("You can see the result on your screen:");
                    MyTree.enabling();
                    break;
                }
                default:
                    System.out.println("Error: You may have entered an incorrect mode. Try again.");
                    break;
            }
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}