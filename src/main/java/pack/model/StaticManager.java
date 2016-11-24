package pack.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.staticdata.ChampData;
import net.rithms.riot.constant.staticdata.ItemListData;
import net.rithms.riot.constant.staticdata.MasteryListData;
import net.rithms.riot.constant.staticdata.RuneListData;
import net.rithms.riot.constant.staticdata.SpellData;


@Component
public class StaticManager {
	@Autowired
	RiotApiKeyRotate api;
	public Map<String,Object> getLocaleList(String locale){
		Map<String, Object> map=new HashMap<>();
		try {
			map.put("languagelist", api.getDataLanguages());
			map.put("language", api.getDataLanguageStrings(locale, api.getDataRealm().getV()));
		} catch (RiotApiException e) {
			map.put("errorCode", e.getErrorCode());
			map.put("errorMessage", e.getMessage());
		}

		return map;
	}
	
	public Map<String,Object> getChampionList(String locale){
		Map<String, Object> map=new HashMap<>();
		try {
			map.put("championlist", api.getDataChampionList(locale,api.getDataRealm().getV(),false,ChampData.IMAGE));
		} catch (RiotApiException e) {
			map.put("errorCode", e.getErrorCode());
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	public Map<String,Object> getChampion(String locale,int id){
		Map<String, Object> map=new HashMap<>();
		try{
			map.put("champion", api.getDataChampion(id,locale,api.getDataRealm().getV(),ChampData.ALL));
		} catch (RiotApiException e) {
			map.put("errorCode", e.getErrorCode());
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	public Map<String,Object> getItemList(String locale){
		Map<String, Object> map=new HashMap<>();
		try {
			map.put("itemlist", api.getDataItemList(locale,api.getDataRealm().getV(),ItemListData.ALL));
		} catch (RiotApiException e) {
			map.put("errorCode", e.getErrorCode());
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	public Map<String,Object> getMasterylist(String locale){
		Map<String, Object> map=new HashMap<>();
		try {
			map.put("masterylist", api.getDataMasteryList(locale, api.getDataRealm().getV(), MasteryListData.ALL));
		} catch (RiotApiException e) {
			map.put("errorCode", e.getErrorCode());
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	public Map<String,Object> getRunelist(String locale){
		Map<String, Object> map=new HashMap<>();
		try {
			map.put("runelist", api.getDataRuneList(locale, api.getDataRealm().getV(), RuneListData.ALL));
		} catch (RiotApiException e) {
			map.put("errorCode", e.getErrorCode());
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	public Map<String,Object> getSummonerSpell(String locale){
		Map<String, Object> map=new HashMap<>();
		try {
			map.put("spell", api.getDataSummonerSpellList(locale, api.getDataRealm().getV(),false,SpellData.ALL));
		} catch (RiotApiException e) {
			map.put("errorCode", e.getErrorCode());
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	
}
