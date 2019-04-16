import java.util.Scanner;

public class FindMissing {

    int[] findMissing(int[] a, int[] b, int min_b, int max_b){
        int[] result = new int[max_b+1];
        int[] final_res = new int[result.length];
        
        for(int i=0; i<b.length; i++){
            result[b[i]] += 1;
        }
        for(int j=0; j<a.length; j++){
            result[a[j]] -= 1;
        }
        int pos = 0;
        for(int k=0; k<result.length; k++){
            if(result[k]>0){
                final_res[pos] = k;
                pos++;
            }
        }
        return final_res;
    } 
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int[] a; int[] b;
        int max_b = Integer.MIN_VALUE; int min_b = Integer.MAX_VALUE;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = scan.nextInt();
        }
        int m = scan.nextInt();
        b = new int[m];
        for(int j=0; j<m; j++){
            b[j] = scan.nextInt();
            if(b[j] > max_b)
                max_b = b[j];
            if(b[j] < min_b)
                min_b = b[j];
        }
        FindMissing sol = new FindMissing();
        int[] result = sol.findMissing(a, b, min_b, max_b);
        for(int k=0; k<result.length; k++){
            if(result[k] == 0)
                break;
            System.out.print(result[k]+" ");
        }
    }
}