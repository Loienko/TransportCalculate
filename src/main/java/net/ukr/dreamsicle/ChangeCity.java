package net.ukr.dreamsicle;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.Scanner;

import static net.ukr.dreamsicle.TransportRunner.em;

/**
 * Created by Yura on 01.06.2017.
 */
public class ChangeCity {

    protected static void changeCity(Scanner scanner) {
        //change city
        System.out.print("Enter city name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new distance to next Town: ");
        String sDistanceToNextTown = scanner.nextLine();
        int distanceToNextTown = Integer.parseInt(sDistanceToNextTown);

        System.out.print("Enter new distance to next Town: ");
        String sDistanceToOtherTown = scanner.nextLine();
        int distanceToOtherTown = Integer.parseInt(sDistanceToOtherTown);

        City c = null;
        try {
            Query query = em.createQuery("SELECT c FROM City c WHERE c.name = :name", City.class);
            query.setParameter("name", name);
            c = (City) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("City not found!");
            return;
        } catch (NonUniqueResultException ex) {
            System.out.println("Non unique result!");
            return;
        }

        em.getTransaction().begin();
        try {
            c.setDistanceToNextTown(distanceToNextTown);
            c.getDistanceToOtherTown(distanceToOtherTown);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

}
