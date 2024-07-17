package com.gaurav.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gaurav.entity.Notes;
import com.gaurav.entity.User;

@Component
public interface UserDao {
public int saveUser(User user);

public User login(String email,String password);

public User loginCheck(String email,String password);

public int saveNotes(Notes notes);

public List<Notes> getNotesByUser(User user);

public Notes getNotesById(int id);

public void deleteNotes(int id);

public void updateNotes(Notes n);

	
	
}
