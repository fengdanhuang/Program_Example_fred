#include <stdio.h>
//#include <string.h>

int main(){
	//eg10.19
	printf("eg10.19\n");
	char a[]="I am a boy.", b[20], *p1,*p2;
	p1=a;p2=b;
	for(;*p1!='\0';p1++,p2++)
		*p2=*p1;
	*p2='\0';
	printf("String a is:%s\n",a);
	printf("String b is:");
	for(int i=0;*(b+i)!='\0';i++)
		printf("%c", b[i]);
	printf("\n");


	//eg10.20
/*	printf("eg10.20\n");
	extern void copy_string_array(char a[],char b[]);
	extern void copy_string_pointer(char *,char*);
	char a_20[]="I am a teacher.";
	char b_20[]="you are a student.";
	printf("String a_20[]=%s\nString b_20[]=%s\n",a_20,b_20);
	copy_string_array(a_20, b_20);
	printf("After call copy_string_array():\nString a_20[]=%s\nString b_20[]=%s\n",a_20,b_20);
	for(int i=0;i<60;i++)
		printf("%c", b_20[i]);
	printf("\n");
	
	//eg10.20p
	char*pa,*pb;
	pa="I am a teacher.";pb="You are a student.";
	printf("String pa=%s\nString pb=%s\n",pa,pb);
	copy_string_pointer(pa, pb);
	printf("After call copy_string_pointer():\nString pa=%s\nString pb=%s\n",pa,pb);
*/

	//eg10.21
	printf("eg10.21\n");
	char*aa="I love China!";
	aa=aa+7;
	printf("%s\n",aa);

	//eg10.22
	printf("eg10.22\n");
	char*a22="I love China!";
	printf("The sixth character is: %c\n",a22[5]);
	for(int i=0;a[i]!='\0';i++)
		printf("%c",a22[i]);
	printf("\n");

	//eg10.23
	printf("eg10.23\nPlease input the value of a,b:");
	int max(int,int);
	int (*p23)();
	int a23,b23,c23;
	p23=max;
	scanf("%d %d",&a23,&b23);
	c23=(*p23)(a23,b23);
	printf("a23=%d,b23=%d,c23=%d\n",a23,b23,c23);
	
	//eg10.24
	{
	printf("eg10.24\nPlease enter a and b:");
	int max24(int,int);
	int min24(int,int);
	int add24(int,int);
	int process(int,int,int(*fun)());
	int a,b;
	scanf("%d %d",&a,&b);
	printf("max=");process(a,b,max24);
	printf("min=");process(a,b,min24);
	printf("sum=");process(a,b,add24);
	}

	//eg10.25
	{
		float score[][4]={	{60,70,80,90},
					{56,89,67,88},
					{34,78,90,66}};
		float*search(float (*pointer)[4], int n);
		float*p;
		int i,m;
		printf("eg10.25\nPlease enter the number of students:");
		scanf("%d",&m);
		printf("The score of No.%d are: \n",m);
		p=search(score,m);
		for(i=0;i<4;i++)
			printf("%5.2f\t",*(p+i));
		printf("\n");
		
		//eg10.26
		printf("eg10.26\n");
		float*search1(float (*pointer)[4]);
		int j;
		for(i=0;i<3;i++){
			p=search1(score+i);
			if(p==*(score+i)){
				printf("No.%d scores: ", i);
				for(j=0;j<4;j++)
					printf("%5.2f ", *(p+j));
				printf("\n");
			}
		}
	} 
	
	//eg10.27
	{
		void sort(char*name[], int n);
		void print(char*name[], int n);
		char*name[]={"Follow me","BASIC","GREAT Wall","FORTRAN","Computer design"};
		int n=5;
		printf("eg10.27\n");
		sort(name,n);
		print(name,n);

		//eg10.28
		char**p;
		printf("eg10.28\n");
		printf("char**p:\nAddress:%X\tSizeof(p):%d\tString(wrong):%s\n",p,sizeof(p),p);
		for(int i=0;i<5;i++){
			p=name+i;
			printf("Address:%X\t",*p);printf("Sizeof(*p):%d\t",sizeof(*p));printf("String:%s\n",*p);
		}
	}
	
	//eg10.29
	{
		static int a[5]={1,3,5,7,9};
		int*num[5]={&a[0],&a[1],&a[2],&a[3],&a[4]};
		int**p;
		p=num;
		printf("eg10.29\nint**p:Address:\n%X(Hex)\t%d(Decimal)\n",p,p);
		
		for(int i=0;i<5;i++){
			printf("Address:%X,Integer:%d\n",*p,**p);
			p++;
		}
	}
	return 0;
}
