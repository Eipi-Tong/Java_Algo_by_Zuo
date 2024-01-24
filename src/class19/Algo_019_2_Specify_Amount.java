package class19;

import java.io.*;

/**
 * ClassName: Algo_019_2_Specify_Amount
 * Package: class19
 * CreateTime: 2024/1/22 22:01
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
public class Algo_019_2_Specify_Amount {
    public static void main(String[] args) throws IOException {
        // 把文件里的内容，load进来，保存在内存里，很高效，很经济，托管的很好
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 一个一个读数字
        StreamTokenizer in = new StreamTokenizer(br);
        // 提交答案的时候用的，也是一个内存托管区
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) { // 文件没有结束就继续
            // n，二维数组的行
            int n = (int) in.nval;
            in.nextToken();
            // m，二维数组的列
            int m = (int) in.nval;
            // 装数字的矩阵，临时动态生成
            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    in.nextToken();
                    mat[i][j] = (int) in.nval;
                }
            }
            out.println(Algo_019_1_Fill_Function.maxSumSubmatrix(mat, n, m));
        }
        out.flush();
        br.close();
        out.close();
    }
}
