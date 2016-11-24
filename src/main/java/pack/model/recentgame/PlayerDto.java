package pack.model.recentgame;

public class PlayerDto {
	private Long gameId,summonerId ,searchuserId;
	public Long getSearchuserId() {
		return searchuserId;
	}
	public void setSearchuserId(Long searchuserId) {
		this.searchuserId = searchuserId;
	}
	private int teamId,championId;
	private String chamName1,chamName2,summonerName;
	public String getChamName1() {
		return chamName1;
	}
	public void setChamName1(String chamName1) {
		this.chamName1 = chamName1;
	}
	public String getSummonerName() {
		return summonerName;
	}
	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}
	public String getChamName2() {
		return chamName2;
	}
	public void setChamName2(String chamName2) {
		this.chamName2 = chamName2;
	}
	public Long getGameId() {
		return gameId;
	}
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
	public Long getSummonerId() {
		return summonerId;
	}
	public void setSummonerId(Long summonerId) {
		this.summonerId = summonerId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getChampionId() {
		return championId;
	}
	public void setChampionId(int championId) {
		this.championId = championId;
	}
}
