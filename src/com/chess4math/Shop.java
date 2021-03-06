package com.chess4math;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.chess4math.data.Drink;
import com.chess4math.data.Food;
import com.chess4math.data.Product;
import com.chess4math.data.ProductManager;

import static com.chess4math.data.Rating.*;


/**
 *
 * @author lorenchess
 */
public class Shop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ProductManager pm = new ProductManager();

        Product p1 = pm.createProduct (101,"Tea",BigDecimal.valueOf(1.99), THREE_STAR);

        Product p2 = pm.createProduct (102,"Coffee",BigDecimal.valueOf(1.99),
                FOUR_STAR);

        Product p3 = pm.createProduct (103,"Cake",BigDecimal.valueOf(3.99),
                FIVE_STAR, LocalDate.now().plusDays(2));

        Product p4 = pm.createProduct (105,"Cookie",BigDecimal.valueOf(3.99),TWO_STAR,LocalDate.now());

        Product p5 = p3.applyRating(THREE_STAR);

        Product p6 = pm.createProduct (104, "Chocolate", BigDecimal.valueOf(2.99),
                FIVE_STAR);

        Product p7 = pm.createProduct (104, "Chocolate", BigDecimal.valueOf(2.99),
                FIVE_STAR, LocalDate.now().plusDays(2));

        Product p8 = p4.applyRating(FIVE_STAR);

        Product p9 = p1.applyRating(TWO_STAR);

        System.out.println(p6.equals(p7));

        //System.out.println(p1.getBestBefore());
//        System.out.println(p3.getBestBefore());

//        System.out.println(p1.getId()+" "+p1.getName() + " " + p1.getPrice()+" "
//                +p1.getDiscount() +" "+ p1.getRating().getStars());
//        System.out.println(p2.getId()+" "+p2.getName() + " " + p2.getPrice()+" "
//                +p2.getDiscount() +" "+ p2.getRating().getStars());
//        System.out.println(p3.getId()+" "+p3.getName() + " " + p3.getPrice()+" "
//                +p3.getDiscount() +" "+ p3.getRating().getStars());
//        System.out.println(p4.getId()+" "+p4.getName() + " " + p4.getPrice()+" "
//                +p4.getDiscount() +" "+ p4.getRating().getStars());
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);
        System.out.println(p8);
    }

}
