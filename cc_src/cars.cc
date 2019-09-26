#include "cars.h"

static uint64_t counter = 1;

extern "C" {

	garage_t* createGarage() {
	    garage_t *garage = (garage_t*) malloc(sizeof(garage_t));
	    garage->car1.id = counter++;
	    garage->car2.id = counter++;
	    garage->car3.id = counter++;
	    enum car_type_t t1 = FORD;
	    enum car_type_t t2 = CHEVY;
	    enum car_type_t t3 = DODGE;

      garage->car1.type = t1;
      garage->car2.type = t2;
      garage->car3.type = t3;

	    garage->owner_name = strdup("Sam Davis");



	    char *listOfOwners[3];

	    listOfOwners[0] =strdup("Sam Davis");
	    listOfOwners[1] =strdup("Doug");
	    listOfOwners[2] =strdup("Bryan");

	    garage->car_owner_names=listOfOwners;
	    return garage;
	}

	void freeGarage(garage_t *garage) {
      //if(garage->owner_name != NULL){
      //  free(garage->owner_name);
     // }
	    free(garage);
	}

  void sayHello(){
       printf("Hello, World from Graal VM Native Image!");
  }

}