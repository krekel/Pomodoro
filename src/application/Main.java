package application;
	
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
	Button buttonPomodoro;
	Label time = new Label();
	CountDown countDown = new CountDown();
	//private boolean running;
	
	@Override
	public void start(Stage primaryStage) {
		
			time = countDown.getLabel();
			
			BorderPane root = new BorderPane();
			root.setTop(addGridUpper(buttonPomodoro));
			root.setBottom(addGridBottom());
			root.setCenter(time);
			
			Scene scene = new Scene(root,600,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Pomodoro Timer");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
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
	
	public GridPane addGridUpper(Button buttonPomodoro){
		
		GridPane grid = new GridPane();
		grid.setHgap(20);
		grid.setVgap(20);
	    grid.setPadding(new Insets(15, 12, 15, 12));
	    
	    //Pomodoro button(25min)
	    buttonPomodoro = new Button("Pomodoro");
        buttonPomodoro.setPrefSize(200, 60);
        grid.add(buttonPomodoro, 0, 0);
        buttonPomodoro.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				countDown.runTimer();
			}
        	
        });
        
        //Short break button(5min)
        Button buttonShortBreak = new Button("Short Break");
        buttonShortBreak.setPrefSize(200, 60);
        grid.add(buttonShortBreak, 1, 0);
        buttonShortBreak.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
		
				
			}
		});
        
        //Long break(10min)
        Button buttonLongBreak = new Button("Long Break");
        buttonLongBreak.setPrefSize(200, 60);
        grid.add(buttonLongBreak, 2, 0);
        buttonLongBreak.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
					
				
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
				
				
			}
		});
 
        //Stop button
        Button stopBtn = new Button("Stop");
        stopBtn.setPrefSize(200, 60);
        grid.add(stopBtn, 1, 0);
        stopBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			}
		});
        
        //Reset Button
        Button resetBtn = new Button("Reset");
        resetBtn.setPrefSize(200, 60);
        grid.add(resetBtn, 2, 0);
        resetBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				
			}
		});
	    
		return grid;
	}
	
//	public void runTimer(int mins){
//		  final Timer timer = new Timer();
//	        timer.scheduleAtFixedRate(new TimerTask() {
//	            int sec = 00;
//	            int min = mins;
//	            
//	            public void run() {
//	            	
//	            	time.setText(String.format("%02d:%02d", min , sec));
//	                System.out.printf("%02d:%02d", min , sec);
//	                System.out.println();
//	                
//	                if (min < 0 && sec < 0)
//	                    timer.cancel();
//	                else if( min > 0 && sec == 00){
//	                	sec = 59;
//	                	min--;
//	                }
//	                else if(sec > 0)
//	                	sec--;
//	            }
//	        }, 0, 1000);
//	    }
	
}
