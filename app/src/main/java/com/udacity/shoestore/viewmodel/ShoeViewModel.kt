package com.udacity.shoestore.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.BR
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>((mutableListOf()))

    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    fun addNewShow(item: Shoe) {
        item?.let {
            _shoeList.value?.add(item)
        }
    }
}