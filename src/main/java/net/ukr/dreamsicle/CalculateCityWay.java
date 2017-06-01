package net.ukr.dreamsicle;

import java.util.Scanner;

import static net.ukr.dreamsicle.TransportRunner.em;

/**
 * Created by Yura on 01.06.2017.
 */
public class CalculateCityWay {

    protected static void calculateCityWay(Scanner scanner) {

        System.out.print("Enter city name: ");
        String firstCityName = scanner.nextLine();

        City c = em.find(City.class, firstCityName);

        if (c == null) {
            System.out.println("City not found!");
            return;
        }

    }
}
