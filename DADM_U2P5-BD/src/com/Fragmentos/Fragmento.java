/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Fragmentos;

import android.app.AlertDialog;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.Activities.R;
import com.Model.ModeloBD;
import com.Model.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sabdi
 */
public class Fragmento extends ListFragment {
    
    static ListView lista;
    static ArrayList<Usuario> usuarios;
    static MiAdaptador adaptador;
    static View view;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragmento, null);
        
        lista = (ListView)view.findViewById(android.R.id.list);
        return view;
        
    }
    
    public static void setElements(final ModeloBD mibd) throws Exception {
        usuarios = mibd.listarUsuarios();
        adaptador = new MiAdaptador(view.getContext(), R.layout.renglon, usuarios) {
            @Override
            public void renglonLista(View view, final int pos) {
                TextView et1 = (TextView)view.findViewById(R.id.tv2);
                Button bt1 = (Button)view.findViewById(R.id.bt1);
                Button bt2 = (Button)view.findViewById(R.id.bt2);
                
                et1.setText(usuarios.get(pos).getNick());
                
                bt1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                       mibd.eliminarUsuario(usuarios.get(pos).getNick());
                       Toast.makeText(v.getContext(), "Eliminado ", 1).show();
                        try {
                            setElements(mibd);
                        } catch (Exception ex) {
                            Logger.getLogger(Fragmento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                
                bt2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(final View v) {
                        AlertDialog.Builder dialogo = new AlertDialog.Builder(v.getContext());
                        dialogo.setTitle("Modificar Usuario");
                        
                        final EditText et = new EditText(v.getContext());
                        et.setHint("Nick");
                        dialogo.setView(et);
                        
                        dialogo.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                mibd.modificarRegistro(usuarios.get(pos).getNick(), et.getText().toString());
                                Toast.makeText(v.getContext(), "Modificado", 1).show();
                                try {
                                    setElements(mibd);
                                } catch (Exception ex) {
                                    Logger.getLogger(Fragmento.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                dialog.dismiss();
                            }
                        });
                        
                        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();;
                            }
                        });
                        dialogo.show();
                    }
                });
                
            }
        };
        lista.setAdapter(adaptador);
    }
    
    public static void otroSetElements (final ModeloBD mibd, String texto) throws Exception {
        usuarios = mibd.buscarUsuario(texto);
        adaptador = new MiAdaptador(view.getContext(), R.layout.renglon, usuarios) {
            @Override
            public void renglonLista(View view, final int pos) {
                TextView et1 = (TextView)view.findViewById(R.id.tv2);
                Button bt1 = (Button)view.findViewById(R.id.bt1);
                Button bt2 = (Button)view.findViewById(R.id.bt2);
                
                et1.setText(usuarios.get(pos).getNick());
                
                bt1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                       mibd.eliminarUsuario(usuarios.get(pos).getNick());
                       Toast.makeText(v.getContext(), "Eliminado ", 1).show();
                        try {
                            setElements(mibd);
                        } catch (Exception ex) {
                            Logger.getLogger(Fragmento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                
                bt2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(final View v) {
                        AlertDialog.Builder dialogo = new AlertDialog.Builder(v.getContext());
                        dialogo.setTitle("Modificar Usuario");
                        
                        final EditText et = new EditText(v.getContext());
                        et.setHint("Nick");
                        dialogo.setView(et);
                        
                        dialogo.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                mibd.modificarRegistro(usuarios.get(pos).getNick(), et.getText().toString());
                                Toast.makeText(v.getContext(), "Modificado", 1).show();
                                try {
                                    setElements(mibd);
                                } catch (Exception ex) {
                                    Logger.getLogger(Fragmento.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                dialog.dismiss();
                            }
                        });
                        
                        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();;
                            }
                        });
                        dialogo.show();
                    }
                });
            }
        };
        lista.setAdapter(adaptador);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.prueba, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        */
    }
    
}
