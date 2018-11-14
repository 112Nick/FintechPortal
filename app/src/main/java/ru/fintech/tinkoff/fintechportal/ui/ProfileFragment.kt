package ru.fintech.tinkoff.fintechportal.ui

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import ru.fintech.tinkoff.fintechportal.R
import ru.fintech.tinkoff.fintechportal.domain.User

class ProfileFragment : Fragment() {

    var avatar : ImageView? = null
    var fullname : TextView? = null
    var email : TextView? = null
    var about : TextView? = null
    var phoneNumber : EditText? = null
    var city : EditText? = null
    var school : EditText? = null
    var schoolYear : EditText? = null
    var university : EditText? = null
    var depatment : EditText? = null
    var faculty : EditText? = null
    var univercityYear : EditText? = null
    var work : EditText? = null
    var editBtn : FloatingActionButton? = null
    var user : User? = null

    companion object {
        fun newInstance(user : User?) : ProfileFragment {
            val profileFragment = ProfileFragment()
            val bundle = Bundle()
            bundle.putParcelable("USER", user)
            profileFragment.arguments = bundle
            return profileFragment

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        if (args != null) {
            user = args.getParcelable("USER")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_profile, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        avatar = view.findViewById(R.id.avatar)
        fullname = view.findViewById(R.id.fullname)
        email = view.findViewById(R.id.email_text)
        about = view.findViewById(R.id.about)
        phoneNumber = view.findViewById(R.id.phone_number)
        city = view.findViewById(R.id.city)
        school = view.findViewById(R.id.school)
        schoolYear = view.findViewById(R.id.school_year)
        university = view.findViewById(R.id.university)
        univercityYear = view.findViewById(R.id.university_year)
        depatment = view.findViewById(R.id.department)
        faculty = view.findViewById(R.id.faculty)
        work = view.findViewById(R.id.work)
        editBtn = view.findViewById(R.id.edit_button)

        fullname?.text = user?.lastName + " " + user?.firstName + " " + user?.middleName
        email?.text = user?.email
        about?.text = user?.description
        phoneNumber?.text = user?.firstName?.toEditable()
        city?.text = user?.region?.toEditable()
        school?.text = user?.school?.toEditable()
        schoolYear?.text = user?.schoolGraduation?.toEditable()
        university?.text = user?.university?.toEditable()
        univercityYear?.text = user?.universityGraduation?.toEditable()
        depatment?.text = user?.department?.toEditable()
        faculty?.text = user?.faculty?.toEditable()
        work?.text = user?.currentWork?.toEditable()


    }

    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

}