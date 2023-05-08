package com.nur.serviceproviderinterviewcrud.view

import UsersViewmodelFactory
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.nur.serviceproviderinterviewcrud.R
import com.nur.serviceproviderinterviewcrud.api.ApiInterface
import com.nur.serviceproviderinterviewcrud.repository.UserRepository
import com.nur.serviceproviderinterviewcrud.viewmodel.UsersViewModel


class ServiceProviderRegistration : AppCompatActivity() {

    private lateinit var viewModel: UsersViewModel
    private lateinit var factory: UsersViewmodelFactory
    private lateinit var userName:EditText
    private lateinit var userEmail:EditText
    private lateinit var userGender:EditText
    private lateinit var btn_save:Button
    private lateinit var switch: SwitchCompat
    var isCheke:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_provider_registration)

        val toolbar: Toolbar = findViewById<View>(R.id.toolbarid) as Toolbar
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true);


        userName = findViewById(R.id.nameid)
        userEmail = findViewById(R.id.emailid)
        userGender = findViewById(R.id.genderId)
        btn_save = findViewById(R.id.btn_save)
        switch = findViewById(R.id.switchid)

        switch.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                isCheke = isChecked
            }
        })
        val api = ApiInterface()
        val repo = UserRepository(api)
        factory = UsersViewmodelFactory(repo)
        viewModel = ViewModelProvider(this,factory).get(UsersViewModel::class.java)


        println(isCheke.toString() + " is ding checked")

        val body = mapOf(
            "name" to "${userName.text}",
            "email" to "${userEmail.text}",
            "gender" to "${userGender.text}",
            "status" to "${if(isCheke==true) "active" else "inactive"}"
        )

        btn_save.setOnClickListener {
            viewModel.createUsers(body)
//            viewModel.userCrate.observe(this, Observer {
//                Log.d("UserCreate", "onCreate: the response user name is ${it.name}")
//            })
        }



    }
}