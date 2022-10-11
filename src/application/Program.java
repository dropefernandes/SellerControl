package application;

import java.util.List;
import java.util.Scanner;

import dao.DaoFactory;
import dao.DepartmentDao;
import entities.Department;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n =========== Find All ===========");
		
		List<Department> departments = departmentDao.findAll();
		for(Department department : departments) {
			System.out.println(department);
		}
		
		System.out.println("\n =========== Find By Id ===========");
		System.out.println("Enter id for search department: ");
		int id = sc.nextInt();
		
		Department department = departmentDao.findById(id);
		System.out.println(department);
		
		System.out.println("\n =========== insert ===========");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());

		System.out.println("\n =========== update ===========");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");
		
		System.out.println("\n =========== delete =========== ");
		System.out.print("Enter id for delete test: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
//		SellerDao dao = DaoFactory.createSellerDao();
//
//		System.out.println("======== Find By Id ========");
//		
//		Seller seller = dao.findById(3);
//		System.out.println(seller);
//		
//		System.out.println("\n ======== GET BY DEPARTMENT ========");
//		
//		Department department = new Department(2, null);
//		List<Seller> sellers = dao.findByDepartment(department);
//		for (Seller obj : sellers) {
//			System.out.println(obj);
//		}
//		
//		System.out.println("\n ========== insert ========");
//		
//		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4500.00, department);
//		dao.insert(newSeller);
//		System.out.println("Inserted! New Id = " + newSeller.getId());
//		
//		
//		System.out.println("\n ========== update ========");
//		
//		seller = dao.findById(1);
//		seller.setName("Rafaela Marchesini");
//		dao.update(seller);
//		System.out.println(seller);
//		
//		
//		System.out.println("\n ========== delete ========");
//		System.out.println("Enter id for delete test: ");
//		int id = sc.nextInt();
//		
//		dao.deleteById(id);
//		System.out.println("Deleted!");
//		
		sc.close();
	}
}
