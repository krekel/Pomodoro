package application;

import java.awt.Toolkit;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class CountDown extends Parent {
	
	public static final int POMODORO = 25;
	public static final int SHORT = 5;
	public static final int LONG = 10;
	
	private int startTime;
	private int minutes;
	private Timeline timeLine;
	private AnimationTimer timer;
	private Label text = new Label();
	private int sec;

	public CountDown(){
		sec = 0;
	}
	
	public Label getLabel(){
		return text;
	}
	
	public void runTimer(int min){
		
		minutes = min;
		
		timeLine = new Timeline();
		timeLine.setCycleCount(timeLine.INDEFINITE);
		KeyFrame timer = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				text.setText(String.format("%02d:%02d", minutes, sec));
				
				 if (minutes == 0 && sec == 0){
					 Toolkit.getDefaultToolkit().beep();
					 timeLine.stop();
				 }
	                    
				 else if( minutes > 0 && sec == 00){
	                	minutes--;
	                	sec = 59;
	                	
	                }
				 else if(sec > 0)
	                	sec--;
				 
			} //handle()
			
		});
		timeLine.getKeyFrames().add(timer);
		timeLine.playFromStart();
	}

}//
