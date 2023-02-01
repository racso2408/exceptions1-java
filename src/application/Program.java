package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();

        System.out.print("Room Number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date: (DD/MM/YYYY) ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date: (DD/MM/YYYY) ");
        Date checkOut = sdf.parse(sc.next());

        if (checkIn.before(now) || checkOut.before(now)){
            System.out.println("Error in reservation. Reservation dates must be future dates.");
            System.exit(0);
        } else if (!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date.");
            System.exit(0);
        }

        Reservation reservation = new Reservation(number, checkIn, checkOut);
        System.out.println(reservation);
        System.out.println();


        System.out.print("Update reservation? (s/n) ");
        char resp = sc.next().charAt(0);
        if (resp == 'n'){
            System.out.println("No updates were recorded.");
            System.exit(0);
        } else {
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date: (DD/MM/YYYY) ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date: (DD/MM/YYYY) ");
            checkOut = sdf.parse(sc.next());
            if (checkIn.before(now) || checkOut.before(now)){
                System.out.println("Error in reservation. Reservation dates must be future dates.");
                System.exit(0);
            } else if (!checkOut.after(checkIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date.");
                System.exit(0);
            }
            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);



        }



        sc.close();

    }
}
