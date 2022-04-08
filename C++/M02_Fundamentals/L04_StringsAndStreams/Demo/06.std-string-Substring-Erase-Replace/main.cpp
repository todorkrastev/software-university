#include<iostream>
#include<string>
using namespace std;

int main() {
    string sentence = "the quick brown fox jumps over the lazy dog";

    //"the " is skipped
    string partOfSentenceToEnd = sentence.substr(4);
    cout << partOfSentenceToEnd << endl;

    string partOfSentence = sentence.substr(4, 10);
    cout << partOfSentence << endl;

    string foxWord = "fox";
    string horseWord = "horse";

    sentence.replace(sentence.find(foxWord), foxWord.size(), horseWord);

    cout << "AFTER REPLACING " << foxWord << " WITH " << horseWord << ":" << endl;
    cout << sentence << endl;

    return 0;
}
