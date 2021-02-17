// Ordenar os numeros por ordem decrescente de frequencia, recorrendo a um Linkedhashmap
// que mapeia para cada numero, a sua frequencia

import java.util.*;

 class RKS2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    long C  = sc.nextLong();
    LinkedHashMap<Long,Integer> map = new LinkedHashMap<Long,Integer>();
    for(int i = 0 ; i < N ; i++) {
      long n = sc.nextLong();
      int temp;
      if (map.containsKey(n)){
        temp = map.get(n)+1;
        map.put(n,temp);
      }
      else {
      map.put(n,1);
      }
    }
    while(!map.isEmpty()){
      long max = Collections.max(map.values());
      ArrayList<Long> maxL = new ArrayList<Long>();
      // iterar pelos elementos, quando encontrar uma key cujo value é max
      // imprimir a key value vezes e depois remove-la
      for(Map.Entry<Long,Integer> entry : map.entrySet()){
        if(entry.getValue()==max) {
          for(int i = 0 ; i < entry.getValue();i++){
            System.out.print(entry.getKey()+ " ");
          }
          maxL.add(entry.getKey());
        }
      }
      for (int j = 0 ; j < maxL.size(); j++){
        map.remove(maxL.get(j));
      }
    }
  }
}
