package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
	
	Label time = new Label();
	CountDown countDown = new CountDown();
	private boolean running = false;
	
	@Override
	public void start(Stage primaryStage) {
			
			time = countDown.getLabel();
			
			BorderPane root = new BorderPane();
			root.setTop(addGridUpper());
			root.setBottom(addGridBottom());
			root.setCenter(time);
			
			Scene scene = new Scene(root,500,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Tomate Timer");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("icon.png"));
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
				@Override
				public void handle(WindowEvent event) {
					Platform.exit();
					System.exit(0);	
				}
			});
			primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public GridPane addGridUpper(){
		
		GridPane grid = new GridPane();
		grid.setHgap(20);
		grid.setVgap(20);
	    grid.setPadding(new Insets(15, 12, 15, 12));
	    
	    //Pomodoro button(25min)
	    Button buttonPomodoro = new Button("Pomodoro");
        buttonPomodoro.setPrefSize(200, 60);
        grid.add(buttonPomodoro, 0, 0);
        buttonPomodoro.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				if(!running){
					countDown.setCurrent(1);
					countDown.setMinutes(25);
					countDown.runPomodoro();
					running = true;
				}
				else if(running){
					running = false;
					countDown.getTimeLine().stop();
					countDown.setCurrent(1);
					countDown.setMinutes(25);
					countDown.runPomodoro();
					running = true;
				}
			}
        	
        });
        
        //Short break button(5min)
        Button buttonShortBreak = new Button("Short Break");
        buttonShortBreak.setPrefSize(200, 60);
        grid.add(buttonShortBreak, 1, 0);
        buttonShortBreak.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(!running){
					countDown.setCurrent(2);
					countDown.setMinutes(5);
					countDown.runPomodoro();
					running = true;
				}
				else if(running){
					running = false;
					countDown.getTimeLine().stop();
					countDown.setCurrent(2);
					countDown.setMinutes(5);
					countDown.runPomodoro();
					running = true;
				}
			}
		});
        
        //Long break(10min)
        Button buttonLongBreak = new Button("Long Break");
        buttonLongBreak.setPrefSize(200, 60);
        grid.add(buttonLongBreak, 2, 0);
        buttonLongBreak.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(!running){
					countDown.setCurrent(3);
					countDown.setMinutes(10);
					countDown.runPomodoro();
					running = true;
				}
				else if(running){
					running = false;
					countDown.getTimeLine().stop();
					countDown.setCurrent(3);
					countDown.setMinutes(10);
					countDown.runPomodoro();
					running = true;
				}
			}
		});
	    
		return grid;
		
	}
	
	public GridPane addGridBottom(){
		
		GridPane grid = new GridPane();
		grid.setHgap(20);
		grid.setVgap(20);
	    grid.setPadding(new Insets(15, 12, 15, 12));
	    
	    //Start button
	    Button startBtn = new Button("Start");
        startBtn.setPrefSize(200, 60);
        grid.add(startBtn, 0, 0);
        startBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				countDown.start();
				
			}
		});
 
        //Stop button
        Button stopBtn = new Button("Stop");
        stopBtn.setPrefSize(200, 60);
        grid.add(stopBtn, 1, 0);
        stopBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				countDown.pause();
			}
		});
        
        //Reset Button
        Button resetBtn = new Button("Reset");
        resetBtn.setPrefSize(200, 60);
        grid.add(resetBtn, 2, 0);
        resetBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				countDown.reset();
			}
		});
	    
		return grid;
	}
	
}
