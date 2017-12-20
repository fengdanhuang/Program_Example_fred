#include <stdio.h>
#include <stdlib.h>  
#include <time.h>  
#include <cuda.h> 
#include "cuPrintf.cu"


bool InitGPUSet();
bool cuPrintInit();
__global__ void MyKernel(float* devPtr, size_t pitch, int width, int height);

int main(){
	int width = 5, height = 5;
	float *devPtr;
	size_t pitch = 10;
	
//	gridDim.x=2;gridDim.y=2;gridDim.z=2;
//	blockDim.x=2;blockDim.y=2;blockDim.z=2;

	dim3 gridDim(2,2,3);
	dim3 blockDim(2,2,2);

	if(!cuPrintInit())  puts("device is not ready!");
	printf("pitch before:%d\n",pitch);
	cudaMallocPitch(&devPtr, &pitch, width*sizeof(float), height);
	MyKernel<<<gridDim,blockDim>>>(devPtr,pitch,width,height);
	cudaPrintfDisplay(stdout, true);//true输出是哪一个block的第几个thread在执行本条输出语句，形如：[blockID, threadID]；false不输出  
        cudaPrintfEnd(); 
	cudaFree(devPtr);
	printf("pitch after:%d\n", pitch);

	return 0;
}


__global__ void MyKernel(float* devPtr, size_t pitch, int width, int height){
	cuPrintf("当前执行kernel的 block 编号:/t%d\n");
	cuPrintf("width=%d,height=%d,pitch=%d\n", width, height,pitch);
	cuPrintf("gridDim.x=%d,gridDim.y=%d,gridDim.z=%d\n", gridDim.x, gridDim.y,gridDim.z);
	cuPrintf("blockDim.x=%d,blockDim.y=%d,blockDim.z=%d\n", blockDim.x, blockDim.y, blockDim.z);
	//cuPrintf("blockIdx.x=%d, blockIdx.y=%d\n", blockIdx.x, blockIdx.y,blockIdx.z);
	//cuPrintf("threadIdx.x=%d, threadIdx.y=%d, threadIdx.z=%d\n",threadIdx.x,threadIdx.y,threadIdx.z);
	cuPrintf("blockIdx.z=%d, blockIdx.y=%d,blockIdx.x=%d\n", blockIdx.z, blockIdx.y,blockIdx.x);
	cuPrintf("threadIdx.z=%d, threadIdx.y=%d, threadIdx.x=%d\n",threadIdx.z,threadIdx.y,threadIdx.x);
	for(int r=0;r<height;++r){
		float *row = (float*)((char*)devPtr+r*pitch);
		for(int c=0; c<width; ++c){
			float element = row[c];
			cuPrintf("%f ",element);
		}
		cuPrintf("\n");
	}
	cuPrintf("\n");
}

bool InitGPUSet()  
{  
    char GPU[100] = "GPU: ";  
    cudaDeviceProp tCard;  
    int num = 0;  
    if(cudaSuccess == cudaGetDeviceCount(&num))  
    {  
        for(int i = 0; i < num; ++ i)  
        {  
            cudaSetDevice(i);  
            cudaGetDeviceProperties(&tCard, i);  
            puts(strcat(GPU , tCard.name));//返回的就是链接后的结果,也为其的嵌套使用提供了条件  
        }  
    }  
    else  return false;  
    return true;  
}  

bool cuPrintInit()  {  
    cudaError_t err = cudaPrintfInit();  
    if(0 != strcmp("no error", cudaGetErrorString(err)))  return false;  
    return true;  
}  
