#ifndef MIN_AGGREGATOR_H
#define MIN_AGGREGATOR_H

#include "Aggregator.h"

class MinAggregator : public StreamAggregator {
public:
	MinAggregator(std::istream& stream) : StreamAggregator(stream) {}

	void aggregate(int next) override {
		StreamAggregator::aggregate(next);

		if (this->getNumAggregated() == 1 || this->aggregationResult > next) {
			this->aggregationResult = next;
		}
	}
};

#endif // !MIN_AGGREGATOR_H

