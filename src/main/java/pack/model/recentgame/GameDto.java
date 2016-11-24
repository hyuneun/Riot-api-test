package pack.model.recentgame;

import java.util.List;
import java.util.Map;

import net.rithms.riot.dto.Game.Player;
import net.rithms.riot.dto.Game.RawStats;


public class GameDto {
	private String summonerId, subType, gameMode ,gameType,chamName1 ,chamName2, spellName1,spellName2;
	private boolean invalid;
	public String getSpellName1() {
		return spellName1;
	}
	public void setSpellName1(String spellName1) {
		this.spellName1 = spellName1;
	}
	public String getSpellName2() {
		return spellName2;
	}
	public void setSpellName2(String spellName2) {
		this.spellName2 = spellName2;
	}
	private long createDate, gameId;
	private int championId ,teamId , spell1,spell2,level ,mapId,ipEarned;
	private RawStats rawstats;
	private List<PlayerDto> fellowPlayers;
	private Map<String, String> SummonerNameMap;

	public Map<String, String> getSummonerNameMap() {
		return SummonerNameMap;
	}
	public void setSummonerNameMap(Map<String, String> summonerNameMap) {
		SummonerNameMap = summonerNameMap;
	}
	public String getChamName1() {
		return chamName1;
	}
	public void setChamName1(String chamName1) {
		this.chamName1 = chamName1;
	}
	public String getChamName2() {
		return chamName2;
	}
	public void setChamName2(String chamName2) {
		this.chamName2 = chamName2;
	}
	public String getSummonerId() {
		return summonerId;
	}
	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getGameMode() {
		return gameMode;
	}
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public boolean isInvalid() {
		return invalid;
	}
	public void setInvalid(boolean invalid) {
		this.invalid = invalid;
	}
	public long getCreateDate() {
		return createDate;
	}
	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public int getChampionId() {
		return championId;
	}
	public void setChampionId(int championId) {
		this.championId = championId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getSpell1() {
		return spell1;
	}
	public void setSpell1(int spell1) {
		this.spell1 = spell1;
	}
	public int getSpell2() {
		return spell2;
	}
	public void setSpell2(int spell2) {
		this.spell2 = spell2;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMapId() {
		return mapId;
	}
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	public int getIpEarned() {
		return ipEarned;
	}
	public void setIpEarned(int ipEarned) {
		this.ipEarned = ipEarned;
	}
	public RawStats getRawstats() {
		return rawstats;
	}
	public void setRawstats(RawStats rawstats) {
		this.rawstats = rawstats;
	}
	public List<PlayerDto> getFellowPlayers() {
		return fellowPlayers;
	}
	public void setFellowPlayers(List<PlayerDto> fellowPlayers) {
		this.fellowPlayers = fellowPlayers;
	}
	
	
}
