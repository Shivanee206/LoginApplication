package com.example.shivani.loginapplication;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        TextView sign_inText=(TextView)findViewById(R.id.sign_in_text);
        sign_inText.setTypeface(Typeface.createFromAsset(getApplicationContext().getAssets(),"fonts/Billabong.ttf"));
        TextInputLayout email=(TextInputLayout)findViewById(R.id.email);
        String emailId= String.valueOf(email.getEditText());
       boolean validContact=  isValidEmail(emailId);
        if(validContact==true){
            Toast.makeText(MainActivity.this,"Valid Email Id",Toast.LENGTH_SHORT);
        }
        else{
            Toast.makeText(MainActivity.this,"Please enter Valid Email Id",Toast.LENGTH_SHORT);
        }
        PackageInfo info;
        try {
            info = getPackageManager().getPackageInfo("com.example.shivani.loginapplication", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                //String something = new String(Base64.encodeBytes(md.digest()));
                Log.e("hash key", something);
                Toast.makeText(MainActivity.this,something,Toast.LENGTH_LONG).show();
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("no such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("exception", e.toString());
        }
        TextView noAccount=(TextView)findViewById(R.id.no_account);
        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    LoginButton fbSignIn=(LoginButton) findViewById(R.id.fbSignInBtn);
        FacebookSdk.sdkInitialize(getApplicationContext());
      callbackManager = CallbackManager.Factory.create();

        fbSignIn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(MainActivity.this, loginResult.getAccessToken().getUserId()+loginResult.getAccessToken().getApplicationId()
                        +loginResult.getAccessToken().getSource(), Toast.LENGTH_LONG).show();
                Log.e("User Details",loginResult.getAccessToken().getUserId()+loginResult.getAccessToken().getApplicationId()
                        +loginResult.getAccessToken().getSource());
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "Sorry Login Activity Cancelled !", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(MainActivity.this, "Error in Login Please Try again !", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public final static boolean isValidEmail(String target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
