// O valor pretendido e somado em todos os elementos de l para a direita,
// depois subtraido de todos os elementos de r para a direita,
// ficando assim a soma so no range pretendido

// implementacao da BIT de https://www.topcoder.com/community/competitive-programming/tutorials/binary-indexed-trees/


#include <bits/stdc++.h>
using namespace std;

long long BIT[50000];
int n;


int read(int idx) {
  int sum = 0;
  while (idx > 0) {
    sum += BIT[idx];
    idx -= (idx & -idx);
  }
  return sum;
}

void update(int idx, int val) {
  while (idx <= n) {
    BIT[idx] += val;
    idx += (idx & -idx);
  }
}

int main () {
  int t,u,l,r,val,q, index;
  scanf("%d\n",&t);
  for(int i = 0 ; i < t ; i++){
    scanf("%d %d\n",&n,&u);
    for(int j = 0 ; j <= (n+1) ; j++){
      BIT[j] = 0;
    }
    for(int j = 0 ; j < u;j++){
      scanf("%d %d %d\n",&l,&r,&val);
      update(l+1,val);
      update(r+2,(-1 * val));
    }
    scanf("%d\n",&q);
    for(int j = 0 ; j < q ; j++){
      scanf("%d\n",&index);
      printf("%d\n",read(index+1));
    }
  }
  return 0;
}
