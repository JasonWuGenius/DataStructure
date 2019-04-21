import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        String x1 = s[0];
        int k1 = Integer.parseInt(s[1]);
        String x2 = s[2];
        int k2 = Integer.parseInt(s[3]);
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for(int i=0; i<k1; i++){
            sb1.append(x1);
        }
        for(int i=0; i<k2; i++){
            sb2.append(x2);
        }
        int len1 = sb1.toString().length();
        int len2 = sb2.toString().length();
        if(len1 > len2){
            System.out.println("Greater");
        }
        else if(len1 < len2){
            System.out.println("Less");
        }
        else{
            for(int i=0; i<len1; i++){
                if(sb1.charAt(i) > sb2.charAt(i)){
                    System.out.print("Greater");
                }
                else if(sb1.charAt(i) < sb2.charAt(i)){
                    System.out.print("Less");
                }
            }
            System.out.println("Equal");
        }
    }
}
