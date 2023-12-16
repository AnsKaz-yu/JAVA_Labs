import java.io.*;
import java.util.*;

public class FileInputHelper implements Closeable{
    private File file;
    private InputStream inputStream;
    //private BufferedReader fileReader;
    public FileInputHelper(String filename) throws IOException {
        file = new File(filename);
        inputStream = new FileInputStream(file);
        //fileReader = new BufferedReader(new FileReader(file));
    }

    public FileInputHelper() throws FileNotFoundException {
        file = new File("input.txt");
        inputStream = new FileInputStream(file);
        //fileReader = new BufferedReader(new FileReader(file));
    }

    public void setFilename(String filename) throws IOException {
        close();
        file = new File(filename);
        inputStream = new FileInputStream(file);
        //fileReader = new BufferedReader(new FileReader(file));
    }

    @Override
    public void close() throws IOException{
        inputStream.close();
        //fileReader.close();
    }

    public String readText() throws IOException {
        StringBuilder text = new StringBuilder();
        int cur;
        char s;
        while((cur = inputStream.read()) != -1){
            s = (char) cur;
            text.append(s);
        }
        return text.toString();
    }

    public String readCodingText() throws IOException {
        StringBuilder CodingText = new StringBuilder();
        int cur = inputStream.read();
        //System.out.println(cur);
        while (cur != -1){
            CodingText.append(to_bits(cur));
            cur = inputStream.read();
            //System.out.println(cur);
        }
        //System.out.println(CodingText);
        return CodingText.toString();
    }

    public Map<String, Integer> readDecodingTree() throws IOException {
        Map<String, Integer> decodingMap = new HashMap<String, Integer>();
        int cur = inputStream.read();

        do {
            int letter = cur;
            StringBuilder code = new StringBuilder();
            cur = inputStream.read();
            while (cur != '\n') {
                code.append((char) cur);
                cur = inputStream.read();
            }
            decodingMap.put(code.toString(), letter);
            cur = inputStream.read();
        } while (cur != '\u0000');
        return decodingMap;
    }

    private StringBuilder to_bits(int cur){
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if ((cur & 1) == 1){
                ans.append('1');
            }
            else {
                ans.append('0');
            }
            cur = cur >> 1;
        }
        ans.reverse();
        //System.out.println(ans);
        return ans;
    }

    public double getFileSizeBytes() {
        return  (double) file.length();
    }
}
