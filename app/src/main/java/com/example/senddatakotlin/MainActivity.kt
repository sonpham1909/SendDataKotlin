package com.example.senddatakotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Kiểm tra xem Activity đã được tạo ra trước đó hay chưa
        if (savedInstanceState == null) {
            // Tạo các instance của Fragment
            val firstFragment = BlankFragment()
            val secondFragment = BlankFragment2()

            // Thực hiện giao dịch để thêm các Fragment vào các container
            supportFragmentManager.beginTransaction()
                .add(R.id.Fragment_1, firstFragment)
                .add(R.id.Fragment_2, secondFragment)
                .commit()
        }

    }
}