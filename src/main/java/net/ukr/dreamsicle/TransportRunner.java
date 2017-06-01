package net.ukr.dreamsicle;


import javax.persistence.*;
import java.util.Scanner;

import static net.ukr.dreamsicle.AddCity.addCity;
import static net.ukr.dreamsicle.CalculateCityWay.calculateCityWay;
import static net.ukr.dreamsicle.ChangeCity.changeCity;
import static net.ukr.dreamsicle.DeleteCity.deleteCity;
import static net.ukr.dreamsicle.RandomCity.insertRandomCity;
import static net.ukr.dreamsicle.ViewCity.viewCity;

/**
 * Created by Yura on 01.06.2017.
 */
public class TransportRunner {
    //create Fabric
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            //create connection
            emf = Persistence.createEntityManagerFactory("TransportCalculate");
            em = emf.createEntityManager();
            try {
                while (true) {
                    System.out.println("\n1: add city (Sorry, don't work else)");
                    System.out.println("2: add random city");
                    System.out.println("3: delete city");
                    System.out.println("4: change city");
                    System.out.println("5: calculation of the minimum price between a pair of cities (Sorry, don't work else)");
                    System.out.println("6: view city");
                    System.out.println("7: If do you want to leave");
                    System.out.println("Please, make your choice!");
                    System.out.print("  -> \n");

                    String s = scanner.nextLine();
                    switch (s) {
                        case "1":
                            addCity(scanner);
                            break;
                        case "2":
                            insertRandomCity(scanner);
                            break;
                        case "3":
                            deleteCity(scanner);
                            break;
                        case "4":
                            changeCity(scanner);
                            break;
                        case "5":
                            calculateCityWay(scanner);
                            break;
                        case "6":
                            viewCity();
                            break;
                        case "7":
                            System.out.println("Goodbye!!!");
                            return;
                        default:
                            return;
                    }
                }
            }finally {
                System.out.println("Goodbye!!!");
                scanner.close();
                em.close();
                emf.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return;
        }
    }
}
