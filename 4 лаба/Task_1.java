import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

public class Task_1
{
    static File root_folder = new File(".");

    public static void main(String[] args) throws IOException
    {

        File F1=new File(root_folder.getAbsolutePath() + "/MyFile1.txt");
        F1.createNewFile();
        File F2=new File("D:\\MyFile2.txt");
        F2.createNewFile();
        File F3=new File("D:\\Projects\\MyFile3.txt");
        F3.createNewFile();
        task1_2(F1);
        File new_folder = new File(root_folder.getAbsolutePath() + "/NewFolder");
        new_folder.mkdir();
        System.out.println("----------------------");
        File[] file_arr = root_folder.listFiles();
        for(int i=0;i<file_arr.length;i++)
        {
            System.out.println(file_arr[i].getName());
        }
        System.out.println("----------------------");
        String[] file_name_arr = root_folder.list();
        for(int i=0;i<file_name_arr.length;i++)
        {
            System.out.println(file_name_arr[i]);
        }
        System.out.println("----------------------");
        F1.delete();
        F2.delete();
        F3.delete();
        new_folder.delete();
    }
    public static void task1_2(File F1)
    {
        if (F1.isFile())
        {
            if (contain_check(root_folder, F1.getName()))
                System.out.println("Файл " + F1.getName() + "содержится в папке " + F1.getParentFile().getName() + " по пути "+ F1.getPath()+ " размером " + F1.length()/1024 + " kb");
            else
                System.out.println("Не нашел F1");
        }
        else if (F1.isDirectory())
        {
            if (contain_check(F1, F1.getName()))
                System.out.println("В папке " + F1.getName() + "содержится файл " + F1.getName() + " по пути "+ F1.getPath() + " размером " + F1.length()/1024 + " kb");
            else
                System.out.println("Не нашел F1");
        }
    }

    public static boolean contain_check(File folder, String file_name)
    {
        String[] files = folder.list();
        for (int i = 0; i<files.length; i++)
        {
            if (files[i].equals(file_name))
                return  true;
        }
        return false;
    }
}

