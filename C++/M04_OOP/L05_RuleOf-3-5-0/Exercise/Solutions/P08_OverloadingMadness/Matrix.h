#ifndef MATRIX_H_
#define MATRIX_H_

#include <iostream>
#include <vector>

class Matrix {
    public:
        Matrix() = default;
        ~Matrix() = default;

        Matrix & operator=(const std::vector<std::vector<int>> & data);
        Matrix & operator+=(const Matrix & other);
        Matrix & operator-=(const Matrix & other);
        Matrix & operator*=(const Matrix & other);
        Matrix & operator/=(const Matrix & other);

        friend std::ostream & operator<<(std::ostream & os,
                                         const Matrix & matrix);

    private:
        std::vector<std::vector<int>> _data;
};

#endif /* MATRIX_H_ */
