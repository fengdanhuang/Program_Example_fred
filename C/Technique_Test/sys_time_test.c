#include <stdio.h>
#include <sys/time.h>

int main(int argc, char*argv[]){
	
	struct timeval timev;
	gettimeofday(&timev,NULL);
	printf("Current time:%f, %f\n", timev.tv_sec, timev.tv_usec);
	gettimeofday(&timev,NULL);
	printf("Current time:%f, %f\n", timev.tv_sec, timev.tv_usec);
	gettimeofday(&timev,NULL);
	printf("Current time:%f, %f\n", timev.tv_sec, timev.tv_usec);


	
	return 0;
}
