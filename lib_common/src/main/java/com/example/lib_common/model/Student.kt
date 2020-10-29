package com.example.lib_common.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Aller on 2019/12/22.
 */
@Entity(tableName = "Student")
data class Student(@PrimaryKey(autoGenerate = true) val id: Int, val name: String)