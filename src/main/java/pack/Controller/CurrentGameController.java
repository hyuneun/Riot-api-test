package pack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pack.model.CurrentGame.InGameManager;


@CrossOrigin(origins="*")
@RestController
public class CurrentGameController {
	
	@Autowired
	InGameManager inGameManager;
	
	@RequestMapping("/currentGame/{username}")
	@ResponseBody
	public Object getlist1(@PathVariable("username")String username) {
		//System.out.println(username);
		Object object = new Object();
		object = inGameManager.process(username);
		
		return object;
	}
	
}
