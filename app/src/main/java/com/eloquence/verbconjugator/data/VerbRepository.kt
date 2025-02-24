package com.eloquence.verbconjugator.data

import androidx.lifecycle.LiveData
import androidx.sqlite.db.SimpleSQLiteQuery
import com.eloquence.verbconjugator.model.Favourite
import com.eloquence.verbconjugator.model.Verb

class VerbRepository(private val verbDao: VerbDao) {

    val allVerbs: LiveData<List<Verb>> = verbDao.getAllVerbs()

    val allWeakVerbs: LiveData<List<Verb>> = verbDao.getWeakVerbs()

    val allStrongVerbs: LiveData<List<Verb>> = verbDao.getStrongVerbs()

    val allReflexiveVerbs: LiveData<List<Verb>> = verbDao.getReflexiveVerbs()

    val allSeparableVerbs: LiveData<List<Verb>> = verbDao.getSeparableVerbs()

    val allNonSeparableVerbs: LiveData<List<Verb>> = verbDao.getNonSeparableVerbs()

    val allFavourites: LiveData<List<Verb>> = verbDao.getFavourites()

    val allStoredFavourites: List<Verb> = verbDao.getStoredFavourites()

    suspend fun insertFavourite(favourite: Favourite) = verbDao.insert(favourite)

    suspend fun deleteFavourite(verbId: Int) = verbDao.deleteFavourite(verbId)

    fun isEmpty() = verbDao.isEmpty()

    fun getFilteredVerbs(constraint: String?): LiveData<List<Verb>> =
        verbDao.getFilteredVerbs(constraint)

    suspend fun insert(verb: Verb) = verbDao.insert(verb)

    suspend fun bulkInsert(verbs: List<Verb>) = verbDao.bulkInsert(verbs)

    suspend fun update(verb: Verb) = verbDao.update(verb)

    suspend fun migrateFavourite(verbId: Int) = verbDao.migrateFavourite(verbId)
}