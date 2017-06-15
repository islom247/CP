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
            PrintWriter out = new PrintWriter("B-large-practice.out");
            solver.solve(in, out);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static class Solver {
        public void solve(InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int i = 0; i < t; ++i) {
                long n = in.nextLong();
                String s = "" + n;
                int[] c = new int[s.length()];
                for (int j = 0; j < s.length(); ++j) {
                    c[j] = Character.getNumericValue(s.charAt(j));
                }
                while (!ok(c)) {
                    c = change(c);
                }
                out.print("Case #" + (i + 1) + ": ");
                for (int j = 0; j < c.length; ++j) {
                    if (j == 0 && c[j] == 0) {
                        continue;
                    } else {
                        out.print(c[j]);
                    }
                }
                out.println();
            }
        }
        static int[] change(int[] c) {
            for (int j = 1; j < c.length; ++j) {
                if (c[j] < c[j - 1]) {
                    --c[j - 1];
                    for (int k = j; k < c.length; ++k) {
                        c[k] = 9;
                    }
                }
            }
            return c;
        }
        static boolean ok(int[] c) {
            for (int i = 1; i < c.length; ++i) {
                if (c[i] < c[i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            //reader = new BufferedReader(new InputStreamReader(stream), 32768);
            try {
                reader = new BufferedReader(new FileReader("B-large-practice.in"));
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