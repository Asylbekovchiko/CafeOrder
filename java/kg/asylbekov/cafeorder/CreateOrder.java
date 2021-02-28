package kg.asylbekov.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class CreateOrder extends AppCompatActivity {

    private TextView textHello;
    private TextView additionalText;

    private Spinner spinnerTea;
    private Spinner spinnerCoffee;

    private CheckBox milk;
    private CheckBox lemon;
    private CheckBox sugar;

    private String name;
    private String paasword;
    private String drink;

    private StringBuilder stringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);

        textHello = findViewById(R.id.textHello);
        additionalText = findViewById(R.id.adds);

        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);

        milk = findViewById(R.id.milk);
        lemon = findViewById(R.id.lemon);
        sugar = findViewById(R.id.sugar);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        paasword = intent.getStringExtra("pass");
        textHello.setText(name);

        drink = getString(R.string.tea);
        String additionsText = String.format(getString(R.string.addtotea), drink);
        additionalText.setText(additionsText);

        stringBuilder = new StringBuilder();
    }

    public void checkRadioButton(View view){
        RadioButton radioButton = (RadioButton) view;
        int id = radioButton.getId();
        if(id == R.id.buttonTea){
            drink = getString(R.string.tea);
            spinnerTea.setVisibility(View.VISIBLE);
            spinnerCoffee.setVisibility(View.INVISIBLE);
            lemon.setVisibility(View.VISIBLE);
        }else if(id == R.id.buttonCoffee){
            drink = getString(R.string.coffe);
            spinnerTea.setVisibility(View.INVISIBLE);
            spinnerCoffee.setVisibility(View.VISIBLE);
            lemon.setVisibility(View.INVISIBLE);
        }
        String additionsText = String.format(getString(R.string.addtotea), drink);
        additionalText.setText(additionsText);
    }

    public void clickSend(View view){
        stringBuilder.setLength(0);
        if(milk.isChecked()){
            stringBuilder.append(getString(R.string.milk));
        }
        if(sugar.isChecked()){
            stringBuilder.append(getString(R.string.sugar));
        }
        if(lemon.isChecked() && drink.equals(getString(R.string.lemon))){
            stringBuilder.append(getString(R.string.lemon));
        }

        String additionsCheck = "";
        if(stringBuilder.length() > 0 ){
            additionsCheck = String.format("Выбранные добавки: " + stringBuilder.toString());

        }else{
            additionsCheck = "добавок нет";
        }

        String positions = "";
        if(drink.equals(getString(R.string.tea))){
            positions = spinnerTea.getSelectedItem().toString();
        }else if (drink.equals(getString(R.string.coffe))){
            positions = spinnerCoffee.getSelectedItem().toString();
        }
        String order = String.format("Имя: %s, Пароль: %s, Напиток: %s, Вид напитка: %s, Добавки: %s", name, paasword, drink, positions, additionsCheck);
        Intent intent = new Intent(this, Orders.class);
        intent.putExtra("orders",order);
        startActivity(intent);
    }

    }


