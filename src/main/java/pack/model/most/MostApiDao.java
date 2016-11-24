package pack.model.most;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.dto.Stats.RankedStats;
import pack.model.RiotApiKeyRotate;

@Repository
public class MostApiDao {
	@Autowired
	RiotApiKeyRotate api;
	
	public List<MostDto> apigetMost(long SummonerId) throws RiotApiException{
		List<MostDto> list = null;
			RankedStats rs = api.getRankedStats(SummonerId);
			if (rs != null) {
				list = new ArrayList<>();
			for (int i = 0; i < rs.getChampions().size(); i++) {
				if(rs.getChampions().get(i).getId() != 0){
					MostDto dto = new MostDto();
					dto.setSummonerId(rs.getSummonerId());	//소환사id
					dto.setChampionId(rs.getChampions().get(i).getId());//championId
					dto.setPlayed(rs.getChampions().get(i).getStats().getTotalSessionsPlayed());//played
					dto.setWin(rs.getChampions().get(i).getStats().getTotalSessionsWon());//win
					dto.setLose(rs.getChampions().get(i).getStats().getTotalSessionsLost());//lose
					dto.setGoldEarned(rs.getChampions().get(i).getStats().getTotalGoldEarned());//goldEarned
					dto.setMinionkills(rs.getChampions().get(i).getStats().getTotalMinionKills());//cs
					dto.setKills(rs.getChampions().get(i).getStats().getTotalChampionKills());//kills
					dto.setAssists(rs.getChampions().get(i).getStats().getTotalAssists());//assists
					dto.setDeaths(rs.getChampions().get(i).getStats().getTotalDeathsPerSession());//deaths
					dto.setDeaths(rs.getChampions().get(i).getStats().getMaxChampionsKilled());//maxkills
					dto.setMaxAssists(rs.getChampions().get(i).getStats().getMaxAssists());//maxassists
					dto.setMaxDeaths(rs.getChampions().get(i).getStats().getMaxNumDeaths());//maxdeaths
					dto.setDamageDealt(rs.getChampions().get(i).getStats().getTotalDamageDealt());//damagedealt
					dto.setDamageTaken(rs.getChampions().get(i).getStats().getTotalDamageTaken());//damagetaken
					dto.setDoubleKills(rs.getChampions().get(i).getStats().getTotalDoubleKills());
					dto.setTripleKills(rs.getChampions().get(i).getStats().getTotalTripleKills());
					dto.setQuadraKills(rs.getChampions().get(i).getStats().getTotalQuadraKills());
					dto.setPentaKills(rs.getChampions().get(i).getStats().getTotalPentaKills());
					list.add(dto);
				}		
			}
		}
		return list;
	}
}
