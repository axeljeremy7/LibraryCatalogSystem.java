package TestPackage;

import java.io.IOException;
import java.util.Scanner;

import edu.wmich.cs1120.spring16.assig3axel.Controller;
import edu.wmich.cs1120.spring16.assig3axel.IController;

public class TestClassLab3 {
	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		IController control = new Controller(keyboard);
		control.readInput("file.txt");
		// F380.M1 book
		// QJ015.C42.55.2 periodical

		String response = "";
		boolean quitFlag = false;
		while (!quitFlag) {
			control.showMenu();
			response = keyboard.nextLine();
			System.out.println();
			switch (response) {
			case "1":
				control.displayCollection();
				break;
			case "2":
				control.checkoutMaterials();
				break;
			case "3":
				quitFlag = true;
				break;
			}
		}
		keyboard.close();

	}

}
