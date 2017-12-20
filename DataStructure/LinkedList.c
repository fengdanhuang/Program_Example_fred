#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>


#ifndef N
#define N 10
#endif

typedef struct Node{
	int data;
	struct Node *next;
}Node, *LinkedList;


LinkedList createLinkedList(int input[N]){
	LinkedList L = (LinkedList)malloc(sizeof(Node));
	L->data = 0;
	L->next = NULL;
//	printf ("%p\n", L); //print pointer value
	
	for (int i=N-1; i>=0; i--){//data is assigned as input order.
		LinkedList p = (LinkedList)malloc(sizeof(Node));
		p->data = input[i];
//		printf ("%d ", p->data);
		p->next = L->next;
		L->next = p;
	}	
	return L;	
}


bool getElement(LinkedList L, int i, int *e){
	LinkedList p = L;
	int j = 1;
	
	while ( p && j<i){
		p = p->next;
		j++;
	}
	if ( !p || j>i ) return false;
	
	*e = p->data;
	return true;
}



bool insertElement(LinkedList L, int i, int *e){
	LinkedList p = L;
	int j = 0;
	
	while (p && j<i-1){
		p = p->next;
		j++;
	}
	if (!p || j>i-1) return false;
	LinkedList s = (LinkedList) malloc(sizeof(Node));
	s->data = *e, 
	s->next = p->next;
	p->next = s;
	return true;
}


bool deleteElement(LinkedList L, int i, int *e){
	LinkedList p = L;
	int j = 0;

	while (p->next && j<i-1){
		p = p->next;
		j++;
	}
	if ( !(p->next) || j>i-1) return false;
	LinkedList q = p->next;
	p->next=q->next;
	*e = q->data;
	free(q);
	return true;
}

void printLinkedList(LinkedList p){
	while (p != NULL){
		printf("%d -> ", p->data);
		p = p->next;
	}
	printf("\n");		
}


void printElement(int index, int element){
	printf("The %dth element is %d\n", index, element);
}


int main(int argc, char** argv){
//	if (argc < 2){
//		fprintf(stderr, "Usage: Program_Name #_of_input_number(integer)\n");
//		exit(1);
//	}

	srand( (unsigned)time(NULL) );
	int input[N];
	printf("\nThe input data is:\n");
	for (int i=0; i<N; i++){
		input[i] = rand()%(1000-(-1000)+1) + 1;
		printf ("%d ", input[i]);
	}
	printf("\n");

	LinkedList L, p;
	L = createLinkedList(input); //create a linked list
//	printf("%p\n", L);//print pointer value

	printf("The linkedlist is :\n");
	printLinkedList(L);

	int e = 10;
	insertElement(L, 3, &e);
	insertElement(L, 6, &e);
	insertElement(L, 10, &e);	
	printLinkedList(L);


	deleteElement(L, 1, &e);
	printLinkedList(L);
	deleteElement(L, 10, &e);
	printLinkedList(L);
	
	int i = 5;
	getElement(L, i, &e);
	printElement(i, e);	
	
	return 0;
}
