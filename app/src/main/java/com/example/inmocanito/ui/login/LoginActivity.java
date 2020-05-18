package com.example.inmocanito.ui.login;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmocanito.R;

public class LoginActivity extends AppCompatActivity {

    //Inicializando LoginViewModel para usarlo aqui
    private LoginViewModel LVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Inicializando LoginViewModel para usarlo aqui
        LVM = ViewModelProviders.of(this).get(LoginViewModel.class);

        final EditText etEma = findViewById(R.id.etLEmail);
        final EditText etCon = findViewById(R.id.etLContraseña);
        final Button btnLogin = findViewById(R.id.btnLogin);
        final ProgressBar loadingProgressBar = findViewById(R.id.pbLoading);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LVM.login(etEma.getText().toString(), etCon.getText().toString());
            }
        });

        LVM.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                btnLogin.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    etEma.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    etCon.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        LVM.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                if (loginResult.getError() != null) {

                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {

                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Ignorar
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Ignorar
            }

            @Override
            public void afterTextChanged(Editable s) {
                LVM.loginDataChanged(etEma.getText().toString(),
                        etCon.getText().toString());
            }
        };

        etEma.addTextChangedListener(afterTextChangedListener);
        etCon.addTextChangedListener(afterTextChangedListener);
        etCon.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    LVM.login(etEma.getText().toString(),
                            etCon.getText().toString());
                }
                return false;
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean vedad;
                vedad = LVM.loginAriel(etEma.getText().toString(), etCon.getText().toString());

                if (vedad == true){
                LVM.login(etEma.getText().toString(), etCon.getText().toString());
                    loadingProgressBar.setVisibility(View.VISIBLE);
                }
                else {loadingProgressBar.setVisibility(View.INVISIBLE);}
            }
        });
    }

//Esto es afuera de onCreate
    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

}