package net.ukr.dreamsicle;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

import static net.ukr.dreamsicle.TransportRunner.em;

/**
 * Created by Yura on 01.06.2017.
 */
public class CalculatePrice {

    protected static void calculatePriceWay(Scanner scanner) {

        System.out.print("Enter city name: ");
        String firstCityName = scanner.nextLine();

        Query query = em.createQuery("SELECT c FROM City c", City.class);
        List<City> list = (List<City>) query.getResultList();

        double sum = 0;
        
        for (City c : list) {
            if (c.getFirstCityName() .equals(firstCityName)){
                sum = c.getDistanceBetweenTown()*1.5;
                System.out.println("Fare between " + c.getFirstCityName() + " and " + c.getLastCityName() + " = " + sum + " $");
            }
        }
    }
}
