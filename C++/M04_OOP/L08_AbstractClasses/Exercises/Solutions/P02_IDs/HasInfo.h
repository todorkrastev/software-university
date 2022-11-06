#ifndef HAS_INFO_H
#define HAS_INFO_H

#include <string>

class HasInfo {
public:
	virtual std::string getInfo() const = 0;

	virtual ~HasInfo() {}
};

#endif // !HAS_INFO_H

