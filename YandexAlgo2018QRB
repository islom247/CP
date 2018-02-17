import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }
    static class Solver {
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] rc = new int[2 * n][n];
            for (int i = 0; i < 2 * n; ++i) {
                for (int j = 0; j < n; ++j) {
                    rc[i][j] = in.nextInt();
                }
            }
            int[] firs_row = new int[n];
            int[] first_col = new int[n];
            int ind = 0;
            for (int i = 0; i < 2 * n; ++i) {
                for (int j = 0; j < 2 * n; ++j) {
                    if (i != j && rc[i][0] == rc[j][0]) {
                        firs_row = Arrays.copyOf(rc[i], n);
                        first_col = Arrays.copyOf(rc[j], n);
                        ind = i;
                        break;
                    }
                }
            }
            for (int t : firs_row) {
                out.print(t + " ");
            }
            for (int i = 1; i < n; ++i) {
                for (int j = 0; j < 2 * n; ++j) {
                    if (j != ind && first_col[i] == rc[j][0]) {
                        for (int k = 0; k < n; ++k) {
                            out.print(rc[j][k] + " ");
                        }
                    }
                }
            }
        }
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public String nextLine() {
            String s = "";
            try {
                s = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return s;
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
