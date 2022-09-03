#ifndef SEQUENCE_H
#define SEQUENCE_H

#include <vector>

template<typename T, typename Generator>
class Sequence {
public:
	class Iterator {
		const std::vector<T>& sequenceElements;
		int indexInSequence;

		Iterator(const std::vector<T>& sequenceElements, int indexInSequence)
			: sequenceElements(sequenceElements), indexInSequence(indexInSequence) {}
	public:
		static Iterator getBegin(const std::vector<T>& sequenceElements) {
			return Iterator(sequenceElements, 0);
		}

		static Iterator getEnd(const std::vector<T>& sequenceElements) {
			return Iterator(sequenceElements, -1);
		}

		const T& operator*() const {
			return this->sequenceElements.at(this->indexInSequence);
		}

		Iterator& operator++() {
			this->indexInSequence++;
			return *this;
		}

		bool operator!=(const Iterator& other) const {
			return !(*this == other);
		}

		bool operator==(const Iterator& other) const {
			bool sequencesMatch = this->sequenceElements == other.sequenceElements;
			bool bothPositionsAreEnd = isEndIndex(this->indexInSequence, this->sequenceElements)
				&& isEndIndex(other.indexInSequence, other.sequenceElements);
			bool positionsMatch = this->indexInSequence == other.indexInSequence;

			return sequencesMatch && (bothPositionsAreEnd || positionsMatch);
		}

	private:
		static int isEndIndex(int index, const std::vector<T>& sequenceElements) {
			return index == -1 || index == sequenceElements.size();
		}
	};

private:
	Generator generator;
	std::vector<T> generated;
public:
	void generateNext(int n) {
		for (int i = 0; i < n; i++) {
			this->generated.push_back(this->generator());
		}
	}

	Iterator begin() const {
		return Iterator::getBegin(this->generated);
	}

	Iterator end() const {
		return Iterator::getEnd(this->generated);
	}
};

#endif // !SEQUENCE_H

