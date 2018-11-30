package todo;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import todo.task.api.TaskController;
import todo.task.model.Task;
import todo.user.api.UserController;
import todo.user.model.User;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserController userController;

	@Autowired
	private TaskController taskController;


	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner userInput = new Scanner(System.in);
		User user = getUserDetails(userInput);
		while(true){
			runProgram(user, userInput);
		}
	}

	//Like a UI

	private User getUserDetails(Scanner userInput){
		String name = getUserInput("Enter your first name: ", userInput);
		//String email = getUserInput("Enter your email address: ", userInput);
		return userController.createUser(name);
	}

	private Task getNewTask(Scanner userInput){
		String taskId = getUserInput("what is the Task ID? ", userInput);
		String taskDescription = getUserInput("what is the Task Description? ", userInput);
		return taskController.createTask(taskId, taskDescription);
	}

	private String getMenuChoice(Scanner userInput){
		System.out.println();
		System.out.println("1. create a todo.task");
		System.out.println("2. complete a todo.task");
		System.out.println("3. see completed tasks");
		System.out.println("4. see incomplete tasks");
		return getUserInput("Pick a menu option: ", userInput);
	}

	private void invalidMenuChoice(){
		System.out.println("invalid menu choice");
		System.out.println("please choose a valid menu choice");
	}

	private String getUserInput(String text, Scanner userInput){
		System.out.println(text);
		return userInput.next( );
	}

	private String getTaskId(Scanner userInput){
		return getUserInput("what is the Task ID? ", userInput);
	}

	private void runProgram(User user, Scanner userInput) {
		switch (getMenuChoice(userInput)) {
			case "1":
				userController.addNewTask(user, getNewTask(userInput));
				break;
			case "2":
				userController.completeTask(user, getTaskId(userInput));
				break;
			case "3":
				userController.getCompletedTasks(user);
				break;
			case "4":
				userController.getIncompleteTasks(user);
				break;
			default: invalidMenuChoice();
		}
	}
}
