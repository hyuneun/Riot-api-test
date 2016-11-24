package pack.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.rithms.riot.dto.Static.Champion;
import net.rithms.riot.dto.Static.ChampionList;
import pack.model.StaticManager;





@CrossOrigin("*")
@RestController
public class StaticController {
	
	@Autowired
	StaticManager staticManager;
	
	
	@RequestMapping("/static/locale/{locale}")
	@ResponseBody
	public Object getlocalelist(@PathVariable String locale){
		return staticManager.getLocaleList(locale);
	}
	@RequestMapping("/static/locale/{locale}/champion")
	@ResponseBody
	public Object getlocaleChampionlist(@PathVariable("locale")String locale){
		return staticManager.getChampionList(locale);
	}
	
	@RequestMapping("/static/locale/{locale}/champion/{id}")
	@ResponseBody
	public Object getlocaleChampionById(@PathVariable String locale,
			@PathVariable("id") int id){
		return staticManager.getChampion(locale,id);
	}
	
	@RequestMapping("/static/locale/{locale}/item")
	@ResponseBody
	public Object getlocaleItemlist(@PathVariable("locale")String locale){
		return staticManager.getItemList(locale);
	}
	@RequestMapping("/static/locale/{locale}/item/{id}")
	@ResponseBody
	public Object getlocaleItemById(@PathVariable String locale,
			@PathVariable("id") String id){
		return staticManager.getLocaleList(locale);
	}
	
	@RequestMapping("/static/locale/{locale}/mastery")
	@ResponseBody
	public Object getlocaleMasterylist(@PathVariable("locale")String locale){
		return staticManager.getMasterylist(locale);
	}
	@RequestMapping("/static/locale/{locale}/rune")
	@ResponseBody
	public Object getlocaleRunelist(@PathVariable("locale")String locale){
		return staticManager.getRunelist(locale);
	}
	
	@RequestMapping("/static/locale/{locale}/summoner")
	@ResponseBody
	public Object getlocalespell(@PathVariable("locale")String locale){
		return staticManager.getSummonerSpell(locale);
	}
	
	
	
	
	
	
}
