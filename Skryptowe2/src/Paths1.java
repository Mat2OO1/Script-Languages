import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Paths1 {
    public static ArrayList<File> ShowAllFiles(ArrayList<File> paths, File folder, Boolean R, Boolean d, Boolean s) throws IOException {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                if (R) {
                    paths.add(file);
                    ShowAllFiles(paths, file, R, d, s);
                } else {
                    paths.add(file);
                }
            } else if (!d) {
                paths.add(file);
            }
        }


    return paths;

}
    public static ArrayList<String> ShowSize(ArrayList<File> paths){
        ArrayList<String> output = new ArrayList<String>();
        for (File path : paths) {
            output.add(path.getPath() + " " + path.length() + " B");
        }
        return output;
    }
    public static void main(String[] args) throws IOException {
        boolean R = false;
        boolean d = false;
        boolean s = false;
        boolean alpha = false;
        boolean date = false;
        for (int i=0; i < args.length; i++) {
            if (args[i].equals("-R")) {
                R = true;
            } else if (args[i].equals("-d")) {
                d = true;
            } else if (args[i].equals("-s")) {
                s = true;
            } else if (args[i].equals("alpha")) {
                alpha = true;
            } else if (args[i].equals("date")) {
                date = true;
            }
        }
        ArrayList<File> paths = new ArrayList<File>();
        paths = ShowAllFiles(paths, new File("."), R,d,s);
        if (date) {
            Collections.sort(paths, new Comparator<File>() {
                public int compare(File f1, File f2) {
                    return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
                }
            });
        } else if (alpha) {
            Collections.sort(paths);
        }
        if (s) {
            ArrayList<String> output = new ArrayList<>();
            output = ShowSize(paths);
            for (String line : output ) {
                System.out.println(line);
            }
        } else {
            for (File path : paths) {
                System.out.println(path.getPath());
            }
        }

    }
}
