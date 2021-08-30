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
            PrintWriter out = new PrintWriter("consistency_chapter_1_output.txt");
            solver.solve(in, out);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static class Solver {
        public void solve(InputReader in, PrintWriter out) {
            int T = in.nextInt();
            String vowels = "AEIOU";
            for (int t = 0; t < T; ++t) {
                String s = in.next();
                Set<Character> v = new HashSet<>();
                Set<Character> c = new HashSet<>();
                Map<Character, Integer> freq = new HashMap<>();
                int totalVowels = 0;
                int totalCons = 0;
                int mostFreqVow = 0;
                int mostFreqCons = 0;
                for (int i = 0; i < s.length(); ++i) {
                    char cur = s.charAt(i);
                    if (!freq.containsKey(cur)) {
                        freq.put(cur, 1);
                    } else {
                        freq.put(cur, freq.get(cur) + 1);
                    }
                    if (vowels.contains("" + cur)) {
                        v.add(cur);
                        ++totalVowels;
                        mostFreqVow = Math.max(freq.get(cur), mostFreqVow);
                    } else {
                        c.add(cur);
                        ++totalCons;
                        mostFreqCons = Math.max(freq.get(cur), mostFreqCons);
                    }
                }
                String result = "Case #" + (t + 1) + ": ";
                if ((v.size() == 1 && c.size() == 0 )|| (c.size() == 1 && v.size() == 0)) {
                    result += 0;
                } else if (v.size() == 1 && c.size() == 1) {
                    result += Math.min(totalVowels, totalCons);
                } else if (v.size() == 1 && c.size() != 1) {
                    result += Math.min(totalVowels + (totalCons - mostFreqCons) * 2, totalCons);
                } else if (v.size() != 1 && c.size() == 1) {
                    result += Math.min(totalCons + (totalVowels - mostFreqVow) * 2, totalVowels);
                } else {
                    result += Math.min(totalVowels + (totalCons - mostFreqCons) *  2, totalCons + (totalVowels - mostFreqVow) * 2);
                }
                out.println(result);
            }
        }
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            //reader = new BufferedReader(new InputStreamReader(stream), 32768);
            try {
                reader = new BufferedReader(new FileReader("consistency_chapter_1_input.txt"));
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
