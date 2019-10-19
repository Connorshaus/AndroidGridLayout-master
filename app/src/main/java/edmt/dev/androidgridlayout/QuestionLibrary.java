package edmt.dev.androidgridlayout;

public class QuestionLibrary {

    //questions array
    private String mQuestions [] = {
            "What is our professor's first name?",
            "What time is our class at?",
            "What days do we have class on?",
            "What day is our next progress report due?"
    };

    //choices array (2D array)
    private String mChoices [][] = {
            {"Maya", "Sonia", "Laura"},
            {"11:00", "1:25", "3:35"},
            {"Mon/Wed", "Tues/Thurs", "Mon/Wed/Fri"},
            {"Sunday", "Monday", "Tuesday"}
    };

    //correct answers array
    private String mCorrectAnswers[] = {"Sonia", "3:35", "Mon/Wed", "Sunday"};

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a){
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a){
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}