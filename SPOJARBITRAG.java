// Aplicacao do algortimo de Floyd Warshall a um grafo cujos vertices representam uma moeda
// e as arestas o cambio entre moedas
// Se a distancia de uma moeda a si mesma for superior a 1, 
// encontramo-nos perante um caso de arbitrage

import java.util.*;
 class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int cCounter = 0;

    while(true) {
      cCounter++;
      int n = sc.nextInt();
      if(n==0) break;

      double[][] distance = new double[n][n];

      TreeMap<String, Integer> map = new TreeMap<String, Integer>();

      int counter = 0;

      sc.nextLine();

      for(int i = 0 ; i < n ; i++) {
        String cName = sc.nextLine();
        //System.out.println(cName);
        map.put(cName,counter);
        counter++;
      }

      int m = sc.nextInt();
      sc.nextLine();

      for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < n ; j++) {
          distance[i][j] = 0.0;
        }
      }

      for(int i = 0 ; i < m ; i++) {
        String a = sc.next();
        double eRate = Double.parseDouble(sc.next());
        String b = sc.next();
      //  System.out.println(a);
        distance[map.get(a)][map.get(b)] = eRate;
      //    System.out.println("distance["+map.get(a)+"]["+map.get(b)+"]= "+eRate);
        //System.out.println("aresta de " + a + " para " + b + " com custo " + eRate);
      }

      for(int k = 0 ; k < n ; k++) {
        for(int i = 0 ; i < n ; i++) {
          for(int j = 0 ; j < n ; j++) {
            if (distance[i][j] < (distance[i][k] * distance[k][j]))
              distance[i][j] = distance[i][k] * distance[k][j];
          }
        }
      }
      int flag = 0;
      for(int i = 0 ; i < n ; i++) {
      //  System.out.println(distance[i][i]);
        if(distance[i][i] > 1.0) {
          System.out.println("Case " + cCounter + ": Yes");
          flag = 1;
          break;
        }
      }
      if (flag == 0) System.out.println("Case " + cCounter + ": No");
    }
  }
}
