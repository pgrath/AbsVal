package com.example.pat.absval;

import android.content.res.AssetManager;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void absVal (View view)
            throws java.io.IOException
    {
    //BEGIN
        //declare the things
        TextView txtVw;
        EditText usrIn; //edit_infile
        EditText usrOut; //edit_outfile
        String inFile;
        String outFile;
        Double tmpVal[] = new Double[100];
        int arrayNum;
        arrayNum = 0;
        int tstCount = 0;


        //set up text view to write to it
        txtVw = (TextView) findViewById(R.id.text_main);
        txtVw.setText("Getting input file. . . ");

        //set up the edittext boxes so i can reeeeaaaaaaaddd from them
        usrIn = (EditText) findViewById(R.id.edit_infile);
        usrOut = (EditText) findViewById(R.id.edit_outfile);

        //set all that juicy data in the fields to a string so I can use them
        inFile = usrIn.getText().toString();
        outFile = usrOut.getText().toString();

        //set up infile for reading into array
        AssetManager assetManager = getAssets();
        Scanner fileScn = new Scanner(assetManager.open(inFile));

        //set up outfile for writing
        File outputFile = new File(getExternalFilesDir(null),outFile);
        FileWriter fw = new FileWriter(outputFile);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);




        while(fileScn.hasNext()){
            tmpVal[arrayNum] = fileScn.nextDouble();
            arrayNum++;
            tstCount++;

        //    txtVw.setText(Math.abs(tmpVal));
        }
        for (int a = 0; a < tstCount; a++ ){
            txtVw.setText(Math.abs(tmpVal[a]) + "\n");
            pw.println(Math.abs(tmpVal[a]) + "\n");


        }


    pw.close();
    }

}