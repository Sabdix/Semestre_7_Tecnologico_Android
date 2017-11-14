
package com.Clases;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/**
 *
 * @author sabdi
 */
public class GraficaBarras {
    
    public Intent getIntent(Context context, int[] array, String texto) {
        
        CategorySeries series = new CategorySeries("Gráfica de Barras");
        for (int i=0; i < array.length; i++) {
            series.add("Barra" + (i+1), array[i]);
        }
        
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(series.toXYSeries());
        
        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
        XYSeriesRenderer renderer = new XYSeriesRenderer();
        renderer.setDisplayChartValues(true);
        renderer.setChartValuesSpacing((float)2.5);
        renderer.setColor(Color.WHITE);
        mRenderer.addSeriesRenderer(renderer);
        
        mRenderer.setChartTitle(texto);
        mRenderer.setZoomButtonsVisible(true);

        

        
        Intent intent = ChartFactory.getBarChartIntent(context, dataset, mRenderer, Type.DEFAULT);
        
        return intent;
    }
    
}
