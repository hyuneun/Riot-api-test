package pack.model.match;

public class AvgDto {
	private String tier, lane;
	private double totalDamageDealt, totalDamageTaken, wardsPlaced, wardsKilled, towerkills, minionskilled,
			neutralMinionsKilled, neutralMinionsKilledTeamjungle, neutralMinionsKilledEnemyjungle, goldEarned, kills,
			deaths, assists;

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public double getTotalDamageDealt() {
		return totalDamageDealt;
	}

	public void setTotalDamageDealt(double totalDamageDealt) {
		this.totalDamageDealt = totalDamageDealt;
	}

	public double getTotalDamageTaken() {
		return totalDamageTaken;
	}

	public void setTotalDamageTaken(double totalDamageTaken) {
		this.totalDamageTaken = totalDamageTaken;
	}

	public double getWardsPlaced() {
		return wardsPlaced;
	}

	public void setWardsPlaced(double wardsPlaced) {
		this.wardsPlaced = wardsPlaced;
	}

	public double getWardsKilled() {
		return wardsKilled;
	}

	public void setWardsKilled(double wardsKilled) {
		this.wardsKilled = wardsKilled;
	}

	public double getTowerkills() {
		return towerkills;
	}

	public void setTowerkills(double towerkills) {
		this.towerkills = towerkills;
	}

	public double getMinionskilled() {
		return minionskilled;
	}

	public void setMinionskilled(double minionskilled) {
		this.minionskilled = minionskilled;
	}

	public double getNeutralMinionsKilled() {
		return neutralMinionsKilled;
	}

	public void setNeutralMinionsKilled(double neutralMinionsKilled) {
		this.neutralMinionsKilled = neutralMinionsKilled;
	}

	public double getNeutralMinionsKilledTeamjungle() {
		return neutralMinionsKilledTeamjungle;
	}

	public void setNeutralMinionsKilledTeamjungle(double neutralMinionsKilledTeamjungle) {
		this.neutralMinionsKilledTeamjungle = neutralMinionsKilledTeamjungle;
	}

	public double getNeutralMinionsKilledEnemyjungle() {
		return neutralMinionsKilledEnemyjungle;
	}

	public void setNeutralMinionsKilledEnemyjungle(double neutralMinionsKilledEnemyjungle) {
		this.neutralMinionsKilledEnemyjungle = neutralMinionsKilledEnemyjungle;
	}

	public double getGoldEarned() {
		return goldEarned;
	}

	public void setGoldEarned(double goldEarned) {
		this.goldEarned = goldEarned;
	}

	public double getKills() {
		return kills;
	}

	public void setKills(double kills) {
		this.kills = kills;
	}

	public double getDeaths() {
		return deaths;
	}

	public void setDeaths(double deaths) {
		this.deaths = deaths;
	}

	public double getAssists() {
		return assists;
	}

	public void setAssists(double assists) {
		this.assists = assists;
	}

}
