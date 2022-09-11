#ifndef LIST_H
#define LIST_H

#include <string>

class List {
private:
    class Node {
    private:
        int value;
        Node * prev;
        Node * next;

    public:
        Node(int value, Node * prev, Node * next);

        int getValue() const;
        void setValue(int value);

        Node * getNext() const;
        void setNext(Node * next);

        Node * getPrev() const;
        void setPrev(Node * prev);
    };

    Node * head;
    Node * tail;
    size_t size;
public:
    List();
    List(const List& other);

    int first() const ;
    void add(int value);
    void addAll(const List& other);
    void removeFirst();
    void removeAll();

    size_t getSize() const;
    bool isEmpty() const;

    static List getReversed(List l);
    std::string toString() const;

    List& operator<<(const int& value);
    List& operator<<(const List& other);

    List& operator=(const List& other);

    ~List();
};

#endif // LIST_H
