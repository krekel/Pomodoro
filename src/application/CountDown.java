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
	private Label text = new Label();
	private int sec;

	public CountDown(){
		sec = 0;
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
	
	public Label getLabel(){
		return text;
	}
	
	
	public void runTimer(){
		
		int startTime = getMin();
		
		timeLine = new Timeline();
		timeLine.setCycleCount(timeLine.INDEFINITE);
		KeyFrame timer = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (timeLine != null) {
		            timeLine.stop();
		        }
				
				minutes = startTime;
				
				text.setText(String.format("%02d:%02d", minutes, sec));
				
				 if (minutes < 0 && sec < 0)
	                    timeLine.stop();
	             if( minutes > 0 && sec == 00){
	                	sec = 59;
	                	minutes--;
	                }
	             if(sec > 0)
	                	sec--;			
			} //handle()
			
		});
		timeLine.getKeyFrames().add(timer);
		timeLine.playFromStart();
	}

}//
