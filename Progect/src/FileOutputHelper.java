import java.io.*;
import java.math.BigInteger;
import java.util.Map;

public class FileOutputHelper implements Closeable{
    private File file;
    private OutputStream outputStream;
    private FileWriter fileWriter;
    private int currentByte;
    private int numBitsFilled;

    public FileOutputHelper(){};
    public void setFileName(String filename) throws IOException {
        file = new File(filename);
        file.delete();
        outputStream = new FileOutputStream(file, true);
        fileWriter = new FileWriter(file, true);
    }

    public double getFileSizeBytes() {
        return  (double) file.length();
    }

    //for usual text
    public void writeString(String decodingString) throws IOException {
        fileWriter.write(decodingString);
    }

    //for coded text. we have to write it using bits
    public void writeCodingText(String codingString) throws IOException {
        //System.out.println(codingString);
        for (int i = 0; i<codingString.length(); i++){
            boolean bit = (codingString.charAt(i) == '1' ? 1 : 0) == 1;
            writeBit(bit);
        }
        if (numBitsFilled != 0) writeByte();
    }

    public void writeEncodingMap(Map<Character, String> encodingMap) throws IOException {
        for (Map.Entry<Character, String> item : encodingMap.entrySet()){
            fileWriter.write(item.getKey() + item.getValue() + '\n');
        }
        fileWriter.write('\u0000');
        fileWriter.flush();
    }

    public void close() throws IOException {
        fileWriter.close();
        outputStream.close();
    }

    private void writeBit(boolean bit) throws IOException {
        currentByte = ((currentByte << 1) | (bit ? 1 : 0));
        numBitsFilled++;

        if (numBitsFilled == 8) {
            writeByte();
        }
    }

    private void writeByte() throws IOException {
        //System.out.println(currentByte);
        outputStream.write(currentByte);
        currentByte = 0;
        numBitsFilled = 0;
    }
}