package ifam.com.registrohorarioaula

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class InstituicaoFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var num1 = getView()?.findViewById<EditText>(R.id.num1)
        var num2 = getView()?.findViewById<EditText>(R.id.num2)
        val btn_calcular = getView()?.findViewById<Button>(R.id.button)
        var res = getView()?.findViewById<TextView>(R.id.txt_res)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_instituicao, container, false)

        /*var num1 = getView()?.findViewById<EditText>(R.id.num1)
        var num2 = getView()?.findViewById<EditText>(R.id.num2)
        val btn_calcular = getView()?.findViewById<Button>(R.id.button)
        var res = getView()?.findViewById<TextView>(R.id.txt_res)*/

    }

}