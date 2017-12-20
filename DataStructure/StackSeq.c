#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>


#define N 10

typedef struct StackNode{
	int data;
	struct StackNode *next;
}StackNode;


typedef struct Stack{
	StackNode *base;
	StackNode *top;
	int stacksize;
}Stack;

/*
void createStack(){
	Stack S->base = (StackNode)malloc(sizeof(StackNode));
	S->base
}*/


void initStack(int S[N]){
	
	


bool Push(Stack S, StackNode e){
	if (S->top == S->base){
		fprintf(stderr, "The stack overflow!\n");
		return false;
//		exit(1);
	}
	*(S->top) = e;
	S->top++;
	return true;
}


bool Pop(Stack S, StackNode e){
	if (S->top == S->base) return false;
	S->top = S->top - 1;
	e = *(S->top);
	return true;
}

	
int main(int argc, char **argv){
	int S[N];
		

	return 0;
}
