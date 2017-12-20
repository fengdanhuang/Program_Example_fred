#include <stdio.h>
#include <signal.h>

void sighandler(int signum){
	printf("SIGINT received. Inside sighandler.\n");
}

int main(){
	signal(SIGINT, (void*)sighandler);
	while(1)
		printf("Program running!");
	return 0;
}
