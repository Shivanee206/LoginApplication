package com.example.shivani.loginapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView, image1, image2, image3, image4, image5, image6, image7, image8, image9;
    private Context context=this;
    EditText editEmail,editUserName,editContact,editPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);
        TextView sign_upText = (TextView) findViewById(R.id.sign_up_text);
        sign_upText.setTypeface(Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Billabong.ttf"));
        imageView = (ImageView) findViewById(R.id.avatarImage);
        TextView avatar = (TextView) findViewById(R.id.textAvatar);
        avatar.setOnClickListener(this);
        Button createAccount = (Button) findViewById(R.id.createAccountBtn);
        createAccount.setOnClickListener(this); 
        editEmail=(EditText)findViewById(R.id.editEmail2);
        editUserName=(EditText)findViewById(R.id.editUserName);
        editContact=(EditText)findViewById(R.id.editContact);
        editPassword=(EditText)findViewById(R.id.editPassword2);
     }
    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
    public final static boolean isValidContact(CharSequence target) {
        return !TextUtils.isEmpty(target) && Patterns.PHONE.matcher(target).matches();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.createAccountBtn:
                Editable emailId=  editEmail.getText();
                boolean validEmail=  isValidEmail(emailId);
                if(validEmail==true){
                    Toast.makeText(context,"Valid Email Id",Toast.LENGTH_SHORT);
                }
                else{
                    Toast.makeText(context,"Please enter Valid Email Id",Toast.LENGTH_SHORT);
                }
                Editable contact=  editContact.getText();
                boolean validContact=  isValidContact(contact);
                if(validContact==true){
                    Toast.makeText(context,"Valid Contact",Toast.LENGTH_SHORT);
                }
                else{
                    Toast.makeText(context,"Please enter Valid Contact Number",Toast.LENGTH_SHORT);
                }

                Intent intent = new Intent(SignUpActivity.this, MyAccountActivity.class);
                startActivity(intent);
                break;
            case R.id.textAvatar:
                final Dialog openDialog = new Dialog(context);
                openDialog.setContentView(R.layout.set_profile_picture);
                openDialog.setTitle("Select Your Favourite Avatar");
                Button button = (Button) openDialog.findViewById(R.id.ok);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openDialog.dismiss();
                    }
                });
                image1 = (ImageView) openDialog.findViewById(R.id.one);
                image2 = (ImageView) openDialog.findViewById(R.id.two);
                image3 = (ImageView) openDialog.findViewById(R.id.three);
                image4 = (ImageView) openDialog.findViewById(R.id.four);
                image5 = (ImageView) openDialog.findViewById(R.id.five);
                image6 = (ImageView) openDialog.findViewById(R.id.six);
                image7 = (ImageView) openDialog.findViewById(R.id.seven);
                image8 = (ImageView) openDialog.findViewById(R.id.eight);
                image9 = (ImageView) openDialog.findViewById(R.id.nine);
                image1.setOnClickListener(this);
                image2.setOnClickListener(this);
                image3.setOnClickListener(this);
                image4.setOnClickListener(this);
                image5.setOnClickListener(this);
                image6.setOnClickListener(this);
                image7.setOnClickListener(this);
                image8.setOnClickListener(this);
                image9.setOnClickListener(this);
                openDialog.show();
                break;
            case R.id.one:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.one));
                break;
            case R.id.two:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.two));
                break;
            case R.id.three:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.three));
                break;

            case R.id.four:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.four));
                break;
            case R.id.five:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.five));
                break;
            case R.id.six:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.six));
                break;
            case R.id.seven:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.seven));
                break;
            case R.id.eight:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.eight));
                break;
            case R.id.nine:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.one));
                break;
        }
    }
    
}