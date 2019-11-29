package com.example.bmicalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btncalc.setOnClickListener() {
            try {
                val height = editheight.text.toString()
                val weight = editweight.text.toString()
                val status: String
                val bmi: Double = weight.toDouble() / (height.toDouble() * height.toDouble())

                if (bmi < 18.5) {
                    imageView.setImageResource(R.drawable.under)
                    status = "Under"
                } else if (bmi <= 24.9) {
                    imageView.setImageResource(R.drawable.normal)
                    status = "Normal"
                } else {
                    imageView.setImageResource(R.drawable.over)
                    status = "over"
                }


                txtshowbmi.text = "BMI = %.2f".format(bmi, status)
            }catch (e:Exception) {
                val toast:Toast = Toast.makeText(this, "invalid input", Toast.LENGTH_LONG )

                toast.setGravity(Gravity.CENTER, 0,0)
                toast.show()
            }
        }

        btnreset.setOnClickListener() {
            editheight.text.clear()
            editweight.text.clear()
            txtshowbmi.text = ""
            imageView.setImageResource(R.drawable.empty)
        }

    }
}
