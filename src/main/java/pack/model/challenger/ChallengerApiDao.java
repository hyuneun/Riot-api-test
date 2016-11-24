package pack.model.challenger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.QueueType;
import net.rithms.riot.dto.League.League;
import net.rithms.riot.dto.League.LeagueEntry;
import net.rithms.riot.dto.Match.MatchDetail;
import pack.model.RiotApiKeyRotate;

@Repository
public class ChallengerApiDao {
	@Autowired
	RiotApiKeyRotate api;
	
	public List<ChallengerDto> apigetChallenger() throws RiotApiException{
		List<ChallengerDto> list = new ArrayList<ChallengerDto>();
		try {		
			League challenger = api.getChallengerLeague(QueueType.RANKED_SOLO_5x5);
			for (int i = 0; i < challenger.getEntries().size(); i++) {
				ChallengerDto dto = new ChallengerDto(); 
				dto.setTier(challenger.getTier());
				dto.setLeaguePoints(challenger.getEntries().get(i).getLeaguePoints());
				dto.setPlayerOrTeamName(challenger.getEntries().get(i).getPlayerOrTeamName());
				dto.setWins(challenger.getEntries().get(i).getWins());
				dto.setLosses(challenger.getEntries().get(i).getLosses());
				list.add(dto);
			}	
		} catch (RiotApiException e) {
			System.out.println("apigetChallenger " + e);
			return null;
		}
		return list;
	}
	
	public List<ChallengerDto> apigetMaster() throws RiotApiException{
		List<ChallengerDto> list = new ArrayList<ChallengerDto>();
		try {
			League master = api.getMasterLeague(QueueType.RANKED_SOLO_5x5);
			for (int i = 0; i < master.getEntries().size(); i++) {
				ChallengerDto dto = new ChallengerDto(); 
				dto.setTier(master.getTier());
				dto.setLeaguePoints(master.getEntries().get(i).getLeaguePoints());
				dto.setPlayerOrTeamName(master.getEntries().get(i).getPlayerOrTeamName());
				dto.setWins(master.getEntries().get(i).getWins());
				dto.setLosses(master.getEntries().get(i).getLosses());
				list.add(dto);
			}	
		} catch (RiotApiException e) {
			System.out.println("apigetMaster " + e);
			return null;
		}
		return list;
	}
}
