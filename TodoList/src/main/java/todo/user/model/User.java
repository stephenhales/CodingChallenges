
package todo.user.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import todo.task.model.Task;

public class User {

	@Getter @Setter private String name;
	@Getter @Setter private String email;
	@Getter @Setter private List<Task> tasks;

	public boolean validate() {
		if (name == null) {
			return false;
		}
		return true;
	}
}