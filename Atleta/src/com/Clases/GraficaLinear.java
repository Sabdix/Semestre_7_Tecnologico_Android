/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Clases;

import android.content.Context;
import android.graphics.Color;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/**
 *
 * @author sabdi
 */
public class GraficaLinear {
    
    private GraphicalView view;
    private TimeSeries dataset = new TimeSeries("Rendimiento");
    private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
    private XYSeriesRenderer renderer = new XYSeriesRenderer();
    private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();

    public GraficaLinear(String nombre) {
        //Agregar simple dataset a uno multiple
        mDataset.addSeries(dataset);
        
        //Personalizar Línea
        renderer.setColor(Color.WHITE);
        renderer.setPointStyle(PointStyle.SQUARE);
        renderer.setFillPoints(true);
        
        //Habilitar zoom
        mRenderer.setZoomButtonsVisible(true);
        mRenderer.setXTitle("Partidos");
        mRenderer.setYTitle("Rendimiento de "+ nombre);
        
        //Renderer simple a uno multiple
        mRenderer.addSeriesRenderer(renderer);
    }
    
    public GraphicalView getView(Context context) {
        view = ChartFactory.getLineChartView(context, mDataset, mRenderer);
        return view;
    }
    
    public void agregarPunto(Punto p) {
        dataset.add(p.getX(), p.getY());
    }
}
