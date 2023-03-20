package com.saytoonz.cryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.saytoonz.cryptocurrency.domain.model.CoinDetail

data class CoinDetailDto(
    @SerializedName("description")
    val description: String, // Bitcoin is a cryptocurrency and worldwide payment system. It is the first decentralized digital currency, as the system works without a central bank or single administrator.
    @SerializedName("development_status")
    val developmentStatus: String, // Working product
    @SerializedName("first_data_at")
    val firstDataAt: String, // 2010-07-17T00:00:00Z
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean, // true
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String, // SHA256
    @SerializedName("id")
    val id: String, // btc-bitcoin
    @SerializedName("is_active")
    val isActive: Boolean, // true
    @SerializedName("is_new")
    val isNew: Boolean, // false
    @SerializedName("last_data_at")
    val lastDataAt: String, // 2023-03-20T12:00:00Z
    @SerializedName("links")
    val links: Links,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>,
    @SerializedName("logo")
    val logo: String, // https://static.coinpaprika.com/coin/btc-bitcoin/logo.png
    @SerializedName("message")
    val message: String,
    @SerializedName("name")
    val name: String, // Bitcoin
    @SerializedName("open_source")
    val openSource: Boolean, // true
    @SerializedName("org_structure")
    val orgStructure: String, // Decentralized
    @SerializedName("proof_type")
    val proofType: String, // Proof of Work
    @SerializedName("rank")
    val rank: Int, // 1
    @SerializedName("started_at")
    val startedAt: String, // 2009-01-03T00:00:00Z
    @SerializedName("symbol")
    val symbol: String, // BTC
    @SerializedName("tags")
    val tags: List<Tag>,
    @SerializedName("team")
    val team: List<TeamMember>,
    @SerializedName("type")
    val type: String, // coin
    @SerializedName("whitepaper")
    val whitepaper: Whitepaper
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description, symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}