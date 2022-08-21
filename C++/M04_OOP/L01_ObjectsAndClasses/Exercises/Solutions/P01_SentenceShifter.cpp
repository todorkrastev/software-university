#include <iostream>
#include <sstream>
#include <string>
#include <vector>

class Sequence {

public:
	typedef std::vector<std::string> Sentence;

	Sequence(std::istream& stream);

	Sentence getShiftedSentence(size_t index);

	void print(std::ostream& ostr);
	static void print(std::ostream& ostr, const Sentence& seq);


private:
	Sentence sent;
};

Sequence::Sequence(std::istream& istr) {

	std::string buf;
	std::getline(istr, buf);

	std::istringstream sstr(buf);

	while (sstr >> buf) {
		sent.push_back(buf);
	}
}

void Sequence::print(std::ostream& ostr, const Sentence& seq) {
	std::string str;
	for (size_t i = 0; i < seq.size(); i++) {
		ostr << seq[i] << std::endl;
	}
}

void Sequence::print(std::ostream& ostr) {
	print(ostr, sent);
}

Sequence::Sentence Sequence::getShiftedSentence(size_t index) {
	Sentence ret;
	ret.resize(this->sent.size());
	size_t curr;


	for (curr = 0, index = ret.size() - index; curr < ret.size(); curr++) {
		ret[curr] = this->sent[index];
		index++;
		if (index >= ret.size()) {
			index = 0;
		}
	}

	return ret;
}

int main() {

	Sequence seq(std::cin);

	size_t shifter;

	std::cin >> shifter;

	Sequence::Sentence res = seq.getShiftedSentence(shifter);

	Sequence::print(std::cout, res);

	return 0;
}