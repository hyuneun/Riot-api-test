package pack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pack.model.ChallengerManager;

@CrossOrigin(origins = "*")
@RestController
public class ChallengerController {
	@Autowired
	ChallengerManager challengerManager;

	@RequestMapping("challenger")
	@ResponseBody
	public Object getChallenger() {
		return challengerManager.getChallenger();
	}
}
