#include <stdio.h>

int main(){

	int r[7];
//	r[1000] = 0;
	printf("r[100]=%d\n", r[100]);

	int m = 7;
	int rr[m];//variable could be used to define array
	for(int i=0; i<m; i++){
		rr[i] = 2;
		printf("rr[%d]=%d\n", i, rr[i]);
	}
	
	return 0;
}
