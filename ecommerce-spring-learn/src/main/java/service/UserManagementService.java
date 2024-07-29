package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Dao.UsersDao;
import entity.Users;

@Component
	public class UserManagementService {

		@Autowired
		UsersDao userDao;

		public List<Users> getAllUsers() {
			return userDao.findAll();
		}

		public Users getUserById(Integer userid) {
			return userDao.findById(userid).get();
		}

		

	
}
