package pack.model.match;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.dto.Match.MatchDetail;
import pack.model.RiotApiKeyRotate;


@Repository
public class MatchApiDao {
	@Autowired
	RiotApiKeyRotate api;
	
	public MatchBean apigetMatch(long matchId) throws RiotApiException{
		MatchBean dto = new MatchBean();	//통합match
		MatchDetail detail = api.getMatch(matchId);			//match
		
		//팀정보
		List<MatchTeamDto> tlist = new ArrayList<MatchTeamDto>();
		for (int i = 0; i < detail.getTeams().size(); i++) {
			MatchTeamDto teamDto = new MatchTeamDto();
			teamDto.setMatchId(matchId);
			teamDto.setBanChampionId1(detail.getTeams().get(i).getBans().get(0).getChampionId());
			teamDto.setBanChampionId2(detail.getTeams().get(i).getBans().get(1).getChampionId());
			teamDto.setBanChampionId3(detail.getTeams().get(i).getBans().get(2).getChampionId());
			teamDto.setTeamId(detail.getTeams().get(i).getTeamId());
			teamDto.setBaronkills(detail.getTeams().get(i).getBaronKills());
			teamDto.setDragonkills(detail.getTeams().get(i).getDragonKills());
			tlist.add(teamDto);
		}
		
		//소환사 게임 정보
		List<MatchParticipantDto> plist = new ArrayList<MatchParticipantDto>();
		System.out.println(detail.getParticipants().size());
		for (int i = 0; i < detail.getParticipants().size(); i++) {
			MatchParticipantDto pDto = new MatchParticipantDto();
			/*
			System.out.println(matchId);
			System.out.println(detail.getParticipants().get(i).getStats().getNeutralMinionsKilled());
			System.out.println(detail.getParticipants().get(i).getStats().getNeutralMinionsKilledTeamJungle());
			System.out.println(detail.getParticipants().get(i).getStats().getNeutralMinionsKilledEnemyJungle());
			System.out.println(detail.getParticipants().get(i).getTeamId());
			System.out.println(detail.getParticipants().get(i).getParticipantId());
			System.out.println(detail.getParticipants().get(i).getSpell1Id());
			System.out.println(detail.getParticipants().get(i).getSpell2Id());
			System.out.println(detail.getParticipants().get(i).getChampionId());
			System.out.println(detail.getParticipants().get(i).getMasteries().get(9).getMasteryId());
			System.out.println(detail.getParticipants().get(i).getStats().getKills());
			System.out.println(detail.getParticipants().get(i).getStats().getDeaths());
			System.out.println(detail.getParticipants().get(i).getStats().getAssists());
			System.out.println(detail.getParticipants().get(i).getStats().getItem0());
			System.out.println(detail.getParticipants().get(i).getStats().getItem1());
			System.out.println(detail.getParticipants().get(i).getStats().getItem2());
			System.out.println(detail.getParticipants().get(i).getStats().getItem3());
			System.out.println(detail.getParticipants().get(i).getStats().getItem4());
			System.out.println(detail.getParticipants().get(i).getStats().getItem5());
			System.out.println(detail.getParticipants().get(i).getStats().getTotalDamageDealt());
			System.out.println(detail.getParticipants().get(i).getStats().getTotalDamageTaken());
			System.out.println(detail.getParticipants().get(i).getStats().getWardsPlaced());
			System.out.println(detail.getParticipants().get(i).getStats().getWardsKilled());
			System.out.println(detail.getParticipants().get(i).getStats().getMinionsKilled());
			System.out.println(detail.getParticipants().get(i).getStats().getGoldEarned());
			if(detail.getParticipants().get(i).getTimeline().getLane().equals("BOTTOM")){
				System.out.println(detail.getParticipants().get(i).getTimeline().getRole());
			}else{
				System.out.println(detail.getParticipants().get(i).getTimeline().getLane());				
			}
			System.out.println(detail.getParticipants().get(i).getStats().getTowerKills());
			System.out.println();
			*/
			pDto.setMatchId(matchId);
			pDto.setNeutralMinionsKilled(detail.getParticipants().get(i).getStats().getNeutralMinionsKilled());
			pDto.setNeutralMinionsKilledTeamjungle(detail.getParticipants().get(i).getStats().getNeutralMinionsKilledTeamJungle());
			pDto.setNeutralMinionsKilledEnemyjungle(detail.getParticipants().get(i).getStats().getNeutralMinionsKilledEnemyJungle());
			pDto.setTeamId(detail.getParticipants().get(i).getTeamId());
			pDto.setParticipantId(detail.getParticipants().get(i).getParticipantId());
			pDto.setSpell1Id(detail.getParticipants().get(i).getSpell1Id());
			pDto.setSpell2Id(detail.getParticipants().get(i).getSpell2Id());
			pDto.setChampionId(detail.getParticipants().get(i).getChampionId());
			for(int i2 = 0; i2 < detail.getParticipants().get(i).getMasteries().size(); i2++){
                int mid = (int)detail.getParticipants().get(i).getMasteries().get(i2).getMasteryId(); 
                int index = Integer.toString(mid).lastIndexOf("6");
                long mst = (long)mid;
                if(index > 1){
                   pDto.setMastery(mst);
                }
             }
			pDto.setKills(detail.getParticipants().get(i).getStats().getKills());
			pDto.setDeaths(detail.getParticipants().get(i).getStats().getDeaths());
			pDto.setAssists(detail.getParticipants().get(i).getStats().getAssists());
			pDto.setItem0(detail.getParticipants().get(i).getStats().getItem0());
			pDto.setItem1(detail.getParticipants().get(i).getStats().getItem1());
			pDto.setItem2(detail.getParticipants().get(i).getStats().getItem2());
			pDto.setItem3(detail.getParticipants().get(i).getStats().getItem3());
			pDto.setItem4(detail.getParticipants().get(i).getStats().getItem4());
			pDto.setItem5(detail.getParticipants().get(i).getStats().getItem5());
			pDto.setTotalDamageDealt(detail.getParticipants().get(i).getStats().getTotalDamageDealt());
			pDto.setTotalDamageTaken(detail.getParticipants().get(i).getStats().getTotalDamageTaken());
			pDto.setWardsPlaced(detail.getParticipants().get(i).getStats().getWardsPlaced());
			pDto.setWardsKilled(detail.getParticipants().get(i).getStats().getWardsKilled());
			pDto.setMinionskilled(detail.getParticipants().get(i).getStats().getMinionsKilled());
			pDto.setGoldEarned(detail.getParticipants().get(i).getStats().getGoldEarned());
			if(detail.getParticipants().get(i).getTimeline().getLane().equals("BOTTOM")){
				pDto.setLane(detail.getParticipants().get(i).getTimeline().getRole());
			}else{
				pDto.setLane(detail.getParticipants().get(i).getTimeline().getLane());				
			}
			pDto.setTowerkills(detail.getParticipants().get(i).getStats().getTowerKills());
			plist.add(pDto);
		}
		
		//소환사 개별 정보
		List<MatchParticipantIdentitiesDto> pilist = new ArrayList<MatchParticipantIdentitiesDto>();
		for (int i = 0; i < detail.getParticipantIdentities().size(); i++) {
			MatchParticipantIdentitiesDto piDto = new MatchParticipantIdentitiesDto();
			piDto.setMatchId(matchId);
			piDto.setParticipantId(detail.getParticipantIdentities().get(i).getParticipantId());
			piDto.setSummonerId(detail.getParticipantIdentities().get(i).getPlayer().getSummonerId());
			piDto.setSummonerName(detail.getParticipantIdentities().get(i).getPlayer().getSummonerName());
			pilist.add(piDto);
		}
		
		dto.setTeam(tlist);
		dto.setParticipant(plist);
		dto.setParticipantIdentities(pilist);
        return dto;
	}
}
