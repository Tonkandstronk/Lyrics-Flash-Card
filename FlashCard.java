package flashCard;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.animation.RotateTransition;
import javafx.util.Duration;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlashCard extends Application {

    private Label flashCard = new Label();
    private Button flip = new Button("");
    private List<Flashcard> flashcards;
    private int currentIndex = 0;
    private boolean showingQuestion = true;

    // Flashcard class
    public static class Flashcard {
        private String question;
        private String answer;

        public Flashcard(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getQuestion() { return question; }
        public String getAnswer() { return answer; }
    }

    // Data
    public static class FlashCardData {
        public static List<Flashcard> getFlashcards() {
            List<Flashcard> flashcards = new ArrayList<>();

            flashcards.add(new Flashcard(
                "What would I be without my Louies\nSince I got money don't talk to me\nWhen I ain't have money you wasn't talkin' to me\nThese niggas with me they sparkin' for me",
                "Granny's"
            ));

            flashcards.add(new Flashcard(
                "Rep that block with my niggas yeah, them 3Hunna members\nGot a hunnid in my robins, Balenciagas cost 6 hunnid",
                "Hundreds"
            ));

            flashcards.add(new Flashcard(
                "She wanna be a Glory Girl, but she don't like my Glory Guys\nI know this bitch a thot, she wanna meet my mama now",
                "Macaroni Time"
            ));

            flashcards.add(new Flashcard(
                "\"When you put the O on the side the two\"\nThey like, \"Sosa and I got ya album too\"\nIf I was you, bitch, I will buy it too",
                "Buy It"
            ));

            flashcards.add(new Flashcard(
                "Got niggas in Nigeria and\nThey totin' choppas boy\nGo pick you a casket boy\nGo buy you a doctor boy\nGo buy you a choppa boy\nGo buy you some shottas boy\nSee you we gone shoot you boy\nYou make it hallelujah boy\nAnd I ain't gon' do it boy\nYou know how much my shoes lil boy",
                "Voodoo"
            ));

            flashcards.add(new Flashcard(
                "Police still lurkin', shawty want a Birkin\nI still murk it, you probably still a virgin\nThe life I live make you nervous\nSprinkler still goin', clock still tickin'\nGive a nigga a two piece\nSpicy with a biscuit",
                "Bestie"
            ));
            
            flashcards.add(new Flashcard(
            	    "El mejor fucking ekipo de Mexico",
            	    "Club America"
            	));
            		
        
            Collections.shuffle(flashcards); // Shuffle cards
            return flashcards;
        }
    }

    @Override
    public void start(Stage primaryStage) {

        flashcards = FlashCardData.getFlashcards(); // Load and shuffle cards

        // Style the flashcard
        flashCard.setStyle(
            "-fx-background-color:linear-gradient(to top,#FFFF00,#000000,#0000FF);" +
            "-fx-border-color:#8B0000; -fx-border-width:5;" +
            "-fx-text-fill:white; -fx-font-weight:bold;" +
            "-fx-font-family: fantasy; -fx-font-size:10px;"
        );
        flashCard.setPrefSize(350, 350);
        flashCard.setAlignment(Pos.CENTER);
        flashCard.setText(flashcards.get(currentIndex).getQuestion());

        // Transparent flip button
        flip.setPrefSize(350, 350);
        flip.setStyle("-fx-background-color:transparent; -fx-border-color:transparent;");
        flip.setOnAction(e -> flipCard());

        StackPane cards = new StackPane(flashCard, flip);

        BorderPane root = new BorderPane();
        root.setCenter(cards);
        root.setStyle("-fx-background-color:linear-gradient(to bottom,#FFFF00,#000000,#0000FF);");

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Flashy Flashcards");
        primaryStage.show();
    }

    private void flipCard() {
        if (showingQuestion) {
            flashCard.setText(flashcards.get(currentIndex).getAnswer()); // show answer
        } else {
            currentIndex++;
            if (currentIndex >= flashcards.size()) currentIndex = 0; // loop back
            flashCard.setText(flashcards.get(currentIndex).getQuestion()); // show next question
        }
        showingQuestion = !showingQuestion; // toggle state
    }

    public static void main(String[] args) {
        launch(args);
    }
}
