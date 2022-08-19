//Notes: Does not account for obj: -m-/-mw-
//To do: Make a practice system (with variying levels of difficulty, vRoot, +obj, +subj, etc...)
//          like a quizlet quiz, with messages for correct/incorrect
//Add infinitive

import java.util.*;

class SwahiliVerb{

    public static void main(String[] args){ 
        decompose("nilikupenda");
    }

    //Returns a Verb with all the properties of the original verb
    public static Verb decompose(String verb){
        String originalVerb = verb; //Figure out if this is necessary
        verb = verb.toLowerCase().trim();
        
        boolean isNegative = findIsNegative(verb);
        Subject subject = findSubject(verb, isNegative);
                
        verb = removeSubject(verb, isNegative, subject);
        Tense tense = findTense(verb, isNegative);
                
        verb = removeTense(verb, isNegative, tense);
        Object object = findObject(verb);
                
        verb = removeObject(verb, object);
        VRoot vRoot = findVRoot(verb, isNegative);
                
        return new Verb(originalVerb, isNegative, subject, tense, object, vRoot);
    }
    
    //If the verb is negative, return true, otherwise false
    public static boolean findIsNegative(String verb){
        for(Subject subject : Subject.values() ){
            if(verb.substring(0, subject.getSwaSubj(true).length() ).equals(subject.getSwaSubj(true) ) ){
                return true;
            }
        }
        return false;
    }
    
    //Finds the Subject of the given verb, returns null if none found
    public static Subject findSubject(String verb, boolean isNegative){
        for(int i = Subject.values().length - 1 ; i >= 0 ; i--){
            Subject prefix = Subject.values()[i];
            if(verb.substring(0, prefix.getSwaSubj(isNegative).length() ).equals(prefix.getSwaSubj(isNegative) ) ){
                return prefix;
            }
        }
        return null;
    }
    
    //Returns the parameter String without the subject
    public static String removeSubject(String verb, boolean isNegative, Subject subject){
        if(subject == null){
            return verb;
        }
        return verb.substring(subject.getSwaSubj(isNegative).length() );
    }
     
    //Finds the Tense of a given verb, returns null if none found
    public static Tense findTense(String verb, boolean isNegative){
        for(int i = Tense.values().length - 1 ; i >= 0 ; i--){
            Tense infix = Tense.values()[i];
            if(verb.substring(0, infix.getSwaTense(isNegative).length() ).equals(infix.getSwaTense(isNegative) ) ){
                return infix;
            }
        }
        return null;
    }

    //Removes the Tense
    public static String removeTense(String verb, boolean isNegative, Tense tense){
        if(tense == null){
            return verb;
        }
        return verb.substring(tense.getSwaTense(isNegative).length() );
    }
    
    //Finds the Object of a given verb, returns null if none found
    public static Object findObject(String verb){
        for(int i = Object.values().length - 1 ; i >= 0 ; i--){
            Object infix = Object.values()[i];
            if(verb.substring(0, infix.getSwaObj().length() ).equals(infix.getSwaObj() ) ){
                return infix;
            }
        }
        return null;
    }

    //Removes the Object
    //NEED TO ADD THE M/MW
    public static String removeObject(String verb, Object object){
        if(object == null){
            return verb;
        }
        return verb.substring(object.getSwaObj().length() );
    }    
    
    //Finds the VRoot of a given verb, returs null if none found
    public static VRoot findVRoot(String verb, boolean isNegative){
        for(int i = VRoot.values().length - 1 ; i >= 0 ; i--){
            VRoot vRoot = VRoot.values()[i];
            if(verb.length() == vRoot.getSwaVRoot().length() && verb.substring(0, vRoot.getSwaVRoot().length() ).equals(vRoot.getSwaVRoot(isNegative) ) ){
                return vRoot;
            }
        }
        return null;
    }
    
    //Makes a String representing the Swahili verb from a Verb
    public static String makeSwaVerb(Verb verb){
        boolean isNegative = verb.getIsNegative();
        String runningVerb = "";
        if(verb.getSubject() != null){
            runningVerb += verb.getSubject().getSwaSubj(isNegative);
        }
        if(verb.getTense() != null){
            runningVerb += verb.getTense().getSwaTense(isNegative);
        }
        if(verb.getObject() != null){
            runningVerb += verb.getObject().getSwaObj();  //Later, include -m-/-mw-
        }
        if(verb.getVRoot() != null){
            runningVerb += verb.getVRoot().getSwaVRoot(isNegative);
        }
        return runningVerb;
    }
}