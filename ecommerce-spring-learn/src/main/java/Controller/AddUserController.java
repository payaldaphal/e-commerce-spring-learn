package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Dto.AddUserRequest;
import Dto.AddUserResponse;
import service.AddUserService;

@RestController
public class AddUserController {
	@Autowired
	private AddUserService addUserService;

	@PostMapping(path = "/api/user/AddUser")
	public AddUserResponse adduser(@RequestBody AddUserRequest addUserBody) {
		return addUserService.addUser(addUserBody);
	}

}
