


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nur.serviceproviderinterviewcrud.repository.UserRepository
import com.nur.serviceproviderinterviewcrud.viewmodel.UsersViewModel


class UsersViewmodelFactory(private val userRepository: UserRepository): ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersViewModel(userRepository) as T
    }

}