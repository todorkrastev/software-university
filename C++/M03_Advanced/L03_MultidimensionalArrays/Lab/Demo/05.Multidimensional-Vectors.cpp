#include <iostream>
#include <vector>

int main()
{
	using namespace std;

    // NOTE: this bracket {} initialization for vectors is supported since C++11
    vector<vector<char> > charMatrix =
    {
        vector<char> {' ', ' ', '_', '_', ' ', '_', '_', ' ', ' '},
        vector<char> {' ', '/', ' ', ' ', 'V', ' ', ' ', '\\', ' '},
        vector<char> {' ', '\\', ' ', ' ', ' ', ' ', ' ', '/', ' '},
        vector<char> {' ', ' ', '\\', ' ', ' ', ' ', '/', ' ', ' '},
        vector<char> {' ', ' ', ' ', '\\', ' ', '/', ' ', ' ', ' '},
        vector<char> {' ', ' ', ' ', ' ', 'V', ' ', ' ', ' ', ' '},
		//NOTE: having a comma after the last element
		//(1D array in this case) is ok
    };

    for (size_t row = 0; row < charMatrix.size(); row++)
    {
        for (size_t col = 0; col < charMatrix[row].size(); col++)
        {
            cout << charMatrix[row][col];
        }
        cout << endl;
    }

    cout << "hearts don't look like that btw" << endl;

    vector<vector<int> >  identityMatrix =
    {
        vector<int> {1, 0, 0},
        vector<int> {0, 1, 0},
        vector<int> {0, 0, 1}
    };

    for (int row = 0; row < 3; row++)
    {
        for (int col = 0; col < 3; col++)
        {
            cout << identityMatrix[row][col] << " ";
        }
        cout << endl;
    }

    vector<vector<vector<int> > > cube =
    {
        vector<vector<int> >
        {
            vector<int> {111, 112, 113, 114},
            vector<int> {121, 122, 123, 124},
            vector<int> {131, 132, 133, 134}
        },
        vector<vector<int> >
        {
            vector<int> {211, 212, 213, 214},
            vector<int> {221, 222, 223, 224},
            vector<int> {231, 232, 233, 234}
        }
    };

    int inputMatrixRows = 0;
    int inputMatrixCols = 0;

    cout << "Enter array width: ";
    cin >> inputMatrixRows;

    cout << "Enter array height: ";
    cin >> inputMatrixCols;

    vector<vector<int> > inputMatrix;
    for (int row = 0; row < inputMatrixRows; row++)
    {
        vector<int> inputRow;
        for (int col = 0; col < inputMatrixCols; col++)
        {
            int element;
            cin >> element;
            inputRow.push_back(element);
        }

        inputMatrix.push_back(inputRow);
    }

    cout << "The matrix you typed in:" << endl;

    for (int row = 0; row < inputMatrixRows; row++)
    {
        for (int col = 0; col < inputMatrixCols; col++)
        {
            cout << inputMatrix[row][col] << " ";
        }
        cout << endl;
    }

    return 0;
}
