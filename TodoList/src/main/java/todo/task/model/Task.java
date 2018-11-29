
package todo.task.model;

import lombok.Getter;
import lombok.Setter;

public class Task {

	@Getter @Setter private String description;
	@Getter @Setter private Boolean isCompleted;

	public boolean validate() {
		if (description == null) {
			return false;
		}
		return true;
	}
}