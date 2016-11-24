package pack.model.summoner;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.dto.League.League;
import net.rithms.riot.dto.League.LeagueEntry;
import net.rithms.riot.dto.Summoner.Summoner;
import pack.Controller.SummonerBean;

@Repository
public class SummonerDao  {
	
	@Autowired
	private SummonerDBInter summonerDBInter;
	
	
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRES_NEW)
	public boolean insertSummoner(SummonerDto summoner) {
		boolean success=false;
		try{
			summonerDBInter.insertsummoner(summoner);
			success=true;
		}catch(Exception e){
			return success;
		}
		return success;
	}
	
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRES_NEW)
	public boolean insertLeague(LeagueDto dto){
		boolean success=false;
		try{
			summonerDBInter.insertleague(dto);
			summonerDBInter.insertentrys((LeagueEntry)dto.getEntrylist().get(0));
			success=true;
		}catch(DataAccessException e){
			return success;
		}
		return success;
	}
	
	
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRES_NEW)
	public boolean updateSummoner(SummonerDto summoner){
		boolean success=false;
		try{
			summonerDBInter.updateSummoner(summoner);
			success=true;
		}catch(Exception e){
			return success;
		}
		return success;
	}
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRES_NEW)
	public boolean updateLeague(LeagueDto dto){
		boolean success=false;
		try{
			summonerDBInter.updateleague(dto);
			summonerDBInter.updateEntries((LeagueEntry)dto.getEntrylist());
			success=true;
		}catch(Exception e){
			return success;
		}
		return success;
	}
	
	public SummonerDto selectSummoner(SummonerBean bean){
		return summonerDBInter.selectsearchData(bean);
	}
	
	public LeagueDto selectLeagueData(Long id){
		LeagueDto league = null;
		try {
			league = summonerDBInter.selectLeagueData(id);
			league.setEntrylist(summonerDBInter.selectEntryData(league.getEntries()));
		} catch (Exception e) {
			return null;
		}
		return league;
	}
	
	
	
	
	
	
	
}
