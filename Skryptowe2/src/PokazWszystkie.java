import java.util.Map;

public class PokazWszystkie {
    public static String showVars(){
        String output = "";
        Map<String, String> vars = System.getenv();
        for (Map.Entry entry : vars.entrySet())
        {
            output+=(entry.getKey() + "=" + entry.getValue() + "  ");
        }
        return output;
    }
    public static void main(String[] args) {
        System.out.println(showVars());
        for(String arg : args){
            System.out.print(arg + " ");
        }
    }
}

