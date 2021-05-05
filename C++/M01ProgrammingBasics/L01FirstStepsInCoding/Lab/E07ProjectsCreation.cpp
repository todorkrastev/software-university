#include <iostream>
using namespace std;

int main()
{
    string name;
    cin >> name;

    int numOfProjects;
    cin >> numOfProjects;

    int timeNeedForASingleProject = 3;

    int totalTime = timeNeedForASingleProject * numOfProjects;

    cout << "The architect " << name << " will need " << totalTime << " hours to complete " << numOfProjects << " prject/s.";
    return 0;
}
