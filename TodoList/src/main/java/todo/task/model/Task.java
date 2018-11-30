
package todo.task.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {

	private int id;
	private String description;
	private Boolean isCompleted;

}