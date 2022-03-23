import java.util.ArrayList;
import java.util.Scanner;

public class Tail1 {
    public static void main(String[] args) throws Exception {
        int lines = 0;
        boolean e = false;
        for(String arg : args){
            String[] tmp = arg.split("[= ]");
            if(tmp[0].equals("--lines")){
                lines = Integer.parseInt(tmp[1]);
            }
            else if(tmp[0].equals("-e")){
                e = true;
            }
            else{
                throw new Exception("Wrong parameters");
            }
        }
        Scanner sc = new Scanner(System.in);
        ArrayList<String> text = new ArrayList<>();
        while(sc.hasNextLine()) {
            text.add(sc.nextLine());
        }
        if(text.size() < lines && !e){
            System.out.println(0);
            throw new Exception("Zabraklo " + (lines - text.size()) + " linii do wypisania");
        }
        else if(text.size() < lines){
            System.out.println(0);
        }
        else {
            for (int i = text.size()-1-lines; i < text.size(); i++) {
                System.out.println(text.get(i));
            }
            System.out.println(2);
        }
    }
}
