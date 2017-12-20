#include <stdio.h>

int main(){
	//eg12.1
	{
		printf("eg12.1\n");
		unsigned a,b,c,d;
		scanf("%o",&a);
		b=a>>4;
		c=~(~0<<4);
		d=b&c;
		printf("%o,%d\n%o,%d\n",a,a,d,d);
	}
	//eg12.2
	{
		printf("eg12.2\n");
		unsigned a,b,c;
		int n;
		scanf("a=%o,n=%d",&a,&n);
		b=a<<(16-n);
		c=a>>n;
		c=c|b;
		printf("%o\n%o",a,c);

	}
	return 0;
}
