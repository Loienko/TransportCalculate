package net.ukr.dreamsicle;

import java.util.Scanner;

import static net.ukr.dreamsicle.TransportRunner.em;

/**
 * Created by Yura on 01.06.2017.
 */
public class DeleteCity {

    protected static void deleteCity(Scanner scanner) {
        
        System.out.print("Enter city id: ");
        String sId = scanner.nextLine();
        int id = Integer.parseInt(sId);

        City c = em.find(City.class, id);
        if (c == null) {
            System.out.println("City not found!");
            return;
        }

        em.getTransaction().begin();
        try {
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

}
