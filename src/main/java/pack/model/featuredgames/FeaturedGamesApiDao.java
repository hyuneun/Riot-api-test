package pack.model.featuredgames;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.FeaturedGames.FeaturedGames;
import pack.model.RiotApiKeyRotate;

@Repository
public class FeaturedGamesApiDao {
	@Autowired
	RiotApiKeyRotate api;
	
	public FeaturedGames ApiGetList() throws RiotApiException{
		return api.getFeaturedGames(Region.KR);
	}
}
