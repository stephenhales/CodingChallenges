package todo.user.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import todo.user.model.User;

@Repository
public class UserRepository {
	private static List<UserDao> users = new ArrayList<>();
	private int nextUserId = 0;

	public Optional<User> getUserById(int userId){
		return users.stream()
			.filter(dao -> dao.getUserId() == userId)
			.findFirst()
			.map(User::new);
	}

	public User createUser(User user){
		user.setUserId(nextUserId++);
		users.add(new UserDao(user));
		return user;
	}

	public User updateUser(User user){
		users.stream()
			.filter(dao -> dao.getUserId() == user.getUserId())
			.findFirst()
			.ifPresent(dao -> dao = new UserDao(user));
		return user;
	}
}
