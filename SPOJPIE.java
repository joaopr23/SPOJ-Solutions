// Pesquisa binaria para o maior volume por fatia para o qual é possivel que todos os
// amigos tenham uma fatia desse volume

import java.util.*;
import java.lang.Math;
import java.io.*;
import java.util.StringTokenizer;


// FastScanner
// Pedro Ribeiro (DCC/FCUP)
class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner(InputStream stream) {
	br = new BufferedReader(new InputStreamReader(stream));
    }

    String next() {
	while (st == null || !st.hasMoreElements()) {
	    try {
		st = new StringTokenizer(br.readLine());
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	return st.nextToken();
    }

    int nextInt() {
	return Integer.parseInt(next());
    }

    long nextLong() {
	return Long.parseLong(next());
    }

    double nextDouble() {
	return Double.parseDouble(next());
    }

    String nextLine(){
	String str = "";
	try {
	    str = br.readLine();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return str;
    }

}

// FastPrint (remember to call FastPrint.out.close() at the end)
// Pedro Ribeiro (DCC/FCUP)
class FastPrint {
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
}

class SPOJPIE {

  public static Double bSearch(Double low, Double high, int T, int F, Double[] vT) {
    Double middle = low + (high-low)/2;
    int iteration = 0;

    while (iteration <= 50) {
      int fSum = 0;
      middle = low + ((high-low)/2);

      for (int i = 0 ; i < T ; i++) {
        fSum = (int)(fSum + (vT[i] / middle));
      }

      //if(fSum == F) return middle;
      if(fSum >= F) low = middle;
      else high = middle;

      iteration++;
    }
    return middle;
  }

  public static void main(String[] args) {

    FastScanner sc = new FastScanner(System.in);
    int T, F;
    int cases = sc.nextInt();
    Double r, low, high;

    for (int i = 0 ; i < cases ; i++) {
      //Tartes
      T = sc.nextInt();
      //Amigos
      F = sc.nextInt()+1;

      Double[] vT = new Double[T];
      for (int j = 0 ; j < T ; j++) {
        r = sc.nextDouble();
        vT[j] = Math.PI * (r*r);
      }

      Arrays.sort(vT);
      low = 0.0;
      high = vT[vT.length-1];
      FastPrint.out.println((double)Math.round(bSearch(low, high, T, F, vT) * 10000d) / 10000d);
    }
    FastPrint.out.close();
  }
}
