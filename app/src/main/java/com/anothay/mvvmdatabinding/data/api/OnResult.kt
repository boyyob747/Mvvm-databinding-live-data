package com.anothay.mvvmdatabinding.data.api


interface OnResult<T> {
  fun onSuccess(response: T)
  fun onLoading()
  fun onFailed(message: String)
  fun onEmpty()
}