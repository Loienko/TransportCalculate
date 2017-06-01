package net.ukr.dreamsicle;

import java.util.Random;
import java.util.Scanner;

import static net.ukr.dreamsicle.TransportRunner.em;

/**
 * Created by Yura on 01.06.2017.
 */
public class RandomCity {

    static final String[] NAMES = {"Kiev", "Lviv", "Kharkov", "Dnepr", "Odessa"};
    static final Random RND = new Random();

    static String randomName() {
        return NAMES[RND.nextInt(NAMES.length)];
    }

    protected static void insertRandomCity(Scanner scanner) {

        System.out.print("Enter way count: ");
        String sCount = scanner.nextLine();
        int count = Integer.parseInt(sCount);

        em.getTransaction().begin();
        try {
            for (int i = 0; i < count; i++) {
                City c = new City(randomName(), randomName(), RND.nextInt(10000));
                em.persist(c);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }
}
