package net.ukr.dreamsicle;

import java.util.Scanner;

import static net.ukr.dreamsicle.TransportRunner.em;

/**
 * Created by Yura on 01.06.2017.
 */
public class AddCity {

    protected static void addCity(Scanner scanner) {

        System.out.print("Input first city name: ");
        String firstCityName = scanner.nextLine();

        System.out.println("Input last city name^ ");
        String lastCityName = scanner.nextLine();

        System.out.print("Input distance between town: ");
        String sDistanceBetweenTown = scanner.nextLine();
        Integer distanceBetweenTown = Integer.parseInt(sDistanceBetweenTown);

        em.getTransaction().begin();
        try {
            City c = new City(firstCityName, lastCityName, distanceBetweenTown);
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

}
