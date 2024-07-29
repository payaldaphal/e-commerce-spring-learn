package service;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Dao.UsersDao;
import Dto.UpdateUserRequest;
import Dto.UpdateUserResponse;
import entity.Users;

@Component
	public class UpdateUserService {
		@Autowired
		UsersDao usersDao;

		public UpdateUserResponse updateUser(UpdateUserRequest request) {
			UpdateUserResponse response = new UpdateUserResponse();

			// If user_id not sent in request
			if (request.getUser_id() == null) {
				response.setResponseCode("911");
				response.setMessage("User ID is required");
				return response;
			}

			// If user_id not present in DB
			java.util.Optional<Users> usersPresentInDb = usersDao.findById(request.getUser_id());

			if (!usersPresentInDb.isPresent()) {
				response.setResponseCode("912");
				response.setMessage("User_id Not Present in DB");
				response.setRequest(request);
				return response;
			}

			Users usersTable = new Users();

			usersTable.setFirstName(request.getFirstName());
			usersTable.setLastName(request.getLastName());
			usersTable.setLoginName(request.getUser());
			usersTable.setPassword(request.getPassword());
			usersTable.setUser_id(request.getUser_id());

			usersDao.save(usersTable);
			response.setResponseCode("0000");
			response.setMessage("User Updated Successfully");
			response.setRequest(request);
			return response;

		}
	}

