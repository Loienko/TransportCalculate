package net.ukr.dreamsicle;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import java.util.Scanner;

import static net.ukr.dreamsicle.TransportRunner.em;

/**
 * Created by Yura on 01.06.2017.
 * Next update will be add the change the name first city and last city
 */
public class ChangeCity {

    protected static void changeCity(Scanner scanner) {
        //change city
        System.out.print("Enter first city name: ");
        String firstCityName = scanner.nextLine();

        /*System.out.print("Enter last city name: ");
        String lastCityName = scanner.nextLine();*/

        System.out.print("Enter new distance to next Town: ");
        String sDistanceBetweenTown = scanner.nextLine();
        Integer distanceBetweenTown = Integer.parseInt(sDistanceBetweenTown);

        City c = null;
        try {
            TypedQuery<City> query = em.createQuery("SELECT c FROM City c WHERE c.firstCityName = :firstCityName", City.class);
            query.setParameter("firstCityName", firstCityName);
            //query.setParameter("lastCityName", lastCityName);
            c = query.getSingleResult();

        } catch (NoResultException ex) {
            System.out.println("City not found!");
            return;
        } catch (NonUniqueResultException ex) {
            System.out.println("Non unique result!");
            return;
        }

        em.getTransaction().begin();
        try {
            c.setDistanceBetweenTown(distanceBetweenTown);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

}
