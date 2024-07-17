package com.gaurav.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.gaurav.entity.Notes;
import com.gaurav.entity.User;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;

@Transactional
@Repository //you can use here component or service also but this good for dao
public class UserDaoImpl implements UserDao{
@Autowired

private HibernateTemplate hibernateTemplate;

	public int saveUser(User user) {
		int i=(Integer)hibernateTemplate.save(user);
		
		return i;
	}

	@Override
	public User login(String email, String password) {
		// TODO Auto-generated method stub
		String sql="from User where email=:em and password=:pwd";
		User user=(User)hibernateTemplate.execute(session-> {
			
			Query q=session.createQuery(sql);
			q.setString("em",email);
            q.setString("pwd",password);
            q.setMaxResults(1);
             return q.uniqueResult();
		});
			return user;
	}

	public User loginCheck(String email,String password)
	{
		String sql="from User where email=:em and password=:pw";
		User u=new User();
		 u=(User)hibernateTemplate.execute(session->{
    Query q=session.createQuery(sql);
    q.setString("em",email);
    q.setString("pw",password);
    q.setMaxResults(1);
    
    return q.uniqueResult();
     
    });
		
		return u;
     }
	@Override
	public int saveNotes(Notes notes) {
		int i=(Integer)hibernateTemplate.save(notes);
		return i;
	}

	@Override
	public List<Notes> getNotesByUser(User user) {
		String sql="from Notes where user_id=:us";
		List<Notes> list= hibernateTemplate.execute(session->{
		Query q=session.createQuery(sql);
			q.setEntity("us",user);
			return q.getResultList();
		});
		return list;
	}

	@Override
	public Notes getNotesById(int id) {
Notes n=hibernateTemplate.get(Notes.class,id);
		return n;
	}

	@Override
	public void deleteNotes(int id) {
Notes n=hibernateTemplate.get(Notes.class,id);		
hibernateTemplate.delete(n);
	}

	@Override
	public void updateNotes(Notes n) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(n);
		}

}
