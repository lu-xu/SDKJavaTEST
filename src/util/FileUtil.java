package util;

import java.util.ArrayList;
import java.util.List;

import _Test.bean.AnalysEntity;

public class FileUtil {
	public static double calPrice(long duration){
		//��λ����
//		return duration*0.01/900+0.01;
//		return 0.01;
		return duration*0.01/60+1.01;
	}
	public static String AnalysLog(String content,List<String> target){
		List<Integer> times = new ArrayList<>();
		for(String s:target){
			String[] temp = s.split(content);
			times.add(Integer.parseInt(temp[1]));
			
		}
		int ms50=0,ms200=0,ms1000=0,ms1000_=0;
		int total=0;
		for(int i:times){
			if(i<50){
				ms50++;
			}else if(i<200){
				ms200++;
			}else if(i<1000){
				ms1000_++;
			}else{
				ms1000++;
			}
			total+=i;
		}
		double average = total/target.size();
		double ms50p = ms50/target.size()*100;
		double ms200p = ms200/target.size()*100;
		double ms1000p = ms1000/target.size()*100;
		double ms1000p_ = ms1000_/target.size()*100;
		AnalysEntity entity = new AnalysEntity();
		entity.setMs50(ms50);
		entity.setMs200(ms200);
		entity.setMs1000(ms1000);
		entity.setMs50p(ms50p);
		entity.setMs200p(ms200p);
		entity.setMs1000p(ms1000p);
		entity.setAverage(average);
		String msg = content+target.size()+"��\n 50ms����"+ms50+"��������"+ms50p+"%\n 50~200ms"+ms200+"��������"+ms200p+"%\n 200~1000s"+ms1000_+"��������"+ms1000p_+"%\n 1s����"+ms1000+"��������"+ms1000p+"%\n ƽ��"+average+"ms\n";
		entity.setMsg(msg);
		return msg;
	}
}
