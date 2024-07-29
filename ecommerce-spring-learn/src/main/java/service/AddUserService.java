package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Dao.UsersDao;
import Dto.AddUserRequest;
import Dto.AddUserResponse;
import entity.Users;

@Component
public class AddUserService {
	@Autowired
	UsersDao usersDao;

	public AddUserResponse addUser(AddUserRequest request) {
		Users usersTable = new Users();

		usersTable.setFirstName(request.getFirstName());
		usersTable.setLastName(request.getLastName());
		usersTable.setLoginName(request.getUser());
		usersTable.setPassword(request.getPassword());

		Users dataInsertedByDaoIncludingGeneratedValue = usersDao.save(usersTable);

		AddUserResponse response = new AddUserResponse();

		response.setResponseCode("0000");
		response.setMessage("User added successfully");
		response.setRequest(request);

		response.setUser_id(dataInsertedByDaoIncludingGeneratedValue.getUser_id());

		return response;
	}
}