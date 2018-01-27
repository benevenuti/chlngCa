package mars;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mars.business.Navigator;
import mars.model.Region;

@RestController
public class NavigationController {

	// CHANGE HERE TO 1 IF HTTP RESPONSE TO 400 BAD REQUEST SHOULD BE USED
	// OR TO 0 IF TEXTUAL 400 WITH HTTP 200
	private static int USE_HTTP_RESPONSE = 1;

	private Region defaultRegion = new Region(0, 0, 4, 4);

	@PostMapping(path = "/rest/mars/{moves}")
	public String navigate(@PathVariable(value = "moves") String moves) {
		try {
			return Navigator.navigate(moves, defaultRegion).toString()	;
		} catch (IllegalArgumentException e) {
			// specification expect a textual 400 Bad Request response
			// if specification changes, just change USE_HTTP_RESPONSE to 1
			if (USE_HTTP_RESPONSE == 0) {
				return "400 Bad Request";
			} else {
				throw e;
			}
		}
	}

	// handler to the exceptions response with http 400 status, bad request
	@ExceptionHandler
	void handleException(Exception e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}
}