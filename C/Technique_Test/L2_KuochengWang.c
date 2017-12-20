#include <stdio.h>

struct mynode{
	double x;
	double y;
	int *ival;
}

struct mynode my_node;

int main(){
	struct mynode *st_ptr = &my_node; 
	st_ptr->x=1;st_ptr_y=2;
	st_prt->ival={325424};
	printf("ival=%d", *ival);
	printf("x= %d",x);
	printf("y= %d",y);
	
	return 0;
}

