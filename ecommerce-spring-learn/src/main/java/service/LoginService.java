package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Dao.UsersDao;
import Dto.LoginRequest;
import Dto.LoginResponse;
import entity.Users;

@Component
	public class LoginService {

		@Autowired
		UsersDao userDao;

		public LoginResponse login(LoginRequest loginBody) {
			LoginResponse response = new LoginResponse();

			Users userReceivedFromDb = userDao.findByLoginName(loginBody.user);
			if (isNotNull(userReceivedFromDb)) {

				if (userReceivedFromDb.getLoginName().equals(loginBody.user)
						&& userReceivedFromDb.getPassword().equals(loginBody.password)) {
					response.responseCode = "0000";
					response.message = "Login Success";
					response.firstName = userReceivedFromDb.getFirstName();
					response.lastName = userReceivedFromDb.getLastName();
					response.loginName = userReceivedFromDb.getLoginName();
					response.password = userReceivedFromDb.getPassword();

					return response;

				} else {
					response.responseCode = "911";
					response.message = "Login Failed!!";
					
				}
				return response;

			}

			else {
				response.responseCode = "911";
				response.message = "User Not Found!!";
				return response;
			}
		}

		private boolean isNotNull(Users userReceivedFromDb) {
			// TODO Auto-generated method stub
			return false;
		}
	}

