import java.io.*;
import java.util.*;

public class Main {	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] n = new int[N];
        int[] s = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int x=0; x<N; x++) {
        	n[x] = Integer.parseInt(st.nextToken());
        	if (x==0) {
        		s[x] = n[x];
        		continue;
        	}
        	s[x] += n[x] + s[x-1];
        }
        for (int x=0; x<M; x++) {
        	st = new StringTokenizer(br.readLine());
        	int i = Integer.parseInt(st.nextToken());
        	int j = Integer.parseInt(st.nextToken());
        	if (i==1) {
        		sb.append(s[j-1]).append("\n");
        	} else {
        		sb.append(s[j-1]-s[i-2]).append("\n");
        	}
        }
        System.out.println(sb);
    }
}
