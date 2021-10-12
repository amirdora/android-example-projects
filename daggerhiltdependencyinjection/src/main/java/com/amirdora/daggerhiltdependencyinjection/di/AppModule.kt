package com.amirdora.daggerhiltdependencyinjection.di

import android.content.Context
import com.amirdora.daggerhiltdependencyinjection.db.AppDao
import com.amirdora.daggerhiltdependencyinjection.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getAppDB(context: Context): AppDatabase {
        return AppDatabase.getAppDb(context)
    }

    @Singleton
    @Provides
    fun getDao(appDb: AppDatabase): AppDao {
        return appDb.getDAO()
    }
}