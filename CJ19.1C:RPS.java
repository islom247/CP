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
            int T = in.nextInt();
            outer:
            for (int t = 0; t < T; ++t) {
                int A = in.nextInt();
                int max_length = 0;
                String[] C = new String[A];
                for (int a = 0; a < A; ++a) {
                    C[a] = in.next();
                    max_length = Math.max(max_length, C[a].length());
                }
                StringBuilder sb = new StringBuilder();
                boolean[] eliminated = new boolean[A];
                for (int i = 0; i < max_length; ++i) {
                    int r = 0, p = 0, s = 0;
                    for (int a = 0; a < A; ++a) {
                        char c = C[a].charAt(i % C[a].length());
                        r += c == 'R' && !eliminated[a] ? 1 : 0;
                        p += c == 'P' && !eliminated[a] ? 1 : 0;
                        s += c == 'S' && !eliminated[a] ? 1 : 0;
                    }
                    if (r > 0 && p > 0 && s > 0) {
                        out.printf("Case #%d: %s\n", t + 1, "IMPOSSIBLE");
                        continue outer;
                    }
                    if (r > 0 && p > 0 && s == 0) {
                        sb.append('P');
                    }
                    if (r > 0 && s > 0 && p == 0) {
                        sb.append('R');
                    }
                    if (p > 0 && s > 0 && r == 0) {
                        sb.append('S');
                    }
                    if (r == A) {
                        sb.append('P');
                    }
                    if (p == A) {
                        sb.append('S');
                    }
                    if (s == A) {
                        sb.append('R');
                    }
                    for (int a = 0; a < A; ++a) {
                        char c = C[a].charAt(i % C[a].length());
                        if (c == 'R' && sb.charAt(i % sb.length()) == 'P') {
                            eliminated[a] = true;
                        } else if (c == 'P' && sb.charAt(i % sb.length()) == 'S') {
                            eliminated[a] = true;
                        } else if (c == 'S' && sb.charAt(i % sb.length()) == 'R') {
                            eliminated[a] = true;
                        }
                    }
                }
                out.printf("Case #%d: %s\n", t + 1, sb);
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
            String s;
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
