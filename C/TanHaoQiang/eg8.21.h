extern A;

//We can use the for loop to calculate the power.
power(int n){
	int i, y=1;
	for(i=1;i<=n;i++)
		y *= A;
	return y;
}
