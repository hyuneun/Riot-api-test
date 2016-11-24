package pack.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.dto.FeaturedGames.FeaturedGames;
import net.rithms.riot.dto.Static.ChampionList;
import pack.model.featuredgames.FeaturedGamesApiDao;

@Service
public class FeaturedGameManager {
	@Autowired
	FeaturedGamesApiDao api;

	
	public Map<String,Object> getFeaturedGame(){
		HashMap<String, Object> map=new HashMap<>();
		try {
			FeaturedGames list= api.ApiGetList();
			if(list==null){
				map.put("success", false);
				map.put("errorMessage", "게임중인 유저가 없습니다");
			}else{
				map.put("success", true);
				map.put("featuredList", list);
			}
		} catch (RiotApiException e) {
			map.put("success", false);
			map.put("errorMessage", e.getMessage());
			map.put("errorCode", e.getErrorCode());
		}
		return map;
	}
}
