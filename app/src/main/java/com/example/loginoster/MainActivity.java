package com.example.loginoster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Asegúrate de que el nombre de tu layout es correcto

        // Enlazar las vistas con sus respectivos IDs
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Configurar el botón de inicio de sesión
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto ingresado en los campos
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Validar si el email y la contraseña son correctos
                if (email.isEmpty() || password.isEmpty()) {
                    // Si falta email o contraseña
                    Toast.makeText(MainActivity.this, "Email o Contraseña son inválidos", Toast.LENGTH_SHORT).show();
                } else {
                    // Validación para email y contraseña correctos
                    if (email.equals("incade@gmail.com") && password.equals("12345")) {
                        // Si el email y la contraseña son correctos
                        Toast.makeText(MainActivity.this, "¡Login exitoso!", Toast.LENGTH_SHORT).show();

                        // Crear un Intent para navegar a HomeActivity
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);

                        // Finalizar MainActivity para evitar que el usuario regrese a la pantalla de login
                        finish();
                    } else {
                        // Si el email o la contraseña son incorrectos
                        Toast.makeText(MainActivity.this, "Email o Contraseña son inválidos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
