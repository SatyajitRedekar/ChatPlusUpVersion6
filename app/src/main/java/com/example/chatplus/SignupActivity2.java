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

import com.example.chatplus.Models.Users;
import com.example.chatplus.databinding.ActivitySignup2Binding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity2 extends AppCompatActivity {

    private FirebaseAuth mAuth;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
//        binding

        ActivitySignup2Binding binding = ActivitySignup2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        complete
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        data resive

        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");
        String userNumber = intent.getStringExtra("number");
        String userDob = intent.getStringExtra("dob");

//         ******************************


        //        auth work only !!!!!

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        final LoadingDialog loadingDialog = new LoadingDialog(SignupActivity2.this);


        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                loadingDialog.startLoadingDialog();
                mAuth.createUserWithEmailAndPassword
                                (binding.editEmail.getText().toString(), binding.editPass.getText().toString()).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()) {
                                    Users users = new Users( userName , userNumber , userDob ,
                                           binding.editEmail.getText().toString() , binding.editPass.getText().toString() );

                                    String id = task.getResult().getUser().getUid();
                                    database.getReference().child("Users").child(id).setValue(users);

                                    Toast.makeText(SignupActivity2.this, "Welcome to ChatPlus", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(SignupActivity2.this,PauseActivity.class);
                                    loadingDialog.dismissDialog();
                                    finish();
                                    startActivity(intent);

                                } else {

                                    loadingDialog.dismissDialog();
                                    Toast.makeText(SignupActivity2.this, task.getException().getMessage() , Toast.LENGTH_SHORT).show();

                                }

                            }
                        });

            }
        });

//      ***********************************


        binding.googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity2.this,ConstructionActivity.class);
                startActivity(intent);
            }
        });

        binding.phoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity2.this,ConstructionActivity.class);
                startActivity(intent);
            }
        });


        binding.goLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity2.this,LoginActivity.class);
                startActivity(intent);
            }
        });

//        app manual testing

//        binding.showCont.setText(userName);
//        binding.showConte.setText(userNumber);
//        binding.showContec.setText(userDob);

//        ******************
    }
}