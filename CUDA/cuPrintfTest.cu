#include <stdio.h>  
#include <stdlib.h>  
#include <time.h>  
#include <cuda.h>  
#include "cuPrintf.cu"  
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
bool cuPrintInit()  
{  
    cudaError_t err = cudaPrintfInit();  
    if(0 != strcmp("no error", cudaGetErrorString(err)))  return false;  
    return true;  
}  
__global__ void displayGPU_demo()  
{  
    int bsize = blockDim.x;  
    int bid = blockIdx.x;  
    int tid = bid * bsize + threadIdx.x;  
    cuPrintf("当前执行kernel的 block 编号:/t%d\n", bid);  
    cuPrintf("当前执行kernel的 thread 在当前块中编号:/t%d\n", threadIdx.x);  
    cuPrintf("当前执行kernel的 thread 全局编号:/t%d\n", tid);  
    cuPrintf("thread over\n\n");  
}  

int main(void)  
{  
    if(!InitGPUSet())  puts("device is not ready!");  
    else if(!cuPrintInit())  puts("device is not ready!");  
    else  
    {  
        displayGPU_demo<<<2, 3>>>();  
        cudaPrintfDisplay(stdout, true);//true输出是哪一个block的第几个thread在执行本条输出语句，形如：[blockID, threadID]；false不输出  
        cudaPrintfEnd();  
    }  
    return 0;  
}  
