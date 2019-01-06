package com.example.daplu.practice;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import static android.support.constraint.Constraints.TAG;

public class signin extends Activity {
    EditText login_email, login_pwd;
    private GoogleSignInClient mGoogleSignInClient;
    private SharedPreferences pref;
    private static final int RC_SIGN_IN = 9001;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        login_email = findViewById(R.id.login_email);
        login_pwd = findViewById(R.id.login_pwd);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleSignInClient= GoogleSignIn.getClient(this,gso);
    }
    public void Onsignin(View view) {
        String username = login_email.getText().toString();
        String password = login_pwd.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,username,password);

        startActivity(new Intent(signin.this,MainPost.class));
    }
    public void OnGoogle(View view){
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent,RC_SIGN_IN);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode,data);
// Check which request we're responding to
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);


        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("name",account.getDisplayName());
            editor.putString("email",account.getEmail());
            editor.commit();
            startActivity(new Intent(signin.this, MainActivity.class));

            // Signed in successfully, show authenticated UI.
            Log.d(TAG,"handleSignInResult getName:"+account.getDisplayName());
            Log.d(TAG, "handleSignInResult getEmail:"+account.getEmail());
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
        }
    }
    public void Backsignup(View view) {
        startActivity(new Intent(signin.this,signup.class));
    }
}