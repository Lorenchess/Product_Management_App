package com.chess4math.data;

import static com.chess4math.data.Rating.*;

/**
 * Annotation @FunctionalInterface prevents interface from compiling if it
defines more than one abstract method.
 */

@FunctionalInterface
public interface Rateable <T> {
    Rating DEFAULT_RATING = NOT_RATED;

     T applyRating (Rating rating);

     default Rating getRating() {
         return DEFAULT_RATING;
     }

     /*This method convert() is static mainly due it does not belong necessary to any object,
     it could be applied any object */

     static Rating convert (int stars) {
       return (stars >= 0 && stars <= 5) ? Rating.values()[stars] : DEFAULT_RATING;
     }

    default T applyRating (int stars) {
         return applyRating (Rateable.convert(stars));
    }
}
