#include <stdio.h>
#include <stdlib.h>
#include <cuda.h>
#include <curand_kernel.h>

__global__ void MyKernel(float** dev_matrix, size_t pitch, int width, int height)
{   
        int number = 0;
        for (int i = 0; i < height; ++i) 
        {
                float* row = (float*)((char*)dev_matrix + i*pitch);

                for (int j = 0; j < width; ++j) 
                {       
                        row[j] = number; 
                        number++;
                }
        }
}


int main (int argc , char * argv [])
{
        int width = 4, height = 2, i, j;
//      float matrix[width][height];
	float matrix[height][width];
        float **dev_matrix;
        size_t pitch;

    	printf("\nMATRIX MANIPULATION\n");

        for (i = 0; i < height; i++) 
                for (j = 0; j < width; j++)
                        matrix[i][j] = 0.0;
 
        printf("Matrix in host memory\n");
        for (i = 0; i < height; i++) 
        {       
                for (j = 0; j < width; j++)
                        printf("%f   ", matrix[i][j]);
                printf("\n");
        }

        cudaMallocPitch(&dev_matrix, &pitch, width * sizeof(float), height);

        cudaMemcpy2D(dev_matrix, pitch, matrix, width * sizeof(float), width * sizeof(float), height, cudaMemcpyHostToDevice);  

        MyKernel<<<2, 2>>>(dev_matrix, pitch, width, height);

        cudaMemcpy2D(matrix, width * sizeof(float), dev_matrix, pitch, width * sizeof(float), height, cudaMemcpyDeviceToHost);

        printf("Matrix after calculate elements in the gpu\n");
        for (i = 0; i < height; i++) 
        {       
                for (j = 0; j < width; j++)
                        printf("%f   ", matrix[i][j]);
                printf("\n");
        }

    cudaFree(dev_matrix);

        return 0;
}
