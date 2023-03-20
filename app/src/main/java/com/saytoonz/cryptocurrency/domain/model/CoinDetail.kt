package com.saytoonz.cryptocurrency.domain.model

import com.saytoonz.cryptocurrency.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String, // btc-bitcoin
    val name: String, // Bitcoin
    val description: String, // Bitcoin is a cryptocurrency and worldwide payment system. It is the first decentralized digital currency, as the system works without a central bank or single administrator.
    val symbol: String, // BTC
    val rank: Int, // 1
    val isActive: Boolean, // true
    val tags: List<String>,
    val team: List<TeamMember>,
)
