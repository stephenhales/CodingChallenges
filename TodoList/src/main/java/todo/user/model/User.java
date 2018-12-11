
package todo.user.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import todo.task.model.Task;
import todo.user.repository.UserDao;

@Getter
@Setter
public class User {

	private String name;
	private String email;
	private int userId;
	private List<Task> tasks;

	public User(String name, String email){
		this.name = name;
		this.email = email;
		this.tasks = new ArrayList<>();
	}

	public User(String name, String email, int userId){
		this.name = name;
		this.email = email;
		this.userId = userId;
		this.tasks = new ArrayList<>();
	}

	public User(UserDao userDao){
		this.name = userDao.getName();
		this.email = userDao.getEmail();
		this.tasks = userDao.getTasks();
	}

	public void addTask(Task task){
		this.tasks.add(task);
	}
}