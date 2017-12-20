
//A number becomes a square number when adding 100. It will also become a square number when adding 268. What is this number?

#include <stdio.h>
#include <math.h>

int main(){

	long int i,x,y,z;

	for (long int i=1;i<100000;i++){ 
		long int x=sqrt(i+100); 
		long int y=sqrt(i+268); 
		if(	x*x	==	i+100	&&	y*y	==	i+268) printf("\n%ld\n",i);
	}
	
	return 0;
}
