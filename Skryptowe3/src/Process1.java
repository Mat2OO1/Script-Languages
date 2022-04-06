import java.util.*;
import java.util.regex.Matcher;

public class Process1 {
    public static void main(String[] args) throws Exception {
        int ignorefirst = 0,ignorelast = 0, lines=0;
        String delimeter="\t",separator="\t", sort="";
        String[] project = new String[0];
        String[] select = new String[0];
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
                        select = tmp[1].split(",");
                }
            else{
                throw new Exception("Incorrect parameters");
            }
        }
        Scanner sc = new Scanner(System.in);
        ArrayList<String> text = new ArrayList<>();
        while(sc.hasNextLine()) {
            lines++;
            text.add(sc.nextLine());

        }
        if(ignorefirst>0) {
            for (int i = 0; i < text.size(); i++) {
                if (text.get(i).length() < ignorefirst) {
                    text.remove(i);
                } else {
                    text.set(i, text.get(i).substring(ignorefirst));
                }
            }
        }
        if(ignorelast >0) {
            for (int i = 0; i < text.size(); i++) {
                if (text.get(i).length() < ignorelast) {
                    text.remove(i);
                } else {
                    text.set(i, text.get(i).substring(0, text.get(i).length() - ignorelast));
                }
            }
        }
        for(int i=0; i<text.size(); i++){
            text.set(i,text.get(i).replaceAll(delimeter,Matcher.quoteReplacement(separator)));
            }
        if(select.length >=2 && select.length%2 ==0 && project.length>=1){
            String[] tmp1 = text.get(0).split(separator);
            for (int j = 0; j < project.length; j++) {
                System.out.print(tmp1[Integer.parseInt(project[j])] + separator);
            }
            System.out.println();
            for(int i =1; i<text.size();i++) {
                String line = text.get(i);
                String[] tmp = line.split(separator);
                boolean isPresent = true;
                for(int j=0; j< select.length; j+=2)
                    if (!tmp[Integer.parseInt(select[j])].toLowerCase().equals(select[j+1].toLowerCase())) {
                        isPresent = false;
                        break;
                    }
                if(isPresent){
                    if (tmp.length >= project.length) {
                        for (int j = 0; j < project.length; j++) {
                            System.out.print(tmp[Integer.parseInt(project[j])] + separator);
                        }
                        System.out.println();
                    }
                }
                }
            System.exit(0);
        }
        else if(select.length >=2 && select.length%2 ==0){
            for(int i =1; i<text.size();i++) {
                String line = text.get(i);
                String[] tmp = line.split(separator);
                boolean isPresent = true;
                for(int j=0; j< select.length; j+=2)
                    if (!tmp[Integer.parseInt(select[j])].toLowerCase().equals(select[j+1].toLowerCase())) {
                        isPresent = false;
                        break;
                    }
                if(isPresent){
                    System.out.println(line);
                }
            }
            System.exit(0);
        }
        else if(project.length >=1){
            for(String line : text) {
                String[] tmp = line.split(separator);
                if (tmp.length >= project.length) {
                    for (int i = 0; i < project.length; i++) {
                            System.out.print(tmp[Integer.parseInt(project[i])] + separator);
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
