//eg10.25
float*search(float(*pointer)[4],int n){
	float*pt;
	pt=*(pointer+n);
	return pt;
}


//eg10.26
float*search1(float(*pointer)[4]){
	int i;float*pt;
	pt=*(pointer+1);
	for(i=0;i<4;i++)
		if(*(*pointer+i)<60) pt=*pointer;
	return pt;
}
