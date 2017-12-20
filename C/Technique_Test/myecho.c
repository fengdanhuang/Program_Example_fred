#include <stdio.h>

int main(int initial_count,char**initial_values);//the Argument of main function

int main(int initial_count,char**initial_values){
	
	//myecho1:
	printf("myecho1:\n");
	int count=initial_count;char**values=initial_values;
	while(count>1){
		values++;
		printf("%s\n",*values);
		--count;
	}
	
	//myecho2:
	printf("myecho2:\n");
	count=initial_count;values=initial_values;
	while(count-->1)
		printf("%s\n",*++values);
	
	//myecho3:
	printf("myecho3:\n");
	count=initial_count;values=initial_values;
	while(--count>0)
		printf("%s%c",*++values,count>1?' ':'\n');

	//myecho4:
	printf("myecho4:\n");
	count=initial_count;values=initial_values;
	for(int i=1;i<count;i++)
		printf("%s%c",values[i],i<count-1?' ':'\n');
}
