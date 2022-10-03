#ifndef AGGREGATOR_H
#define AGGREGATOR_H

#include <istream>

class StreamAggregator {
private:
	std::istream& stream;
	int numAggregated;
protected:
	int aggregationResult;

	virtual void aggregate(int next) {
		this->numAggregated++;
	}
public:
	StreamAggregator(std::istream& stream) : stream(stream), numAggregated(0) {}

	int aggregate() {
		int next;
		while (this->stream >> next) {
			this->aggregate(next);
		}

		return this->getAggregationResult();
	}

	int getAggregationResult() const {
		return this->aggregationResult;
	}

	int getNumAggregated() const {
		return this->numAggregated;
	}

	virtual ~StreamAggregator() {}
};

#endif // !AGGREGATOR_H

