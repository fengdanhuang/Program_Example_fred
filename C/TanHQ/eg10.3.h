static swap1(int*,int*);
static swap2(int*,int*);
extern exchange(int*,int*,int*);

//eg10.3
swap1(int *p1, int *p2){
	int temp;
	temp=*p1;*p1=*p2;*p2=temp;
}

swap2(int *p1, int *p2){//may have problem. Since *temp is not initialized.
	int *temp;
	*temp=*p1;*p1=*p2;*p2=*temp;
}

swap3(int *p1, int *p2){
	int *temp;
	temp=p1;p1=p2;p2=temp;
}

//eg10.4
extern exchange(int *q1, int *q2, int *q3){
	if(*q1<*q2) swap1(q1,q2);
	if(*q1<*q3) swap1(q1,q3);
	if(*q2<*q3) swap1(q2,q3);
}

//eg10.7
static void inverse(int x[], int n){
	printf("The size of x(formal parameter) is:	%4dB,%4dbit\n", sizeof(x), sizeof(x)*8);
	printf("The size of x[i](array element) is:	%4dB,%4dbit\n", sizeof(x[0]), sizeof(x[0])*8);
	int temp,i,j;
	for(i=0;i<=(n-1)/2;i++){		
		j=n-1-i;
		temp=x[i];x[i]=x[j];x[j]=temp;
	}
	return;//notice:this is the value for void.
}

extern void inverse_pointer(int *x, int n){
	int*p,*i,*j,temp;
	i=x;j=x+n-1;p=x+(n-1)/2;
	for(;i<=p;i++,j--){
		temp=*i;*i=*j;*j=temp;
	}
	return ;
}

//eg10.8
static int max, min;
void max_min_value(int array[], int n){
	int* p,*array_end;
	array_end=array+n;	max=min=*array;
	for(p=array+1;p<array_end;p++)
		if(*p>max) max=*p;
		else if(*p<min) min=*p;
	//return;
}

//eg10.9
sort(int x[], int n){
	int k,t;
	for(int i=0;i<n-1;i++){
		k=i;
		for(int j=i+1;j<n;j++)
			if(*(x+j)>*(x+k)) k=j;
		if(k!=i){
			t=*(x+i);*(x+i)=*(x+k);*(x+k)=t;
		}
	}
}


//eg10.14
void average(float*p,int n){
	float *p_end;
	float sum=0,aver;
	p_end=p+n-1;
	for(;p<=p_end;p++)
		sum=sum+(*p);
	aver=sum/n;
	printf("Averag=%5.2f\n", aver);
}

void search(float (*p)[4], int n){
	printf("The score of No.%d are:\n", n);
	for(int i=0;i<4;i++)
		printf("%3.2f ", *(*(p+n)+i));
	printf("\n");
}

void search_fail(float (*p)[4], int n){
	int i,j,flag;
	for(j=0;j<n;j++){
		flag=0;
		for(i=0;i<4;i++)
			if(*(*(p+j)+i)<60) flag=1;
		if(flag==1){
			printf("No.%d fails, his scores are:", j+1);
			for(i=0;i<4;i++)
				printf("%3.2f ", *(*(p+j)+i));
			printf("\n");
		}
	}
}
