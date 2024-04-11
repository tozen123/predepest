package com.doublehammerstudio.predepest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class informationPestAct extends AppCompatActivity {

    TextView title, txtd;
    ImageView img;
    Button closeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_pest);




        title = findViewById(R.id.title);
        txtd = findViewById(R.id.txt);
        img = findViewById(R.id.pestImg);
        closeButton = findViewById(R.id.close);

        Intent intent = getIntent();
        if (intent != null) {
            String intentTitle = intent.getStringExtra("title");
            int intentImg = intent.getIntExtra("img", 0);
            title.setText(intentTitle);
            img.setImageResource(intentImg);

            if (intentTitle.equals("Mole Crickets"))
            {
                txtd.setText(R.string.a);
            }
            else if (intentTitle.equals("Root Aphids"))
            {
                txtd.setText(R.string.b);
            }
            else if (intentTitle.equals("Root Weevils"))
            {
                txtd.setText(R.string.c);
            }
            else if (intentTitle.equals("Greenhorned Caterpillars"))
            {
                txtd.setText(R.string.d);
            }
            else if (intentTitle.equals("Rice Skippers"))
            {
                txtd.setText(R.string.e);
            }
            else if (intentTitle.equals("Planthoppers"))
            {
                txtd.setText(R.string.g);
            }
            else if (intentTitle.equals("Rice Leaffolder"))
            {
                txtd.setText(R.string.h);
            }
            else if (intentTitle.equals("Rice Stem Borers"))
            {
                txtd.setText(R.string.i);
            }
            else if (intentTitle.equals("Stalked-eyed Flies"))
            {
                txtd.setText(R.string.j);
            }
            else if (intentTitle.equals("Stalked-eyed Flies"))
            {
                txtd.setText(R.string.j);
            }
            else if (intentTitle.equals("Seedling Maggots"))
            {
                txtd.setText(R.string.k);
            }
            else if (intentTitle.equals("Rice Whorl Maggots"))
            {
                txtd.setText(R.string.l);
            }
            else if (intentTitle.equals("Rice Caseworms"))
            {
                txtd.setText(R.string.m);
            }
            else if (intentTitle.equals("Armyworms and Cutworms"))
            {
                txtd.setText(R.string.n);
            }
            else if (intentTitle.equals("Grasshoppers, Katydids, and Field Crickets"))
            {
                txtd.setText(R.string.o);
            }
            else if (intentTitle.equals("Black Bugs"))
            {
                txtd.setText(R.string.p);
            }
            else if (intentTitle.equals("Rice Hispa"))
            {
                txtd.setText(R.string.q);
            }
            else if (intentTitle.equals("Mealybugs"))
            {
                txtd.setText(R.string.r);
            }
            else if (intentTitle.equals("Ripening Seed Bugs"))
            {
                txtd.setText(R.string.s);
            }
            else if (intentTitle.equals("Stink Bugs"))
            {
                txtd.setText(R.string.t);
            }
            else if (intentTitle.equals("Ants"))
            {
                txtd.setText(R.string.u);
            }
            else if (intentTitle.equals("Rice Green Semilooper"))
            {
                txtd.setText(R.string.v);
            }
            else if (intentTitle.equals("Rice Thrips"))
            {
                txtd.setText(R.string.w);
            }
            else if (intentTitle.equals("Rice Leaf Beatles"))
            {
                txtd.setText(R.string.x);
            }
            else if (intentTitle.equals("Wireworms"))
            {
                txtd.setText(R.string.y);
            }
            else if (intentTitle.equals("Root-Feeding Mealybugs"))
            {
                txtd.setText(R.string.z);
            }
            else if (intentTitle.equals("Leafhoppers"))
            {
                txtd.setText(R.string.aa);
            }
            else if (intentTitle.equals("Termites"))
            {
                txtd.setText(R.string.bb);
            }
            else if (intentTitle.equals("White Grubs"))
            {
                txtd.setText(R.string.cc);
            }
            else if (intentTitle.equals("Field Crickets"))
            {
                txtd.setText(R.string.dd);
            }

        }

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}