import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Process1 {
    public static void main(String[] args) {
        int ignorefirst = 0,ignorelast = 0, lines=0;
        String delimeter=",",separator="\t",select = "DEFAULTVALUE123";
        String[] project = new String[0];
        for(String arg : args) {
            String[] tmp = arg.split("[= ]");
            if (tmp.length >= 2) {
                    if(tmp[0].equals("--ignorefirst"))
                        ignorefirst = Integer.parseInt(tmp[1]);
                    else if(tmp[0].equals("--ignorelast"))
                        ignorelast = Integer.parseInt(tmp[1]);
                    else if(tmp[0].equals("--delimeter"))
                        delimeter = tmp[1];
                    else if(tmp[0].equals("--separator"))
                        separator = tmp[1];
                     else if(tmp[0].equals("--project")) {
                        project = tmp[1].split(",");
                    }
                    else if(tmp[0].equals("--select"))
                        select = tmp[1];
                }
            else{
                System.out.println("Incorrect parameters");
            }
        }
        Scanner sc = new Scanner(System.in);
        ArrayList<String> text = new ArrayList<>();
        while(sc.hasNextLine()) {
            lines++;
            text.add(sc.nextLine());

        }
        for(int i=0; i< text.size(); i++) {
            if (text.get(i).length() < ignorefirst) {
                text.remove(i);
            } else {
                text.set(i,text.get(i).substring(ignorefirst));
            }
        }
        for(int i= 0; i< text.size(); i++) {
            if (text.get(i).length() < ignorelast) {
                text.remove(text.get(i));
            } else {
                text.set(i, text.get(i).substring(0, text.get(i).length() - ignorelast));
                }
            }
        for(String line : text){
            text.set(text.indexOf(line),line.replaceAll(delimeter,Matcher.quoteReplacement(separator)));
            }
        if(select!= "DEFAULTVALUE123"){
            for(String line : text){
                if(line.contains(select)){
                    System.out.println(line);
                }
            }
            System.out.println(0);
        }
        else if(project.length >=1){
            for(String line : text) {
                String[] tmp = line.split(separator);
                if (tmp.length > project.length) {
                    for (int i = 0; i < project.length; i++) {
                        System.out.print(tmp[Integer.parseInt(project[i])] + " ");
                    }
                    System.out.println();
                }
            }

            System.out.println(0);
        }

        else{
            if(text.size() > 0){
                for(String line : text){
                    System.out.println(line);
                }
                System.out.println(0);}
            else if(lines != 0){
                System.out.println(1);
            }
            else{
                System.out.println(2);
            }
        }


    }
}
