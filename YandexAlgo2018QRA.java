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
            boolean[] chosen = new boolean[33];
            for (int i = 0; i < 10; ++i) {
                chosen[in.nextInt()] = true;
            }
            int n = in.nextInt();
            for (int i = 0; i < n; ++i) {
                int has = 0;
                for (int j = 0; j < 6; ++j) {
                    has += chosen[in.nextInt()] ? 1 : 0;
                }
                out.println(has > 2 ? "Lucky" : "Unlucky");
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
