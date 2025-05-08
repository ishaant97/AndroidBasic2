package com.example.androidbasic2.Unit4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidbasic2.R
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class ExternalStorage : AppCompatActivity() {

    lateinit var uname : EditText
    lateinit var pwd : EditText
    lateinit var saveBtn : Button
    lateinit var fStream : FileOutputStream
    private val fileName = "SampleFile.txt"
    private val filePath = "MyFileStorage"
    lateinit var myExternalFile : File


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_external_storage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        uname = findViewById(R.id.userNameEditText)
        pwd = findViewById(R.id.passwordEditText)
        saveBtn = findViewById(R.id.saveButton)
        saveBtn.setOnClickListener {
            val userName = """
                ${uname.text}
            """.trimIndent()
            val password = pwd.text.toString()

            try {
                if (userName.isEmpty() || password.isEmpty()){
                    Toast.makeText(this,"Either of fields is empty",Toast.LENGTH_SHORT).show()
                }
                else{
                    myExternalFile = File(getExternalFilesDir(filePath),fileName)
                    fStream = FileOutputStream(myExternalFile)
                    fStream.write(userName.toByteArray())
                    fStream.write(password.toByteArray())
                    fStream.close()
                    Toast.makeText(this,"Details Saved" + myExternalFile.absolutePath,Toast.LENGTH_SHORT).show()
                    intent = Intent(this,ExternalDetail::class.java)
                    startActivity(intent)
                }
            }
            catch (e : FileNotFoundException){
                e.printStackTrace()
            }
            catch (e : IOException) {
                e.printStackTrace()
            }
        }
    }
}