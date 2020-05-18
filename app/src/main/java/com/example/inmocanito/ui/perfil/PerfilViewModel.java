package com.example.inmocanito.ui.perfil;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PerfilViewModel extends ViewModel {

    private MutableLiveData<String> mTvEditar;
    private MutableLiveData<String> mEtDni;
    private MutableLiveData<String> mEtApellido;
    private MutableLiveData<String> mEtNombre;


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

        //Si es diferente y no matchea pasa el error
        if (!dniInput.matches(numerosPattern)) {
            DniOk.setVisibility(View.INVISIBLE);
            Dni.setError("Ingrese Dni valido");
            Dni.requestFocus();
            Dni.setTextColor(Color.rgb(255, 66, 26));
        } else if (dniInput==null) {
            DniOk.setVisibility(View.INVISIBLE);
            Dni.setError("Ingrese Dni");
            Dni.requestFocus();
            Dni.setTextColor(Color.rgb(255, 66, 26));
        } else {
            DniOk.setVisibility(View.VISIBLE);
            Dni.setTextColor(Color.rgb(0, 255 , 0));
        }


    }
}