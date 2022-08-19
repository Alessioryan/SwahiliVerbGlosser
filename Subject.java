enum Subject{
    s1_SING(1, false, "ni", "si", "i"), //Figure out a way to account for "i" capitalization
    s2_SING(2, false, "u", "hu", "you"),
    s3_SING(3, false, "a", "ha", "s/he"),
    s1_PLUR(1, true, "tu", "hatu", "we"),
    s2_PLUR(2, true, "m", "ham", "you all"),
    s3_PLUR(3, true, "wa", "hawa", "they");
    
    private int person;
    private boolean isPlur;
    private String swaPosSubj;
    private String swaNegSubj;
    private String engSubj;
    
    private Subject(int person, boolean isPlur, String swaPosSubj, String swaNegSubj, String engSubj){
        this.person = person;
        this.isPlur = isPlur;
        this.swaPosSubj = swaPosSubj;
        this.swaNegSubj = swaNegSubj;
        this.engSubj = engSubj;
    }
    
    public int getPerson(){
        return this.person;
    }
    
    public boolean getIsPlur(){
        return this.isPlur;
    }
    
    public String getSubj(boolean isSwa, boolean isNeg){ //Is this necessary?
        if(isSwa){
            return getSwaSubj(isNeg);
        } else {
            return this.engSubj;
        }
    }
    
    public String getSwaSubj(boolean isNeg){
        if(this == null){
            return "";
        }
        if(isNeg){
            return this.swaNegSubj;
        }
        return this.swaPosSubj;
    }
    
    public String getEngSubj(){
        return this.engSubj;
    }
    
    enum AlternateSubject{
        aS3_SING_HE(s3_SING, "he"),
        aS3_SING_SHE(s3_SING, "she"),
        aS2_PLUR_YALL(s2_PLUR, "yall"),
        aS2_PLUR_Y_ALL(s2_PLUR, "y'all");
        
        private Subject subject;
        private String altEngSubj;
        
        private AlternateSubject(Subject subject, String altEngSubj){
            this.subject = subject;
            this.altEngSubj = altEngSubj;
        }
        
        public Subject getSubject(){
            return this.subject;
        }
        
        public String getEngSubj(){
            return this.altEngSubj;
        }
    }
}