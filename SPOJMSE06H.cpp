// Depois de ordenar as estradas por ordem decrescente de coordenada Oeste
// a BIT e usada para cada estrada r, verificar quais estradas com 
// coordenada Oeste inferior a de r, 
// tem coordenada Este menor que a de r, e assim intersetam r


// implementacao da BIT de https://www.topcoder.com/community/competitive-programming/tutorials/binary-indexed-trees/


#include <bits/stdc++.h>
using namespace std;

struct road {
  int x;
  int y;
};
typedef struct road Road;
Road roads[1010025];

bool compareRoads(Road x1, Road x2) {
  if(x1.x == x2.x) return (x1.y < x2.y);
  else return (x1.x < x2.x);
  }

long long BIT[1005];

long long get(int idx){
	long long sum = 0;
	while(idx>0){
		sum += BIT[idx];
		idx -= (idx&-idx);
	}
	return sum;
}

void update(int idx,int n){
	while(idx<=n){
		BIT[idx]++;
		idx += (idx & -idx);
	}
}

int main() {
  long long sum;
  int T;
  scanf("%d",&T);
  for(int i = 0 ; i < T ; i++) {
  //  vector <pair<int,int>> roads;
  int N,M,K;
  scanf("%d %d %d",&N,&M,&K);

    for(int j = 1 ; j <=M ; j++) {
      BIT[j] = 0;
    }
    for(int j = 0 ; j < K ; j++) {
      int a,b;
      scanf("%d %d",&a,&b);
      //roads.push_back(make_pair(a,b));
      roads[j].x = a;
      roads[j].y = b;
    }
    sort(roads,roads+K,compareRoads);
    sum = 0;
    
    for(int j = 0 ; j < K; j++) {
      sum = sum + get(M-roads[j].y);
      update(M-roads[j].y+1,M);
    }
    printf("Test case %d: %lld\n",(i+1),sum);
  }
  return 0;
}
