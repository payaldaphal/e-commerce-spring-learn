package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Dto.LoginRequest;
import Dto.LoginResponse;
import service.LoginService;

@RestController
public class LoginController {
	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest loginBody) {

		System.out.println(loginBody.user);
		System.out.println(loginBody.password);
		return loginService.login(loginBody);
	}


}
