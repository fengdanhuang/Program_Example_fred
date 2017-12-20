#include<stdio.h>

int main(){
	int i, j, row = 0, column =0, max;
		
	int a[3][4] = {
			{1,2,3,4},
			{9,8,7,6},
			{-10, 10, -5, 2}};

	max = a[0][0];
	
	for(i=0; i<3; i++)
		for(j=0; j<4; j++)
			if (max < a[i][j]){
				max = a[i][j];
				row = i;
				column = j;
			}

	printf("The maximum value is: %d\n", max);
	printf("The maximum value is: a[%d][%d]\n", row, column);

	return 0;
}
			
