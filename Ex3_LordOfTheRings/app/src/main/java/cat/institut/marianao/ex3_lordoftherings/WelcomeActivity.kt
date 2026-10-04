package cat.institut.marianao.ex3_lordoftherings

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val usersPoints= mapOf(
            "gandalf" to 312,
            "frodo" to 222,
            "saruman" to 489
        )

        val bundle= intent.extras
        val name= bundle?.getString("name")

        val textPoints = findViewById<TextView>(R.id.txtScore)
        val textWelcome= findViewById<TextView>(R.id.txtWelcome)
        val btnBackAgain= findViewById<Button>(R.id.btnBackAgain)

        textWelcome.text="Welcome, my Lord $name!"
        if(name in usersPoints){
            val points=usersPoints[name]
            textPoints.text="Your Score is $points"
            Toast.makeText(this, "THE NAME SHALL PASS!", Toast.LENGTH_SHORT).show()
        }
        else{
            textPoints.text="Your Score is 0"
            Toast.makeText(this, "THE NAME SHALL NOT PASS!", Toast.LENGTH_SHORT).show()
        }

        btnBackAgain.setOnClickListener {
            finish()
        }


    }
}