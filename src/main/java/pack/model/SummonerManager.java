package pack.model;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pack.Controller.SummonerBean;
import pack.model.summoner.LeagueDto;
import pack.model.summoner.SummonerApiDao;
import pack.model.summoner.SummonerDao;
import pack.model.summoner.SummonerDto;

@Service
public class SummonerManager {
	
	@Autowired
	SummonerApiDao apiDao;
	@Autowired
	SummonerDao summonerDao;
	public Map<String,Object> getSummonerAndLeague(SummonerBean bean){
		HashMap<String,Object> map=new HashMap<>();
		SummonerDto summoner =summonerDao.selectSummoner(bean);
		LeagueDto dto=null;
		if(summoner!=null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Date date=null;
			try {
				date=format.parse(summoner.getSearchDate());
				summoner.setSearchDate(format.format(date));
			} catch (Exception e) {
				System.out.println("parsing err"+e);
			}
			Calendar searchDate=Calendar.getInstance();
			searchDate.setTime(date);
			searchDate.add(Calendar.MINUTE, 2);
			if(searchDate.getTime().before(new Date())){
				try {
					summoner=apiDao.ApigetSummonerByName(bean.getName());
					dto=apiDao.ApigetLeagueData(summoner.getId());
					summonerDao.updateSummoner(dto, summoner);
				} catch (Exception e) {
					System.out.println("getSummonerAndLeague ApiGetUpdate Error"+e);
					map.put("success", "false");
					map.put("error", e.getMessage());
					return map;
				}
			}
			map.put("summonerData", summoner);
			map.put("leagueData", summonerDao.selectLeagueData(summoner.getId()));
			map.put("success", "true");
		}else{
			try {
				summoner=apiDao.ApigetSummonerByName(bean.getName());
				dto=apiDao.ApigetLeagueData(summoner.getId());
				summonerDao.insertSummoner(dto, summoner);
				map.put("summonerData", summoner);
				map.put("leagueData", summonerDao.selectLeagueData(summoner.getId()));
				map.put("success", "true");
			} catch (Exception e) {
				map.put("success", "false");
				map.put("error", e.getMessage());
			}
		}
		return map;
	}
	
	
	
	
}
