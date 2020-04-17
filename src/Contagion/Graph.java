package Contagion;
import java.awt.BasicStroke;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection; 

public class Graph extends JFrame {
	public Graph(){
		super(" ");
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel chartPanel = createChartPanel();
		add(chartPanel, BorderLayout.CENTER);
		setVisible(true);
	}
	
	private JPanel createChartPanel() {
		String chartTitle = "SIR model";
		String XTitle = "Time";
		String YTitle = "Infections";
		
		XYDataset dataset = createDataSet();
		JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, XTitle, YTitle, dataset);
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
		
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesPaint(1, Color.BLUE);
		renderer.setSeriesPaint(2, Color.GREEN);
		
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));
		renderer.setSeriesStroke(1, new BasicStroke(2.0f));
		renderer.setSeriesStroke(2, new BasicStroke(2.0f));
		
		plot.setBackgroundPaint(Color.DARK_GRAY);
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);
		
		plot.setRenderer(renderer);
		
		return new ChartPanel(chart);
	}
	private XYDataset createDataSet() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		XYSeries series1 = new XYSeries("Number of Infected");
		XYSeries series2 = new XYSeries("Number of Susceptible");
		XYSeries series3 = new XYSeries("Number of Cured");
		
		int t = 0;
		
		for(int n:Contagion.curedHistory) {
			series3.add(t, n);
			t++;
		}
		t = 0;
		for(int n:Contagion.infectedHistory) {
			series1.add(t, n);
			t++;
		}
		t = 0;
		for(int n:Contagion.healthyHistory) {
			series2.add(t,n);
			t++;
		}
		
		dataset.addSeries(series1);
	    dataset.addSeries(series2);
	    dataset.addSeries(series3);
	    
	    return dataset;
	}
}
