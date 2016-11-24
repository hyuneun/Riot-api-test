package pack.model;


import org.springframework.stereotype.Component;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.constant.Region;

@Component
public class RiotApiKeyRotate extends RiotApi{
	private String[] key={
			"RGAPI-405a98fb-22c7-4afc-8718-77a577111c33",   
			"RGAPI-ecd1ee24-b78a-4a8c-8984-0d3a153e95cb",
			"RGAPI-318533dd-c968-4019-8f0b-7d9ead363547",
			"RGAPI-6498944e-01da-4335-a120-d85f8e47933b",
			"RGAPI-4ddd1110-574c-4a90-8444-3b6b3f9dcd3d",	//우리팀꺼
			"RGAPI-033e608d-708b-4e5d-97bd-cf6ceafe3356"}; //미림 api

	private int index=0;
	public RiotApiKeyRotate() {
		setKey(key[index]);
		setRegion(Region.KR);
	}
	public void next(){
		index++;
		if(!(index<key.length)){
			index=0;
		}
		setKey(key[index]);
	}
}
