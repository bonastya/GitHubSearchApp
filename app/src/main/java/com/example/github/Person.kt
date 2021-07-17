package com.example.github

data class User(val name: String, val description: String, val repositories: List<Repository>, var avatarNumber: Int)
data class Repository(val name: String, val description: String, val lang: String, val userName: String)