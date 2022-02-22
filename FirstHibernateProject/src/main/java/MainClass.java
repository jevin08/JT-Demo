import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Locker;
import entities.Player;
import utilities.HibernateUtil;

public class MainClass {
	public static void addNewPlayerNewLocker(Player p, Locker l) {

		p.setLocker(l);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(p); // saving the player and locker details
		tx.commit();
		session.close();

	}

	public static void addNewPlayerNoLocker(Player p) {
		p.setLocker(null);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(p); // saving the player and null locker details
		tx.commit();
		session.close();
	}

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Player's Id");
		int id = sc.nextInt();
		System.out.println("Enter the Player's name");
		String name = sc.next();
		System.out.println("Enter the Player's date of birth in MM/dd/yyyy format");
		String datestr = sc.next();
		SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
		Date dob = (Date) formatter.parse(datestr);
		
		System.out.println("Enter the Player's address");
		String address = sc.next();
		System.out.println("Enter the Player's phoneNo");
		long phone = sc.nextLong();

		System.out.println("Do you want to allocate Locker(Y/N)");
		String lock = sc.next();
		if (lock.compareToIgnoreCase("y") == 0) {
			System.out.println("Enter the Locker Id");
			int lid = sc.nextInt();
			System.out.println("Enter the locker type");
			String ltype = sc.next();
			System.out.println("Enter the rent");
			Double lrent = sc.nextDouble();

			Locker l1 = new Locker(lid, ltype, lrent);

			Player p1 = new Player(id, name, dob, address, phone);
			addNewPlayerNewLocker(p1, l1);

			sc.close();
		} else {
			Player p1 = new Player(id, name, dob, address, phone);
			addNewPlayerNoLocker(p1);
			sc.close();
		}

	}

}
