package me.zifya.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class ReadFile {

    public static boolean HaveLists(String Name) {
        File folder = new File("C:\\Users\\Zifya\\Desktop\\Bot\\Lists\\" + Name + "\\");
        if (folder.list().length > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static ArrayList<String> names(String user_name) {
        File folder = new File("C:\\Users\\Zifya\\Desktop\\Bot\\Lists\\" + user_name + "\\");
        ArrayList<String> potential_names = new ArrayList<String>(Arrays.asList(folder.list()));
        return potential_names;
    }

    public static String returnNameValue(String nameValue, String ID) throws IOException {
        String filepath = "C:\\Users\\Zifya\\Desktop\\Bot\\Lists\\" + nameValue + "\\" + ID + ".properties";
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(filepath);
        properties.load(inputStream);
        String listname = properties.getProperty("ListsName");
        System.out.println(nameValue);
        System.out.println(listname);
        System.out.println(ID);
        inputStream.close();
        return listname;

    }

    public static String returnCPU(String nameValue, String ID) throws IOException {
        String filepath = "C:\\Users\\Zifya\\Desktop\\Bot\\Lists\\" + nameValue + "\\" + ID + ".properties";
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(filepath);
        properties.load(inputStream);
        String listcpu = properties.getProperty("CPU");
        System.out.println(nameValue);
        System.out.println(listcpu);
        System.out.println(ID);
        inputStream.close();
        return listcpu;

    }

    public static String returnRAM(String nameValue, String ID) throws IOException {
        String filepath = "C:\\Users\\Zifya\\Desktop\\Bot\\Lists\\" + nameValue + "\\" + ID + ".properties";
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(filepath);
        properties.load(inputStream);
        String listram = properties.getProperty("RAM");
        System.out.println(nameValue);
        System.out.println(listram);
        System.out.println(ID);
        inputStream.close();
        return listram;
    }

    public static String returnGPU(String nameValue, String ID) throws IOException {
        String filepath = "C:\\Users\\Zifya\\Desktop\\Bot\\Lists\\" + nameValue + "\\" + ID + ".properties";
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(filepath);
        properties.load(inputStream);
        String listgpu = properties.getProperty("GPU");
        System.out.println(nameValue);
        System.out.println(listgpu);
        System.out.println(ID);
        inputStream.close();
        return listgpu;
    }
}
