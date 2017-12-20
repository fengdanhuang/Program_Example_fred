#include <stdio.h>
#include <string.h>
#include "eg11.2.h"
//#include "eg11.4.h"
//#include "eg11.5.c"

int main(int count,char *values[]){
	//eg11.1
	{
		printf("eg11.1\n");
		struct student{
			long int num;
			char name[20];
			char sex;
			char addr[20];
		}a={89031,"Li Lin",'M',"123 Beijing Road"};
		printf("NO.:%ld\nname:%s\nsex:%c\naddress:%s\n",a.num,a.name,a.sex,a.addr);
	}
	
	//eg11.2
	{
		printf("eg11.2\nPlease input the cadidates'name:Li,Zhang,Fun.");
		//Notice:Both of the assignment below are allowed by the system.
		struct person leader[]={"Li",0,"Zhang",0,"Fun",0};
		//struct person leader[]={{"Li",0},{"Zhang",0},{"Fun",0}};
		int i,j;
		char leader_name[20];
		for(i=1;i<=10;i++){
			scanf("%s",leader_name);
			for(j=0;j<3;j++)
				if(strcmp(leader_name,leader[j].name)==0) leader[j].count++;
		}
		printf("\n");
		for(i=0;i<3;i++)
			printf("%5s:%d\n",leader[i].name,leader[i].count);
	}
	
	//eg11.3
	{
		printf("eg11.3\n");
		struct student{
			long num;
			char name[20];
			char sex;
			float score;
		};
		struct student stu_1;
		struct student*p;
		p=&stu_1;
		stu_1.num=89101;
		strcpy(stu_1.name,"Li Lin");
		stu_1.sex='M';
		stu_1.score=89.5;
		printf("No.:%ld\nname:%s\nsex:%c\nscore:%f\n",stu_1.num,stu_1.name,stu_1.sex,stu_1.score);
		printf("No.:%ld\nname:%s\nsex:%c\nscore:%f\n",(*p).num,(*p).name,(*p).sex,(*p).score);
	}

	//eg11.4
	{
#include "eg11.4.h"
		printf("eg11.4\n");
		struct student*p;
		printf("No.	Name	Sex	Age\n");
		for(p=stu;p<stu+3;p++)
			printf("%5d %-20s %2c %4d\n",p->num,p->name,p->sex,p->age);
	}	
	
	//eg11.5
	{
#include "eg11.5.c"
		printf("eg11.5\n");		
		struct student stu;
		stu.num=12345;
		strcpy(stu.name,"Li Li");
		stu.score[0]=67.5;stu.score[1]=89;stu.score[2]=78.6;
		print(stu);
		printf("eg11.6\n");
		print_pointer(&stu);
	}

	//eg11.12,eg11.6-eg11.11 are the link list example.
	{
#include "eg11.12.h"
		printf("eg11.12.h\n");
		int n,i;
		for(i=0;i<2;i++){
			scanf("%d %s %c %c",&person[i].num,person[i].name,&person[i].sex,&person[i].job);
			if(person[i].job=='s') 
				scanf("%d",&person[i].category.class);
			else if (person[i].job=='t') scanf("%s",person[i].category.position);
			else printf("input error!");
		}
		printf("\n");
		printf("No.    Name	sex job	class/position\n");
		for(i=0;i<2;i++){
			if(person[i].job=='s')
				printf("%-6d %-10s %-3c %-3c %-6d\n",person[i].num,person[i].name,person[i].sex,
									person[i].job,person[i].category.class);
			else
				printf("%-6d %-10s %-3c %-3C %-6s\n",person[i].num,person[i].name,person[i].sex,
									person[i].job,person[i].category.position);
		}
		printf("\n");
	}	

	//eg11.13
	{
		enum color {red,yellow,blue,white,black};//0,1,2,3,4
		enum color i,j,k,pri;
		int n, loop;
		n=0;
		for(i=red;i<=black;i++)
			for(j=red;j<=black;j++)
				if(i!=j){
					for(k=red;k<=black;k++)
						if((k!=i)&&(k!=j)){
							n=n+1;
							printf("%-4d",n);
							for(loop=1;loop<=3;loop++){
								switch(loop){
									case 1:pri=i;break;
									case 2:pri=j;break;
									case 3:pri=k;break;
									default:break;
								}
								switch(pri){
									case red:printf("%-10s","red");break;
									case yellow:printf("%-10s","yellow");break;
									case blue:printf("%-10s","blue");break;
									case white:printf("%-10s","white");break;
									case black:printf("%-10s","black");break;
									default:break;
								}
							}
							printf("\n");
						}
				}
		printf("\ntotal:%5d\n",n);
	}
	return 0;
}
