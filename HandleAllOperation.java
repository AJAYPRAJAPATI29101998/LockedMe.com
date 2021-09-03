import java.util.Scanner;

public class HandleAllOperation {
	
	public static void handleWelcomeScreenInput() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				MenuOptions.displayMenu();
				int input = sc.nextInt();

				switch (input) {
				case 1:
					OperateFile.displayAllFiles("main");
					break;
				case 2:
					HandleAllOperation.handleFileMenuOptions();
					break;
				case 3:
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleWelcomeScreenInput();
			} 
		} while (running == true);
	}
	
		public static void handleFileMenuOptions() {
			boolean running = true;
			Scanner sc = new Scanner(System.in);
			do {
				try {
					MenuOptions.displayFileMenuOptions();
					OperateFile.createMainFolderIfNotPresent("main");
					
					int input = sc.nextInt();
					switch (input) {
					case 1:
						// File Add
						System.out.println("Enter the name of the file to be added to the \"main\" folder");
						String fileToAdd = sc.next();
						
						OperateFile.createFile(fileToAdd, sc);
						
						break;
					
					case 2:
						// File/Folder Search
						System.out.println("Enter the name of the file to be searched from \"main\" folder");
						String fileName = sc.next();
						
						OperateFile.createMainFolderIfNotPresent("main");
						OperateFile.displayFileLocations(fileName, "main");
break;
						
					case 3:
						// Exit
						System.out.println("Program exited successfully.");
						running = false;
						sc.close();
						System.exit(0);
						
					default:
						System.out.println("Please select a valid option from above.");
					}
				} catch (Exception e) {
					System.out.println(e.getClass().getName());
					handleFileMenuOptions();
				}
			} while (running == true);
		}
	}

			
