package cat.institut.marianao.suma_resta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    private lateinit var number1 : EditText
    private lateinit var number2 : EditText
    private lateinit var radioGroup : RadioGroup
    private lateinit var result : TextView
    private lateinit var btnAdd : Button
    private lateinit var btnClear : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLayout()

        addListenners()

    }


    private fun initLayout (){
        number1=findViewById<EditText>(R.id.Number1)
        number2=findViewById<EditText>(R.id.Number2)
        radioGroup=findViewById<RadioGroup>(R.id.rgOptions)
        result=findViewById<TextView>(R.id.Result)
        btnAdd=findViewById<Button>(R.id.BtnAdd)
        btnClear=findViewById<Button>(R.id.btnClear)

        radioGroup.check(R.id.BtnRatioAdd)
    }

    private fun addListenners(){

        btnAdd.setOnClickListener {
            makeOperation()
        }

        btnClear.setOnClickListener {
            number1.text.clear()
            number2.text.clear()
        }

    }

    private fun makeOperation(){
        val operator1= number1.text.toString().trim()
        val operator2= number2.text.toString().trim()



        if(operator1.isNotBlank() && operator2.isNotBlank()){

                when (radioGroup.checkedRadioButtonId) {
                    R.id.BtnRatioAdd -> {result.text = "Result: " + (operator1.toInt()+operator2.toInt())}
                    R.id.BtnRatioSubstract -> {result.text = "Result: " + (operator1.toInt()-operator2.toInt())}


                    else -> {
                        Toast.makeText(
                            this,
                            "Select an operation",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }



        }
        else{
            Toast.makeText(this, "Complete Camps 1 and 2 to continue your transaction.", Toast.LENGTH_SHORT).show()
        }

    }



}