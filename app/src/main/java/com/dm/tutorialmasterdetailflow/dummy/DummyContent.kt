package com.dm.tutorialmasterdetailflow.dummy

import java.util.ArrayList
import java.util.HashMap

/**
 * Classe helper per fornire contenuto di esempio per le interfacce utente create dalle
 * procedure guidate del modello Android.
 *
 * TODO: Sostituisci tutti gli usi di questa classe prima di pubblicare la tua app.
 */
object DummyContent {

    /**
     * Un array di elementi campione (fittizi).
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * Una mappa di elementi campione (fittizi), per ID.
     */
    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    private val COUNT = 25

    init {
        // Aggiungi alcuni articoli di esempio.
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createDummyItem(position: Int): DummyItem {
        return DummyItem(position.toString(), "Item " + position, makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * Un oggetto fittizio che rappresenta una parte di contenuto.
     */
    data class DummyItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}
