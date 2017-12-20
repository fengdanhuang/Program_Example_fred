//Print the Narcissistic Number, which is a number that it equals to a sum of three digit number's qubic.

#include <stdio.h>

int main(){

	int i,j,k,n;
	printf("'water flower'number is:");

	for(n=100;n<1000;n++){
		i=n/100;//get ones
		j=n/10%10;//get tenth digits
		k=n%10;//get hundredth digits
		if(i*100+j*10+k==i*i*i+j*j*j+k*k*k){
			printf("%-5d",n);
		}
	}
	printf("\n");
	
	return 0;
}
