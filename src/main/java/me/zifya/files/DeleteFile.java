package me.zifya.files;

import java.io.*;

public class DeleteFile {

    public static void removefile(String Name, String ID) {
        File list = new File("C:\\Users\\Zifya\\Desktop\\Bot\\Lists\\" + Name + "\\" + ID + ".properties");
        System.out.println(list.getAbsolutePath());
        list.deleteOnExit();
        if (list.delete()) {
            System.out.println("File deleted");
        }

    }

    public static boolean DoesFileExist(String Name, String ID) {
        File f1 = new File("C:\\Users\\Zifya\\Desktop\\Bot\\Lists\\" + Name + "\\" + ID + ".properties");
        if (f1.exists()) {
            return true;
        } else {
            return false;
        }

    }
}
