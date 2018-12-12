package todo;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import todo.exception.UserException;
import todo.exception.ValidationException;
import todo.task.model.Task;
import todo.user.api.UserController;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserController userController;

	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner userInput = new Scanner(System.in);
		getUserDetails(userInput);
		while(true){
			runProgram(userInput);
		}
	}

	//Like a UI
	private static int userId = 0;

	private void getUserDetails(Scanner userInput){
		String name = getUsersName(userInput);
		String email = getUsersEmail(userInput);
		try{
			userId = userController.createUser(name, email).getUserId();
		}
		catch (ValidationException e){
			System.out.println("Invalid input(s): " + e.getMessage());
			getUserDetails(userInput);
		}
		catch (UserException e){
			System.out.println("Invalid input: " + e.getMessage());
			getUserDetails(userInput);
		}
	}

	private void addNewUserTask(Scanner userInput){
		String taskDescription = getTaskDescription(userInput);
		try{
			userController.addNewTask(userId, taskDescription);
		}catch(ValidationException e){
			System.out.println("Invalid input(s): " + e.getMessage());
			addNewUserTask(userInput);
		}
	}

	private String getMenuChoice(Scanner userInput){
		System.out.println();
		System.out.println("1. create a todo task");
		System.out.println("2. complete a todo task");
		System.out.println("3. see todo list");
		return getUserInput("Pick a menu option: ", userInput);
	}

	private String getUserInput(String text, Scanner userInput){
		System.out.println(text);
		return userInput.next();
	}

	private int getUserInputInt(String text, Scanner userInput){
		System.out.println(text);
		return userInput.nextInt();
	}

	private void runProgram(Scanner userInput) {
		switch (getMenuChoice(userInput)) {
			case "1":
				addNewUserTask(userInput);
				printUserTaskList();
				break;
			case "2":
				userController.completeTask(userId, getTaskId(userInput));
				printUserTaskList();
				break;
			case "3":
				printTodoList(userController.getIncompleteTasks(userId));
				break;
			default: invalidMenuChoice();
		}
	}

	private String getTaskDescription(Scanner userInput){
		return getUserInput("enter the task description: ", userInput);
	}

	private String getUsersName(Scanner userInput){
		return getUserInput("Enter your first name: ", userInput);
	}

	private String getUsersEmail(Scanner userInput){
		return getUserInput("Enter your email address: ", userInput);
	}

	private int getTaskId(Scanner userInput){
		return getUserInputInt("what is the task id? ", userInput);
	}

	private void printUserTaskList(){
		List<Task> tasks = userController.getUserById(userId).getTasks();
		printTodoList(tasks);
	}

	private void printTodoList(List<Task> tasks){
		for(Task task: tasks){
			System.out.print("id: " + task.getId());
			System.out.print("   ");
			System.out.print("task: " + task.getDescription());
			System.out.print("   ");
			System.out.println("complete: " + task.getIsCompleted());
		}
	}

	private void invalidMenuChoice(){
		System.out.println("invalid menu choice");
		System.out.println("please choose a valid menu choice");
	}

}
