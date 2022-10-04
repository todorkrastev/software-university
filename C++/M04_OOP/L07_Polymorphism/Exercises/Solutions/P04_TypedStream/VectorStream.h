#ifndef VECTOR_STREAM_H
#define VECTOR_STREAM_H

#include "Vector2D.h"
#include "TypedStream.h"

class VectorStream : public TypedStream<Vector2D> {
public:
	VectorStream(const std::string& input) : TypedStream(input) {}

	TypedStream<Vector2D>& operator>>(Vector2D& v) override {
		double x, y;
		this->stream >> x >> y;

		v = Vector2D(x, y);

		return *this;
	}
};

#endif // !VECTOR_STREAM_H

