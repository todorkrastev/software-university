#ifndef AVERAGE_AGGREGATOR_H
#define AVERAGE_AGGREGATOR_H

#include "Aggregator.h"

class AverageAggregator : public StreamAggregator {
	int total;
public:
	AverageAggregator(std::istream& stream) : StreamAggregator(stream), total(0) {}

	void aggregate(int next) override {
		StreamAggregator::aggregate(next);
		this->total += next;
		this->aggregationResult = this->total / this->getNumAggregated();
	}
};

#endif // !AVERAGE_AGGREGATOR_H