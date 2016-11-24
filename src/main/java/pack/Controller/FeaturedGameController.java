package pack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pack.model.FeaturedGameManager;

@CrossOrigin(origins="*")
@RestController
public class FeaturedGameController {
	
	@Autowired
	FeaturedGameManager manager;
	
	@RequestMapping(value="/featuredgames",method=RequestMethod.GET)
	@ResponseBody
	public Object getlist1() {
		return manager.getFeaturedGame();
	}
}
