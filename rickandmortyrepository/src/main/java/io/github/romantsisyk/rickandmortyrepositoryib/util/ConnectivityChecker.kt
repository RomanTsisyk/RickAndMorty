package io.github.romantsisyk.rickandmortyrepositoryib.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

/**
 * Utility class for checking network connectivity.
 *
 * @property context The application [Context] used to access system services.
 */
class ConnectivityChecker(private val context: Context) {

    /**
     * Checks if the device is connected to the internet.
     *
     * @return True if the device has an active internet connection, otherwise false.
     */
    fun isConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}
