package lk.shenaz.maslibrary;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity {

    private static  final String TAG = "LoginLog";
    private String email;
    private String password;

    private GoogleSignInClient googleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etemail = (EditText) findViewById(R.id.etemail);
        final EditText etPassword = (EditText) findViewById(R.id.etpassword);
        Button btnsignin = (Button) findViewById(R.id.btnsignin);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = etemail.getText().toString();
                password= etPassword.getText().toString();

                User user = LoginChecker(email,password);
                if (user == null) {
                    Toast.makeText(getApplicationContext(), "Invalid email & Password", Toast.LENGTH_SHORT).show();
                   /* Intent homeIntent = new Intent(getApplicationContext(),TabActivity.class);
                    startActivity(homeIntent);*/
                }
                else{
                    Intent tabIntent = new Intent(getApplicationContext(),TabActivity.class);
                    startActivity(tabIntent);
                }
            }
        });

        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_WIDE);

        GoogleSignInOptions gso= new  GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this,gso); //intializing

        GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (account != null){
            if (account.getEmail() != null){
                //Login success then Open the main activity
            }
        }

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(getApplicationContext());
                if (account != null){
                    //Login success then Open the main activity
                    if (account.getEmail() != null){

                    }
                }else{
                   Intent signInIntent = googleSignInClient.getSignInIntent();
                   startActivityForResult(signInIntent, 9001);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 9001){
            Task<GoogleSignInAccount>task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult (task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> Completedtask) {
        try {
            GoogleSignInAccount account = Completedtask.getResult(ApiException.class);
            Log.i(TAG, "New Logged UserName :"+account.getDisplayName());
        }catch (ApiException e){
            Log.i(TAG, "SignIn Failed code ="+ e.getStatusCode());
        }
    }

    public User LoginChecker(String email, String password) {
        User user = new  User();
        try
            {
                LoginAsyncTask loginAsyncTask = new LoginAsyncTask(email, password);
                //user = loginAsyncTask.exeute().get();
            }
        catch (Exception e ){
            e.printStackTrace();
        }
        return user;
    }

    }

