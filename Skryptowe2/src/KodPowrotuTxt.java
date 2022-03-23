import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class KodPowrotuTxt {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String tekst = sc.nextLine();
        File txt = new File(tekst);
        BufferedReader br = new BufferedReader(new FileReader(txt));
        tekst = "";
        String st;
        while(( st = br.readLine()) != null){
            tekst += st;
        }
        String[] slowa = tekst.split(" ");
        int tab[] = new int[args.length];
        for(int i=0;i< tab.length;i++){
            tab[i] = 0;
        }
        for(String slowo: slowa){
            for(int i=0; i<args.length; i++){
                if(args[i].equals(slowo.toLowerCase())){
                    tab[i]++;
                }
            }
        }
        int max = -1;
        int index = -1;
        for(int i=0; i<tab.length; i++){
            if(tab[i] > max){
                max = tab[i];
                index = i;
            }
        }
        if(index == -1){
            System.out.println(0);
        }
        else{
            System.out.println(index);
        }
    }
}