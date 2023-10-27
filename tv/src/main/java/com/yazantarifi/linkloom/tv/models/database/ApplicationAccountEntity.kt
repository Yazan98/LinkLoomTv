package com.yazantarifi.linkloom.tv.models.database

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ApplicationAccountEntity: RealmObject() {

    @PrimaryKey
    var name: String = ""

}
