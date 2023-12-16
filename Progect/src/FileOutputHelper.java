import java.io.*;
import java.util.Map;

public class FileOutputHelper implements Closeable{
    private File file;
    private OutputStream outputStream;
    //private FileWriter fileWriter;
    private int currentByte;
    private int numBitsFilled;

    public FileOutputHelper(String filename) throws IOException {
        setFileName(filename);
    }
    public void setFileName(String filename) throws IOException {
        file = new File(filename);
        file.delete();
        outputStream = new FileOutputStream(file, true);
        //fileWriter = new FileWriter(file, true);
    }

    public double getFileSizeBytes() {
        return  (double) file.length();
    }

    //for usual text
    public void writeString(String decodingString) throws IOException {
        for (int i = 0; i<decodingString.length(); i++){
            outputStream.write(decodingString.charAt(i));
        }
    }

    //for coded text. we have to write it using bits
    public void writeCodingText(String codingString) throws IOException {
        //System.out.println(codingString);
        for (int i = 0; i<codingString.length(); i++){
            boolean bit = (codingString.charAt(i) == '1' ? 1 : 0) == 1;
            writeBit(bit);
        }
        while (numBitsFilled != 0) writeBit(false);
    }

    public void writeEncodingMap(Map<Integer, String> encodingMap) throws IOException {
        for (Map.Entry<Integer, String> item : encodingMap.entrySet()){
            outputStream.write(item.getKey());
            for (int i = 0; i < item.getValue().length(); i++){
                outputStream.write(item.getValue().charAt(i));
            }
            outputStream.write('\n');
        }
        outputStream.write('\u0000');
        outputStream.flush();
    }

    public void close() throws IOException {
        //fileWriter.close();
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