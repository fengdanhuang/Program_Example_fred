#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>

#define N 10

typedef struct BiTNode{
	int data;
	struct BiTNode *lchild, *rchild;
}BiTNode, *BiTree;


bool createTree(BiTree T){


}

void visit(int data){
	printf(" %d is visited.\n", data);
}


bool PreOrder(BiTree T){
	if (!T){
		visit(T->data);
		PreOrder(T->lchild);
		PreOrder(T->rchild);
	}
}


bool InOrder(BiTree T){
	if(!T){
		InOrder(T->lchild);
		visit(T->data);
		InOrder(T->rchild);
	}
}

/*
bool InOrderNonRecursive(BiTree T){
	InitStack(S);
	Push(S,T);
	while(!StackEmpty(S)){
		while (GetTop(S,p))
			push(S, p->lchild);
		pop(s);
		if(!StackEmpty(S)){
			pop(S,p);
			visit(p->data);
			push(S,p->rchild);
		}
	}
}
*/



int main(int argc, char**agrv){
		

	return 0;
}
