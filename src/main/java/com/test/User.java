package com.test;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.user.post.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="user_details")
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="Minum must be 2char")
	private String userName;
	
	@Past(message="No past")
	private LocalDate dob;
	
	private String desc;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;
	public List<Post> getPosts() {
		return posts;
	}

	
	public User() {
		
	}

	public User(Integer id, String userName, LocalDate dob) {
		super();
		this.id = id;
		this.userName = userName;
		this.dob = dob;
	}
	public User(Integer id, @Size(min = 2, message = "Minum must be 2char") String userName,
			@Past(message = "No past") LocalDate dob, String desc) {
		super();
		this.id = id;
		this.userName = userName;
		this.dob = dob;
		this.desc = desc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", dob=" + dob + ", desc=" + desc + "]";
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}	
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
