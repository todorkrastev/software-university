#include "Matrix.h"


Matrix & Matrix::operator=(const std::vector<std::vector<int>> & data) {
    _data = data;

    return *this;
}

Matrix & Matrix::operator+=(const Matrix & other) {
    for(size_t i = 0; (i < _data.size()) && (i < other._data.size()); ++i) {
        for(size_t j = 0; (j < _data[i].size()) && (j < other._data[i].size());
                                                                            ++j) {
            _data[i][j] += other._data[i][j];
        }
    }

    return *this;
}

Matrix & Matrix::operator-=(const Matrix & other) {
    for(size_t i = 0; (i < _data.size()) && (i < other._data.size()); ++i) {
        for(size_t j = 0; (j < _data[i].size()) && (j < other._data[i].size());
                                                                            ++j) {
            _data[i][j] -= other._data[i][j];
        }
    }

    return *this;
}

Matrix & Matrix::operator*=(const Matrix & other) {
    for(size_t i = 0; (i < _data.size()) && (i < other._data.size()); ++i) {
        for(size_t j = 0; (j < _data[i].size()) && (j < other._data[i].size());
                                                                            ++j) {
            _data[i][j] *= other._data[i][j];
        }
    }

    return *this;
}

Matrix & Matrix::operator/=(const Matrix & other) {
    for(size_t i = 0; (i < _data.size()) && (i < other._data.size()); ++i) {
        for(size_t j = 0; (j < _data[i].size()) && (j < other._data[i].size());
                                                                            ++j) {
            if(0 != other._data[i][j]) {
                _data[i][j] /= other._data[i][j];
            } else {
                _data[i][j] = 0;
            }
        }
    }

    return *this;
}

std::ostream & operator<<(std::ostream & os,
                          const Matrix & matrix) {
    for(size_t i = 0; i < matrix._data.size(); ++i) {
        for(size_t j = 0; j < matrix._data[i].size(); ++j) {
            os << matrix._data[i][j] << ' ';
        }
        os << std::endl;
    }

    return os;
}