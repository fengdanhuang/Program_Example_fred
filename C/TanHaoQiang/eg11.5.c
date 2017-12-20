#include <string.h>
#include <stdio.h>

#define FORMAT "%d\n%s\n%f\n%f\n%f\n"

struct student{
	int num;
	char name[20];
	float score[3];
};//notice:semicolon is necessary for defining a structure.

void print(struct student stu){
	printf(FORMAT,stu.num,stu.name,stu.score[0],stu.score[1],stu.score[2]);
	printf("\n");
}

void print_pointer(struct student *p){
	printf(FORMAT,p->num,p->name,p->score[0],
					p->score[1],
					p->score[2]);
	printf("\n");
}
