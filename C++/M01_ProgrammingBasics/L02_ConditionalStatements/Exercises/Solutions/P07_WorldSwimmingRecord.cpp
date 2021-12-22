#include <iostream>
#include <stdio.h>  
#include <math.h>       
using namespace std;

int main() {

	double worldRecord, distance, time;
	cin >> worldRecord >> distance >> time;

	double slowDown = floor(distance / 15) * 12.5;

	double totalTime = (distance * time) + slowDown;

	if (totalTime < worldRecord) {
		printf("Yes, he succeeded! The new world record is %.2lf seconds.\n", totalTime);
	} else {
		printf("No, he failed!He was %.2lf seconds slower.", totalTime - worldRecord);
	}

	return 0;
}