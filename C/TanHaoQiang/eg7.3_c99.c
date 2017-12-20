#include <stdio.h>

int main(){
	int a[11];
	
	printf("Please input 10 numbers:\n");
	
	for (int i=1; i<11; i++)
		scanf("%d ", &a[i]);
	printf("\n");
	
	for(int j=1; j<=9; j++)
		for (int i=1; i<=10-j; i++)
			if (a[i] > a[i+1]) { int t=a[i]; a[i]=a[i+1]; a[i+1]=t;}
	printf("The sorted numbers:\n");
	for (int i=1; i<11; i++)
		printf("%d ", a[i]);
}
