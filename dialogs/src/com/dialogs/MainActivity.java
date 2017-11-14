package com.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
    Button btDialog;
    Button btAlertDialog;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btDialog = (Button)findViewById(R.id.btDialog);
        btAlertDialog = (Button)findViewById(R.id.btAlertDialog);
        
        //Custom Dialog
        btDialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.custom);
                dialog.setTitle("Ejemplo");
                
                Button dialogButton = (Button)dialog.findViewById(R.id.btContinuar);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        //AlertDialog
        btAlertDialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder constructor = new AlertDialog.Builder(v.getContext());
                constructor.setMessage("Esto es un Alert Dialog");
                constructor.setCancelable(true);
                
                constructor.setPositiveButton("Simon", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                constructor.setNegativeButton("Nel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                
                });
                AlertDialog alerta = constructor.create();
                alerta.show();
            }
        });
    }
}
