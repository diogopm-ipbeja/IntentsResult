package pt.ipbeja.intentsresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class EditActivity : AppCompatActivity() {


    private lateinit var nrInput: EditText
    private lateinit var nameInput: EditText
    private lateinit var saveBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)



        this.nameInput = findViewById(R.id.name)
        this.nrInput = findViewById(R.id.studentNr)
        this.saveBtn = findViewById(R.id.saveButton)

        saveBtn.setOnClickListener {

            val name = nameInput.text.toString()
            val studentNr = nrInput.text.toString()

            val i = Intent().apply {
                putExtra("name", name)
                putExtra("studentNr", studentNr)
            }

            setResult(RESULT_OK, i)
            finish()
        }


    }
}