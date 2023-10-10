package lesson20231010;

import java.io.File;
import java.util.Scanner;

public class ListFileTree {

    public static void main(String args[])  {
        String s;
        while(true) {
            System.out.println("Enter full path ('quit' to exit): ");
            Scanner scanner = new Scanner(System.in);
            s = scanner.nextLine();

            if(s.equals("quit")) break;
            File f = new File(s);
            if(!f.exists()) {
                System.out.println("\nNot found: " + s);
                continue;
            }

            if(!f.isDirectory()) {
                System.out.println("\nNot directory: " + s);
                continue;
            }

            list(s);
        }
    }

    static void list(String szDir) {
        File f = new File(szDir);
        String[] sDirList = f.list();

        int i;
        for(i = 0; i < sDirList.length; i++) {
            File f1 = new File(szDir + File.separator + sDirList[i]);

            if(f1.isFile())
                System.out.println("File: " + szDir + File.separator + sDirList[i]);
            else {
                System.out.println("Moving to dir: " + szDir + File.separator + sDirList[i]);
                list(szDir + File.separator + sDirList[i]);
            }
        }
    }


}
