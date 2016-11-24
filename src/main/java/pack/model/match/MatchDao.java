package pack.model.match;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MatchDao {
	@Autowired
	private MatchDBInter matchDBInter;
	
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRES_NEW)
	public boolean insertMatch(MatchBean bean){
		boolean success=false;
		try{
			for (int i = 0; i < bean.getTeam().size(); i++) {
				matchDBInter.insertMatchTeam(bean.getTeam().get(i));
			}
			System.out.println(bean.getParticipant().size());
			for (int i = 0; i < bean.getParticipant().size(); i++) {	
				matchDBInter.insertMatchParticipantIdentities(bean.getParticipantIdentities().get(i));
			}
			
			for (int i = 0; i < bean.getParticipantIdentities().size(); i++) {
				matchDBInter.insertMatchParticipant(bean.getParticipant().get(i));				
			}
			
			success=true;
		}catch(Exception e){
			return success;
		}
		return success;
	}
	
	public List<MatchDto> selectMatch(long matchId){
		return matchDBInter.getMatch(matchId);
	}
	
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRES_NEW)
	public boolean insertAvg(MatchBean bean){
		boolean success=false;
		try{
			
			for (int i = 0; i < bean.getParticipant().size(); i++) {
				matchDBInter.insertAvg(bean.getParticipant().get(i));
			}
			success=true;
		}catch(Exception e){
			return success;
		}
		return success;
	}
	
	public List<AvgDto> selectAvg(){
		return matchDBInter.getAvg();
	}

}
