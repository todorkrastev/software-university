#include<iostream>
#include<string>
#include<map>
#include<vector>
using namespace std;

typedef string TenStrings[10];

void printArray(TenStrings strings) {
    for (int i = 0; i < 10; i++) {
        cout << strings[i] << " ";
    }
    cout << endl;
}

int main() {
    typedef unsigned long long ull;
    ull number = 42; //unsigned long long number = 42;

    TenStrings words = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog", "!"};

    printArray(words);

    cout << endl;

    typedef map<string, vector<int> > StudentScores;

    // Scores are from here, names are changed: https://judge.softuni.bg/Contests/Compete/Results/Simple/878
    StudentScores judgeAssignment2Scores;
    judgeAssignment2Scores["ghost4e"] = {100, 100, 100, 100};
    judgeAssignment2Scores["Reclaimer"] = {100, 80, 0, 100};
    judgeAssignment2Scores["SpecificDude"] = {100, 90, 100, 100};

    for (StudentScores::iterator i = judgeAssignment2Scores.begin(); i != judgeAssignment2Scores.end(); i++) {
        cout << i->first << " ";
        for (int score : i->second) {
            cout << score << " ";
        }

        cout << endl;
    }

    return 0;
}
