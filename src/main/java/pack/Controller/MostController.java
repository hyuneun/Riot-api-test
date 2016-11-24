package pack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pack.model.MostManager;

@CrossOrigin(origins="*")
@RestController
public class MostController {
	@Autowired
	MostManager mostManager;
	
	@RequestMapping("most/{summonerId}")
	@ResponseBody
	public Object getMost(@PathVariable("summonerId")long summonerId) {
		return mostManager.getMost(summonerId);
	}
}
