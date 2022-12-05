#pragma once
#include "Scientist.h"

class Discovery
{
private:
	char* discoveryName;
	int year;
	Scientist scientist;
	Fields fieldOfStudy;

public:
	Discovery();
	Discovery(const char* discoveryName, int year, const Scientist& scientistName, Fields fieldOfStudy);
	Discovery(const Discovery& other);

	char* getDiscoveryName() const;
	int getYear() const;
	Scientist getScientist() const;
	Fields getFieldOfStudy() const;

	void setDiscoveryName(const char* name);
	void setYear(int year);
	void setScientist(const Scientist& author);
	void setFieldOfStudy(Fields fieldOfStudy);
	char* getScientistName() const;

	Discovery& operator = (const Discovery& other);
	~Discovery();

};

