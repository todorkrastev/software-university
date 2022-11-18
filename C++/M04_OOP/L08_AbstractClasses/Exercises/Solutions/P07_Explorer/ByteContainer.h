#ifndef BYTE_CONTAINER_H
#define BYTE_CONTAINER_H

#include <string>

class ByteContainer {
public:
	virtual std::string getBytes() const = 0;

	virtual ~ByteContainer() {}
};

#endif // !BYTE_CONTAINER_H

