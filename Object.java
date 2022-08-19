enum Object{
    s1_SING(1, false, "ni", "me"),
    s2_SING(2, false, "ku", "you"),
    s3_SING(3, false, "m", "her/him"), //Acknowledge irregularities
    s1_PLUR(1, true, "tu", "us"),
    s2_PLUR(2, true, "wa", "you all"),
    s3_PLUR(3, true, "wa", "them");
    
    private int person;
    private boolean isPlur;
    private String swaObj;
    private String engObj;
    
    private Object(int person, boolean isPlur, String swaObj, String engObj){
        this.person = person;
        this.isPlur = isPlur;
        this.swaObj = swaObj;
        this.engObj = engObj;
    }
    
    public int getPerson(){
        return this.person;
    }
    
    public boolean getIsPlur(){
        return this.isPlur;
    }
    
    public String getObj(boolean isSwa, boolean isNeg){ //Is this necessary?
        if(isSwa){
            return getSwaObj();
        } else {
            return this.engObj;
        }
    }
    
    public String getSwaObj(){
        if(this == null){
            return "";
        }
        return this.swaObj;
    }
    
    public String getEngObj(){
        return this.engObj;
    }
}