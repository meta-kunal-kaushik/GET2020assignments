package Counseling;

import java.util.HashMap;

public class programs {

    String branchName;
    int capasity;
    HashMap<String,Integer> map;
    programs(String branchName,int capasity){
        map.put(branchName, capasity);
    }
}
