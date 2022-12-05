#pragma once
#include<iostream>

enum Fields { Chemistry, Physics, Linguistics, Philosophy };

class Scientist
{
private:
	char* name;
	int discoveriesCount;

public:
	Scientist();
	Scientist(char* name, int discoveriesCount);
	Scientist(const Scientist& other);
	Scientist& operator=(const Scientist& other);
	~Scientist();

	char* getName() const;
	int getDiscoveriesCount() const;
	void setName(const char* name);
	void setDiscoveriesCount(int count);

	void Print() const;
};

