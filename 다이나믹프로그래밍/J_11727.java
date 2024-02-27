import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int p = 10007;
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        if (n>1) {
            for (int i=2; i<=n; i++) {
            	arr[i] = ( arr[i-1]%p + (arr[i-2]%p * 2%p)%p ) % p;
            }
        }
        System.out.println(arr[n]);
    }
}
