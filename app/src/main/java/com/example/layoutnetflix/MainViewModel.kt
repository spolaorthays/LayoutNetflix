package com.example.layoutnetflix

import android.app.Activity
import android.app.Application
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

open class BaseActivity: AppCompatActivity() {

    inline fun <reified T: ViewDataBinding> Activity.bind(@LayoutRes layout: Int, noinline block: T.() -> Unit): T {
        return DataBindingUtil.setContentView<T>(this, layout).apply {
            block.invoke(this)
        }
    }

}

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var userList = MutableLiveData<ArrayList<User>>()
    var newUserList = arrayListOf<User>()
    private val context = getApplication<Application>().applicationContext

    init {
        init()
    }

    fun add(user: User){
        newUserList.add(user)
        userList.value = newUserList
    }

    fun remove(user: User){
        newUserList.remove(user)
        userList.value = newUserList
    }

    fun init() {
        populateList()
        //emptyList()
        userList.value = newUserList
    }

    fun populateList() {
        val user1 = User("Batata")
        newUserList.add(user1)
        newUserList.add(user1)
        newUserList.add(user1)
        newUserList.add(user1)
        newUserList.add(user1)
        newUserList.add(user1)
        newUserList.add(User("Novo Usuário", context.getDrawable(R.drawable.img_add_user)))
    }

    fun emptyList() {
        newUserList = ArrayList()
    }
}