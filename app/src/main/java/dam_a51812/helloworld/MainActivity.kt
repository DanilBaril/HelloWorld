package dam_a51812.helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var greetStr = "Olá"
        var name = ""
        var pt = true;

        val buttonNome = findViewById<Button>(R.id.buttonNome)
        val nomeBox = findViewById<EditText>(R.id.nomeBox)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val langBtn = findViewById<Button>(R.id.langBtn)
        val textView = findViewById<TextView>(R.id.textView)

        buttonNome.setOnClickListener {
            name = nomeBox.text.toString()
            if(name.isEmpty()){ textView2.text = greetStr
            }else{ textView2.text = "$greetStr $name!" }
        }

        langBtn.setOnClickListener {
            if(pt){
                langBtn.text = "EN"
                greetStr = "Hello";textView2.text = "$greetStr $name!"
                textView.text = "My first android app!"
                nomeBox.setText("Name")
                buttonNome.text = "Select"
                pt = false
            }else{
                langBtn.text = "PT"
                greetStr = "Olá";textView2.text = "$greetStr $name!"
                textView.text = "A minha primeira app android!"
                nomeBox.setText("Nome")
                buttonNome.text = "Selecionar"
                pt = true
            }
        }

        val ldSwitch = findViewById<Switch>(R.id.LDswitch)
        ldSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }


        println(getString(R.string.activity_oncreate_msg, this@MainActivity.localClassName))
    }
}