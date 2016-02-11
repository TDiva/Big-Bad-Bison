package main;

import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
import static java.util.stream.Collectors.joining;

public class InOutService {

    public static final String OUT_DELIMITER = " ";

    BufferedReader in;
    PrintWriter out;

    // uses space, tab, new line, etc. as delimiter
    StringTokenizer tok = new StringTokenizer("");

    public InOutService(String filename) {
        try {
            in = new BufferedReader(new FileReader(filename + ".in"));
            out = new PrintWriter(filename + ".out");
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    public InOutService(String in, String out) {
        try {
            this.in = new BufferedReader(new FileReader(in));
            this.out = new PrintWriter(out);
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    public String readLine() throws IOException {
        if (tok.hasMoreTokens())
            return tok.nextToken("\n").trim();
        tok = new StringTokenizer("");
        return in.readLine();

    }

    public String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    public int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    public long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    public double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    public boolean readBoolean() throws IOException {
        return Boolean.valueOf(readString());
    }

    public void saveLine(String s) {
        out.write(s + "\n");
    }

    public void saveLine(Object... arg) {
        out.write(Arrays.asList(arg).stream().map(o -> o.toString()).collect(joining(OUT_DELIMITER)) + "\n");
    }

    public void saveLineWithDelimiter(String del, Object... arg) {
        out.write(Arrays.asList(arg).stream().map(o -> o.toString()).collect(joining(del)) + "\n");
    }

    public void close() {
        try {
            in.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}