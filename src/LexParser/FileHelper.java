package LexParser;

import java.io.*;

public class FileHelper {

    public static char[] readFile(String filePath) {
        char[] result = new char[10000];
        int pointer = 0;
        File file = new File(filePath);
        try {
            BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    result[pointer++] = line.charAt(i);
                }
                result[pointer++] = '\n';
            }
            result[pointer] = '#';
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
