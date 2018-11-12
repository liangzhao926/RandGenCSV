package Common;

import java.util.HashMap;
import java.util.Map;

public class RandomImsi<E> {
	Map<String, RandomCollection<String>> map = new HashMap<String, RandomCollection<String>>(); 

    public RandomImsi(RandomCollection<String> mapMccMnc, int size) {
    	super();
    	for (String mccMnc : mapMccMnc.values()) {
    		RandomCollection<String> rc = new RandomCollection<String>();
    		map.put(mccMnc, rc);
            for (int i = 0; i < size; i++) {
            	rc.add(RandUtils.nextIntString(Config.IMSI_LEN), 10.0);
            }
    		
    	}
    }
    
    public String next(String mccMnc) {
    	RandomCollection<String> rc = map.get(mccMnc);
    	if (null == rc) {
    		return "";
    	}
    	return rc.next();
    }

}