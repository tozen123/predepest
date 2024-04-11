package com.doublehammerstudio.predepest;

public class DataDensityModel {
    private String densityLabel;
    private String dateLabel;

    private String humidityLabel;
    private String temperatureLabel;
    private String percipitationLabel;
    private String detectedPestLabel;


    public DataDensityModel(String densityLabel, String dateLabel, String humidityLabel, String temperatureLabel, String percipitationLabel, String detectedPestLabel) {
        this.densityLabel = densityLabel;
        this.dateLabel = dateLabel;
        this.humidityLabel = humidityLabel;
        this.temperatureLabel = temperatureLabel;
        this.percipitationLabel = percipitationLabel;
        this.detectedPestLabel = detectedPestLabel;
    }
    public String getDensityLabel() {
        return densityLabel;
    }

    public void setDensityLabel(String densityLabel) {
        this.densityLabel = densityLabel;
    }

    public String getDateLabel() {
        return dateLabel;
    }

    public void setDateLabel(String dateLabel) {
        this.dateLabel = dateLabel;
    }
    public String getHumidityLabel() {
        return humidityLabel;
    }

    public void setHumidityLabel(String humidityLabel) {
        this.humidityLabel = humidityLabel;
    }

    public String getTemperatureLabel() {
        return temperatureLabel;
    }

    public void setTemperatureLabel(String temperatureLabel) {
        this.temperatureLabel = temperatureLabel;
    }

    public String getPrecipitationLabel() {
        return percipitationLabel;
    }

    public void setPrecipitationLabel(String percipitationLabel) {
        this.percipitationLabel = percipitationLabel;
    }

    public String getDetectedPestLabel() {
        return detectedPestLabel;
    }

    public void setDetectedPestLabel(String detectedPestLabel) {
        this.detectedPestLabel = detectedPestLabel;
    }
}
