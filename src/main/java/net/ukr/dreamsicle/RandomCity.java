package net.ukr.dreamsicle;

import java.util.Random;
import java.util.Scanner;

import static net.ukr.dreamsicle.TransportRunner.em;

/**
 * Created by Yura on 01.06.2017.
 * To exclude the coincidence between two cities, need to make more work with the code.
 */
public class RandomCity {

    static final String[] NAMES = {"Kiev", "Lviv", "Kharkov", "Dnepr", "Odessa", "Donetsk", "Poltava"};
    static final Random RND = new Random();
    static final Random RND1 = new Random();

    static String randomFirstName() {
        return NAMES[RND.nextInt(NAMES.length)];
    }

    static String randomLastName(){
        return NAMES[RND1.nextInt(NAMES.length)];
    }

    protected static void insertRandomCity(Scanner scanner) {

        System.out.print("Input the number of cities: ");
        String sCount = scanner.nextLine();
        int count = Integer.parseInt(sCount);

        em.getTransaction().begin();
        try {
            for (int i = 0; i < count; i++) {
                City c = new City(randomFirstName(), randomLastName(), RND.nextInt(10000));
                em.persist(c);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }
}
