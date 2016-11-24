package pack.model.challenger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ChallengerDao {
	@Autowired
	private ChallengerDBInter challengerDBInter;

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
	public boolean insertChallenger(List<ChallengerDto> list) {
		boolean success = false;
		try {
			//처음할때만 사용하고 삭제
			for (int i = 0; i < list.size(); i++) {
				challengerDBInter.insertChallenger(list.get(i));
			}
			success = true;
			
			//두번째부터
			/*
			//기존 리스트 지우고 삽입
			if (challengerDBInter.deleteChallenger() > 0) {
				for (int i = 0; i < list.size(); i++) {
					challengerDBInter.insertChallenger(list.get(i));
				}
				success = true;
			}
			*/
		} catch (Exception e) {
			return success;
		}
		return success;
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
	public boolean insertMaster(List<ChallengerDto> list) {
		boolean success = false;
		try {
			//처음할때만 사용하고 삭제
			for (int i = 0; i < list.size(); i++) {
				challengerDBInter.insertChallenger(list.get(i));
			}
			success = true;
			
			//두번째부터
			/*
			//기존 리스트 지우고 삽입
			if (challengerDBInter.deleteMaster() > 0){
				for (int i = 0; i < list.size(); i++) {
					challengerDBInter.insertMaster(list.get(i));
				}
				success = true;				
			}
			*/
		} catch (Exception e) {
			return success;
		}
		return success;
	}

	public List<ChallengerDto> getChallenger() {
		return challengerDBInter.selectChallenger();
	}

	public List<ChallengerDto> getMaster() {
		return challengerDBInter.selectMaster();
	}
}
