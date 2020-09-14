package com.myweb.lab7dialogrv

import StudentsAdapter
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.*
import androidx.recyclerview.widget.RecyclerView.LayoutManager as LayoutManager1



class MainActivity : AppCompatActivity() {
    val studentList :ArrayList<Student> = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentData()
        recycler_view.adapter = StudentsAdapter(this.studentList, applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
    }

    fun studentData(){
        studentList.add(Student("621234567-8", "Alice", 20))
        studentList.add(Student("629876543-2", "Bob", 21))
    }

    fun addStudent(view: View){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout, null)
        val myBuilder = AlertDialog.Builder(this)
        myBuilder.setView(mDialogView)

        val mAlertDialog = myBuilder.show()
        mAlertDialog.btnAdd.setOnClickListener(){
            studentList.add(
                Student(
                    mAlertDialog.edt_id.text.toString(),
                    mAlertDialog.edt_name.text.toString(),
                    mAlertDialog.edt_age.text.toString().toInt()
                )
            )
            recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(
                applicationContext,
                "The student is added successfully",
                Toast.LENGTH_LONG
            ).show()
            mAlertDialog.dismiss()
        }
        mAlertDialog.btnCancel.setOnClickListener(){
            mAlertDialog.dismiss()
        }
    }
}