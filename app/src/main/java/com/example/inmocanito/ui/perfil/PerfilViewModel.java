package com.example.inmocanito.ui.perfil;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmocanito.model.clsPropietario;

import java.util.ArrayList;

public class PerfilViewModel extends ViewModel {

    private MutableLiveData<String> mTvEditar;
    private MutableLiveData<String> mEtDni;
    private MutableLiveData<String> mEtApellido;
    private MutableLiveData<String> mEtNombre;

    ArrayList<clsPropietario> arregloPropietarios = new ArrayList<>();

    public void botonHabilitado(EditText Dni, EditText Apellido, EditText Nombre, EditText Telefono, EditText Correo, EditText Contraseña){
        Dni.setEnabled(true);
        Apellido.setEnabled(true);
        Nombre.setEnabled(true);
        Telefono.setEnabled(true);
        Correo.setEnabled(true);
        Contraseña.setEnabled(true);
    }
    public void cargarPropietarios(EditText Dni, EditText Apellido, EditText Nombre, EditText Telefono, EditText Correo, EditText Contraseña){
        arregloPropietarios.add(new clsPropietario(1,31599310,"Francescoli","Enzo ", 14665768, "Uriarte@ElPríncipe.com","1234"));
        arregloPropietarios.add(new clsPropietario(2,32599311,"Suarez","Hernan", 15635767, "Suarez@pierna.com","12345"));
        arregloPropietarios.add(new clsPropietario(3,33599312,"Godinez","Roman", 15625766, "Godinez@cuello.com","12356"));
        arregloPropietarios.add(new clsPropietario(4,34599313,"Aboga","Tortugon", 15661754, "Aboga@pata.com","1234567"));

        Dni.setText(String.valueOf(arregloPropietarios.get(0).getDni()));
        Apellido.setText(arregloPropietarios.get(0).getApellido());
        Nombre.setText(arregloPropietarios.get(0).getNombre());
        Telefono.setText(String.valueOf(arregloPropietarios.get(0).getTelefono()));
        Correo.setText(arregloPropietarios.get(0).getEmail());
        Contraseña.setText(arregloPropietarios.get(0).getClave());
    }

    public PerfilViewModel() {
        mTvEditar = new MutableLiveData<>();
        mEtDni = new MutableLiveData<>();
        mEtApellido = new MutableLiveData<>();
        mEtNombre = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mTvEditar;
    }

    public void editar(String Dni, String Apellido, String Nombre){
        mTvEditar.setValue("Usuario Editado "+Apellido+" "+Nombre);
    }

    public void datosCambian(EditText Dni, EditText Apellido, EditText Nombre, EditText Telefono, EditText Correo, EditText Contraseña, ImageView DniOk, Button btnEdit) {

        String dniInput = Dni.getText().toString().trim();
        String apellidoInput = Apellido.getText().toString().trim();
        String nomInput = Nombre.getText().toString().trim();
        String telInput = Telefono.getText().toString().trim();
        String correInput = Correo.getText().toString().trim();
        String contraInput = Contraseña.getText().toString().trim();

        String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String numerosPattern = "[-+]?[0-9]*[.,]?[0-9]+";
        String letrasPattern = "^[a-zA-Z][a-zA-Z0-9-_./]{1,20}$";

        //Si es diferente y no matchea pasa el error
        if (!dniInput.matches(numerosPattern)  || dniInput==null){
            DniOk.setVisibility(View.INVISIBLE);
            Dni.setError("Ingrese Dni valido");
            Dni.requestFocus();
            Dni.setTextColor(Color.rgb(255, 66, 26));
        } else {
            DniOk.setVisibility(View.VISIBLE);
            Dni.setTextColor(Color.rgb(0, 255 , 0));
        }
        if (!apellidoInput.matches(letrasPattern)  || apellidoInput  == null){
            Apellido.setError("Ingrese Apellido valido");
            Apellido.setTextColor(Color.rgb(255, 66, 26));
        } else {
            DniOk.setVisibility(View.VISIBLE);
            Apellido.setTextColor(Color.rgb(0, 255 , 0));
        }
        if (!nomInput.matches(letrasPattern)  || nomInput  == null){
            Nombre.setError("Ingrese Nombre valido");
            Nombre.setTextColor(Color.rgb(255, 66, 26));
        } else {
            Nombre.setTextColor(Color.rgb(0, 255 , 0));
        }
        if (!telInput.matches(numerosPattern)  || telInput  == null){
            Telefono.setError("Ingrese Telefono valido");
            Telefono.setTextColor(Color.rgb(255, 66, 26));
        } else {
            Telefono.setTextColor(Color.rgb(0, 255 , 0));
        }
        if (!correInput.matches(emailPattern)  || correInput  == null){
            Correo.setError("Ingrese Email valido");
            Correo.setTextColor(Color.rgb(255, 66, 26));
        } else {
            Correo.setTextColor(Color.rgb(0, 255 , 0));
        }
        if (contraInput  == null){
            Contraseña.setError("Ingrese Contraseña valida");
            Contraseña.setTextColor(Color.rgb(255, 66, 26));
        } else {
            Contraseña.setTextColor(Color.rgb(0, 255 , 0));
        }

    }
}