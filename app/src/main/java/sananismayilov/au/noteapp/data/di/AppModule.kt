package sananismayilov.au.noteapp.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import sananismayilov.au.noteapp.data.local.NoteDao
import sananismayilov.au.noteapp.data.local.NoteDb
import sananismayilov.au.noteapp.data.repository.NoteRepositoryImpl
import sananismayilov.au.noteapp.domain.repository.NoteRepository
import sananismayilov.au.noteapp.util.Constants.DBNAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRoomDb(@ApplicationContext context : Context)  = Room.databaseBuilder(
        context,NoteDb::class.java,DBNAME
    ).build()

    @Provides
    @Singleton
    fun provideDao(db : NoteDb) = db.getDao()

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao) : NoteRepository{
        return NoteRepositoryImpl(noteDao)
    }

}