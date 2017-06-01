package net.ukr.dreamsicle;

import java.util.Scanner;

import static net.ukr.dreamsicle.TransportRunner.em;

/**
 * Created by Yura on 01.06.2017.
 */
public class AddCity {

    protected static void addCity(Scanner scanner) {

        System.out.print("Enter city name: ");
        String cityName = scanner.nextLine();

        System.out.print("Enter distance to next town: ");
        String sDistanceToNextTown = scanner.nextLine();
        int distanceToNextTown = Integer.parseInt(sDistanceToNextTown);

        System.out.print("Enter distance to next town: ");
        String sDistanceToOtherTown = scanner.nextLine();
        int distanceToOtherTown = Integer.parseInt(sDistanceToOtherTown);

        em.getTransaction().begin();
        try {
            City c = new City(cityName, distanceToNextTown, distanceToOtherTown);
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

}
