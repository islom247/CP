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
            for (int t = 0; t < T; ++t) {
                int n = in.nextInt();
                String[] s = new String[n];
                TreeMap<String, Integer> suff_count = new TreeMap<String, Integer>(
                        new Comparator<String>() {
                            @Override
                            public int compare(String s1, String s2) {
                                if (s1.length() > s2.length()) {
                                    return 1;
                                } else if (s1.length() < s2.length()) {
                                    return -1;
                                } else {
                                    return s1.compareTo(s2);
                                }
                            }
                        });
                for (int i = 0; i < n; ++i) {
                    s[i] = in.next();
                    for (int j = s[i].length() - 1; j >= 0; --j) {
                        String suffix = s[i].substring(j);
                        if (suff_count.containsKey(suffix)) {
                            suff_count.put(suffix, suff_count.get(suffix) + 1);
                        } else {
                            suff_count.put(suffix, 1);
                        }
                    }
                }
                long max = 0;
                Map<String, Integer> info = new HashMap<>();
                for (String key : suff_count.descendingKeySet()) {
                    int count = suff_count.get(key);
                    if (key.length() == 1 && !info.containsKey(key)&& count > 1) {
                        max += 2;
                    }
                    if (key.length() == 1 && info.containsKey(key) && count > info.get(key) + 1) {
                        max += 2;
                    }
                    if (key.length() > 1 && !info.containsKey(key) && !info.containsKey(key.substring(1)) && count > 1) {
                        max += 2;
                        info.put(key.substring(1), 2);
                    } else if (key.length() > 1 && !info.containsKey(key) && info.containsKey(key.substring(1)) && count > 1) {
                        max += 2;
                        info.put(key.substring(1), 2 + info.get(key.substring(1)));
                    }
                    if (key.length() > 1 && info.containsKey(key) && !info.containsKey(key.substring(1)) && count > info.get(key) + 1) {
                        max += 2;
                        info.put(key, 2 + info.get(key));
                    } else if (key.length() > 1 && info.containsKey(key) && info.containsKey(key.substring(1)) && count >  info.get(key) + 1) {
                        max += 2;
                        info.put(key, 2 + info.get(key));
                        info.put(key.substring(1), 2 + info.get(key.substring(1)));
                    }
                }
                out.printf("Case #%d: %d\n", t + 1, max);
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
