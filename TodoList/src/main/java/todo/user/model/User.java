
package todo.user.model;

import java.util.List;
import lombok.Getter;
import todo.task.model.Task;

@Getter
public class User {

	private String name;
	private String email;
	private List<Task> tasks;

	public User(String name, String email){
		this.name = name;
		this.email = email;
	}
}