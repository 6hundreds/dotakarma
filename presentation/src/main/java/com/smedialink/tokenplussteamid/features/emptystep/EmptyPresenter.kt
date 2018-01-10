package com.smedialink.tokenplussteamid.features.emptystep

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class EmptyPresenter @Inject constructor(
        private val router: Router
) : BasePresenter<EmptyView>()
