package com.example.lib_common.base

import androidx.lifecycle.ViewModel
import autodispose2.lifecycle.CorrespondingEventsFunction
import autodispose2.lifecycle.LifecycleEndedException
import autodispose2.lifecycle.LifecycleScopeProvider
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject

/**
 * ViewModel 基类
 */
abstract class BaseViewModel : ViewModel(), LifecycleScopeProvider<BaseViewModel.ViewModelEvent> {

    // Subject backing the auto disposing of subscriptions.
    private val lifecycleEvents = BehaviorSubject.createDefault(ViewModelEvent.CREATED)

    /**
     * The events that represent the lifecycle of a [ViewModel].
     *
     * The [ViewModel] lifecycle is very simple. It is created
     * and then allows you to clean up any resources in the
     * [ViewModel.onCleared] method before it is destroyed.
     */
    enum class ViewModelEvent {
        CREATED, CLEARED
    }

    /**
     * The observable representing the lifecycle of the [ViewModel].
     *
     * @return [Observable] modelling the [ViewModel] lifecycle.
     */
    override fun lifecycle(): Observable<ViewModelEvent> {
        return lifecycleEvents.hide()
    }

    /**
     * Returns a [CorrespondingEventsFunction] that maps the
     * current event -> target disposal event.
     *
     * @return function mapping the current event to terminal event.
     */
    override fun correspondingEvents(): CorrespondingEventsFunction<ViewModelEvent> {
        return CORRESPONDING_EVENTS
    }

    override fun peekLifecycle(): ViewModelEvent? {
        return lifecycleEvents.value
    }

    /**
     * Emit the [ViewModelEvent.CLEARED] event to
     * dispose off any subscriptions in the ViewModel.
     */
    override fun onCleared() {
        lifecycleEvents.onNext(ViewModelEvent.CLEARED)
        super.onCleared()
    }

    companion object {
        /**
         * Function of current event -> target disposal event. ViewModel has a very simple lifecycle.
         * It is created and then later on cleared. So we only have two events and all subscriptions
         * will only be disposed at [ViewModelEvent.CLEARED].
         */
        private val CORRESPONDING_EVENTS = CorrespondingEventsFunction<ViewModelEvent> { event ->
            when (event) {
                ViewModelEvent.CREATED -> ViewModelEvent.CLEARED
                else -> throw LifecycleEndedException(
                    "Cannot bind to ViewModel lifecycle after onCleared.")
            }
        }
    }
}