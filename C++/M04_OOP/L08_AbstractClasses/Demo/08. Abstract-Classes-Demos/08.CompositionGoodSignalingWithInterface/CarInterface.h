#ifndef CARINTERFACE_H_
#define CARINTERFACE_H_

class CarInterface {
public:
  virtual ~CarInterface() = default;

  virtual void setFullTurn(bool status) = 0;
};



#endif /* CARINTERFACE_H_ */
