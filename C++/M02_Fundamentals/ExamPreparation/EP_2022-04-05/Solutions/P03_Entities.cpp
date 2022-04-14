#include <iostream>
#include <algorithm>
#include <vector>
#include <sstream>

using namespace std;

void printData(vector<vector<string>>& data) {

	for (vector<vector<string>>::iterator itRows = data.begin(); itRows != data.end(); itRows++) {

		vector<string>& curRow = *itRows;

		for (vector<string>::iterator itData = curRow.begin(); itData != curRow.end(); itData++) {
			cout << *itData << " ";
		}

		cout << endl;
	}
}


int findIndex(vector<string>& columns, string& query) {

	auto colName = find(columns.begin(), columns.end(), query);

	if (colName != columns.end()) {

		return colName - columns.begin();
	}
	else {

		return -1;
	}
}


int main() {

	vector<string> columns;
	vector <vector<string>> data;
	string query;

	string buf;
	getline(cin, buf);

	istringstream columnsStream(buf);
	string colBuf;
	while (columnsStream >> colBuf) {
		columns.push_back(colBuf);
	}

	size_t numberOfColumns = columns.size();

	while (true) {
		getline(cin, buf);
		if (buf == "end") {
			break;
		}

		istringstream inputStream(buf);
		string itemBuf;
		vector<string> curLine;

		while (inputStream >> itemBuf) {
			curLine.push_back(itemBuf);
		}

		data.push_back(curLine);
	}

	cin >> query;

	int queryColumn = findIndex(columns, query);

	vector<string> queryData;
	vector<unsigned> countData;

	for (vector<string>& row : data) {

		string curData = row[queryColumn];

		int dataIndex = findIndex(queryData, curData);

		if (dataIndex == -1) {
			queryData.push_back(curData);
			countData.push_back(1);
		} else {
			countData[dataIndex]++;
		}
	}

	unsigned maxOccurrences = 0;
	int maxOccurencesIndex = 0;
	int curIndex = 0;

	for (unsigned curOccurrence : countData) {

		if (curOccurrence > maxOccurrences) {
			maxOccurrences = curOccurrence;
			maxOccurencesIndex = curIndex;
		}

		curIndex++;
	}

	cout << queryData[maxOccurencesIndex] << " " << countData[maxOccurencesIndex] << endl;

	return 0;
}
