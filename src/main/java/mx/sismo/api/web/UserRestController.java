package mx.sismo.api.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Void> retrieveUser() {
		int target = -5;
                int num = 3;

                target =- num;  // Noncompliant; target = -3. Is that really what's meant?
                target =+ num; // Noncompliant; target = 3

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
