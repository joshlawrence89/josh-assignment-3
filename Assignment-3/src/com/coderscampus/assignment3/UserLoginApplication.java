package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		UserService userService = new UserService();

		User[] arr_user = new User[4];

		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			int i = 0;
			String line = "";
			while ((line = fileReader.readLine()) != null) {
				String[] accounts = line.split(",");
				arr_user[i] = userService.isUser(accounts[0], accounts[1], accounts[2]);
				i++;
			}

		} catch (FileNotFoundException e) {
			System.out.println("Oops, the file wasn't found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Oops, there was an I/O Exception");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {

			System.out.println("Enter Your email: ");
			String username = scanner.nextLine();
			username = username.toUpperCase();

			System.out.println("Enter Your password: ");
			String password = scanner.nextLine();

			for (int index = 0; index < arr_user.length; index++) {
				if (arr_user[index].getUserName().toUpperCase().equals(username)
						&& arr_user[index].getPassword().equals(password)) {
					System.out.println("Welcome: " + arr_user[index].getName());
					System.exit(0);
				} else {
				}
			}
			System.out.println();

			System.out.println("Invalid login, please try again");

			System.out.println();
		}
		System.out.println("Too many failed login attempts, you are now locked out.");
		scanner.close();
	}
}