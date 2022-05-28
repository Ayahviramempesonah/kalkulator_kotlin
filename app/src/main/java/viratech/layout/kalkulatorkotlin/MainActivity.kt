package viratech.layout.kalkulatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtSatu : EditText
    private lateinit var edtDua : EditText
    private lateinit var edtTiga : EditText
    private lateinit var btnHasil : Button
    private lateinit var tvHasil : TextView


    companion object {
        private const val STATE_RESULT= "state_result"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        edtSatu = findViewById(R.id.ini_edt_satu)
        edtDua = findViewById(R.id.ini_edt_dua)
        edtTiga = findViewById(R.id.ini_edt_tiga)
        btnHasil = findViewById(R.id.btn_hasil)
        tvHasil = findViewById(R.id.tv_hasil)

        btnHasil.setOnClickListener(this)






    }

    override fun onClick(p0: View) {
        if (p0.id == R.id.btn_hasil){
            val inputLength = edtSatu.text.toString().trim()
            val inputWidth = edtDua.text.toString().trim()
            val inputHeight = edtTiga.text.toString().trim()


            var isEmptyFields = false

            if (inputLength.isEmpty()){
                isEmptyFields = true
                edtSatu.error = "field ini tidak boleh kosong"
            }
            if (inputWidth.isEmpty()){
                isEmptyFields = true
                edtDua.error = "field ini tidak boleh kosong"
            }
            if (inputHeight.isEmpty()){
                isEmptyFields = true
                edtTiga.error = "field ini tidak boleh kosong"
            }

            if ( !isEmptyFields){
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvHasil.text = volume.toString()

            }







        }

    }
}