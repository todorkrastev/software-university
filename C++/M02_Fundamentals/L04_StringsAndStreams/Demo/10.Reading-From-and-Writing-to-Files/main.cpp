#include <fstream>
#include <iostream>
using namespace std;

int main() {
    ifstream input;
    // NOTE: the file input.txt should exist in the directory where
    //the binary file is created and run!
    input.open("input.txt");

    //IMPORTANT: always make an error check
    if(!input.is_open())
    {
    	cerr << "input.txt file could not be found" << endl;
    }

    int a, b;
    input >> a >> b;

    ofstream output;
    output.open("output.txt", ofstream::app);
    output << a + b << endl;

    return 0;
}
