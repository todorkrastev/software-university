#ifndef PAIR_H
#define PAIR_H

template<typename T1, typename T2>
class Pair {
public:
	T1 first; T2 second;

	Pair(T1 first, T2 second) :
		first(first),
		second(second) {
	}
};

#endif // !PAIR_H