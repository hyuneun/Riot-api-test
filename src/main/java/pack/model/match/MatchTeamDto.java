package pack.model.match;

public class MatchTeamDto {
	private long matchId;
	private int teamId, baronkills, dragonkills, banChampionId1, banChampionId2, banChampionId3;

	public long getMatchId() {
		return matchId;
	}

	public int getBanChampionId1() {
		return banChampionId1;
	}

	public void setBanChampionId1(int banChampionId1) {
		this.banChampionId1 = banChampionId1;
	}

	public int getBanChampionId2() {
		return banChampionId2;
	}

	public void setBanChampionId2(int banChampionId2) {
		this.banChampionId2 = banChampionId2;
	}

	public int getBanChampionId3() {
		return banChampionId3;
	}

	public void setBanChampionId3(int banChampionId3) {
		this.banChampionId3 = banChampionId3;
	}

	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getBaronkills() {
		return baronkills;
	}

	public void setBaronkills(int baronkills) {
		this.baronkills = baronkills;
	}

	public int getDragonkills() {
		return dragonkills;
	}

	public void setDragonkills(int dragonkills) {
		this.dragonkills = dragonkills;
	}

}
