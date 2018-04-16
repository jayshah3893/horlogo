package com.artemchep.horlogo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.artemchep.horlogo.R
import com.artemchep.horlogo.extensions.setTextExclusive
import com.artemchep.horlogo.model.ConfigItem
import com.artemchep.horlogo.ui.interfaces.OnItemClickListener

/**
 * @author Artem Chepurnoy
 */
open class ConfigAdapter(
        models: MutableList<ConfigItem>
) :
        AdapterBase<ConfigItem, ConfigAdapter.Holder>(models) {

    /**
     * @author Artem Chepurnoy
     */
    class Holder(
            listener: OnItemClickListener<Int>,
            view: View
    ) : AdapterBase.ViewHolderBase(listener, view), View.OnClickListener {

        internal val iconImageView = view.findViewById<ImageView>(R.id.iconImageView)
        internal val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        internal val summaryTextView = view.findViewById<TextView>(R.id.summaryTextView)

        init {
            view.setOnClickListener(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_config, parent, false)
        return Holder(this, v)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val model = models[position]

        holder.apply {
            titleTextView.text = model.title
            summaryTextView.setTextExclusive(model.summary)
            iconImageView.setImageDrawable(model.icon)
        }
    }

}