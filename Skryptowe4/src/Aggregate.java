import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Aggregate {
    public static ArrayList<ArrayList<String>> tab = new ArrayList<>();

    public static ArrayList<Integer> getColumn(int index){
        ArrayList<Integer> newArr = new ArrayList<>();
        for(int i=1; i<tab.size();i++){
            newArr.add(Integer.parseInt(tab.get(i).get(index)));
        }
        return newArr;
    }
    public static int min(String column){
        int index =tab.get(0).indexOf(column);
        ArrayList<Integer> data = getColumn(index);
        int min = data.get(1);
        for(int i=0; i< data.size();i++){
            int tmp = data.get(i);
            if(min > tmp && tmp>=0){
                min =tmp;
            }
        }
        return min;
    }
    public static int max(String column){
        int index =tab.get(0).indexOf(column);
        ArrayList<Integer> data = getColumn(index);
        int max = data.get(1);
        for(int i=0; i< data.size();i++){
            int tmp = data.get(i);
            if(max < tmp && tmp>=0){
                max =tmp;
            }
        }
        return max;
    }
    public static int sum(String column){
        int index =tab.get(0).indexOf(column);
        ArrayList<Integer> data = getColumn(index);
        int sum = 0;
        for(int i=0; i< data.size();i++){
            int tmp = data.get(i);
            if(tmp>=0){
                sum+=tmp;
            }
        }
        return sum;
    }
    public static int avg(String column){
        return sum(column)/ getColumn(tab.get(0).indexOf(column)).size();
    }
    public static int count(String column){
        return getColumn(tab.get(0).indexOf(column)).size();
    }
    public static int median(String column){
        ArrayList<Integer> data =getColumn(tab.get(0).indexOf(column));
        Collections.sort(data);
        if (data.size() % 2 == 0)
            return (data.get(data.size()/2)+ data.get(data.size()/2 -1))/2;
        else
            return data.get(data.size()/2);
    }
    public static int variance(String column){
        int avg = avg(column);
        int variance= 0;
        ArrayList<Integer> data = getColumn(tab.get(0).indexOf(column));
        for(Integer val: data){
            variance+= Math.pow(val - avg,2);
        }
        return variance/data.size();
    }
    public static void readFile() throws Exception {
        Scanner sc = new Scanner(System.in);
        String line = "";
        while(sc.hasNextLine()) {
            if ((line = sc.nextLine()).isEmpty()) {
                throw new Exception("Empty input");
            }
            else {
                String[] tmp = line.split("\t");
                ArrayList<String> arr = new ArrayList<String>();
                Collections.addAll(arr, tmp);
                tab.add(arr);
            }
        }
    }
    public static void userChoice(String[] args) throws Exception {
        readFile();
        for(String arg:args){
            String[] tmp = arg.split("[\\(||\\)]");
            if(tmp.length>=2){
                if(tmp[0].equals("min")){
                    System.out.println(min(tmp[1]));
                }
                else if(tmp[0].equals("max")){
                    System.out.println(max(tmp[1]));
                }
                else if(tmp[0].equals("sum")){
                    System.out.println(sum(tmp[1]));
                }
                else if(tmp[0].equals("avg")){
                    System.out.println(avg(tmp[1]));
                }
                else if(tmp[0].equals("count")){
                    System.out.println(count(tmp[1]));
                }
                else if(tmp[0].equals("median")){
                    System.out.println(median(tmp[1]));
                }
                else if(tmp[0].equals("variance")){
                    System.out.println(variance(tmp[1]));
                }
                else{
                    throw new Exception("Wrong parameters!");
                }

            }
            else{
                throw new Exception("Wrong parameters!");
            }
        }
    }
    public static void main(String[] args) throws Exception {
        userChoice(args);
    }
}
