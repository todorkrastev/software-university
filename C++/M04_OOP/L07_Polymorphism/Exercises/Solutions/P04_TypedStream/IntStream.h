#ifndef INT_STREAM_H
#define INT_STREAM_H

#include "TypedStream.h"

class IntStream : public TypedStream<int> {
public:
	IntStream(const std::string& input) : TypedStream(input) {}

	TypedStream<int>& operator>>(int& i) override {
		this->stream >> i;
		return *this;
	}
};

#endif // !INT_STREAM_H

