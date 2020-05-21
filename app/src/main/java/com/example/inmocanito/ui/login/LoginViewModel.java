package com.example.inmocanito.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Patterns;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.AndroidViewModel;
import com.example.inmocanito.MainActivity;
import com.example.inmocanito.R;
import com.example.inmocanito.model.clsPropietario;
import java.util.Timer;
import java.util.TimerTask;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class LoginViewModel extends AndroidViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private MutableLiveData<String> tvMensaje;
    private MutableLiveData<String> pbProgreso;
    Timer tiempoPaInicia;

    private Context context;
    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }
    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }
    public LoginViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();

    }

    public LiveData<String> getTvMensaje(){
        if(tvMensaje == null){
            tvMensaje = new  MutableLiveData<>();
        }
        return tvMensaje;
    }
    public LiveData<String> getPdProgreso(){
        if(pbProgreso == null){
            pbProgreso = new  MutableLiveData<>();
        }
        return pbProgreso;
    }


    public void logueo(String email, String password, ProgressBar pbProges){
        clsPropietario miPropietario = new clsPropietario();
        boolean rta = miPropietario.logueo(email, password);
        if(!rta) {tvMensaje.setValue("Datos Incorrectos");
        Toast.makeText(getApplication(),"Tu Contraseña o Email Son Incorrectos", Toast.LENGTH_LONG).show();
        pbProges.setVisibility(View.INVISIBLE);
        } else{
            tvMensaje.setValue("Iniciando Sesion...");
            pbProges.setVisibility(View.VISIBLE);
            tiempoPaInicia = new Timer();
            tiempoPaInicia.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent i = new Intent(getApplication(), MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplication().startActivity(i);
                }
            },2000);
         }
    }



    public void login(String cuenta, String contraseña) {

        if(cuenta.equals("ariel@gmail.com")&& contraseña.equals("123456")) {
            Intent i = new Intent(getApplication().getApplicationContext(), MainActivity.class);
            i.addFlags(FLAG_ACTIVITY_NEW_TASK);
            getApplication().getApplicationContext().startActivity(i);
        }else{
            Toast.makeText(getApplication(),"Tu Contraseña o Email Son Incorrectos", Toast.LENGTH_LONG).show();
        }
    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }


    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }

}

