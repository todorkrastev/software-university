#ifndef CAR_H
#define CAR_H

#include <string>

class Car {

private:
	std::string m_sBrand;
	std::string m_sModel;

	unsigned int m_unYear;

public:

	Car(std::string sBrand, std::string sModel, unsigned int unYear) {
		m_sBrand = sBrand;
		m_sModel = sModel;
		m_unYear = unYear;
	}

	std::string GetBrand() const {
		return m_sBrand;
	}

	std::string GetModel() const {
		return m_sModel;
	}

	int GetYear() const {
		return m_unYear;
	}

};

#endif // !CAR_H