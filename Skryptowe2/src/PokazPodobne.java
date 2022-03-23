import java.util.ArrayList;
import java.util.Collections;

public class PokazPodobne {
    public static void main(String[] args) {
        String[] vars = PokazWszystkie.showVars().split(" ");
        ArrayList<String> output = new ArrayList<>();
        for(String arg : args){
            int count =0;
            for(String var : vars){
                if(var.toLowerCase().contains(arg.toLowerCase())){
                    count++;
                    String[] tmp = var.split(";");
                    for(String s : tmp){
                        output.add("\t" + arg + "=" + s);
                    }
                }
            }
            if(count==0){
                output.add(arg +"=NONE");
            }

        }
        Collections.sort(output);
        for(String elem: output){
            System.out.println(elem);
        }
    }
}
