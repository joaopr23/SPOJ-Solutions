// Pesquisa ternaria para encontrar a altura para a qual o custo da alteracao das alturas 
// e minimo

import java.util.*;

class K12 {

  public static long cost(int[] h, int[] c, int heigh) {
   long cost = 0;
    for(int i = 0 ; i < h.length ; i++) {
      cost = cost + (Math.abs(h[i]-heigh)*c[i]);
    }
    return cost;
  }

  public static int tSearch(int low, int high, int[] h, int[] c) {

    while(low<=high) {
      int middle1, middle2;

      if(low==high) break;

      middle1 = low + (high-low)/3;
      middle2 = high - (high-low)/2;

      if(cost(h,c,middle1) > cost(h,c,middle2)) {
        low = middle1+1;
      }
      else high = middle2-1;
    }
    return low;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int i = 0 ; i < T ; i++) {
      int n = sc.nextInt();
      int[] h = new int[n];
      int[] c = new int[n];
      int maxH = 0;
      int minH= 10010;
      int th;
      for(int j = 0 ; j < n ; j++){
        th = sc.nextInt();
        h[j] = th;
        if (th>maxH) maxH=th;
        if( th<minH) minH =th;
      }
      for(int j = 0 ; j < n ; j++){
        c[j] = sc.nextInt();
      }

      int high= maxH;


      System.out.println(cost(h,c,tSearch(0, high, h,c)));

    }
  }
}
