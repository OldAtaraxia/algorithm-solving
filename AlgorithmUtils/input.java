package AlgorithmUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class input {
    /*
    * 输入输出
    * BufferedReader可以读一行, 比Scanner快
    * */
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        reader.close();
    }
}
