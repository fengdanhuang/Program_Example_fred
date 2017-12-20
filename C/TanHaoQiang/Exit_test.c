


int main(int argc, char*argv[]){
#ifdef EE 
	#include <stdlib.h>	
	exit(100);
#else
	#ifdef _EE
		#include <unistd.h>
		_exit(50);
	#endif
#endif
	return 15.5;


}
