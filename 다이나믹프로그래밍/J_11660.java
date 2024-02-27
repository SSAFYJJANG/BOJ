import java.io.*;
import java.util.*;

public class Main {	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] sum = new int[N][N];
        for (int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0; j<N; j++) {
        		int t = Integer.parseInt(st.nextToken());
        		sum[i][j] += t;
        		if (j==0) continue;
        		sum[i][j] += sum[i][j-1];
        	}
        }
        for (int i=0; i<M; i++) {
        	int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	int ans = 0;
        	if (xy[1]==1) {
        		for (int j=xy[0]; j<=xy[2]; j++)
        			ans += sum[j-1][xy[3]-1];
        	} else {
        		for (int j=xy[0]; j<=xy[2]; j++)
        			ans += sum[j-1][xy[3]-1]-sum[j-1][xy[1]-2];
        	}
        	sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
