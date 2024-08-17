package com.example.roomdatabase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.cusrecyclerfaslha.databinding.ActivityMainBinding
import com.example.roomdatabase.db.DbHandler
import com.example.roomdatabase.db.Entity.EntitiUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DbHandler.getDatabase(this)



        binding.save.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                val name = binding.name.text.toString()
                val phon= binding.phon.text.toString()
                db.userDao().insertUser(
                    EntitiUser(name = "$name", phone = "$phon")
                )
            }
        }

//        binding.update.setOnClickListener{
//            lifecycleScope.launch {
//                withContext(Dispatchers.IO){
//                    db.userDao().updateUser(
//                        EntitiUser(
//                            2,
//                            "mohamad",
//                            "09876"
//                        )
//                    )
//                }
//            }
//        }


//        binding.button2.setOnClickListener {
//            lifecycleScope.launch {
//                db.userDao().getUser().collect { userList ->  // استفاده از collect
//                    val text = userList.joinToString(separator = "\n\n")
//                    binding.textView.text = text
//                }
//            }
//        }
    }
}