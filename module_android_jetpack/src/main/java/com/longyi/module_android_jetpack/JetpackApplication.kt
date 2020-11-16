package com.longyi.module_android_jetpack

import android.app.Application
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.db.AppDataBase
import com.example.lib_common.model.Student
import com.example.lib_common.utils.PreferenceUtils
import com.example.uitestdemo.ioThread


class JetpackApplication : BaseApplication()  {

    private val sTAG:String = JetpackApplication::class.java.simpleName

    /**
     * 通过反射，完成了组件 Application 的初始化操作，也实现了组件与化中的解耦需求
     */
    override fun initData(application: Application) {
        val allStudent = AppDataBase.instance(application).getStudentDao().getAllStudent()
        val dataSource = allStudent.create()
        val hasData = PreferenceUtils.getBoolean("initStudentData", false)
        dataSource.map {
            if (!hasData){
                PreferenceUtils.saveValue("initStudentData", true)
            }
        }
        if (!hasData){
            initStudentData()
        }
    }

    // 默认数据
    private fun initStudentData(){
        ioThread {
            // 单线程池
            AppDataBase.instance(BaseApplication.context).getStudentDao().insert(
                CHEESE_DATA.map {
                    Student(
                        id = 0,
                        name = it
                    )
                })
        }
    }
    private val CHEESE_DATA = arrayListOf(
        "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
        "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag",
        "Airedale", "Aisy Cendre", "Allgauer Emmentaler", "Alverca", "Ambert",  // 15
        "American Cheese", "Ami du Chambertin", "Anejo Enchilado", "Anneau du Vic-Bilh", "Anthoriro",
        "Appenzell", "Aragon", "Ardi Gasna", "Ardrahan", "Armenian String",
        "Aromes au Gene de Marc", "Asadero", "Asiago", "Aubisque Pyrenees", "Autun", // 30
        "Avaxtskyr", "Baby Swiss", "Babybel", "Baguette Laonnaise", "Bakers",
        "Baladi", "Balaton", "Bandal", "Banon", "Barry's Bay Cheddar", "Basing", "Basket Cheese", "Bath Cheese", "Bavarian Bergkase",
        "Baylough", "Beaufort", "Beauvoorde", "Beenleigh Blue", "Beer Cheese", "Bel Paese",
        "Bergader", "Bergere Bleue", "Berkswell", "Beyaz Peynir", "Bierkase", "Bishop Kennedy",
        "Blarney", "Bleu d'Auvergne", "Bleu de Gex", "Bleu de Laqueuille",
        "Bleu de Septmoncel", "Bleu Des Causses", "Blue", "Blue Castello", "Blue Rathgore",
        "Blue Vein (Australian)", "Blue Vein Cheeses", "Bocconcini", "Bocconcini (Australian)"
    )

}