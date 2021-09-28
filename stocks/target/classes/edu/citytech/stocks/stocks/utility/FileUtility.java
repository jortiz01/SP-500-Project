package edu.citytech.stocks.stocks.utility;
import java.io.*;


public class FileUtility {

    public static String getFile(String FileName) {
        StringBuilder sb = new StringBuilder();
        try{

            BufferedReader bufferedReader = new BufferedReader(new FileReader(FileName));
            String cureentLine;

            while ((cureentLine = bufferedReader.readLine()) != null){
                sb.append(cureentLine);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}