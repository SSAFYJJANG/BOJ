import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, check = 0;
	static boolean visit[];
	static List<Integer>[] list;
	
	static void f(int p, int cnt) {
		if (cnt == 4) {
			check = 1;
			return;
		}
		
		for (int f: list[p]) {
			if (!visit[f]) {
				visit[f] = true;
				f(f, cnt+1);
				visit[f] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[N];
        for (int i=0; i<N; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for (int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	list[a].add(b);
        	list[b].add(a);
        }

        visit = new boolean[N];
        for (int i=0; i<N; i++) {
        	visit[i] = true;
            f(i, 0);
            visit[i] = false;
            
        	if (check == 1) {
        		break;
        	}
        }
     
        System.out.println(check);
    }
}