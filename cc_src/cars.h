#include <stdlib.h>
#include <stdio.h>
#include <inttypes.h>
#include <string.h>
typedef enum car_type_t {
	FORD,
	CHEVY,
	DODGE
} car_type_t;

typedef struct car_t {
	car_type_t type;
	uint64_t id;
} car_t;

typedef struct garage_t {
    char* owner_name;
    // Only here to test char** in graalvm this is a stupid way to structure code.
    char** car_owner_names;
    car_t car1;
    car_t car2;
    car_t car3;
} garage_t;