package chart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChartCreater extends Application {
   // @Override
    public void start(Stage stage) {
        Scene scene = SceneCreater.getChartScene();
        stage.setScene(scene);
        stage.setTitle("Risk Assessment");
        stage.show();
    }
    public void locallaunch( String[] args) {
		launch(args);
	}

}