package com.example.binlisttestcft

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter: RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    var listBins = listOf<Bin>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
       val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_bin_info, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val bin = listBins.get(position)
        holder.textViewBIN.text = "BIN: ${bin.binNumber}"
        holder.textViewScheme.text = "SCHEME/NETWORK: " + bin.binResponse?.scheme
        holder.textViewBrand.text = "BRAND: " + bin.binResponse?.brand
        holder.textViewLength.text = "CARD NUMBER LENGTH: " + bin.binResponse?.number?.length.toString()
        holder.textViewLuhn.text = "CARD NUMBER LUHN: ${if (bin.binResponse?.number?.luhn == true) {" Yes "} else {" No "}}"
        holder.textViewType.text = "TYPE: " + bin.binResponse?.type
        holder.textViewPrepaid.text = "PREPAID:  ${if (bin.binResponse?.prepaid == true) {" Yes "} else {" No "}}"
        holder.textViewCountryName.text = "COUNTRY NAME: " + bin.binResponse?.country?.countyName
        holder.textViewCountryCode.text = "COUNTRY CODE: " + bin.binResponse?.country?.countryCode
        holder.textViewCountryCoordinates.text = "COUNTRY COORDINATES: " +
                "latitude ${bin.binResponse?.country?.latitude}, longitude ${bin.binResponse?.country?.longitude}"
        holder.textViewBankName.text = "BANK NAME: " + bin.binResponse?.bank?.bankName
        holder.textViewBankWebsite.text = "BANK WEBSITE: " + bin.binResponse?.bank?.url
        holder.textViewBankPhone.text = "BANK PHONE: " + bin.binResponse?.bank?.phone
    }

    override fun getItemCount(): Int {
        return listBins.size
    }

    inner class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewBIN: TextView = itemView.findViewById(R.id.textViewBIN)
        val textViewScheme: TextView = itemView.findViewById(R.id.textViewScheme)
        val textViewBrand: TextView = itemView.findViewById(R.id.textViewBrand)
        val textViewLength: TextView = itemView.findViewById(R.id.textViewLength)
        val textViewLuhn: TextView = itemView.findViewById(R.id.textViewLuhn)
        val textViewType: TextView = itemView.findViewById(R.id.textViewType)
        val textViewPrepaid: TextView = itemView.findViewById(R.id.textViewPrepaid)
        val textViewCountryName: TextView = itemView.findViewById(R.id.textViewCountryName)
        val textViewCountryCode: TextView = itemView.findViewById(R.id.textViewCountryCode)
        val textViewCountryCoordinates: TextView = itemView.findViewById(R.id.textViewCountryCoordinates)
        val textViewBankName: TextView = itemView.findViewById(R.id.textViewBankName)
        val textViewBankWebsite: TextView = itemView.findViewById(R.id.textViewBankWebsite)
        val textViewBankPhone: TextView = itemView.findViewById(R.id.textViewBankPhone)
    }

}