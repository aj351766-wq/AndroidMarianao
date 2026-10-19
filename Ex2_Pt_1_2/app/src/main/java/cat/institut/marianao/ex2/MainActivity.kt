package cat.institut.marianao.ex2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var number1 : EditText

    private lateinit var number2 : EditText

    private lateinit var checkBoxAdd : CheckBox

    private lateinit var checkBoxSubstract : CheckBox

    private lateinit var addResult : TextView

    private lateinit var substractResult : TextView

    private lateinit var btnAdd : Button

    private lateinit var btnClear : Button

    private val action = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initLayout()

        addListenners()

    }


    private fun initLayout (){
        number1=findViewById<EditText>(R.id.Number1)
        number2=findViewById<EditText>(R.id.Number2)
        checkBoxAdd=findViewById<CheckBox>(R.id.CheckBoxAdd)
        checkBoxSubstract=findViewById<CheckBox>(R.id.CheckBoxSubstract)
        addResult=findViewById<TextView>(R.id.Add)
        substractResult=findViewById<TextView>(R.id.Substract)
        btnAdd=findViewById<Button>(R.id.BtnAdd)
        btnClear=findViewById<Button>(R.id.btnClear)
    }

    private fun addListenners(){

        checkBoxAdd.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                if (!action.contains("ADD")) {
                    action.add("ADD")
                }
            } else {
                action.remove("ADD")
            }
        }

        checkBoxSubstract.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                if (!action.contains("SUBSTRACT")) {
                    action.add("SUBSTRACT")
                }
            } else {
                action.remove("SUBSTRACT")
            }
        }

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


            when(action.size){
                0 -> Toast.makeText(this, "Select at least one operation", Toast.LENGTH_SHORT).show()


                1-> {
                    if(action.get(0)=="ADD"){
                        addResult.text="Add: " + (operator1.toInt()+operator2.toInt())
                    }

                    if(action.get(0)=="SUBSTRACT"){
                        substractResult.text="Substract: " + (operator1.toInt()-operator2.toInt())
                    }

                }

                2 -> {
                    addResult.text="Add: " + (operator1.toInt()+operator2.toInt())
                    substractResult.text="Substract: " + (operator1.toInt()-operator2.toInt())
                }


            }

        }
        else{
            Toast.makeText(this, "Introduce valid numbers", Toast.LENGTH_SHORT).show()
        }
    }

}