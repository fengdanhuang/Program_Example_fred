#include <cuda.h>
#include <stdio.h>
#include <math.h>
#include "cuPrintf.cu"

#define N 2

__global__ void add2D(int **d_x, int **d_y, int **d_sum){

	//int tid = blockIdx.y*N+blockIdx.x;
	
	d_sum[threadIdx.y][threadIdx.x]=d_x[threadIdx.y][threadIdx.x]+d_y[threadIdx.y][threadIdx.x];
	cuPrintf("d_sum[%d][%d]=%d\n",threadIdx.y, threadIdx.x, d_sum[threadIdx.y][threadIdx.x]);	
}

int main(){
	int x[N][N], y[N][N], sum[N][N];
	int **d_x, **d_y, **d_sum;
	size_t dpitch_x=N, dpitch_y=N, dpitch_sum=N;
//	size_t dpitch;
	dim3 blockDim(N,N,1);
	for(int i=0;i<N;i++){
		for(int j=0;j<N;j++){
			x[i][j]=3;y[i][j]=6;
		}
	}
	
	cudaPrintfInit();

	cudaMallocPitch((void**)&d_x, &dpitch_x, N*sizeof(int), N);
	cudaMallocPitch((void**)&d_y, &dpitch_y, N*sizeof(int), N);
	cudaMemcpy2D(d_x,dpitch_x, x, N*sizeof(int), N*sizeof(int),N,cudaMemcpyHostToDevice);
	cudaMemcpy2D(d_y,dpitch_y, y, N*sizeof(int), N*sizeof(int),N,cudaMemcpyHostToDevice);
	
	add2D<<<1,blockDim>>>(d_x,d_y,d_sum);
	cudaPrintfDisplay(stdout,true);
	cudaPrintfEnd();
	cudaMemcpy2D(sum,N*sizeof(int), d_sum, dpitch_sum, N*sizeof(int),N,cudaMemcpyDeviceToHost);
/*	for(int i=0;i<N;i++){
		for(int j=0;j<N;j++){
			printf("sum[%d][%d]=%d ",i,j,sum[i][j]);
		}
		printf("\n");
	}*/
	return 0;
}






	
