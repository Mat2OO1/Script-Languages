import java.util.Scanner;

public class KodPowrotuInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tekst = sc.nextLine();
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
