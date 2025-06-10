import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MoodUI extends Application {

    private TextArea outputArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MoodMuse 🎵");

        // Title Label
        Label title = new Label("How are you feeling today?");
        title.setFont(Font.font("Verdana", 24));
        title.setTextFill(Color.DARKSLATEBLUE);

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setWrapText(true);
        outputArea.setFont(Font.font("Arial", 14));
        outputArea.setPrefHeight(200);
        outputArea.setStyle("-fx-control-inner-background: #F3F4F6;");

        // Mood Buttons
        HBox moodBox = new HBox(10);
        moodBox.setAlignment(Pos.CENTER);
        moodBox.setPadding(new Insets(20));

        String[] moods = {"😊 Happy", "😢 Sad", "😠 Angry", "😌 Relaxed", "😖 Stressed", "✨ Inspired"};
        for (String mood : moods) {
            Button moodBtn = new Button(mood);
            moodBtn.setFont(Font.font("Arial", 14));
            moodBtn.setStyle(getButtonStyle("#E0E7FF"));
            moodBtn.setOnMouseEntered(e -> moodBtn.setStyle(getButtonStyle("#C7D2FE")));
            moodBtn.setOnMouseExited(e -> moodBtn.setStyle(getButtonStyle("#E0E7FF")));
            moodBtn.setOnAction(e -> handleMoodClick(mood.split(" ")[1])); // Extract mood keyword
            moodBox.getChildren().add(moodBtn);
        }

        VBox layout = new VBox(20, title, moodBox, outputArea);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(30));
        layout.setStyle("-fx-background-color: linear-gradient(to bottom, #f0f4ff, #e0ecff);");

        Scene scene = new Scene(layout, 600, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleMoodClick(String mood) {
        String quote = MoodAnalyzer.getQuote(mood);
        String song = MoodAnalyzer.getSong(mood);
        outputArea.setText("🎵 Recommended Song:\n" + song + "\n\n💬 Quote:\n" + quote);
        MoodAnalyzer.logMood(mood, quote, song);
    }

    private String getButtonStyle(String bgColor) {
        return "-fx-background-color: " + bgColor + ";" +
                "-fx-background-radius: 12;" +
                "-fx-text-fill: #1E3A8A;" +
                "-fx-padding: 10 16 10 16;" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 5, 0, 0, 2);";
    }
}



