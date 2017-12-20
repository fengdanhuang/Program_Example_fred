#include <stdio.h>
#include <stdlib.h>

#define SIZE 4

typedef struct student_type{
	char name[10];
        int num;
        int age;
        char addr[15];
}student_type;
student_type stud[SIZE];

int main(int argc,char*argv[]){
	//eg13.1
	{
		printf("eg13.1\n");
		FILE*fp;
		char ch,filename[10];
		scanf("%s",filename);
		//Only if open a file with'w', you could open a new file.
		if((fp=fopen(filename,"w"))==NULL){//= has a lower priority than ==
			printf("Cannot open file\n");
			exit(0);
		}
		ch=getchar();
		ch=getchar();
		while(ch!='#'){
			fputc(ch,fp);putchar(ch);
			ch=getchar();
		}
		fclose(fp);
	}
	//eg13.2
	{
		printf("eg13.2\n");
		FILE*in,*out;
		char ch,infile[10],outfile[10];
		printf("Enter the infile name:\n");
		scanf("%s",infile);
		printf("Enter the outfile name:\n");
		scanf("%s",outfile);
		if((in=fopen(infile,"r"))==NULL){
			printf("Cannot open infile.\n");
			exit(0);
		}
		if((out=fopen(outfile,"w"))==NULL){
			printf("Cannot open outfile.\n");
			exit(0);
		}
		while(!feof(in)) fputc(fgetc(in),out);
		fclose(in);fclose(out);		
		printf("\n");
	}
	//eg13.2a
	{
		printf("eg13.2a\n");
		FILE*in,*out;
		char ch;
		if(argc!=3){
			printf("You forget to enter a filename.\n");
			exit(0);
		}
		if((in=fopen(argv[1],"r"))==NULL){
			printf("Cannot open infile.\n");
			exit(0);
		}
		if((out=fopen(argv[2],"w"))==NULL){
			printf("Cannot open outfile.\n");
			exit(0);
		}
		while(!feof(in)) fputc(fgetc(in),out);
		printf("Copy finished.\n");
		fclose(in);fclose(out);
	}
	//eg13.3
	{	
		printf("eg13.3\n");
		void load();
		void save();
		int i;
		for(i=0;i<SIZE;i++)
			scanf("%s %d %d %s",stud[i].name,&stud[i].num,&stud[i].age,&stud[i].addr);		
		load();
		save();
	}
	//eg13.4
	{
		printf("eg13.4\n");
		FILE*fp1,*fp2;
		fp1=fopen("file1.c","r");
		fp2=fopen("file2.c","w");
		while(!feof(fp1)) putchar(getc(fp1));
		rewind(fp1);
		while(!feof(fp1)) putc(getc(fp1),fp2);
		fclose(fp1);fclose(fp2);
	}
	//eg13.5
	{
		typedef struct student_type{
			char name[10];
			int num;
			int age;
			char sex;
		}STUD;
		STUD stud[10];
		
		int i;
		FILE*fp;
		if((fp=fopen("stud_dat","rb"))==NULL){
			printf("Can not open file.\n");
			exit(0);
		}
		for(i=0;i<10;i+=2){
			fseek(fp,i*sizeof(STUD),0);
			fread(&stud[i],sizeof(STUD),1,fp);
			printf("%s %d %d %c\n",stud[i].name,stud[i].num,stud[i].age,stud[i].sex);
		}
		fclose(fp);
	}
	return 0;
}


void save(){
	FILE*fp;
	int i;
	if((fp=fopen("stu_list","wb"))==NULL){
		printf("Cannot open file.\n");
		return;
	}
	for(i=0;i<SIZE;i++)
		if(fwrite(&stud[i],sizeof(student_type),1,fp)!=1) 
			printf("File write error!");
	fclose(fp);
	printf("\n");
	
	fp=fopen("stu_list","rb");
	for(i=0;i<SIZE;i++){
		fread(&stud[i],sizeof(student_type),1,fp);
		printf("%-10s %4d %4d %-15s\n",stud[i].name,stud[i].num,stud[i].age,stud[i].addr);
	}
}

void load(){
	FILE*fp;
	int i;
	if((fp=fopen("stu_dat","rb"))==NULL){
		printf("Cannot open infile.\n");
		return;
	}
	for(i=0;i<SIZE;i++)
		if(fread(&stud[i],sizeof(student_type),1,fp)!=1){
			if(feof(fp)){
				fclose(fp);
				return;
			}
			printf("file read error.\n");
		}
	fclose(fp);
}
