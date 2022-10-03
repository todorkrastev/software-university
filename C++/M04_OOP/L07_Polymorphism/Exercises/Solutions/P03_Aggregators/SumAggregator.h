#ifndef SUM_AGGREGATOR_H
#define SUM_AGGREGATOR_H

#include "Aggregator.h"

class SumAggregator : public StreamAggregator {
public:
	SumAggregator(std::istream& stream) : StreamAggregator(stream) {}

	void aggregate(int next) override {
		StreamAggregator::aggregate(next);

		if (this->getNumAggregated() == 1) {
			this->aggregationResult = 0;
		}

		this->aggregationResult += next;
	}
};

#endif // !SUM_AGGREGATOR_H

