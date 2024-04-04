package com.pedicab;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.pedicab.daos.UserDAO;
import com.pedicab.daos.UserDAOImpl;
import com.pedicab.models.User;

public class Main {
	
	private static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) throws SQLException {
		
		try (Connection conn = DatabaseConnector.getConnection()){
			System.out.println("Connection successful " + conn);
		} catch (SQLException e) {
			e.printStackTrace();
			return; //exit if connection is unsuccessful
		}
		
		System.out.println("");
		System.out.println("--------------------------------");
		
		System.out.println("\n=============================");
		System.out.println("   WELCOME TO BLIT PEDICAB     ");
		System.out.println("=============================\n");

		UserDAO userDAO = new UserDAOImpl();
		
		List<User> users = userDAO.getAll(); 
		
		
//		
//		User user = userDAO.get(2);
//		
		System.out.println(users);
//		
//		int result = userDAO.delete(user);
//		
//		System.out.println(result);
		
		
		
		
		boolean running = true;
		while (running) {
			System.out.println("Please choose your options");
			System.out.println("");
			System.out.println("1. Book a tour");
			System.out.println("");
			System.out.println("2. Check my tour");
			System.out.println("");
			System.out.println("3. Special request");
			System.out.println("");
			System.out.println("0. Exit\n");
			System.out.println("Enter your choice: ");
			
			String answer = scan.nextLine();
			
			switch(answer) {
				case "1": 
//					booktour();
					System.out.println("Thank you for visiting Blit Pedicab");
					break;
				case "2":
//					checkTour();
					System.out.println("Thank you for visiting Blit Pedicab");
					break;
				case "3":
//					specialRequest();
					System.out.println("Thank you for visiting Blit Pedicab");
					break;
				case "0":
					System.out.println("Thank you for visiting Blit Pedicab");
					running = false;
					break;
				default:
					System.out.println("\nPlease choose valid option number\n");
					break;
			}
		}
	}
}
