package pack.model.recentgame;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.dto.Game.RecentGames;
import net.rithms.riot.dto.Static.SummonerSpellList;
import pack.model.RiotApiKeyRotate;

@Repository
public class RecentApiDao {
	@Autowired
	RiotApiKeyRotate api;
	
	public RecentGames ApigetRecentGame(Long id) throws RiotApiException{
		return api.getRecentGames(id);
	}
	public String getSpellName(int id) throws RiotApiException{
		return api.getDataSummonerSpell(id).getKey();
	}
	public SummonerSpellList getSpellList() throws RiotApiException{
		return api.getDataSummonerSpellList();
	}
}
