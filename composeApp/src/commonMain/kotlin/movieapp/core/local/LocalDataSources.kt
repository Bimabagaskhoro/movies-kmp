package movieapp.core.local

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.types.RealmObject
import kotlin.reflect.KClass

abstract class LocalDataSources(
    vararg kClass: KClass<out RealmObject>
) {

    private val config = RealmConfiguration.create(
        schema = kClass.toList().toSet()
    )
    private val realm = Realm.open(config)

    /***
     * this code for sample crud ->
     */
//    suspend fun <T: RealmObject> insertObject(loocale.movieapp.data: T) {
//        withContext(Dispatchers.IO) {
//            realm.writeBlocking {
//                copyToRealm(loocale.movieapp.data)
//            }
//        }
//    }
//
//    suspend fun <T: RealmObject> removeObject(kClass: KClass<T>, id: Int) {
//        withContext(Dispatchers.IO) {
//            realm.writeBlocking {
//                val transactionItem = query(kClass, "id == $id")
//                delete(transactionItem)
//            }
//        }
//    }
//
//    suspend fun <T: RealmObject> getObjects(kClass: KClass<T>): Flow<List<T>> {
//        return withContext(Dispatchers.IO) {
//            realm.query(kClass)
//                .find()
//                .asFlow()
//                .map {
//                    it.list.asReversed()
//                }
//        }
//    }
//
//    suspend fun <T: RealmObject> getObjectExistById(kClass: KClass<T>, id: Int): Flow<Boolean> {
//        return withContext(Dispatchers.IO) {
//            realm.query(kClass, query = "id = $id")
//                .find()
//                .asFlow()
//                .map {
//                    it.list.isNotEmpty()
//                }
//        }
//    }
//
//    suspend fun <T: RealmObject> getObjectById(kClass: KClass<T>, id: Int): T? {
//        return withContext(Dispatchers.IO) {
//            realm.query(kClass, query = "id == $id")
//                .find()
//                .lastOrNull()
//        }
//    }
}