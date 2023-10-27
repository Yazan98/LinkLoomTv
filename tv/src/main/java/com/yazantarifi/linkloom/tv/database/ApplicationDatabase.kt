package com.yazantarifi.linkloom.tv.database

import io.realm.Realm
import io.realm.RealmObject

class ApplicationDatabase {

    fun insertEntity(item: RealmObject) {
        getRealmInstance()?.use {
            it.executeTransaction {
                it.insertOrUpdate(item)
            }
        }
    }

    private fun getRealmInstance(): Realm? {
        return Realm.getDefaultInstance()
    }

}