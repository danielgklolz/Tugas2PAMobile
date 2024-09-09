import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var num1: EditText
    private lateinit var num2: EditText
    private lateinit var operation: RadioGroup
    private lateinit var calculate: Button
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        operation = findViewById(R.id.operation)
        calculate = findViewById(R.id.calculate)
        result = findViewById(R.id.result)

        calculate.setOnClickListener {
            calculateResult()
        }
    }

    private fun calculateResult() {
        val num1Value = num1.text.toString().toDoubleOrNull()
        val num2Value = num2.text.toString().toDoubleOrNull()

        if (num1Value == null || num2Value == null) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val selectedOperation = operation.checkedRadioButtonId
        var resultValue: Double? = null

        when (selectedOperation) {
            R.id.add -> resultValue = num1Value + num2Value
            R.id.subtract -> resultValue = num1Value - num2Value
            R.id.multiply -> resultValue = num1Value * num2Value
            R.id.divide -> {
                if (num2Value != 0.0) {
                    resultValue = num1Value / num2Value
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
            }
        }

        result.text = "Result: $resultValue"
    }
}