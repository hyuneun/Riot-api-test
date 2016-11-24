package pack.model.match;

public class MatchDto {
	private long matchId, participantId, mastery, item0, item1, item2, item3, item4, item5, totalDamageDealt,
			totalDamageTaken, wardsPlaced, wardsKilled, minionskilled, neutralMinionsKilled,
			neutralMinionsKilledTeamjungle, neutralMinionsKilledEnemyjungle, goldEarned, kills, deaths, assists,
			summonerId, towerkills;
	private String summonerName, championNameK, championNameE;
	private int teamId, baronkills, dragonkills, spell1Id, spell2Id, championId, banChampionId1, banChampionId2,
			banChampionId3;

	public String getChampionNameK() {
		return championNameK;
	}

	public long getNeutralMinionsKilled() {
		return neutralMinionsKilled;
	}

	public void setNeutralMinionsKilled(long neutralMinionsKilled) {
		this.neutralMinionsKilled = neutralMinionsKilled;
	}

	public long getNeutralMinionsKilledTeamjungle() {
		return neutralMinionsKilledTeamjungle;
	}

	public void setNeutralMinionsKilledTeamjungle(long neutralMinionsKilledTeamjungle) {
		this.neutralMinionsKilledTeamjungle = neutralMinionsKilledTeamjungle;
	}

	public long getNeutralMinionsKilledEnemyjungle() {
		return neutralMinionsKilledEnemyjungle;
	}

	public void setNeutralMinionsKilledEnemyjungle(long neutralMinionsKilledEnemyjungle) {
		this.neutralMinionsKilledEnemyjungle = neutralMinionsKilledEnemyjungle;
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

	public void setChampionNameK(String championNameK) {
		this.championNameK = championNameK;
	}

	public String getChampionNameE() {
		return championNameE;
	}

	public void setChampionNameE(String championNameE) {
		this.championNameE = championNameE;
	}

	public int getChampionId() {
		return championId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public long getMatchId() {
		return matchId;
	}

	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}

	public long getParticipantId() {
		return participantId;
	}

	public void setParticipantId(long participantId) {
		this.participantId = participantId;
	}

	public long getMastery() {
		return mastery;
	}

	public void setMastery(long mastery) {
		this.mastery = mastery;
	}

	public long getItem0() {
		return item0;
	}

	public void setItem0(long item0) {
		this.item0 = item0;
	}

	public long getItem1() {
		return item1;
	}

	public void setItem1(long item1) {
		this.item1 = item1;
	}

	public long getItem2() {
		return item2;
	}

	public void setItem2(long item2) {
		this.item2 = item2;
	}

	public long getItem3() {
		return item3;
	}

	public void setItem3(long item3) {
		this.item3 = item3;
	}

	public long getItem4() {
		return item4;
	}

	public void setItem4(long item4) {
		this.item4 = item4;
	}

	public long getItem5() {
		return item5;
	}

	public void setItem5(long item5) {
		this.item5 = item5;
	}

	public long getTotalDamageDealt() {
		return totalDamageDealt;
	}

	public void setTotalDamageDealt(long totalDamageDealt) {
		this.totalDamageDealt = totalDamageDealt;
	}

	public long getTotalDamageTaken() {
		return totalDamageTaken;
	}

	public void setTotalDamageTaken(long totalDamageTaken) {
		this.totalDamageTaken = totalDamageTaken;
	}

	public long getWardsPlaced() {
		return wardsPlaced;
	}

	public void setWardsPlaced(long wardsPlaced) {
		this.wardsPlaced = wardsPlaced;
	}

	public long getWardsKilled() {
		return wardsKilled;
	}

	public void setWardsKilled(long wardsKilled) {
		this.wardsKilled = wardsKilled;
	}

	public long getMinionskilled() {
		return minionskilled;
	}

	public void setMinionskilled(long minionskilled) {
		this.minionskilled = minionskilled;
	}

	public long getGoldEarned() {
		return goldEarned;
	}

	public void setGoldEarned(long goldEarned) {
		this.goldEarned = goldEarned;
	}

	public long getKills() {
		return kills;
	}

	public void setKills(long kills) {
		this.kills = kills;
	}

	public long getDeaths() {
		return deaths;
	}

	public void setDeaths(long deaths) {
		this.deaths = deaths;
	}

	public long getAssists() {
		return assists;
	}

	public void setAssists(long assists) {
		this.assists = assists;
	}

	public long getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
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

	public long getTowerkills() {
		return towerkills;
	}

	public void setTowerkills(long towerkills) {
		this.towerkills = towerkills;
	}

	public int getSpell1Id() {
		return spell1Id;
	}

	public void setSpell1Id(int spell1Id) {
		this.spell1Id = spell1Id;
	}

	public int getSpell2Id() {
		return spell2Id;
	}

	public void setSpell2Id(int spell2Id) {
		this.spell2Id = spell2Id;
	}

}
