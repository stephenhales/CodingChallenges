
package todo.user.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import todo.task.model.Task;

@Getter
@Setter
public class User {

	private String name;
	private String email;
	private List<Task> tasks;
}