package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NavigationController {
	
	@PostMapping(path = "/rest/mars/{moves}")	
	public String navigate(@PathVariable(value = "moves") String moves) {
		
		return (new Position()).toString();
	}
}