import java.util.*;

/*

public class VerbConjugator{
    private Verb givenVerb;
    private Verb[][][] verbConjugations; //person - tense - negation
    
    public static void main(String[] args){
        while(true){
            VerbConjugator test = new VerbConjugator();
            test.printConjugations();
            System.out.println();
            System.out.println("****************************");
            System.out.println();
        }
    }    

    //Constructor    
    public VerbConjugator(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter any Swahili or English verb");
        String response; 
        while(true){
            response = myObj.nextLine().toLowerCase().trim();
            this.givenVerb = new Verb(response);
            if(givenVerb.verb() == null){
                System.out.println("Verb not recognized. Please enter another verb.");
            } else {
                break;
            }
        }
        if(givenVerb.isSwa() ){
            System.out.println("You chose " + givenVerb.toSwaString() + ", with infinitive '" + givenVerb.toSwaInfString() + "'");
            if( (givenVerb.subject() == null || givenVerb.tense() == null) && !givenVerb.isInf() ){
                System.out.println("The verb you entered is ungrammatical, but I assume you're looking for a conjugation of '" + givenVerb.toEngInfString() + "'");
            } else {   
                System.out.println("-->" + givenVerb.toSwaString() + " translates to '" + givenVerb.toEngString() + "'");
            }
        } else {
            System.out.println("You chose " + givenVerb.toEngString() + ", with infinitive '" + givenVerb.toEngInfString() + "'");
            if( (givenVerb.subject() == null || givenVerb.tense() == null) && !givenVerb.isInf() ){
                System.out.println("The verb you entered is ungrammatical, but I assume you're looking for a conjugation of '" + givenVerb.toSwaInfString() + "'");
            } else {   
                System.out.println("-->" + givenVerb.toEngString() + " translates to '" + givenVerb.toSwaString() + "'");
            }
        }
        this.verbConjugations = givenVerb.conjugate();
        System.out.println();
    }   
    
    //Prints all the conjugations of a given verb
    public void printConjugations(){
        for(int i = 0; i < verbConjugations[0].length; i++){
            System.out.println();
            System.out.println("In the positive " + verbConjugations[0][i][0].tense().tenseName() + " you get:");
            for(int j = 0; j < verbConjugations.length; j++){
                System.out.println(verbConjugations[j][i][0].toBothString(this.givenVerb().isSwa() ) );
            }
        }
        System.out.println();
        for(int i = 0; i < verbConjugations[0].length; i++){
            System.out.println();
            System.out.println("In the negative " + verbConjugations[0][i][0].tense().tenseName() + " you get:");
            for(int j = 0; j < verbConjugations.length; j++){
                System.out.println(verbConjugations[j][i][1].toBothString(this.givenVerb().isSwa() ) );
            }
        }    
    }
    
    //Returns the givenVerb
    public Verb givenVerb(){
        return this.givenVerb;
    }
}

 */