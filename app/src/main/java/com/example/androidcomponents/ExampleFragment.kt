package com.example.androidcomponents


class ExampleFragment : BaseFragment() {
    private fun someNetworkOperation() {
        showLoader()
        // Assume we're using a hypothetical API client
        /*ApiClient.performSomeOperation(
            onSuccess = {
                // Handle success
                hideLoader()
            },
            onError = {
                // Handle error
                hideLoader()
            }
        )*/

        setBottomNavigationBarVisibility(true)
    }
}
