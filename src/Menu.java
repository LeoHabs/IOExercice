import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    public static void run(){
        Scanner scanner= new Scanner(System.in);
        int run=1;
        while(run==1){
            menu();
            System.out.println("To continue press 1");
            run=scanner.nextInt();
        }
    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Get list");
        System.out.println("2- Check if present");
        System.out.println("3- Create new file");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                try {
                    System.out.print("Choose new list file name: ");
                    String fileName = scanner.next();
                    System.out.println("Choose directory");
                    String directory= scanner.next();
                    BufferedReader reader = new BufferedReader(new StringReader(Arrays.toString(getList())));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(directory+ fileName + ".txt"));
                    //char size= getList().;
                    writer.write(Arrays.toString(getList()));
                    writer.close();
                } catch (java.io.IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.print("File name: ");
                String userFileInput = scanner.next();
                if (checkFileExist(getList(), userFileInput)) {
                    System.out.println("Exists");
                    return;
                }
                System.out.println("Does not exist");
                break;
            case 3:
                try {
                    System.out.print(" New file name: ");
                    String chooseFileName = scanner.next();
                    System.out.println("Choose directory");
                    String directory= scanner.next();
                    BufferedWriter writer = new BufferedWriter(new FileWriter(directory+ chooseFileName + ".txt"));
                } catch (java.io.IOException e) {
                    System.out.println(e.getMessage());
                }
        }
    }

    public static String[] getList() {
        File file = new File("src");
        return file.list();
    }

    public static boolean checkFileExist(String[] array, String inputName) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(inputName)) {
                return true;
            }
        }
        return false;
    }
}


