#include <stdio.h>
#include <unistd.h>
#include <sys/syscall.h>

int main(int argc, char *argv[]){
	
	long ID1,ID2;
	ID1 = syscall(SYS_getpid);
	printf("syscall(SYS_getpid)=%ld\n", ID1);

	ID2 = getpid();
	printf("getpid=%ld\n",ID2);

	return 0;
}
