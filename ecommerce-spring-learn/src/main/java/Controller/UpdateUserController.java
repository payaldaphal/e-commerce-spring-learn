package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Dto.UpdateUserRequest;
import Dto.UpdateUserResponse;
import service.UpdateUserService;

@RestController
	public class UpdateUserController {

		@Autowired
		private UpdateUserService updateUserService;

		@PostMapping(path = "/api/user/UpdateUser")
		public UpdateUserResponse updateuser(@RequestBody UpdateUserRequest request) {
			return updateUserService.updateUser(request);
		}
		

}
