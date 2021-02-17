// Metodo da biseccao atraves de pesquisa binaria 
// para procurar o 'x' que da a expressao o valor 'c'

import java.util.*;
import java.lang.Math;


 class SPOJTRIGALGE {

  public static Double func (Double A, Double B, Double x) {
    return A*x + B * Math.sin(x);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    Double A, B, C;
    Double lowerL, upperL, x;
    int iterations =10000;
    for(int i = 0 ; i < T ; i++){
      A = sc.nextDouble();
      B = sc.nextDouble();
      C = sc.nextDouble();


      lowerL=-1200000.0;
      upperL=200000.0;

      for (int j = 0 ; j < iterations ; j++) {
      //  System.out.println(lowerL + " - " + upperL);
        if(func(A,B,((upperL+lowerL)/2))==C) {
          //System.out.println("1");
          System.out.println(upperL/2);
          break;
        }
        else if (func(A,B,((upperL+lowerL)/2))<C) {
        //  System.out.println(func(A,B,upperL/2) + " < " + C);
        //  System.out.println("2");
          lowerL=lowerL + ((upperL-lowerL)/2);
        }
        else if (func(A,B,((upperL+lowerL)/2))>C){
        //  System.out.println("3");
          upperL=upperL - ((upperL-lowerL)/2);
        }
      }

      //imprimir
      System.out.println((double)Math.round(upperL * 1000000d) / 1000000d);
    }
  }
}
