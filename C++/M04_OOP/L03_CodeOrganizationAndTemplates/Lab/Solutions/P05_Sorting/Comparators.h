#ifndef COMPARATORS_H
#define COMPARATORS_H

#include "Song.h"

template<typename T>
class LessThan {
public:
	bool operator()(const T& a, const T& b) const {
		return a < b;
	}
};

template<>
class LessThan<Song> {
public:
	bool operator()(const Song& a, const Song& b) const {
		return a.getLengthSeconds() < b.getLengthSeconds();
	}
};

template<typename T, typename Comp >
class Reverse {
public:
	bool operator()(const T& a, const T& b) const {
		Comp compare;
		bool aBeforeB = compare(a, b);
		return !aBeforeB;
	}
};

#endif // !COMPARATORS_H

