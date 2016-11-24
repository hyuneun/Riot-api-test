package pack.model.match;

import java.util.List;

public class MatchBean {
	private List<MatchTeamDto> team;
	private List<MatchParticipantDto> participant;
	private List<MatchParticipantIdentitiesDto> participantIdentities;

	public List<MatchTeamDto> getTeam() {
		return team;
	}

	public void setTeam(List<MatchTeamDto> team) {
		this.team = team;
	}

	public List<MatchParticipantDto> getParticipant() {
		return participant;
	}

	public void setParticipant(List<MatchParticipantDto> participant) {
		this.participant = participant;
	}

	public List<MatchParticipantIdentitiesDto> getParticipantIdentities() {
		return participantIdentities;
	}

	public void setParticipantIdentities(List<MatchParticipantIdentitiesDto> participantIdentities) {
		this.participantIdentities = participantIdentities;
	}

}
