package com.example.roomdatabase.db.dao


import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabase.db.DbHandler
import io.reactivex.rxjava3.core.Flowable

@Dao
interface UserDao {

    @Insert
    fun insertUser(user:Entity)

    @get:Query("SELECTE * FROM  ${DbHandler.USER_TABLE}" )
    val getUser : Flowable<List<Entity>>
}