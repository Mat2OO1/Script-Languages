import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Process1 {
    public static void main(String[] args) {
        int ignorefirst = 0,ignorelast = 0, lines=0;
        String delimeter="DEFAULTVALUE123",separator="\t",select = "DEFAULTVALUE123";
        ArrayList<String> project = new ArrayList<>();
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
                        String[] tmp1 = tmp[1].split("[,]");
                        for (int i = 0; i < tmp1.length; i++) {
                            project.add(tmp1[i]);
                        }
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
            String line = text.get(i);
            if (line.length() < ignorefirst) {
                ignorefirst -= line.length();
                text.remove(text.indexOf(line));
            } else {
                text.set(i,text.get(i).substring(ignorefirst, line.length() - 1));
                break;
            }
        }
        for(int i= text.size()-1; i>=0; i--) {
            if (text.get(i).length() < ignorelast) {
                ignorelast -= text.get(i).length();
                text.remove(text.get(i));
            } else {
                text.set(i, text.get(i).substring(0, text.get(i).length() - 1 - ignorelast));
                break;
                }
            }
        for(String line : text){
            text.set(text.indexOf(line),line.replaceAll(delimeter,Matcher.quoteReplacement(separator)));
            }
        if(project.size() >=1){
            for(int i=0; i< project.size(); i++){
                System.out.println(text.get(Integer.parseInt(project.get(i))));
            }
            System.out.println(0);
        }
        else if(select!= "DEFAULTVALUE123"){
            for(String line : text){
                if(line.contains(select)){
                    System.out.println(line);
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
