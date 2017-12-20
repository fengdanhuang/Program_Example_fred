
void copy_string_array(char from[], char to[]){
	int i=0;
	while(from[i]!='\0'){
		to[i]=from[i];
		i++;
	}
	to[i]='\0';
}

void copy_string_pointer(char*from, char*to){
	/*
	for(;*from!='\0';from++,to++)
		*to=*from;
	*to='\0';*/
	printf("%c,%c",*from,*to);
	//from++;to++;
	//printf("%c,%c",*from,*to);
	
	return;
}
