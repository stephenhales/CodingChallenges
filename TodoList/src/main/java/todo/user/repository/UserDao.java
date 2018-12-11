package todo.user.repository;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import todo.task.model.Task;
import todo.user.model.User;

@Setter
@Getter
public class UserDao {

	private String name;
	private String email;
	private int userId;
	private List<Task> tasks;

	public UserDao(User user){
		this.name = user.getName();
		this.email = user.getEmail();
		this.tasks = user.getTasks();
	}

}
