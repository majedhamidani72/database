package com.example.roomdatabase.db.dao


import androidx.room.*
import com.example.roomdatabase.db.DbHandler
import com.example.roomdatabase.db.Entity.EntitiUser
import kotlinx.coroutines.flow.Flow
import retrofit2.http.DELETE

@Dao
interface UserDao {
    @Insert
    fun insertUser(vararg user: EntitiUser)

    @Query("SELECT * FROM ${DbHandler.USER_TABLE}")
    fun getUser(): Flow<List<EntitiUser>>  // تغییر به تابع غیر `val`

    @Update
    fun  updateUser(vararg user:EntitiUser) :Int

    @Delete
    fun  deleteUser(vararg user:EntitiUser)

    @Query("DELETE FROM ${DbHandler.USER_TABLE}")
    fun deleteAllUser()
}