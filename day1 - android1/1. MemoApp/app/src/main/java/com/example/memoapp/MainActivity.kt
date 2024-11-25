package com.example.memoapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var listView: ListView
    private lateinit var arrayAdapter: ArrayAdapter<String>
    private val itemList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View 초기화
        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
        listView = findViewById(R.id.listView)

        // ListView에 사용할 ArrayAdapter 설정
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)
        listView.adapter = arrayAdapter

        // 버튼 클릭 시 동작
        button.setOnClickListener {
            val inputText = editText.text.toString()

            if (inputText.isNotEmpty()) {
                // 리스트에 입력한 텍스트 추가
                itemList.add(inputText)
                // 리스트 업데이트
                arrayAdapter.notifyDataSetChanged()
                // 입력 필드 초기화
                editText.text.clear()
            }
        }
    }
}
