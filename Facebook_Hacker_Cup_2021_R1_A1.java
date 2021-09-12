import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        //PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        try {
            PrintWriter out = new PrintWriter("output.txt");
            solver.solve(in, out);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static class Solver {
        public void solve(InputReader in, PrintWriter out) {
            int T = in.nextInt();
            for (int t = 0; t < T; ++t) {
                int N = in.nextInt();
                String W = in.next();
                int total = 0;
                char prev = 'F';
                for (int i = 0; i < N; ++i) {
                    char cur = W.charAt(i);
                    if ((cur == 'X' || cur == 'O') && cur != prev) {
                        prev = cur;
                        ++total;
                    }
                }
                out.println("Case #" + (t + 1) + ": " + Math.max(0, total - 1));
            }
        }
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            //reader = new BufferedReader(new InputStreamReader(stream), 32768);
            try {
                reader = new BufferedReader(new FileReader("input.txt"));
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
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
