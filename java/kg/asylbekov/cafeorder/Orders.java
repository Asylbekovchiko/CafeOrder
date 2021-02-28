package kg.asylbekov.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Orders extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderss);
        TextView textView11 = findViewById(R.id.textaa);
        Intent intent = getIntent();
        if(intent.hasExtra("orders")){
            String order = intent.getStringExtra("orders");
            textView11.setText(order);
        }else{
            Intent i = new Intent(this, CreateOrder.class);
            startActivity(i);
        }

    }
}