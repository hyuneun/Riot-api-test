package pack.model.summoner;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import net.rithms.riot.dto.League.LeagueEntry;
import pack.Controller.SummonerBean;

public interface SummonerDBInter {
	@Select("select * from summoner")
	public List<SummonerDto> selectSummoner();
	@Select("select id , revisionDate , summonerLevel , profileIconId , name , DATE_FORMAT(searchDate, '%Y-%m-%d %H:%i') as searchDate from "
			+ " summoner where name=#{name}")
	public SummonerDto selectsearchData(SummonerBean bean);
	
	@Select("select * from league where id=#{id}")
	public LeagueDto selectLeagueData(Long id);
	@Select("select * from entries where playerOrTeamId=#{entry}")
	public List<LeagueEntry> selectEntryData(String entry);

	@Insert("insert into summoner(id,revisionDate,summonerLevel,profileIconId,name) values(#{id}, #{revisionDate},#{summonerLevel},#{profileIconId},#{name})")
	public int insertsummoner(SummonerDto dto);
	
	@Insert("insert into league values(#{id}, #{name},#{tier},#{queue},#{entries})")
	public int insertleague(LeagueDto dto);
	
	@Insert("insert into entries values(#{playerOrTeamId},#{playerOrTeamName} ,#{division} ,#{leaguePoints} ,#{wins} ,#{losses},'NONE',#{isHotStreak},#{isVeteran},#{isFreshBlood},#{isInactive})")
	public int insertentrys(LeagueEntry entry);
	
	@Update("update summoner set searchDate=now(),revisionDate=#{revisionDate},summonerLevel=#{summonerLevel},profileIconId=#{profileIconId},name=#{name} where id=#{id}")
	public boolean updateSummoner(SummonerDto dto);
	
	@Update("update league set name=#{name},tier=#{tier},queue=#{queue},entries=#{entries} where id=#{id}")
	public boolean updateleague(LeagueDto dto);
	
	@Update("update entries set playerOrTeamName=#{playerOrTeamName},division=#{division},leaguePoints=#{leaguePoints},wins=#{wins},losses=#{losses},isHotStreak=#{isHotStreak},isVeteran=#{isVeteran},isFreshBlood=#{isFreshBlood},isInactive=#{isInactive} where playerOrTeamId=#{playerOrTeamId}")
	public boolean updateEntries(LeagueEntry entry);
}
