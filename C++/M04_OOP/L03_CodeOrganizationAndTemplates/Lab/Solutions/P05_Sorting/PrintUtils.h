#ifndef PRINT_UTILS_H
#define PRINT_UTILS_H

template<typename C>
void printContainer(const typename C::iterator& begin, const typename C::iterator& end) {
	for (typename C::iterator i = begin; i != end; i++) {
		std::cout << *i << " ";
	}
}

#endif // !PRINT_UTILS_H
