package edmt.dev.androidgridlayout;

public class QuestionLibrary {

    //questions array
    private String mQuestions[] = {
            "I feel depressed.",
            "I have no motivation.",
            "I feel anxious.",
            "I feel worried.",
            "I am irritable.",
            "I have no patience.",
            "I get angry easily.",
            "I feel nervous.",
            "I feel restless.",
            "I feel down."
    };

    //choices array (2D array)
    private String mChoices[][] = {
            {"Strongly Disagree", "Disagree", "Undecided", "Agree", "Strongly Agree"},
            {"Strongly Disagree", "Disagree", "Undecided", "Agree", "Strongly Agree"},
            {"Strongly Disagree", "Disagree", "Undecided", "Agree", "Strongly Agree"},
            {"Strongly Disagree", "Disagree", "Undecided", "Agree", "Strongly Agree"},
            {"Strongly Disagree", "Disagree", "Undecided", "Agree", "Strongly Agree"},
            {"Strongly Disagree", "Disagree", "Undecided", "Agree", "Strongly Agree"},
            {"Strongly Disagree", "Disagree", "Undecided", "Agree", "Strongly Agree"},
            {"Strongly Disagree", "Disagree", "Undecided", "Agree", "Strongly Agree"},
            {"Strongly Disagree", "Disagree", "Undecided", "Agree", "Strongly Agree"},
            {"Strongly Disagree", "Disagree", "Undecided", "Agree", "Strongly Agree"}
    };

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getChoice5(int a) {
        String choice4 = mChoices[a][4];
        return choice4;
    }

}
