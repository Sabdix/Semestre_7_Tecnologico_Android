package com.practica4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity
{
    EditText etNombre;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        etNombre = (EditText)findViewById(R.id.etNombre);
        this.registerForContextMenu(etNombre);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        
        Intent intent = new Intent(this, Resultado.class);
        intent.putExtra("Nombre", etNombre.getText().toString());
        switch(item.getItemId()) {
            case R.id.menuSaluda:
                intent.putExtra("Opcion", "Houdy!!!");
                startActivity(intent);
                break;
            case R.id.menuDespide:
                intent.putExtra("Opcion", "Bye!!!");
                startActivity(intent);
                break;
            case R.id.menuInvita:
                intent.putExtra("Opcion", "Estas invitado a una super fiesta!!!!!");
                startActivity(intent);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        
        this.getMenuInflater().inflate(R.menu.mi_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        
        Intent intent = new Intent(this, Resultado.class);
        intent.putExtra("Nombre", etNombre.getText().toString());
        switch(item.getItemId()) {
            case R.id.submenuSaluda:
                intent.putExtra("Opcion", "Houdy!!!");
                startActivity(intent);
                break;
            case R.id.menuDespide:
                intent.putExtra("Opcion", "Bye!!!");
                startActivity(intent);
                break;
            case R.id.menuInvita:
                intent.putExtra("Opcion", "Estas invitado a una super fiesta!!!!!");
                startActivity(intent);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        
        MenuInflater inflador = this.getMenuInflater();
        inflador.inflate(R.menu.submenus, menu);
        return true;
    }
    
}
