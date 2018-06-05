package com.ilatis.zdravstvuyurf;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ilatis.zdravstvuyurf.HelperClass.Account;
import com.ilatis.zdravstvuyurf.HelperClass.ReturnIDs;
import com.ilatis.zdravstvuyurf.zdravstvuyuAPI.AutorizationAPI;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import retrofit2.Response;
import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser;
import ru.tinkoff.decoro.slots.Slot;
import ru.tinkoff.decoro.watchers.FormatWatcher;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;

public class LoginActivity extends AppCompatActivity {

    private LoginActivity.UserLoginTask mAuthTask = null;
    private String ERROR = "";

    //UI
    private EditText mPasswordView;
    private EditText mLoginView;
    private View mProgressView;
    private View mLoginFormView;
    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        mLoginFormView = (View) findViewById(R.id.content);
        mProgressView = (View) findViewById(R.id.progressBar);
        mLoginView = (EditText) findViewById(R.id.loginz);
        Slot[] slots = new UnderscoreDigitSlotsParser().parseSlots("+7 (___) ___-__-__");
        FormatWatcher formatWatcher = new MaskFormatWatcher( // форматировать текст будет вот он
                MaskImpl.createTerminated(slots)
        );
        formatWatcher.installOn(mLoginView);
        mPasswordView = (EditText) findViewById(R.id.passwordz);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    try {
                        attemptLogin();
                    } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                    return true;
                }
                return false;
            }
        });

        Button button = (Button)findViewById(R.id.enter);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {
                    attemptLogin();
                } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        });

        Button buttonR = (Button)findViewById(R.id.registration);
        buttonR.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void attemptLogin() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mLoginView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String login = mLoginView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(login)) {
            mLoginView.setError(getString(R.string.error_invalid_Login));
            focusView = mLoginView;
            cancel = true;
        } else if (!isLoginValid(login)) {
            mLoginView.setError(getString(R.string.error_invalid_Login));
            focusView = mLoginView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            showProgress(true);
            mAuthTask = new LoginActivity.UserLoginTask(login,password);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isLoginValid(String login) {
        //TODO: Replace this with your own logic
        return login.length()>10;
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 3 && !password.equals("select")
                && !password.equals("drop") && !password.equals("delete");
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            }
        });


        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        mProgressView.animate().setDuration(shortAnimTime).alpha(
                show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
        private boolean mflag = true;
        String mLogin;
        String mPassword;
        Account acc;
        Gson gson = new Gson();
        UserLoginTask(String login, String password){
            mLogin = login;
            mPassword = password;
            acc = new Account(mLogin, mPassword);
        }

        int press = 0;
        @Override
        protected Boolean doInBackground(Void... params) {
            String str = gson.toJson(acc);
            Response<ReturnIDs> response = null;
            String Error = "";
            int ID = 0;
            try {
                response = AutorizationAPI.getApi().CurrUser(str).execute();
                ID = response.body().getAnswer();
                mflag = ID != -1;
                press = ID;
                ERROR = ERROR += ID;
            } catch (IOException e) {
                Error += e;
                e.printStackTrace();
            }

            return mflag;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            if (success) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            } else {
                switch (press) {
                    case -1:
                        mPasswordView.setError("Неверный логин или пароль");
                        mPasswordView.requestFocus();
                        break;
                    default:
                        Toast toast = Toast.makeText(getBaseContext(),
                                "Ошибка сети",
                                Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        break;
                }
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }

}
