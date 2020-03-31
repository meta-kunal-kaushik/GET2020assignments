package Counseling;

import java.util.ArrayList;
import java.util.List;

public class student {

    String name;
    List <String> branch;
    
    student(String name){
        this.name = name;
        this.branch = new ArrayList<String>();
    }
   
   

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getBranch() {
        return branch;
    }
    public void setBranch(List<String> branch) {
        this.branch = branch;
    }
    
    
    @Override
    public String toString() {
        return "student [name=" + name + ", branch=" + branch + "]";
    }
    
}


