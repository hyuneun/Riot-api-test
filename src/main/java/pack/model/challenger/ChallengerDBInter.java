package pack.model.challenger;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface ChallengerDBInter {
	@Select("select * from challenger where tier = 'CHALLENGER' order by leaguePoints desc")
	public List<ChallengerDto> selectChallenger();
	
	@Delete("delete from challenger where tier = 'CHALLENGER'")
	public int deleteChallenger();
	
	@Insert("insert into challenger values(#{tier}, #{playerOrTeamName}, #{leaguePoints}, #{wins}, #{losses}, now())")
	public int insertChallenger(ChallengerDto dto);
	
	@Select("select * from challenger where tier = 'MASTER' order by leaguePoints desc")
	public List<ChallengerDto> selectMaster();
	
	@Insert("insert into challenger values(#{tier}, #{playerOrTeamName}, #{leaguePoints}, #{wins}, #{losses}, now())")
	public int insertMaster(ChallengerDto dto);
	
	@Delete("delete from challenger where tier = 'MASTER'")
	public int deleteMaster();
	
}
