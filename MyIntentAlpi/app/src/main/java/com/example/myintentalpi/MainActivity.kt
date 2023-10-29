package com.example.myintentalpi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myintentalpi.R.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnMoveActivity : Button
    private lateinit var btnMoveWithData : Button
    private lateinit var btnDialNumber: Button
    private lateinit var btnResultFromActivity: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        btnMoveActivity = findViewById(id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        btnMoveWithData = findViewById(id.btn_move_activity_data)
        btnMoveWithData.setOnClickListener(this)

        btnDialNumber = findViewById(id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)

        btnResultFromActivity = findViewById(id.btn_move_with_result)
        btnResultFromActivity.setOnClickListener(this)

        tvResult = findViewById(id.tv_result)
        warnaReceived()
    }
    override fun onClick(v:View?){
        if (v  != null){
            when (v.id){
                id.btn_move_activity -> run {
                    val intent = Intent (this, MoveActivity::class.java)
                    startActivity(intent)
                }
                id.btn_move_activity_data -> run {
                    val intent = Intent(this, MoveWithDataActivity::class.java)
                    val bundle = Bundle()
                    bundle.putString("Nama", "syaiful")
                    bundle.putString("Alamat", "lol")
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
                id.btn_dial_number -> run {
                    val dialNumber = "088567895541"
                    val intent= Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ dialNumber))
                    startActivity(intent)
                }
                id.btn_move_with_result -> {
                    val intent = Intent(this, Move_For_Result_Activity::class.java)
                    startActivity(intent)
                }

            }
        }
    }

    private fun warnaReceived(){
        val bundle = intent.extras
        val warna = bundle?.getString("Warna")
        tvResult.text = warna
    }
}