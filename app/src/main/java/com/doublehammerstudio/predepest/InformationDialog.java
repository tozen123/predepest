package com.doublehammerstudio.predepest;

import android.app.AlertDialog;
import android.content.Context;

public class InformationDialog {

    public static void show(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", null); // You can add listeners if needed
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
