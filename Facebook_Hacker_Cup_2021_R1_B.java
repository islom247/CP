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
            caseLoop:
            for (int t = 0; t < T; ++t) {
                int N = in.nextInt();
                int M = in.nextInt();
                int A = in.nextInt();
                int B = in.nextInt();
                if (A <= N + M - 2 || B <= N + M - 2) {
                    out.println("Case #" + (t + 1) + ": Impossible");
                    continue caseLoop;
                }
                int[][] grid = new int[N][M];
                for (int i = 0; i < N; ++i) {
                    for (int j = 0; j < M; ++j) {
                        if (i == 0 && j == 0) {
                            grid[i][j] = A - (N + M - 2);
                        } else if (i == 0 && j == M - 1) {
                            grid[i][j] = B - (N + M -2);
                        } else {
                            grid[i][j] = 1;
                        }
                    }
                }
                out.println("Case #" + (t + 1) + ": Possible");
                for (int[] arr : grid) {
                    for (int wait : arr) {
                        out.print(wait + " ");
                    }
                    out.println();
                }
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
