package com.example.chatplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.chatplus.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth MAuth;
    FirebaseDatabase Database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

//        binding

        ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        complete
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


//        login work is here !!!

        MAuth = FirebaseAuth.getInstance();
        final LoadingDialog loadingDialog = new LoadingDialog(LoginActivity.this);


        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadingDialog.startLoadingDialog();
                MAuth.signInWithEmailAndPassword(binding.editLoginEmail.getText().toString(), binding.editLoginPass.getText().toString()).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    loadingDialog.dismissDialog();
                                    Toast.makeText(LoginActivity.this, "Welcome to ChatPlus", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this,PauseActivity.class);
                                    finish();
                                    startActivity(intent);
                                } else {
                                    loadingDialog.dismissDialog();
                                    Toast.makeText(LoginActivity.this,  task.getException().getMessage() , Toast.LENGTH_SHORT).show();
//
                                }
                            }
                        });
            }
        });

//        check mauth here

        if (MAuth.getCurrentUser() != null) {
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }

//        login end here !!!!

        binding.googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              create update avalible from 1.30.00
                Intent intent = new Intent(LoginActivity.this,ConstructionActivity.class);
                startActivity(intent);
            }
        });

        binding.phoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,ConstructionActivity.class);
                startActivity(intent);
            }
        });


        binding.goSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

    }
}