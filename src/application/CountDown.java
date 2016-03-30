package application;

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
	
	private int minutes;
	private Timeline timeLine;
	private AnimationTimer timer;
	private Label text;
	private int sec = 0;

	public CountDown(){
		
	}
	
	public CountDown(int minutes){
		this.minutes = minutes;
	}
	
	public void setMin(int minutes){
		this.minutes = minutes;
	}
	
	public int getMin(){
		return minutes;
	}
	
	
	public void runTimer(){
		int startTime = this.minutes;
		
		text = new Label(String.format("%02d:%02d", this.minutes , this.sec));
		
		timeLine = new Timeline();
		timeLine.setCycleCount(timeLine.INDEFINITE);
		KeyFrame timer = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (timeLine != null) {
		            timeLine.stop();
		        }
				
				minutes = startTime;
				
				 if (minutes < 0 && sec < 0)
	                    timeLine.stop();
	                else if( minutes > 0 && sec == 00){
	                	sec = 59;
	                	minutes--;
	                }
	                else if(sec > 0)
	                	sec--;			
			} //handle()
			
		});
		
	}

}//
