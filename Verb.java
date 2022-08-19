//Hakupendi (S/he doesn't like you) vs Hakupenda (S/he didn't like) vs Hakukupenda (S/he didn't like you)
//      Notice the "i" at the end (significant)
//Hawapendi (S/he doesn't like them) vs (They don't like)
//      Both are valid, change code to allow for both interpretations (context differentiates)
//Is tense strictly obligatory? Should I mark a verb as incorrect if it doesn't have tense?
//      No subject is assumed to be s.1_SING, Napenda = I like
//      If there is no tense, Tense tense = NULL;
//Does there exist a pair of words where -m-/-mw- create ambiguity? (e.g. if womba was a word
//  ninamwomba would have two meanings)
//      omba = to pray/to wish
//      womba = ???
//      ninamwomba = ni + na + m + womba OR ni + na + mw + omba
//      umia = to hurt and tumia = to use, tuma = send, tumia = send to
//      umiza = to hurt (with causative exention)
//      mwumiza or mtumia
//      There does NOT exist such a minimal pair
//How is hanipenda interpreted? (Incorrect neg. pres. conjugation) vs. (Neg. non-pres. conjugation)
// ^^ Assumed to be incorrect 
//      Throw error, it is incorrect

//Does there exist a pair of identical verbs roots but one ends in -a and the other in -i?
// ^^ Assumed to not exist
//      No
//      kuishi = to live, kwisha = to finish
//      finish is maliza
//      kwisha (to reach the end), kumaliza (to finish, to complete e.g. beverage), mwisho (the end)
//      haishi = s/he doesn't live (somewhere), s/he doesn't finish
//Do any verbs begin with a "y" and is it counted as a vowel?
//      Not really
//      Kuyumba = to swing, to sway (intransitive)
//      Y is a consonant
//      Ninamyumbisha = ni + na + m + yumb + isha (causative) = cause him to sway
//Are there many examples like kula + ia = kulia? Or are there few
//      -ia is a prepositional extension (to/for)
//      Account for both (tumia both meanings)
//      Pikia = pika + ia = cook for
//Are there two different verbs that differ only in their final vowel?
//      See example above

import java.util.*;

class Verb{
    private String originalVerb; //Figure out if this is necessary later
    private boolean isNegative;
    private Subject subject;
    private Tense tense;
    private Object object;
    private VRoot vRoot;
    
    public static void main(String[] args){
        //while(true){
            Scanner console = new Scanner(System.in);
            System.out.print("What Swahili verb would you like to decompose? ");
            Verb testVerb = SwahiliVerb.decompose(console.next().trim().toLowerCase() );
            System.out.println("Remaking your verb, you get: " + SwahiliVerb.makeSwaVerb(testVerb) );
            analyze(testVerb);
        //}
    }
    
    public Verb(String originalVerb, boolean isNegative, Subject subject, Tense tense, Object object, VRoot vRoot){
        this.originalVerb = originalVerb;
        this.isNegative = isNegative;
        this.subject = subject;
        this.tense = tense;
        this.object = object;
        this.vRoot = vRoot;
    }
    
    public boolean getIsNegative(){
        return this.isNegative;
    }
    
    public Subject getSubject(){
        return this.subject;
    }
    
    public Tense getTense(){
        return this.tense;
    }
    
    public Object getObject(){
        return this.object;
    }
    
    public VRoot getVRoot(){
        return this.vRoot;
    }
    
    public static void analyze(Verb verb){
        System.out.println("The original verb is: " + verb.originalVerb);
        System.out.println("The verb is negative: " + verb.isNegative);
        System.out.println("The subject is: " + verb.subject);
        System.out.println("The tense is: " + verb.tense);
        System.out.println("The object is: " + verb.object);
        System.out.println("The verb root is: " + verb.vRoot);
        System.out.println();
    }
    
}