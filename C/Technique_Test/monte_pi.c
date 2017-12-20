#include <stdio.h>
#include <stdlib.h>

#define SEED 35791246

int main(int argc, char*argv){
	
	int iteration=0;
	double x,y,z,pi;
	int i,count=0;//count:# of points in the 1st quadrant of unit circle
	
	
	//printf("RAND_MAX:%d\n",RAND_MAX);//test:check the value of RAND_MAX.
	//printf("rand1():%d\n",rand());//test:check the value of rand1()
	//printf("rand2():%d\n",rand());
	//printf("rand3():%d\n",rand());
	
	printf("Enter the number of iterations used to estimate pi:");
	scanf("%d",&iteration);
	
	//intialize random numbers
	srand(SEED);
	count=0;
	for(i=0;i<iteration;i++){
		x = (double)rand()/RAND_MAX;//printf("x-rand():%10d,RAND_MAX:%10d\n",rand(),RAND_MAX); 
		y = (double)rand()/RAND_MAX;//printf("y-rand():%10d,RAND_MAX:%10d\n",rand(),RAND_MAX);
		z = x*x+y*y;
		if (z<=1) count++;
	}

	pi = (double)count/iteration*4;
	printf("count=%d, # of trials=%d, estimate of pi is %g\n",count, iteration, pi);

	return 0;
}
