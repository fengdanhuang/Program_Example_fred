//#include <stdio.h>
#include <math.h>	//used for eg8.6
#include "eg8.21.h"

float f(float x){
	float y;
	y = pow(x,3) - 5*pow(x,2) + 16*x - 80;//need command: gcc -lm XX.c to link the <math.h> library.
	return y;
}

float xpoint(float x1, float x2){ //used for getting the intersection point of x axis and string
	float intersection_x;
	intersection_x = (x1*f(x2)-x2*f(x1))/(f(x2)-f(x1));
	return intersection_x;
}

float root(float x1, float x2){
	float x, y, y1;
	y1 = f(x1);
	do{
		x = xpoint(x1, x2);
		y = f(x);
		if (y*y1 > 0){
			x1=x; y1=y;
		}else{
			x2=x;
		} 
	}while(fabs(y) >= 0.0001);
	return x;
}

age(int n){//this is the function belonged to eg8.7
	int c;
	if (n==1) c=10;
	else c=age(n-1)+2;
	return c;
}

#include <stdio.h>

float factorial(int n){//eg8.9 calculating the factorial. eg8.8
	float f;
	if(n<0) printf("n<0, data error!\n");
	else if (n==0 || n==1) f=1;
	else f = factorial(n-1)*n;
	return f;
}

void move(char x, char y){//eg8.8 hanoi problem
	printf("%c --> %c\n", x, y);
}

void hanoi(int n, char one, char two, char three){//one, two, three means three bottom
	if (n==1) move(one, three);
	else{
		hanoi(n-1, one, three, two);
		move(one, three);
		hanoi(n-1, two, one, three);
	}
}

float average(float array[10]){//eg8.11, get the average grade of the students
	int i;
	float aver, sum=array[0];
	for(i=1;i<10;i++)
		sum += array[i];
	aver=sum/10;
	return aver;
}

float average812(float array[], int n){//eg8.12
	int i;
	float aver, sum=array[0];
	for(i=1;i<n;i++)
		sum += array[i];
	aver=sum/n;
	return aver;
}

#include <stdio.h>

void selection_sort1(int array[], int n){//eg8.13 selection_sort. pass the array name and its size
	//method1:using k to record the position of the minimun number in each iteration
	int i,j,k,t,exchange=0;//comp is used to record the number of exchange.
	for(i=0; i<n-1; i++){
		k=i;
		for(j=i+1; j<n; j++)
			if (array[j]<array[k]) k=j;
		t=array[k];array[k]=array[i];array[i]=t;exchange++;
	}
	printf("The total exchange number for method 1 is:%d\n", exchange);
}

void selection_sort2(int array[], int n){//eg8.13 selection_sort.
	//method2: No using k to record the position of the minimum number
	int i,j,t,exchange=0;
	for(i=0;i<n-1;i++)
		for(j=i+1;j<n;j++)
			if (array[j]<array[i]){
				t=array[j];array[j]=array[i];array[i]=t;exchange++;
			}
	printf("The total exchange number for method 2 is:%d\n",exchange);
}


max_value(int array[][4]){//eg8.14, about 2D array
	int i,j,k,max;
	max=array[0][0];
	for(i=0;i<3;i++)
		for(j=0;j<4;j++)
			if(array[i][j]>max) max=array[i][j];
	return max;
}

//eg8.15
float Max=0, Min=0;//global variance
float average815(float array[], int n){//formal parameter and its size
	int i;
	float aver,sum=array[0];
	Max=Min=array[0];
	for(i=1;i<n;i++){
		if(array[i]>Max) Max=array[i];
		else if (array[i]<Min) Min=array[i];
		sum += array[i];
	}
	aver=sum/n;
	return aver;
}

//eg8.16. The global variance has the same name with the local variance
int ga=3,gb=5;
max_global(int a, int b){
	int c;
	c=a>b?a:b;
	return c;
}


static_variance_usage(int a){//eg8.17.about static variance
	auto int b=0;
	static int c=3;
	b=b+1;
	c=c+1;
	return a+b+c;
}

int static_factorial(int n){//eg8.18.using static variance to calculate factorial
	static int f=1;
	f = f*n;
	return f;
}

int register_factorial(int n){//eg8.19. using register variance to calculate factorial

	register int i, f=1;
	for(i=1;i<=n;i++)
		f=f*i;
	return f;
}


int extern_max(int x, int y){//eg8.20. extern variance usage
	int z = x>y?x:y;
	return z;
}

//eg8.21."extern" usage in different files
int A;

int main(){

	//eg8.1.
	int re_printstar1 = printstar();
	int re_print_message = print_message();
	int re_printstar2 = printstar();
	printf("eg8.1.\nre_printstar1: %d\n", re_printstar1);
	printf("re_print_message: %d\n", re_print_message);
	printf("re_printstar2: %d\n", re_printstar2);

	//eg8.2.
	printf("eg8.2.\nPlease input 2 numbers to get their maximum value: \n");
	int a, b, c;
	scanf("%d %d", &a, &b);
	c = max(a, b);
	printf("Max is:%d\n", c);

	//eg8.3
	printf("eg8.3.\nPlease input 2 int numbers to get their maximum value: \n");
	int _a, _b;
	int _c;
	scanf("%d %d", &_a, &_b);
	_c = _max(_a, _b);
	printf("Max is:%d\n", _c);


	//eg8.4
	int i = 2, p;
	p = LeftRight_Test(i, ++i);//see which one is bigger.
	printf("eg8.4.\nLet i=2.\nThe result of LeftRight_Test(i, ++i) is: %d\n",p);
	printf("The result of printf(\"%%d,%%d\",i,i++) is :");
	printf("%d, %d", i, i++);
	printf("\n");
	
	//eg8.5
	float add(float, float);
	float a4, b4, c4;
	printf("eg8.5.\nPlease input two float numbers:\n");
	scanf("%f %f", &a4, &b4);
	c4 = add(a4, b4);
	printf("The sum of 2 float number is: %f\n", c4);

	//eg8.6
	float x1, x2, f1, f2, x_root;
	printf("eg8.6.\n");
	do{
		printf("Please input x1, x2:\n");
		scanf("%f %f", &x1, &x2);
		f1=f(x1); f2=f(x2);
	} while( f1*f2 >=0 );//notice: there is a semicollon here
	x_root = root(x1, x2);
	printf("A root of equation is %8.4f\n", x_root);

	//eg8.7
	int ith;// The ith people
	printf("eg8.7.\nPlease input the ordinal number of the people:1, 2, 3, ....\n");
	scanf("%d", &ith);
	printf("The age of the %d people is %d\n",ith, age(ith));

	//eg8.8		calculate n!-factorial.
	int n; float fac_result;
	printf("eg8.8\nPlease input an integer number to get its factorial number:");
	scanf("%d", &n);
	fac_result = factorial(n);
	printf("%d! = %10.0f\n", n, fac_result);

	//eg8.9
	int disk_number;
	printf("eg8.9\nPlease input the number of diskes:");
	scanf("%d", &disk_number);
	printf("The step to moving %3d diskes: \n", disk_number);
	hanoi(disk_number, 'A', 'B', 'C');

	//eg8.10
	int large(int, int);	//function prototype
	int a8[10], b8[10], i8, n8=0, m8=0, k8=0;
	printf("eg8.10\nPlease enter array a8: \n");
	for(i8 = 0; i8<10; i8++)
		scanf("%d", &a8[i8]);
	printf("\n");
	printf("Please enter array b8: \n");
	for(i8 = 0; i8<10; i8++)
		scanf("%d", &b8[i8]);
	printf("\n");
	for(i8 = 0; i8<10; i8++){
		if(large(a8[i8], b8[i8])==1) n8 = n8+1;
		else if (large(a8[i8], b8[i8])==0) m8 = m8+1;
		else k8=k8+1;
	}
	printf("a8[i8]>8b[i8] %d times\na8[i8]=b8[i8]%d times\na8[i8]<b8[i8]%d times\n", n8, m8, k8);
	if(n8>k8) printf("array a is larger than array b\n");
	else if (n8<k8) printf("array a is smaller than array b\n");
	else printf("array a is equal to array b\n");
	
	//eg8.11
	float score[10], aver;
	int i_11;
	printf("eg8.11\nPlease input 10 scores:\n");
	for(i_11=0; i_11<10; i_11++)
		scanf("%f", &score[i_11]);
	printf("\n");
	aver=average(score);
	printf("Average score is %5.2f\n", aver);
	
	//eg8.12
	float score_1[5]={98.5, 97, 91.5, 60, 55};
	float score_2[10]={67.5, 89.5, 99, 69.5, 77, 89.5, 76.5, 54, 60, 99.5};
	printf("eg8.12\nThe average of class A is %6.2f\n",average812(score_1, 5));
	printf("The average of class B is %6.2f\n",average812(score_2, 10));

	//eg8.13
	int original1_array[10]={2,7,5,9,10,1,3,8,4,6};
	int original2_array[10]={2,7,5,9,10,1,3,8,4,6};
	printf("eg8.13\nThe original array is: \n");
	for(i=0; i<10; i++)
		printf("%d ", original1_array[i]);
	printf("\n");
	selection_sort1(original1_array, 10);
	printf("The sorted array using method 1 is: \n");
	for(i=0; i<10; i++)
		printf("%d ", original1_array[i]);
	printf("\n");
	selection_sort2(original2_array, 10);
	printf("The sorted array using method 2 is: \n");
	for(i=0; i<10; i++)
		printf("%d ", original2_array[i]);
	printf("\n");

	//eg8.14
	int j;
	int a_2D[3][4]={
			{1,3,5,7},
			{2,4,6,8},
			{15,17,34,12}
			};
	printf("eg8.14\nThe original 2D array is:\n");
	for(i=0;i<3;i++){
		for(j=0;j<4;j++)
			printf("%5d ",a_2D[i][j]);	
		printf("\n");
	}
	printf("The maximum number is %d\n", max_value(a_2D));

	//eg8.15. about global variance
	float ave, stud_score[10]={100,34,98,54,68,72,88,89,91,90};
	printf("eg8.15\nInitial students' score are:\n");
	for(i=0;i<10;i++)
		printf("%.2f\n", stud_score[i]);
	printf("\n");
	ave=average815(stud_score, 10);
	printf("Max= %6.2f\nMin= %6.2f\nAverage= %6.2f\n", Max, Min, ave);

	//eg8.16
	int ga=8;
	printf("eg8.16\nThe maximum number of ga and gb is %d\n",max_global(ga,gb));
	
	//eg8.17
	int a817=2;
	printf("eg8.17\nShow the result of the static variance:\n");
	for(i=0;i<3;i++)
		printf("%d\n", static_variance_usage(a817));
	printf("\n");
	
	//eg8.18
	printf("eg8.18\nCalculating the n! using static variance:\n");
	for(i=1;i<=15;i++)
		printf("%2d! = %10d\n", i, static_factorial(i));
	
	//eg8.19
	printf("eg8.19\n Calculating the n! using register variance:\n");
	for(i=1;i<=20;i++)
		printf("%2d! = %15d\n", i, register_factorial(i));

	//eg8.20
	//extern int A, B;
	extern A,B;
	printf("eg8.20\nGlobal variance A is:%d, B is:%d, The maximum number of extern variance A,B is:%d\n",A,B,extern_max(A,B));
	
	//eg8.21
	int power(int);
	int b21=3,c21,d21,m21;
	printf("eg8.21\nEnter the number A and its power m:\n");
	scanf("%d %d", &A, &m21);
	c21 = A*b21;
	printf("%d * %d = %d\n", A, b21, c21);
	d21 = power(m21);
	printf("%d ** %d = %d\n",A,m21,d21);

	return 0;
}

printstar(){
	printf("**************************\n");
}

print_message(){
	printf("	How do you do! \n");
}

max(int x, int y){
	int z;
	z = x>y?x:y;
	return z;
}


_max(int _x, int _y){
	int _z;
	_z = _x>_y?_x:_y;
	return _z;
}

int LeftRight_Test(int a, int b){
	int c;
	if(a>b) c=1;
	else if (a==b) c=0;
	else c=-1;
	return c;
}

float add(float x, float y){
	float z;
	z = x+y;
	return z;
}

large(int x, int y){
	int flag;
	if(x>y) flag = 1;
	else if (x<y) flag = -1;
	else flag = 0;
	return flag;
}

int A=13, B=-8;//global memory A,B used in extern variance application.
//#include <stdio.h>
