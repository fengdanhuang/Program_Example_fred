#include "stdio.h"//both "" and <> are OK. Just for the C standard library, using <> is faster.
#include "math.h"

//#include </user/chaofeng/C_Example/eg9.1.h> //Thie is correct But too long
#include "eg9.1_eg9.2_eg9.3_eg9.4_eg9.5_eg9.6_eg9.7.h"

int main(){
	//eg9.1
	float l,s,r,v;
	printf("eg9.1\nPlease input radius of a circle:");
	scanf("%f",&r);
	l = 2.0*PI*r;
	s = PI * pow(r,2);
	v = 4/3*PI*pow(r,3);
	printf("length=%10.4f\nsquare=%10.4f\nvolume=%10.4f\n",l,s,v);

	//eg9.2
	printf("eg9.2\nLENGTH = %f\nSQUARE = %f\n",L,S);

	//eg9.3
	float a, area;
	a=3.6;
	area = S1(a);
	printf("eg9.3\nr=%f\narea=%f\n",a,area);

	//eg9.4
	printf("eg9.4\nPlease input radius of a CIRCLE:\n");
	scanf("%f",&r);
	CIRCLE(r,l,s,v);
	printf("eg9.4\nradius=%6.2f, length=%6.2f, square=%6.2f, volume=%6.2f.\n",r,l,s,v);

	//eg9.5,eg9.6
	printf("eg9.5\nUsing macro to replace the functions:\n");
	int a5=1, b5=2, c5=3, d5=4;
	PR(D1,a5);
	PR(D2,a5,b5);
	PR(D3,a5,b5,c5);
	PR(D4,a5,b5,c5,d5);
	char str5[]="CHINA";
	PR(STN,str5);
	
	//eg9.7
	char str7[20]="C Language",c;
	int i=0;
	while((c=str7[i])!='\0'){
		i++;
		#if LETTER
			if(c>='a' && c<='z') c=c-32;
		#else
			if(c>='A' && c<='Z') c=c+32;
		#endif
		printf("%c", c);
	}
	printf("\n");
	return 0;
}

