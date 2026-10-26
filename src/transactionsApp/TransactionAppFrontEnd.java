package transactionsApp;

import java.util.Objects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class TransactionAppFrontEnd extends Application {
	private BorderPane mainLayout;
	private final TransactionAppBackend backend = new TransactionAppBackend(); 
	
	void main(String[]args) {
		launch(args); // calling the start method
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(20));
        
        showOpeningScreen();
        
        Scene scene = new Scene(mainLayout, 900, 600);
		
		Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icon.jpg")));
		stage.getIcons().add(icon);
		stage.setTitle("Fynaro");
		
		stage.setScene(scene);
		stage.show();
	}
	
	private void showOpeningScreen() {
		HBox topBar = new HBox(10);
		topBar.setAlignment(Pos.CENTER_RIGHT);
		
		//buttons
		Button signupBtn = new Button("Sign Up");
		Button loginBtn = new Button("Login");
		
		signupBtn.setOnAction(e -> showAuthView("Sign Up"));
		loginBtn.setOnAction(e -> showAuthView("Login"));
		
		topBar.getChildren().addAll(loginBtn, signupBtn);
        mainLayout.setTop(topBar);
        
		VBox content = new VBox(15);
        content.setAlignment(Pos.CENTER);

        Label title = new Label("Welcome to Fynaro");
        title.setStyle("-fx-text-fill: black; -fx-font-size: 16px; -fx-text-alignment: center;");

        Label explanation = new Label(
            "Fynaro helps you manage your workflow seamlessly.\n" +
            "Explore features, track progress, and boost productivity."
        );
        explanation.setStyle("-fx-text-fill: black; -fx-font-size: 16px; -fx-text-alignment: center;");
        
        content.getChildren().addAll(title, explanation);
        mainLayout.setCenter(content);
	}
	
	private void showAuthView(String mode) {
		//same template in showLoginView too.
		HBox topBar = new HBox();
        topBar.setAlignment(Pos.CENTER_LEFT);
        Button backBtn = new Button("← Back to Home");
        backBtn.setOnAction(e -> showOpeningScreen());
        topBar.getChildren().add(backBtn);
        mainLayout.setTop(topBar);
        
     // Form View
        VBox form = new VBox(15);
        form.setMaxWidth(300);
        form.setAlignment(Pos.CENTER);
        
        // Toggle between Login and Signup modes dynamically
        Hyperlink toggleMode = new Hyperlink(
            mode.equals("Login") ? "Don't have an account? Sign Up" : "Already have an account? Login"
        );
        toggleMode.setOnAction(e -> showAuthView(mode.equals("Login") ? "Sign Up" : "Login"));

        
        Label title = new Label(mode);
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
        
        
        TextField username = new TextField();
        username.setPromptText("Username");
        
        PasswordField password = new PasswordField();
        password.setPromptText("Password"); 
        
        Button submitBtn = new Button(mode);
        submitBtn.setMaxWidth(Double.MAX_VALUE);
        submitBtn.setOnAction(e -> {
			try {
				if(mode.equals("Sign Up")) {
					backend.signup(username.getText(), password.getText());
				}
				else {
					backend.login(username.getText(), password.getText());
				}
				//showMainApp();
			} catch (Exception e1) {
				e1.printStackTrace();
				
				// same layout
				Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Signup Error");
		        alert.setHeaderText("Failed to create account");
		        alert.setContentText(e1.getMessage());
		        alert.showAndWait();
			}
		});
        form.getChildren().addAll(title, username, password, submitBtn, toggleMode);
        mainLayout.setCenter(form);
	}
}
