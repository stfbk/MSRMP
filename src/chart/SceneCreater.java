package chart;

import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

public class SceneCreater {
	private double x;
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	private double y;
	@SuppressWarnings("unchecked")
	public static Scene getChartScene() {
		//scene configuration
		final NumberAxis xAxis = new NumberAxis(0.20, 1.0, 0.02);
		final NumberAxis yAxis = new NumberAxis(0.20, 1.0, 0.02);
		final ScatterChart<Number, Number> sc = new ScatterChart<Number, Number>(xAxis, yAxis);
		xAxis.setLabel("Data Subject");
		yAxis.setLabel("Data Controller");
		sc.setTitle("Feasible Solutions");
		XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
		series1= SeriesCreater.getSeriesData();
		sc.getData().addAll(series1);
		Scene scene = new Scene(sc, 1200, 700);

		return scene;
	}
}
