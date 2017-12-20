#include <stdio.h>

int main(void);

int main(void){
	int test_var = 10;
	printf("Test variable before if statement: %d\n",test_var);
	printf("Address of test varaible before if statement: %X\n", &test_var);
	if(test_var > 5){
		int test_var = 5;
		printf("Test variable within if statement: %d\n", test_var);
		printf("Address of test varaible within if statement: %X\n", &test_var);
		//Independent local block.
		{
			int test_var=0;
			printf("Test variable within independent local block:%d\n", test_var);
			printf("Address of test variable within independent local block:%X\n", &test_var);
		}

		printf("Test variable after independent local block: %d\n", test_var);
		printf("Address of test variable after independent local block: %X\n", &test_var);
	}

	printf("Test variable after if statement: %d\n",test_var);
	printf("Address of test variable after if statement: %X\n", &test_var);

	return 0;
}
