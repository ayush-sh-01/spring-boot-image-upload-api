package new_spring_project.second_project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WelcomeController {
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to the first program";
	}
}
