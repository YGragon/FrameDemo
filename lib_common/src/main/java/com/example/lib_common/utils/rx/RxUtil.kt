package com.example.lib_common.utils.rx


import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.ObservableOnSubscribe

/**
 * RxUtil 工具类，包括 防抖事件处理，EditText 联想搜索
 */
object RxUtil{

    // 防抖事件
    fun clickView(view: View?): Observable<Any> {
        return Observable.create(ViewClickOnSubscribe(view!!))
    }

    // 联想搜索
    fun textChanges(view: EditText?): Observable<String> {
        return Observable.create(ViewChangeOnSubscribe(view!!))
    }

    // SearchView联想搜索
    fun searchViewTextChanges(view: SearchView?): Observable<String> {
        return Observable.create(SearchViewChangeOnSubscribe(view!!)).skip(1)
    }

    // EditText 搜索
    private class ViewChangeOnSubscribe(val view: EditText) : ObservableOnSubscribe<String> {

        override fun subscribe(emitter: ObservableEmitter<String>) {
            val textChange = object :TextWatcher{
                override fun afterTextChanged(s: Editable?) {}

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (!emitter.isDisposed) {
                        //发送消息
                        emitter.onNext(s.toString())
                    }
                }
            }

            view.addTextChangedListener(textChange)
        }

    }

    // SearchView 搜索
    private class SearchViewChangeOnSubscribe(val view: SearchView) : ObservableOnSubscribe<String> {

        override fun subscribe(emitter: ObservableEmitter<String>) {
            val textChange = object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean = false

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (!emitter.isDisposed) {
                        //发送消息
                        newText?.let { emitter.onNext(it) }
                    }
                    return false
                }
            }

            view.setOnQueryTextListener(textChange)
        }

    }

    // 点击防抖
    private class ViewClickOnSubscribe(val view: View) : ObservableOnSubscribe<Any> {

        override fun subscribe(emitter: ObservableEmitter<Any>) {
            val onClickListener = View.OnClickListener {
                //订阅没取消
                if (!emitter.isDisposed) {
                    //发送消息
                    emitter.onNext(1)
                }
            }
            view.setOnClickListener(onClickListener)
        }

    }
}
