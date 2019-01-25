package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: Department insert ====");
		Department newDep = new Department(null, "Home");
		departmentDao.insert(newDep);
		System.out.println("Department inserted! ID = "+ newDep.getId());
		
		System.out.println("\n==== TEST 2: Department findById ====");
		Department fById = departmentDao.findById(4);
		System.out.println(fById);
		
		System.out.println("\n==== TEST 3: Department update ====");
		fById.setName("Nature");
		departmentDao.update(fById);
		System.out.println(fById);
		
		System.out.println("\n==== TEST 4: Department findAll ====");
		List<Department> department = departmentDao.findAll();
		department.sort((x, y) -> x.getId().compareTo(y.getId()));
		department.forEach(System.out::println);
		
		System.out.println("\n==== TEST 5: Department deleteById ====");
		System.out.print("Enter department ID to delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Department deleted!");
		
		sc.close();

	}

}
