#include <stdio.h>
#include <time.h>

int main(void){
	//eg1.
	time_t lt;
	lt = time(NULL);
	printf(ctime(&lt));
	
	//eg2.
	time_t start,end;
	unsigned long t;
	
	start = time(NULL);
	for(t=0;t<1000000000;t++);
	end = time(NULL);
	printf("Loop used %10.10e seconds.\n", difftime(end,start));

	return 0;
}
