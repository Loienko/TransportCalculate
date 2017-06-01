package net.ukr.dreamsicle;

import javax.persistence.Query;
import java.util.List;

import static net.ukr.dreamsicle.TransportRunner.em;

/**
 * Created by Yura on 01.06.2017.
 */
public class ViewCity {

    protected static void viewCity() {
        //We make a query to the database
        Query query = em.createQuery("SELECT c FROM City c", City.class);
        List<City> list = (List<City>) query.getResultList();

        for (City c : list) {
            System.out.println(c);
        }
    }
}
