package com.dm.tutorialmasterdetailflow

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_item_detail.*

/**
 * Un'attività che rappresenta una singola schermata dei dettagli dell'articolo.
 * Questa attività viene utilizzata solo su dispositivi a larghezza ridotta.
 * Sui dispositivi tablet, i dettagli degli elementi vengono presentati fianco a fianco
 * con un elenco di elementi in un file[ItemListActivity].
 */
class ItemDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        // Mostra il pulsante Su nella barra delle azioni.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // savedInstanceState non è nullo quando è presente uno stato di frammento salvato
        // da precedenti configurazioni di questa attività (ad esempio, quando si ruota lo
        // schermo da verticale a orizzontale). In questo caso, il frammento verrà automaticamente
        // aggiunto di nuovo al suo contenitore, quindi non è necessario aggiungerlo manualmente.
        // Per ulteriori informazioni, vedere la guida dell'API Fragments all'indirizzo:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Crea il frammento di dettaglio e aggiungilo all'attività utilizzando una
            // transazione di frammento.
            val fragment = ItemDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(
                        ItemDetailFragment.ARG_ITEM_ID,
                        intent.getStringExtra(ItemDetailFragment.ARG_ITEM_ID)
                    )
                }
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.item_detail_container, fragment)
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                // Questo ID rappresenta il pulsante Home o Su. Nel caso di questa attività,
                // viene visualizzato il pulsante Su. Per ulteriori dettagli, vedere il modello
                // di navigazione su Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back

                navigateUpTo(Intent(this, ItemListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
