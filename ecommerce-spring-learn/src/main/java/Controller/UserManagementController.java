package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import entity.Users;
import service.UserManagementService;

@RestController
	public class UserManagementController {

		@Autowired
		private UserManagementService userService;

		@GetMapping(path = "/api/user/getAllUsers")
		public List<Users> getAllUsers() {
			return userService.getAllUsers();
		}

		@GetMapping(path = "/api/user/get/{userId}")
		public Users getUsersById(@PathVariable Integer userId) {
			return userService.getUserById(userId);
		}
	}
