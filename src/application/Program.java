package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: Seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2: Seller findByDepartment ====");
		List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
		list.sort((x, y) -> x.getId().compareTo(y.getId()));
		list.forEach(System.out::println);
		
		System.out.println("\n==== TEST 3: Seller findAll ====");
		List<Seller> list2 = sellerDao.findAll();
		list2.sort((x, y) -> x.getId().compareTo(y.getId()));
		list2.forEach(System.out::println);
		
		System.out.println("\n==== TEST 3: Seller insert ====");
		Seller newSeller = new Seller(null, "Fellipe", "fellipe@gmail.com", new Date(), 5000.0, new Department(1, null));
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New ID = " + newSeller.getId());
		
		System.out.println("\n==== TEST 4: Seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n==== TEST 5: Seller delete ====");
		System.out.print("Enter ID for delete: ");
		
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deleted!");
		
		sc.close();
	}
}
