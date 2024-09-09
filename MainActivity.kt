import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var inputColumn1: EditText
    private lateinit var inputColumn2: EditText
    private lateinit var radioPlus: RadioButton
    private lateinit var radioMinus: RadioButton
    private lateinit var radioMultiply: RadioButton
    private lateinit var radioDivide: RadioButton
    private lateinit var calcButton: Button
    private lateinit var clearButton: Button
    private lateinit var teksHasil: TextView
    private lateinit var outHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputColumn1 = findViewById(R.id.inputColumn1)
        inputColumn2 = findViewById(R.id.inputColumn2)
        radioPlus = findViewById(R.id.radioPlus)
        radioMinus = findViewById(R.id.radioMinus)
        radioMultiply = findViewById(R.id.radioMultiply)
        radioDivide = findViewById(R.id.radioDivide)
        calcButton = findViewById(R.id.calcButton)
        clearButton = findViewById(R.id.clearButton)
        teksHasil = findViewById(R.id.teksHasil)
        outHasil = findViewById(R.id.outHasil)

        calcButton.setOnClickListener {
            val num1 = inputColumn1.text.toString().toDouble()
            val num2 = inputColumn2.text.toString().toDouble()
            var result = 0.0

            when {
                radioPlus.isChecked -> result = num1 + num2
                radioMinus.isChecked -> result = num1 - num2
                radioMultiply.isChecked -> result = num1 * num2
                radioDivide.isChecked -> result = num1 / num2
            }

            outHasil.text = result.toString()
        }

        clearButton.setOnClickListener {
            inputColumn1.text.clear()
            inputColumn2.text.clear()
            outHasil.text = "0"
        }
    }
}
