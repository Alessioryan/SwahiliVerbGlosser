//The "s" messes everything up

import java.util.*;

class EnglishVerb{
    
    public static void main(String[] args){
        while(true){
            System.out.println("What verb would you like to decompose? ");
            Scanner console = new Scanner(System.in);
            decompose(console.nextLine() );
            System.out.println();
        }
    }
    
    //Returns a Verb with all the properties of the original verb
    public static void decompose(String verb){ //Void for now, will be Verb
        String originalVerb = verb; //Once again, figure out if necessary
        verb = verb.toLowerCase().trim();
        
        boolean isNegative = findIsNegative(verb);
        verb = removeNegative(verb, isNegative);
        
        Subject subject = findSubject(verb);
        verb = removeSubject(verb, subject);
        
        
        System.out.println("The verb is negative: " + isNegative);
        System.out.println("subject is: " + subject);
        System.out.println("verb is: " + verb);
    }
    
    //If the verb is negative, returns true, otherwise false
    public static boolean findIsNegative(String verb){
        if(verb.contains("n't") || verb.contains("not") ){
            return true;
        }
        return false;
    }
    
    //Removes the negation from the verb 
    public static String removeNegative(String verb, boolean isNegative){
        if(isNegative && verb.length() >= 3){
            for(int i = 0; i < verb.length() - 2; i++){
                String focusString = verb.substring(i, i + 3);
                if(focusString.equals("n't") && i != 0 && verb.charAt(i - 1) == 'o' ){ //Fix this for don't -> do
                    return (verb.substring(0, i - 1) + "ill" + verb.substring(i + 3) );
                } else if(focusString.equals("not") || focusString.equals("n't") ){
                    return (verb.substring(0, i) + verb.substring(i + 3) ); 
                } 
            }
        } 
        return verb;
    }
    
    //Returns the subject of the given verb
    public static Subject findSubject(String verb){ //Subject must have a space after (prioritizes help over he-lp)
        for(int i = Subject.values().length - 1 ; i >= 0 ; i--){
            Subject subject = Subject.values()[i]; 
            if(verb.length() >= subject.getEngSubj().length() + 1 && verb.substring(0, subject.getEngSubj().length() + 1).equals(subject.getEngSubj() + " ") ){
                return subject;
            }
        }
        for(int i = Subject.AlternateSubject.values().length - 1; i >=0 ; i--){
            Subject.AlternateSubject altSubject = Subject.AlternateSubject.values()[i];
            if(verb.length() >= altSubject.getEngSubj().length() + 1 && verb.substring(0, altSubject.getEngSubj().length() + 1).equals(altSubject.getEngSubj() + " ") ){
                return altSubject.getSubject();
            }
        }
        return null;
    }
    
    //Removes the subject from the verb and returns the new verb
    public static String removeSubject(String verb, Subject subject){
        if(subject == null){
            return verb;
        }
        if(verb.substring(0, subject.getEngSubj().length() + 1).equals(subject.getEngSubj() + " ") ){
            return verb.substring(subject.getEngSubj().length() + 1); 
        }
        for(Subject.AlternateSubject altSubject : Subject.AlternateSubject.values() ){
            if(verb.substring(0, altSubject.getEngSubj().length() + 1).equals(altSubject.getEngSubj() + " ") ){
                return verb.substring(altSubject.getEngSubj().length() + 1);
            }
        }
        throw new IllegalArgumentException("Shouldn't get here");
    }
    
    //Finds the VRoot of the verb
    public static VRoot findVRoot(String verb, Subject subject){ //For now, "do"/"have" will not be included
        for(VRoot vRoot : VRoot.values() ){
            if(verb.contains(vRoot.getEngPresVerb(subject) ) || verb.contains(vRoot.getEngPastVerb() ) || verb.contains(vRoot.getEngPParticiple() ) ){
                return vRoot;
            }
        }
        return null;
    }
    
    //Returns the Tense
    public static Tense findTense(String verb, boolean isNegative, Subject subject){
        if(verb.contains("will") ){
            
        }
        //eat - don't eat (do eat) NOTE: s3_SING might add an "s"
        //ate - didn't eat (did eat)
        //have eaten - haven't eaten (have eaten)
        //will eat - won't eat (will eat)
        return null;
    }
    
    
    

    
}