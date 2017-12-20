#include <stdio.h>
//#include <cuda.h>

int main(void) {
	cudaDeviceProp prop;//cudaDevieProp is a structure, prop is a structure variable.
	
	int count;
	cudaGetDeviceCount (&count);
	for (int i=0; i< count; i++){
		cudaGetDeviceProperties (&prop, i);
		printf("\n****************************Device %d*************************************\n",i);
		printf("----------General Information----------\n");
		printf("Name: %s\n", prop.name);
		printf("Compute capability: %d.%d\n", prop.major, prop.minor);
	//	printf("Clock rate: %d\n", prop.clockRate);
		printf("Clock rate: %d MHz\n", (prop.clockRate/1000));

		printf("GPU type: ");
		if (prop.integrated)
			printf ("Integrated GPU\n");
		else
			printf ("Discreted GPU\n");

		printf("Device copy overlap: ");		
		if (prop.deviceOverlap)	
			printf ("Enabled\n");
		else
			printf ("Disabled\n");

		printf( "Kernel execution timeout: ");		
		if (prop.kernelExecTimeoutEnabled)
			printf ("Enabled\n");
		else
			printf ("Disabled\n");

		printf( "Mapping Host Memory into CUDA Device Address Space: ");
		if (prop.canMapHostMemory)
			printf ("Enabled\n");
		else
			printf ("Disabled\n");

		printf( "Executing Multiple Kernels Support: ");
		if (prop.concurrentKernels)
			printf ("Enabled\n");
		else 
			printf ("Disabled\n");

		printf( "Device Computing Mode: ");
		if (prop.computeMode == 0) printf("Default\n");
		if (prop.computeMode == 1) printf("Exclusive\n");
		if (prop.computeMode == 2) printf("Prohibited\n");
			
		printf( "\n----------Memory Information for device----------\n");
	//	printf( "Total Global Memory: %ld\n", prop.totalGlobalMem);
		printf( "Total Global Memory: %ld MB\n", (prop.totalGlobalMem/1024/1024));
	//	printf(	"Total Constant Memory: %ld\n", prop.totalConstMem );
		printf( "Total Constant Memory: %ld kB\n", (prop.totalConstMem/1024));	
	//	printf( "Total Constant Memory: %ld MB\n", (prop.totalConstMem/1024/1024));
	//	printf( "Max Memory Pitch Allowed for Memory Copies: %ld\n", prop.memPitch );
		printf( "Max Memory Pitch Allowed for Memory Copies: %ld MB\n", (prop.memPitch/1024/1024));
		printf( "Texture Alignment: %ld B\n", prop.textureAlignment );
		printf( "Max Size Supported for 1D Textures: %ld\n", prop.maxTexture1D);
		printf( "Max Dimensions Supported for 2D Texture: (%d, %d)\n", prop.maxTexture2D[0], prop.maxTexture2D[1]);
		printf( "Max Dimensions Supported for 3D Texture: (%d, %d, %d)\n", 
										prop.maxTexture3D[0],
										prop.maxTexture3D[1],
										prop.maxTexture3D[2]);
/*		printf( "Max Dimensions Supported for 2D Texture Array: (%d, %d, %d)\n", 
										prop.maxTexture2DArray[0],
										prop.maxTexture2DArray[1],
										prop.maxTexture2DArray[2]);
*/		
		printf( "\n----------Thread Information for device----------\n");
		printf( "Streaming Multiprocessor count: %d\n", prop.multiProcessorCount);
	//	printf( "Shared Memory per Block: %ld\n", prop.sharedMemPerBlock);
		printf( "Shared Memory per Block: %ld KB\n", (prop.sharedMemPerBlock/1024));
		printf( "Registers per Block: %ld\n", prop.regsPerBlock);
		printf( "Threads in warp: %ld\n", prop.warpSize);
		printf( "Max threads per block: %d\n",
					prop.maxThreadsPerBlock);			
		printf( "Max thread dimensions: (%d, %d, %d)\n",
					prop.maxThreadsDim[0], prop.maxThreadsDim[1],
					prop.maxThreadsDim[2]);
		printf( "Max grid dimensions: (%d, %d, %d)\n",
					prop.maxGridSize[0], prop.maxGridSize[1],
					prop.maxGridSize[2]);
		printf("*****************************************************************\n");
		}
	
	return 0;
}

