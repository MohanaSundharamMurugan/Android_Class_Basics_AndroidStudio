package com.example.sample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.time.Duration;

public class MainActivity extends AppCompatActivity
{
    //Widget Variable Declaration
    Button toast,customToast,alertButton;
    Switch swit;
    ToggleButton tglButton;
    CheckBox cBox;
    LinearLayout linearLay;
    ImageView cusChkImg;
    TextView cusChkTxt;
    AlertDialog.Builder builder;
    Spinner sp;
    AutoCompleteTextView actv;

    //Local Variable Declaration
    boolean IsClicked=true;
    String[] movies={"2.0","Enthiran","Sivaji","Kaala","Kabali"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);
        toast=(Button) findViewById(R.id.toastBtn);
        customToast=(Button) findViewById(R.id.cusToastBtn);
        swit=(Switch) findViewById(R.id.switcher);
        tglButton=(ToggleButton) findViewById(R.id.toggleBtn);
        cBox=(CheckBox) findViewById(R.id.chkBox);
        linearLay=(LinearLayout) findViewById(R.id.customChkBox);
        cusChkImg=(ImageView) findViewById(R.id.cusChkBoxStatusImg);
        cusChkTxt=(TextView) findViewById(R.id.cusChkBoxStatusTxt);
        alertButton=(Button) findViewById(R.id.alertBtn);
        sp=(Spinner)findViewById(R.id.spinnerList);

        //AutoCompleteTextView Code --> START
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,movies);
        actv =  (AutoCompleteTextView)findViewById(R.id.actView);
        actv.setThreshold(2);//search will be starts from 2nd character
        actv.setAdapter(adapter);
        actv.setTextColor(R.color.purple_700);
        //AutoCompleteTextView Code --> START

        ArrayAdapter aa=new ArrayAdapter(this, android.R.layout.simple_spinner_item,movies);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);
        
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movies[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        
        builder = new AlertDialog.Builder(this);
        alertButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                builder.setMessage("Message") .setTitle("You have meeting at 02:00 PM");
                builder.setMessage("Do you want to Exit?").setCancelable(false)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finishAffinity();
                                Toast.makeText(MainActivity.this, "Application Closed!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Request Cancelled", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert=builder.create();
                alert.setTitle("Sample");
                alert.show();
            }
        });

        linearLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(IsClicked)
                {
                    cusChkImg.setImageResource(R.drawable.check);
                    cusChkTxt.setText("YES");
                    IsClicked=false;
                }
                else
                {
                    IsClicked=true;
                    cusChkImg.setImageResource(R.drawable.multiply);
                    cusChkTxt.setText("NO");
                }
            }
        });

        System.out.println("Toggle Button Status: "+tglButton.isChecked());
        System.out.println("Switch Status: "+swit.isChecked());
        System.out.println("CheckBox Status: "+cBox.isChecked());

        cBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked())
                {
                    Toast.makeText(MainActivity.this, "ACCEPTED", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "NOT ACCEPTED", Toast.LENGTH_SHORT).show();
                }
            }
        });

        swit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked())
                {
                    compoundButton.setText("I'm In");
                }
                else
                {
                    compoundButton.setText("I'm Out");
                }
            }
        });

        tglButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked())
                {
                    Toast.makeText(MainActivity.this, "YES", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "NO", Toast.LENGTH_SHORT).show();
                }
            }
        });

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "I'm Coming...", Toast.LENGTH_SHORT).show();
            }
        });
        customToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li=getLayoutInflater();
                View layout=li.inflate(R.layout.customtoast,(ViewGroup)findViewById(R.id.custom_Toast_Layout));
                Toast t=new Toast(getApplicationContext());//MainActivity.this
                t.setDuration(Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER,0,0);
                t.setView(layout);
                t.show();
            }
        });
    }
}