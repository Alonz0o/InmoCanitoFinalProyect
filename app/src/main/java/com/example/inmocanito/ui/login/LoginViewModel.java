package com.example.inmocanito.ui.login;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Patterns;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.AndroidViewModel;

import com.example.inmocanito.MainActivity;
import com.example.inmocanito.R;

public class LoginViewModel extends AndroidViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();

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

    public void login(String cuenta, String contraseña) {

        if(cuenta.equals("ariel@gmail.com")&& contraseña.equals("123456")) {
            Intent i = new Intent(getApplication().getApplicationContext(), MainActivity.class);
            getApplication().getApplicationContext().startActivity(i);
        }else{
            Toast.makeText(getApplication(),"Tu Contraseña o Email Son Incorrectos", Toast.LENGTH_LONG).show();
        }


    }

    public boolean loginAriel(String cuenta, String contraseña) {
        if(cuenta.equals("ariel@gmail.com")&& contraseña.equals("123456")) {
            Intent i = new Intent(getApplication().getApplicationContext(), MainActivity.class);
            getApplication().getApplicationContext().startActivity(i);
            return true;
        }else{
            Toast.makeText(getApplication(),"Tu Contraseña o Email Son Incorrectos", Toast.LENGTH_LONG).show();
        }
        return false;
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
