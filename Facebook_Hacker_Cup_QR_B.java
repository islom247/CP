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
                int n = in.nextInt();
                char[][] board = new char[n][n];
                for (int i = 0; i < n; ++i) {
                    board[i] = in.next().toCharArray();
                }
                int min = Integer.MAX_VALUE;
                outer:
                for (char[] s : board) {
                    int rowMin = n;
                    for (char c : s) {
                        if (c == 'O') {
                            continue outer;
                        } else if (c == 'X') {
                            --rowMin;
                        }
                    }
                    min = Math.min(min, rowMin);
                }
                outer:
                for (int i = 0; i < n; ++i) {
                    int colMin = n;
                    for (int j =0; j < n; ++j) {
                        if (board[j][i] == 'O') {
                            continue outer;
                        } else if (board[j][i] == 'X') {
                            --colMin;
                        }
                    }
                    min = Math.min(min, colMin);
                }
                int totalSets = 0;
                outer:
                for (char[] s : board) {
                    int rowMin = n;
                    for (char c : s) {
                        if (c == 'O') {
                            continue outer;
                        } else if (c == 'X') {
                            --rowMin;
                        }
                    }
                    if (rowMin == min) {
                        ++totalSets;
                    }
                }
                outer:
                for (int i = 0; i < n; ++i) {
                    int colMin = n;
                    int ind = 0;
                    for (int j = 0; j < n; ++j) {
                        if (board[j][i] == 'O') {
                            continue outer;
                        } else if (board[j][i] == 'X') {
                            --colMin;
                        } else if (board[j][i] == '.') {
                            ind = j;
                        }
                    }
                    if (colMin == min) {
                        ++totalSets;
                    }
                    int temp = n;
                    for (char c : board[ind]) {
                        if (c == 'X') {
                            --temp;
                        }
                    }
                    if (temp == 1) {
                        --totalSets;
                    }
                }
                if (min == Integer.MAX_VALUE) {
                    out.println("Case #" + (t + 1) +": Impossible");
                } else {
                    out.println("Case #" + (t + 1) +": " + min + " " + totalSets);
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
                reader = new BufferedReader(new FileReader("xs_and_os_input.txt"));
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
