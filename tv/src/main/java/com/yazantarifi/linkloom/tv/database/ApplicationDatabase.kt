package com.yazantarifi.linkloom.tv.database

import com.yazantarifi.linkloom.tv.models.database.LinkHistoryEntity
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

    fun onClearHistory(accountName: String) {
        getRealmInstance()?.use {
            it.executeTransaction {
                it.where(LinkHistoryEntity::class.java)
                    .equalTo("account", accountName)
                    .findAll()?.deleteAllFromRealm()
            }
        }
    }

    fun getHistoryItems(): ArrayList<LinkHistoryEntity> {
        val realmInstance = getRealmInstance()
        val results = realmInstance?.where(LinkHistoryEntity::class.java)?.findAll()
        val items = ArrayList<LinkHistoryEntity>()
        results?.map { realmInstance.copyFromRealm(it) }?.let {
            items.addAll(it)
        }

        realmInstance?.close()
        return items
    }

    private fun getRealmInstance(): Realm? {
        return Realm.getDefaultInstance()
    }

}