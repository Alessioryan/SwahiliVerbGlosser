import java.util.*;

//DEAL WITH VERBS THAT CONTAIN "NOT" LATER

enum VRoot{
    vTO_COME("kuja", "come", "came", "come"), //monosyllable verb
    vTO_COOK("pika", "cook", "cooked", "cooked"),
    vTO_DIE("kufa", "die", "died", "died"), //monosyllable verb
    vTO_DO("fanya", "do", "did", "done"),
    vTO_DRAW("chora", "draw", "drew", "drawn"),
    vTO_DRINK("kunywa", "drink", "drank", "drunk"), //monosyllable verb
    vTO_EAT("kula", "eat", "ate", "eaten"), //monosyllable verb
    vTO_GO("enda", "go", "went", "gone"),
    vTO_HEAR("sikia", "hear", "heard", "heard"),
    vTO_JUMP("ruka", "jump", "jumped", "jumped"),
    vTO_LIVE("ishi", "live", "lived", "lived"),
    vTO_LOVE("penda", "love", "loved", "loved"),
    vTO_PLAY("cheza", "play", "played", "played"),
    vTO_READ("soma", "read", "read", "read"),
    vTO_RETURN("rudi", "return", "returned", "returned"),
    vTO_RUN("kimbia", "run", "ran", "ran"),
    vTO_SAY("sema", "say", "said", "said"),
    vTO_SEE("ona", "see", "saw", "seen"),
    vTO_SIT("kaa", "sit", "sat", "sat"),
    vTO_SLEEP("lala", "sleep", "slept", "slept"),
    vTO_SPEAK("ongea", "speak", "spoke", "spoken"),
    vTO_STAND("simama", "stand", "stood", "stood"),
    vTO_WALK("kimbia", "walk", "walked", "walked"),
    vTO_WRITE("andika", "write", "wrote", "written");
    
    private String swaVRoot;
    private String engPresVerb;
    private String engPastVerb;
    private String engPParticiple;
    
    final static char[] VOWELS = {'a','e','i','o','u'}; //Figure out formatting
    
    private VRoot(String swaVRoot, String engPresVerb, String engPastVerb, String engPParticiple){
        this.swaVRoot = swaVRoot;
        this.engPresVerb = engPresVerb;
        this.engPastVerb = engPastVerb;
        this.engPParticiple = engPParticiple;
    }
    
    public String getSwaVRoot(boolean isNegative){
        if(this == null){
            return "";
        }
        if(isNegative && this.swaVRoot.charAt(swaVRoot.length() - 1) == 'a'){
            return this.swaVRoot.substring(0, swaVRoot.length() - 1) + "i";
        }
        return this.swaVRoot;
    }
    
    public String getSwaVRoot(){
        return this.getSwaVRoot(false);
    }
    
    public String getEngPresVerb(){
        return this.engPresVerb;
    }
    
    public String getEngPresVerb(Subject subj){
        if(subj == Subject.s3_SING){
            String lastTwoLetters = this.engPresVerb.substring(0, this.engPresVerb.length() - 2);
            char lastLetter = this.engPresVerb.charAt(this.engPresVerb.length() - 1);
            if(lastTwoLetters.equals("ch") || lastTwoLetters.equals("sh") || lastLetter == 'o' || lastLetter == 's' || lastLetter == 'x' || lastLetter == 'z'){
                return this.engPresVerb + "es";
            } else if(lastLetter == 'y' || !Arrays.asList(VOWELS).contains(this.engPresVerb.charAt(this.engPresVerb.length() - 2)) ){ //CONTINUE HERE
                return this.engPresVerb.substring(0, this.engPresVerb.length() - 1) + "ies";
            } else if(false){ //Irregulars, do later
                
            } else {
                return this.engPresVerb + "s";
            }
        }
        return this.engPresVerb;
    }
    
    public String getEngPastVerb(){
        return this.engPastVerb;
    }
    
    public String getEngPParticiple(){
        return this.engPParticiple;
    }
}