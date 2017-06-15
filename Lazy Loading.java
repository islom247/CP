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
            int t = in.nextInt();
            for (int i = 0; i < t; ++i) {
                int n = in.nextInt();
                int[] w = new int[n];
                for (int j = 0; j < n; ++j) {
                    w[j] = in.nextInt();
                }
                Arrays.sort(w);
                int bags = 1, ind = 0;
                int trips = 0;
                boolean[] b = new boolean[n];
                for (int j = n - 1; j >= 0; --j) {
                    if (!b[j]) {
                        b[j] = true;
                        ++trips;
                    }
                    while (w[j] * bags < 50 && !b[ind]) {
                        b[ind++] = true;
                        ++bags;
                    }
                    bags = 1;
                    int max = -(int)1e9;
                    for (int k = ind; k < j; ++k) {
                        if (!b[k] && w[k] > max) {
                            max = w[k];
                        }
                    }
                    if (max * (j - ind) < 50) {
                        break;
                    }
                }
                out.printf("Case #%d: %d\n", i + 1, trips);
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