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
import todo.user.model.User;


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
		User user = getUserDetails(userInput);
		while(true){
			user = runProgram(user, userInput);
		}
	}

	//Like a UI

	private User getUserDetails(Scanner userInput){
		String name = getUsersName(userInput);
		String email = getUsersEmail(userInput);
		try{
			return userController.createUser(name, email);
		}
		catch (ValidationException e){
			System.out.println("Invalid input(s): " + e.getMessage());
			return getUserDetails(userInput);
		}
		catch (UserException e){
			System.out.println("Invalid input: " + e.getMessage());
			return getUserDetails(userInput);
		}
	}

	private User addNewUserTask(User user, Scanner userInput){
		String taskDescription = getTaskDescription(userInput);
		try{
			return userController.addNewTask(user, taskDescription);
		}catch(ValidationException e){
			System.out.println("Invalid input(s): " + e.getMessage());
			return addNewUserTask(user, userInput);
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

	private User runProgram(User user, Scanner userInput) {
		switch (getMenuChoice(userInput)) {
			case "1":
				return addNewUserTask(user, userInput);
			case "2":
				return userController.completeTask(user, getTaskId(userInput));
			case "3":
				printTodoList(userController.getIncompleteTasks(user));
				return user;
			default: invalidMenuChoice();
				return user;
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

	private void printTodoList(List<Task> tasks){
		for(Task task: tasks){
			System.out.print("id: " + task.getId());
			System.out.print("   ");
			System.out.println("task: " + task.getDescription());
		}
	}

	private void invalidMenuChoice(){
		System.out.println("invalid menu choice");
		System.out.println("please choose a valid menu choice");
	}

}
