package chart;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class SeriesCreater {

	private static double[] x;
	private static double[] y;

	public static double[] getX() {
		return x;
	}

	public static double[] getY() {
		return y;
	}

	@SuppressWarnings("static-access")
	public void setX(double[] x) {
		this.x = x;
	}

	@SuppressWarnings("static-access")
	public void setY(double[] y) {
		this.y = y;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Series<Number, Number> getSeriesData() {
		Series<Number, Number> series1 = new Series<Number, Number>();
		series1.setName("Risk Management Policy");
		double[] x = getX();
		double[] y = getY();
		for (int i = 0; i < x.length; i++) {
			series1.getData().add(new XYChart.Data(x[i], y[i]));
		}

		return series1;

	}


}
