import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.println("\nChoose a mode:\n");
            System.out.println("Code - the application encodes the file. The output is an encoded file containing the encoding tree\nand the directly encoded data.\n");
            System.out.println("Decode - the application receives an encoded file as input, and the output is the decoded source file.\n");
            System.out.println("Info - an encoded file is received at the input and the application displays the encoding tree,\nthe compression ratio of the file, its initial and final (after encoding) sizes.\n");
            Scanner in = new Scanner(System.in);
            String mode = in.next();
            System.out.println("Enter the input file name: ");
            String inputname = in.next();

            System.out.println("\nYour mode: " + mode);
            System.out.println("Your input file: " + inputname + "\n");


            switch (mode.toLowerCase()){
                case "code": {
                    System.out.println("Enter the output file name: ");
                    String outputname = in.next();
                    System.out.println("Your input file: " + outputname + "\n");
                    System.out.println("\nStarting to encode the file...");
                    HuffmanTree MyTree = new HuffmanTree(mode, inputname, outputname);
                    MyTree.enabling();
                    System.out.println("The result is added to " + outputname);
                    break;
                }
                case "decode": {
                    System.out.println("Enter the output file name: ");
                    String outputname = in.next();
                    System.out.println("Your input file: " + outputname + "\n");
                    System.out.println("\nStarting to decode the file...");
                    HuffmanTree MyTree = new HuffmanTree(mode, inputname, outputname);
                    MyTree.enabling();
                    System.out.println("The result is added to " + outputname);
                    break;
                }
                case "info": {
                    System.out.println("\nStarting to analyze the file...");
                    HuffmanTree MyTree = new HuffmanTree(mode, inputname, "output.txt");
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