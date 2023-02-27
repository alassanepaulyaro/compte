package com.example.ca_compte.data

data class Account(
    val balance: Double,
    val contract_number: String,
    val holder: String,
    val id: String,
    val label: String,
    val operations: List<Operation>,
    val order: Int,
    val product_code: String,
    val role: Int
)