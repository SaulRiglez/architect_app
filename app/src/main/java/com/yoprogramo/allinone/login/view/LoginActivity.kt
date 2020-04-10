package com.yoprogramo.allinone.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yoprogramo.allinone.App
import com.yoprogramo.allinone.R
import com.yoprogramo.allinone.databinding.ActivityLoginBinding
import com.yoprogramo.allinone.login.LoginActivityMVP
import timber.log.Timber
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginActivityMVP.View {

    private lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var presenter: LoginActivityMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        (application as App).component.inject(this)

        binding.loginBtn.setOnClickListener {
            presenter.loginButtonClicked()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
        presenter.getCurrentUser()
    }

    override fun getFirstName(): String {
        return binding.etName.text.toString()
    }

    override fun getLastName(): String {
        return binding.etLastName.text.toString()
    }

    override fun shouldNotNotAvailable() {
        Toast.makeText(this, "Error: The user is not available.", Toast.LENGTH_SHORT).show()
    }

    override fun showInputError() {
        Toast.makeText(this, "Error: Wrong input", Toast.LENGTH_SHORT).show()
    }

    override fun showUserSaveMessage() {
        Toast.makeText(this, "User was saved successfully", Toast.LENGTH_SHORT).show()
    }

    override fun startLoginFlow() {
        startActivity(Intent(this, MainActivity::class.java));
    }

    override fun setFirstName(firstName: String) {
        binding.etName.setText(firstName)
    }

    override fun setLastName(lastName: String) {
        binding.etLastName.setText(lastName)
    }
}