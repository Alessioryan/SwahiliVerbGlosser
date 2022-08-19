enum Tense{
        tPRES("present", "na", ""),
        tPAST_SIM("simple past", "li", "ku"),
        tPAST_PER("past perfect", "me", "ja"),
        tFUT("future", "ta", "ta");
        
        private String tenseName;
        private String swaPosTense;
        private String swaNegTense;
        
        private Tense(String tenseName, String swaPosTense, String swaNegTense){
            this.tenseName = tenseName;
            this.swaPosTense = swaPosTense;
            this.swaNegTense = swaNegTense;
        }
        
        public String getTenseName(){
            return this.tenseName;
        }
        
        public String getSwaPosTense(){
            return this.swaPosTense;
        }
        
        public String getSwaNegTense(){
            return this.swaNegTense;
        }
        
        public String getSwaTense(boolean isNeg){
            if(this == null){
                return "";
            }
            if(!isNeg){
                return this.getSwaPosTense();
            }
            return this.getSwaNegTense();
        }
    }