package pack.model.most;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MostDBInter {
	@Select("select summonerId, name as championNameK, kee as championNameE, championId, played, win, lose, goldEarned, minionkills, kills, assists, deaths, maxKills, maxAssists, maxDeaths, damageDealt, damageTaken, doubleKills, tripleKills, quadraKills, pentaKills, searchDate from most inner join champion on most.championId = champion.id where summonerId = #{summonerId} order by played desc")
	public List<MostDto> selectMost(long summonerId);
	
	@Insert("insert into most(summonerId, championId, played, win, lose, goldEarned,"
			+ "minionkills, kills, assists, deaths, maxKills, maxAssists, maxDeaths,"
			+ "damageDealt, damageTaken, doubleKills, tripleKills, quadraKills,"
			+ "pentaKills, searchDate) values(#{summonerId}, #{championId}, #{played}, #{win}, #{lose},"
			+ " #{goldEarned}, #{minionkills}, #{kills}, #{assists}, #{deaths}, #{maxKills}, #{maxAssists}, #{maxDeaths},"
			+ "#{damageDealt}, #{damageTaken}, #{doubleKills}, #{tripleKills}, #{quadraKills}, #{pentaKills}, now())")
	public int insertMost(MostDto dto);
	
	@Delete("delete from most where summonerId = #{summonerId}")
	public int deleteMost(long summonerId);
}
