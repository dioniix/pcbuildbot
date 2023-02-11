package me.zifya.files;

import java.io.*;

public class CreateFile {

    public static void CreateFile(String Name, int ID, String build_name, long User_ID) throws IOException {
        File folder = new File("C:\\Users\\Zifya\\Desktop\\Bot\\Lists\\" + Name);
        if (folder.exists()) {
            System.out.println("Folder already exists");
        } else {
            boolean f1 = new File("C:\\Users\\Zifya\\Desktop\\Bot\\Lists\\" + Name).mkdir();
        }
        File list = new File("C:\\Users\\Zifya\\Desktop\\Bot\\Lists\\" + Name + "\\" + ID + ".properties");
        if (list.createNewFile()) {
            FileWriter writer = new FileWriter(list);
            writer.write("ListsName:" + build_name);
            writer.write("\nCreatedBy:" + Name);
            writer.write("\nUsersID:" + User_ID);
            writer.write("\n");
            writer.write("\nAttributes");
            writer.write("\n");
            writer.write("\nRAM: ");
            writer.write("\nCPU: ");
            writer.write("\nGPU: ");
            writer.close();

        }

    }
}
