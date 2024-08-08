package com.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDoaService {

	private static List <User> users = new ArrayList<>();
	
	private static int userCount=0;
	static {
		users.add(new User(++userCount,"Muru",LocalDate.now().minusYears(25)));
		users.add(new User(++userCount,"Abc",LocalDate.now().minusYears(26)));
		users.add(new User(++userCount,"era",LocalDate.now().minusYears(51)));
	}
	public List<User> findAll(){
		return users;
	}
	
	public User findOne( int id) {
		Predicate<? super User> perdicate = user -> user.getId().equals(id);
		return users.stream().filter(perdicate).findFirst().orElse(null);
	}
	
	public User create(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	public void deleteUser(int id) {
		Predicate<? super User> perdicate = user -> user.getId().equals(id);
		
		users.removeIf(perdicate);
	}
}
