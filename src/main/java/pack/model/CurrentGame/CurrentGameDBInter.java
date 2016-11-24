package pack.model.CurrentGame;

import org.apache.ibatis.annotations.Select;


public interface CurrentGameDBInter {
	
	@Select("select name from champion where id=#{id}")
	public String selectChampion(Long id);
	
	@Select("select kee from champion where id=#{id}")
	public String selectChampionKey(Long id);
	
	@Select("select kee from summonerspell where id=#{id}")
	public String selectSummonerSpell(Long id);
}
