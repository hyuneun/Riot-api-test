package pack.model.summoner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.League.League;
import net.rithms.riot.dto.Summoner.Summoner;
import pack.model.RiotApiKeyRotate;

@Repository
public class SummonerApiDao {
	@Autowired
	RiotApiKeyRotate api;

	public SummonerDto ApigetSummonerByName(String name) throws RiotApiException{
		SummonerDto dto=new SummonerDto();	
		Summoner summoner=api.getSummonerByName(name);
		dto.setId(summoner.getId());
		dto.setName(summoner.getName());
		dto.setProfileIconId(summoner.getProfileIconId());
		dto.setRevisionDate(summoner.getRevisionDate());
		dto.setSummonerLevel(summoner.getSummonerLevel());
		return dto;
	}
	
	public Map<String, String> ApigetSummonerByNames(String summonerIds) throws RiotApiException{
		api.getSummonerNames(summonerIds);
		return api.getSummonerNames(summonerIds);
	}
	
	public LeagueDto ApigetLeagueData(Long id){
		LeagueDto leagueDto=new LeagueDto();
		try {
			List<League> leaguedata = api.getLeagueEntryBySummoner(id);
			leagueDto.setId(id);
			leagueDto.setName(leaguedata.get(0).getName());
			leagueDto.setQueue(leaguedata.get(0).getQueue());
			leagueDto.setTier(leaguedata.get(0).getTier());
			leagueDto.setEntries(leaguedata.get(0).getEntries().get(0).getPlayerOrTeamId());
			leagueDto.setEntrylist(leaguedata.get(0).getEntries());
		} catch (RiotApiException e) {
			return leagueDto;
		}
		return leagueDto;
	}
}
