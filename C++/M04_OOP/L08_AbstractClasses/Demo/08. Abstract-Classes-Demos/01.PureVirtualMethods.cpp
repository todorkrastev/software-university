#include <iostream>
#include <fstream>
#include <string>
#include <sstream>

class Writer {
protected:
	std::ostringstream log;
public:
	Writer() {}
	virtual void write(std::string s) = 0;

	std::string getLog() const {
		return this->log.str();
	}

	virtual ~Writer() {}
};

class ConsoleWriter : public Writer {
public:
	void write(std::string s) override {
		std::cout << s;
		this->log << "wrote " << s.size() << " bytes to console";
	}
};

class FileWriter : public Writer {
	std::string filename;
	std::ofstream fileOut;
public:
	FileWriter(std::string filename)
		: filename(filename)
		, fileOut(filename) {
	}

	void write(std::string s) override {
		this->fileOut << s;
		this->log << "wrote " << s.size() << " bytes to " << filename;
	}
};

void writeHello(Writer& writer) {
	writer.write("hello\n");
}

int main() {
	//Writer writer; // compilation error
	FileWriter fileWriter("03. output.txt");
	ConsoleWriter consoleWriter;

	writeHello(fileWriter);
	std::cout << fileWriter.getLog() << std::endl;

	writeHello(consoleWriter);
	std::cout << consoleWriter.getLog() << std::endl;

	return 0;
}
