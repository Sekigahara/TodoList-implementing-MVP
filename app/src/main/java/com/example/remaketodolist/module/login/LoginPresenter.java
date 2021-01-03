package com.example.remaketodolist.module.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.remaketodolist.R;
import com.example.remaketodolist.data.model.User;
import com.example.remaketodolist.utils.provider.UtilProvider;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginPresenter implements LoginContract.Presenter{
    private final LoginContract.View view;
    private final Context context;

    public LoginPresenter(LoginContract.View view, Context context){
        this.view = view;
        this.context = context;
    }

    public void start(){
        UtilProvider.initUserSession(context);

        if(UtilProvider.getUserSessionUtil().getSession() != null)
            view.redirectToProfile();
    }

    public void handleSignInResult(Activity activity, GoogleSignInResult result, FirebaseAuth firebaseAuth){
        if(result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();

            User user = new User();
            user.setId(account.getIdToken());
            user.setDisplayName(account.getDisplayName());
            user.setEmail(account.getEmail());

            //saving to Shared Preference
            UtilProvider.getUserSessionUtil().setSession(user);

            AuthCredential credential = GoogleAuthProvider.getCredential(user.getId(), null);
            firebaseAuthWithGoogle(activity, credential, firebaseAuth);
        }else{
            String messageToDisplay = "Authentication failed.";
            switch (result.getStatus().getStatusCode()) {
                case CommonStatusCodes.API_NOT_CONNECTED: //17
                    messageToDisplay += "The client attempted to call a method from an API that failed to connect.";
                    break;

                case CommonStatusCodes.DEVELOPER_ERROR: //10
                    messageToDisplay += "The application is misconfigured.";
                    break;

                case CommonStatusCodes.ERROR: //13
                    messageToDisplay += "The operation failed with no more detailed information.";
                    break;

                case CommonStatusCodes.INTERNAL_ERROR: //8
                    messageToDisplay += "An internal error occurred.";
                    break;

                case CommonStatusCodes.INVALID_ACCOUNT: //8
                    messageToDisplay += "Invalid account name specified.";
                    break;

                case CommonStatusCodes.SIGN_IN_REQUIRED: //8
                    messageToDisplay += "Please Sign In to continue.";
                    break;
            }
            Toast.makeText(activity, messageToDisplay, Toast.LENGTH_SHORT).show();
        }
    }

    private void firebaseAuthWithGoogle(final Activity activity, AuthCredential credential, FirebaseAuth firebaseAuth){
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(activity, "Login Successful", Toast.LENGTH_SHORT).show();
                            view.redirectToProfile();
                        }else{
                            Toast.makeText(activity, "Authentication Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void performLogin(final String email, final String password){
        UtilProvider.getUserSessionUtil().setSession(new User(email, password));
        view.redirectToProfile();
    }
}
