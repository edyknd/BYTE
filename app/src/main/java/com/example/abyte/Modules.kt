package com.example.abyte

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modules = module(override = false) {
    single { RepositoryStatement() }
    viewModel {
        StatementViewModel(
            get(),
            get()
        )
    }
}
