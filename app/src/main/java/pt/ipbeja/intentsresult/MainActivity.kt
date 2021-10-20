package pt.ipbeja.intentsresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var photoView: ImageView
    private lateinit var nameView: TextView
    private lateinit var studentNrView: TextView
    private lateinit var editBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.nameView = findViewById(R.id.name)
        this.studentNrView = findViewById(R.id.studentNr)
        this.editBtn = findViewById(R.id.editButton)


        this.photoView = findViewById(R.id.photo)
        val cameraLauncher =
            registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {
                photoView.setImageBitmap(it)
            }


        photoView.setOnClickListener {
            cameraLauncher.launch(null)
        }


        val launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if(result.resultCode == RESULT_OK) {
                val data = result.data!!
                val name = data.getStringExtra("name")
                val nr = data.getStringExtra("studentNr")

                nameView.text = name
                studentNrView.text = nr
            }
        }



        this.editBtn.setOnClickListener {
            val i = Intent(this, EditActivity::class.java)
            launcher.launch(i)
        }


    }


}