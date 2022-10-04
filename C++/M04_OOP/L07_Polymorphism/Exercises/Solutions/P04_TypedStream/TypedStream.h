#ifndef TYPED_STREAM_H
#define TYPED_STREAM_H

#include <string>
#include <istream>
#include <vector>

template<typename T>
class TypedStream {
protected:
	std::istringstream stream;
public:
	TypedStream(const std::string& input) : stream(input) {}

	virtual TypedStream<T>& operator>>(T& t) {
		return *this;
	}

	std::vector<T> readToEnd() {
		std::vector<T> items;
		T item;
		this->operator>>(item);
		while (this->stream) {
			items.push_back(item);
			this->operator>>(item);
		}

		return items;
	}

	virtual ~TypedStream() {}
};

#endif // !TYPED_STREAM_H

