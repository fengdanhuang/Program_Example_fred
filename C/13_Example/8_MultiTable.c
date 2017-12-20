
//Print 9 * 9 multiplication table

#include <stdio.h>


int main(){

	int i,j,result;
	printf("\n");
	for (i=11;i<20;i++){ 
		for(j=11;j<20;j++){
			result=i*j;
			printf("%d*%d=%d ", i, j, result);
		}
		printf("\n");
	}
	
	return 0;
}
