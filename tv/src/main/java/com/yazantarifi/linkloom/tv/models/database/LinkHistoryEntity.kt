package com.yazantarifi.linkloom.tv.models.database

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class LinkHistoryEntity: RealmObject() {

    @PrimaryKey
    var primaryKey: String = ""
    var url: String = ""
    var name: String = ""
    var account: String = ""

}
