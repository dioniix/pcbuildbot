package me.zifya.files;

import java.io.*;
import java.util.Properties;

public class ModifyFile {

    public static boolean DoesFileExist(String Name, String ID) {
        File list = new File("C:\\Users\\Zifya\\Desktop\\Bot\\Lists\\" + Name + "\\" + ID + ".properties");

        if (list.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static void ModifyFile(String Name, String ID, String modifier, String modified) throws IOException {

        String filepath = "C:\\Users\\Zifya\\Desktop\\Bot\\Lists\\" + Name + "\\" + ID + ".properties";
        FileInputStream inputStream = new FileInputStream(filepath);
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(filepath);
        properties.setProperty(modifier,modified);
        properties.store(outputStream, null);
        outputStream.close();
    }


}
