package com.doublehammerstudio.predepest;

public class DataDensityModel {
    private String densityLabel;
    private String dateLabel;
    public DataDensityModel(String densityLabel, String dateLabel) {
        this.densityLabel = densityLabel;
        this.dateLabel = dateLabel;
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

}
