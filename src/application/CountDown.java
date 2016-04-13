package application;

import java.awt.Toolkit;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class CountDown extends Parent {
	
	private int minutes;
	private Timeline timeLine;
	private AnimationTimer timer;
	private Label text = new Label();
	private int sec, min; 
	private int curr;
	
	public Label getLabel(){
		return text;
	}
	
	public Timeline getTimeLine(){
		return timeLine;
	}
	
	public void setMinutes(int minutes){
		this.minutes = minutes;
	}
	
	public int getMinutes(){
		return minutes;
	}
	
	public void setCurrent(int curr){
		this.curr = curr;
	}
	
	public int getCurrent(){
		return curr;
	}
	
	public void runPomodoro(){
		min = getMinutes();
		sec = 0;
		
		timeLine = new Timeline();
		timeLine.setCycleCount(timeLine.INDEFINITE);
		KeyFrame timer = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				text.setText(String.format("%02d:%02d", min, sec));
				
				 if (min == 0 && sec == 0){
					 Toolkit.getDefaultToolkit().beep();
					 timeLine.stop();
				 } 
				 else if( min > 0 && sec == 0){
	                	min--;
	                	sec = 59;
	                }
				 else if(sec > 0)
	                	sec--;
				 
			} //handle()
			
		});
		timeLine.getKeyFrames().add(timer);
		timeLine.playFromStart();
	}
	
	public void runShort(){
		minutes = 5;
		sec = 0;
		curr = 2;
		
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
				 else if( minutes > 0 && sec == 0){
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
	
	public void runLong(){
		minutes = 10;
		sec = 0;
		curr = 3;
		
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
				 else if( minutes > 0 && sec == 0){
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
	
	public void start(){
		timeLine.play();
	}
	
	public void pause(){
		timeLine.pause();
	}
	
	public void reset(){
		switch (curr) {
		case 1:
			min = 25;
			sec = 0;
			break;
		case 2:
			min = 5;
			sec = 0;
			break;
		case 3:
			min = 10;
			sec = 0;
			break;
		default:
			break;
		}
	}

}//
