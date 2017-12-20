
struct{
	int num;
	char name[10];
	char sex;
	char job;
	
	union{
		int class;
		char position[10];
	}category;
}person[2];

