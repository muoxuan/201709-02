import java.util.*;
public class Main {
    public static void main(String[] args) {
        int n = 0;
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        int [] keybox = new int [n+1];
        for(int i = 0; i < n+1; i++){
            keybox[i] = i;
        }
        int k = 0;
        k = reader.nextInt();
        int [][] use = new int[3][k];
        int max = 0;
        for(int i = 0; i < k; i++){
            use[0][i] = reader.nextInt();
            use[1][i] = reader.nextInt();
            use[2][i] = reader.nextInt() + use[1][i];
            if(max < use[2][i]){
                max = use[2][i];
            }
        }
        for(int i = 0; i < k - 1; i++){
            for(int j = i + 1; j < k; j++){
                if(use[1][i] > use [1][j]){
                    for(int l = 0; l < 3; l++) {
                        int m = use[l][i];
                        use[l][i] = use[l][j];
                        use[l][j] = m;
                    }
                }
            }
        }
        for(int time = 0; time <= max; time++ ){
            int huan = 0;
            for(int i = 0; i < k; i++){
                if(use[2][i] == time){
                    huan++;
                }
            }
            if(huan > 0) {
                int[] h = new int[huan];
                int h1 = 0;
                for (int i = 0; i < k; i++) {
                    if (use[2][i] == time) {
                        h[h1] = use[0][i];
                        h1++;
                    }
                }
                for (int i = 0; i < huan - 1; i++) {
                    for (int j = i + 1; j < huan; j++) {
                        if (h[i] > h[j]) {
                            int m = h[i];
                            h[i] = h[j];
                            h[j] = m;
                        }
                    }
                }
                int h2 = 0;
                for (int i = 1; i <= n; i++) {
                    if (keybox[i] == -1) {
                        keybox[i] = h[h2];
                        h2++;
                        if (h2 == huan) {
                            break;
                        }


                    }
                }
            }

            for(int i = 0; i < k; i++){
                if(use[1][i] == time){
                    for(int j = 1; j <= n; j++){
                        if(keybox[j] == use[0][i]){
                            keybox[j] = -1;
                            break;
                        }
                    }
                }
            }


        }
        for(int i = 1; i <= n; i++){
            System.out.print(keybox[i] + " ");
           // System.out.println(use[0][i] + " " + use[1][i] + " " + use[2][i] + " ");
        }
    }
}
