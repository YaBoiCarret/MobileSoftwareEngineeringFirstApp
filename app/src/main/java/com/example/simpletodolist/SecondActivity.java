package com.example.simpletodolist;
import com.example.simpletodolist.Flashcard;
        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import java.util.ArrayList;
        import android.content.Intent;
public class SecondActivity extends AppCompatActivity {
    private ArrayList<Flashcard> flashcards = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Other initialization or code for SecondActivity
        // Populate flashcards
        flashcards.add(new Flashcard("What is device fragmentation?", "Designing user interfaces for all mobile devices available in the market\n"));
        flashcards.add(new Flashcard("What is OS Fragmentation?", "There are many different operating systems\n"));
        flashcards.add(new Flashcard("Unstable and Dynamic Environment", "Providing accessibility to key features or data even in unstable environment \n"));
        flashcards.add(new Flashcard("Rapid Changes", "Difficult to keep up with the changes. Require significant development and maintenance effort. \n"));
        flashcards.add(new Flashcard("Tool Support", "Poor performance of emulator/simulator, Slow development process \n"));
        flashcards.add(new Flashcard("Low Tolerance By Users", "Users will give a poor rating on app store if they experience any bugs or interuptions\n"));
        flashcards.add(new Flashcard("Low Security and Privacy Awareness", "Users do not know very much about there privacy settings and its harder to keep the apps secure because of this \n"));


        TextView answerTextView = findViewById(R.id.txtAnswer);
        // Display the first flashcard
        showFlashcard(0);
        //set answer to blank
        answerTextView.setText("");
        // Find the "Show Answer" button by its ID
        Button showAnswerButton = findViewById(R.id.showAnswerButton);
        // find the next button
        Button nextButton = findViewById(R.id.btnNext);
        // find the previous
        Button previousButton = findViewById(R.id.btnPrevious);
        //find home button
        Button takeMeHomeBtn= findViewById(R.id.btnMyClass);
        // Set an onClickListener to handle the button click
        showAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFlashcard(currentFlashcardIndex);
                showAnswer();
            }

        });
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(currentFlashcardIndex<flashcards.size()) {
                    currentFlashcardIndex += 1;
                    showFlashcard(currentFlashcardIndex);
                    TextView answerTextView = findViewById(R.id.txtAnswer);
                    answerTextView.setText(""); // Set the answer field to blank
                }

            }
        });

        previousButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(currentFlashcardIndex>0) {
                    currentFlashcardIndex -= 1;
                    showFlashcard(currentFlashcardIndex);
                    TextView answerTextView = findViewById(R.id.txtAnswer);
                    answerTextView.setText(""); // Set the answer field to blank
                }
            }
        });
        takeMeHomeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                Intent intent = new Intent(SecondActivity.this, MyClass.class);
                startActivity(intent);

            }
        });
    }

    private int currentFlashcardIndex = 0;

    private void showAnswer() {
        // Retrieve the current flashcard's answer and display it
        Flashcard flashcard = flashcards.get(currentFlashcardIndex);
        TextView answerTextView = findViewById(R.id.txtAnswer);
        answerTextView.setText(flashcard.getAnswer());
    }

    private void showFlashcard(int index) {
        if (index >= 0 && index < flashcards.size()) {
            Flashcard flashcard = flashcards.get(index);
            TextView questionTextView = findViewById(R.id.txtQuestion);


            questionTextView.setText(flashcard.getQuestion());

        }
    }


}
