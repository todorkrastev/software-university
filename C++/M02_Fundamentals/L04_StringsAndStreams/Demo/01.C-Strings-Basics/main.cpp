#include <iostream>
using namespace std;

int main() {
    char text[16] = {'C','+','+',' ','P','r','o','g','r','a','m','m','i','n','g','\0'};
    char sameText[] = {'C','+','+',' ','P','r','o','g','r','a','m','m','i','n','g', 0};
    char sameTextAgain[] = "C++ Programming";
    char sameTextYetAgain[16] = "C++ Programming";

    cout << text << endl;
    cout << sameText << endl;
    cout << sameTextAgain << endl;
    cout << sameTextYetAgain << endl;

    char arrWithNullTerminatorInMiddle[] =
    {'p','r','i','n','t','e','d', '\0', 'n','o','t',' ','p','r','i','n','t','e','d' };

    cout << arrWithNullTerminatorInMiddle << endl;

    char input[100];
    // NOTE: you can enter up to 99 symbols. If you enter 100 symbols or
    //more there will be no room for the null terminator and behavior is undefined
    cin >> input;

    cout << input << endl;

    return 0;
}
