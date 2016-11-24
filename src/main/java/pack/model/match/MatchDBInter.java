package pack.model.match;



import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;



public interface MatchDBInter {
	@Select("select lane, banChampionId1, banChampionId2, banChampionId3, neutralMinionsKilled, neutralMinionsKilledTeamjungle, neutralMinionsKilledEnemyjungle, matchteam.matchId as matchId, matchteam.teamId as teamId, baronkills, dragonkills, towerkills, spell1Id, spell2Id, championId, champion.name as championNameK, champion.kee as championNameE, mastery, kills, deaths, assists, item0, item1, item2, item3, item4, item5, totalDamageDealt, totalDamageTaken, wardsPlaced, wardsKilled, minionskilled, goldEarned, matchparticipant.participantId as participantId, summonerId, summonerName from matchparticipant inner join matchparticipantIdentities on matchparticipant.participantId = matchparticipantIdentities.participantId inner join matchteam on matchparticipant.teamId = matchteam.teamId left join champion on matchparticipant.championId = champion.id where matchteam.matchId=#{matchId} and matchparticipant.matchId=#{matchId} and matchparticipantidentities.matchId=#{matchId}")
	public List<MatchDto> getMatch(long matchId);
	
	@Insert("insert into matchteam(banChampionId1, banChampionId2, banChampionId3, matchId, teamId, baronkills, dragonkills) values(#{banChampionId1}, #{banChampionId2}, #{banChampionId3}, #{matchId},#{teamId},#{baronkills},#{dragonkills})")
	public int insertMatchTeam(MatchTeamDto dto);
	
	@Insert("insert into matchparticipant(item0, item1, item2, item3, item4, item5,  matchId, participantId,"
			+ "mastery, totalDamageDealt,totalDamageTaken, wardsPlaced, wardsKilled, minionskilled,"
			+ "neutralMinionsKilled, towerkills,neutralMinionsKilledTeamjungle, neutralMinionsKilledEnemyjungle,"
			+ "goldEarned, kills, deaths, assists, lane, teamId, spell1Id, spell2Id, championId) "
			+ "values(#{item0}, #{item1}, #{item2}, #{item3}, #{item4}, #{item5}, #{matchId}, #{participantId},"
			+ "#{mastery}, #{totalDamageDealt}, #{totalDamageTaken}, #{wardsPlaced}, #{wardsKilled}, #{minionskilled},"
			+ "#{neutralMinionsKilled}, #{towerkills}, #{neutralMinionsKilledTeamjungle}, #{neutralMinionsKilledEnemyjungle},"
			+ "#{goldEarned}, #{kills}, #{deaths}, #{assists}, #{lane}, #{teamId}, #{spell1Id}, #{spell2Id}, #{championId})")
	public int insertMatchParticipant(MatchParticipantDto dto);

	
	@Insert("insert into matchparticipantIdentities(matchId, participantId, summonerId, summonerName) values(#{matchId}, #{participantId}, #{summonerId}, #{summonerName})")
	public int insertMatchParticipantIdentities(MatchParticipantIdentitiesDto dto);

	@Insert("insert into avg(tier, lane, neutralMinionsKilled, neutralMinionsKilledTeamjungle,"
			+ " neutralMinionsKilledEnemyjungle, kills, deaths, assists, totalDamageDealt, totalDamageTaken,"
			+ " wardsPlaced, wardsKilled, minionskilled, goldEarned, towerkills)"
			+ " values('Bronze', #{lane}, #{neutralMinionsKilled}, #{neutralMinionsKilledTeamjungle},"
			+ " #{neutralMinionsKilledEnemyjungle}, #{kills}, #{deaths}, #{assists}, #{totalDamageDealt}, #{totalDamageTaken},"
			+ " #{wardsPlaced}, #{wardsKilled}, #{minionskilled}, #{goldEarned}, #{towerkills})")
	public int insertAvg(MatchParticipantDto dto);
	
	@Select("select tier, lane, avg(neutralMinionsKilled) as neutralMinionsKilled, avg(neutralMinionsKilledTeamjungle) as neutralMinionsKilledTeamjungle, avg(neutralMinionsKilledEnemyjungle) as neutralMinionsKilledEnemyjungle, avg(kills) as kills, avg(deaths) as deaths, avg(assists) as assists, avg(totalDamageDealt) as totalDamageDealt, avg(totalDamageTaken) as totalDamageTaken, avg(wardsPlaced) as wardsPlaced, avg(wardsKilled) as wardsKilled, avg(minionskilled) as minionskilled, avg(goldEarned) as goldEarned, avg(towerkills) as towerkills from avg group by lane, tier order by tier")
	public List<AvgDto> getAvg();

}
											
		