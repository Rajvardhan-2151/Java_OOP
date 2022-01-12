#include<stdio.h>

int main()

{ 
	int a,b,c;
	float ave;
	printf("enter three sub marks");
	scanf("%d,%d,%d",&a,&b,&c);
	ave=(a+b+c)/3;
 	printf("\nave=%f",ave);
	if(ave>=75)
	printf("\nDisinction");
		else
		{
		if(ave>=60)
		printf("\nFisrt class");
		else
		{
		if(ave>=50)
		printf("\n Second class");
		else
		printf("\n Fail");
		}
	}
	return 0;
           
}
	
	