import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[3*n];
        for(int i = 0;i < arr.length;i++){
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        int index = arr.length -1 -1;
        int ret = 0;
        while (n > 0){
            ret += arr[index];
            index -= 2;
            n--;
        }
        System.out.println(ret);
    }
}