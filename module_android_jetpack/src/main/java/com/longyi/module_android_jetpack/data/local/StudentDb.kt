package com.example.uitestdemo.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.uitestdemo.ioThread
import com.longyi.module_android_jetpack.data.local.Student
import com.tencent.bugly.Bugly.applicationContext

@Database(entities = [Student::class], version = 1)
abstract class StudentDb:RoomDatabase() {

    abstract fun studentDao(): StudentDao

    companion object {
        private var instance: StudentDb? = null
        @Synchronized
        fun get(): StudentDb {
            if (instance == null) {
                instance = Room.databaseBuilder(applicationContext,
                    StudentDb::class.java, "StudentDatabase").build()
            }
            initData()
            return instance!!
        }
        // 默认数据
        private fun initData(){
            ioThread {
                // 单线程池
                get().studentDao().insert(
                    CHEESE_DATA.map {
                        Student(
                            id = 0,
                            name = it
                        )
                    })
            }
        }
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