package kg.asylbekov.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private EditText editName;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.edit);
        editPassword = findViewById(R.id.editP);

    }
    public void onClick(View view){
        String name = editName.getText().toString().trim();
        String pass = editPassword.getText().toString().trim();
    if(!name.isEmpty() && !pass.isEmpty()){
        Intent intent = new Intent(this, CreateOrder.class );
        intent.putExtra("name", name);
        intent.putExtra("pass", pass);
        startActivity(intent);
    }else{
        Toast.makeText(this, R.string.warning, Toast.LENGTH_LONG).show();
    }
    }

}