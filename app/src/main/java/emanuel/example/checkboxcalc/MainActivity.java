package emanuel.example.checkboxcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private CheckBox cb1, cb2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtengo de la parte gráfica y las conecto con la parte lógica. Establezco conexión entre objetos y componentes.
        et1 = (EditText)findViewById(R.id.number1);
        et2 = (EditText)findViewById(R.id.number2);
        cb1 = (CheckBox)findViewById(R.id.sumar);
        cb2 = (CheckBox)findViewById(R.id.restar);
        tv = (TextView)findViewById(R.id.resultado);
    }

    //Este método es la función del botón. "View view" significa que estoy pasándole una vista
    public void Calcular(View view){
        //Creo las variables de tipo String
        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        //parseo las variables de tipo String y las convierto a tipo numérico
        int valor1_Integer = Integer.parseInt(valor1_String);
        int valor2_Integer = Integer.parseInt(valor2_String);

        //Variable de tipo String que contendrá el resultado de las operaciones.
        //Las declaro antes de crear las estructuras condicionales pq necesito crear una variable de...
        // acumulación por si el usuario presiona ambos checkboxs. Guardará ambas operaciones.
        String resultado = "";

        //Creo estructuras condicionales
        if(cb1.isChecked() == true && cb2.isChecked() == true){
            int suma = valor1_Integer + valor2_Integer;
            int resta = valor1_Integer - valor2_Integer;
            resultado = "La suma es: " + suma + " / " + "La resta es: " + resta;
        }else if(cb1.isChecked() == true){
            int suma = valor1_Integer + valor2_Integer;
            resultado = "La suma es: " + suma;
        } else if(cb2.isChecked()){
            int resta = valor1_Integer - valor2_Integer;
            resultado = "La resta es: " + resta;
        }
        /*Para ahorrar código y recursos se puede acortar

        if(cb1.isChecked() == true){
            int suma = valor1_Integer + valor2_Integer;
            resultado = "La suma es: " + suma + " / ";
        }
        if(cb2.isChecked()){
            int resta = valor1_Integer - valor2_Integer;
            resultado = "La resta es: " + resta;
        }*/
        tv.setText(resultado);
    }
}