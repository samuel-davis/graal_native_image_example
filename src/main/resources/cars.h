#include <stdlib.h>
#include <stdio.h>
#include <inttypes.h>

typedef enum car_type_t {
	FORD,
	CHEVY,
	DODGE
} car_type_t;

typedef struct car_feature_t {
	car_type_t type;
	uint64_t id;
} car_feature_t;

typedef struct car_t {
    car_feature_t subject;
    car_feature_t predicate;
    car_feature_t object;
} car_t;