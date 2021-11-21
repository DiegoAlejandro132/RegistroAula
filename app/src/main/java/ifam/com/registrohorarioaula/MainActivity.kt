package ifam.com.registrohorarioaula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var horarioFragment: HorarioFragment
    private lateinit var instituicaoFragment: InstituicaoFragment
    private lateinit var perfilFragment: PerfilFragment

    private lateinit var btn_horario : Button
    private lateinit var btn_instituicao : Button
    private lateinit var btn_perfil : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_horario = findViewById(R.id.btn_horario)
        btn_horario.setOnClickListener(this)

        btn_instituicao = findViewById(R.id.btn_instituicao)
        btn_instituicao.setOnClickListener(this)

        btn_perfil = findViewById(R.id.btn_perfil)
        btn_perfil.setOnClickListener(this)

        horarioFragment = HorarioFragment()
        instituicaoFragment = InstituicaoFragment()
        perfilFragment = PerfilFragment()

        setFragment(horarioFragment)
    }
    private fun setFragment(fragment : Fragment){
        val mudarFragment = supportFragmentManager.beginTransaction()
        mudarFragment.replace(R.id.frame_fragments, fragment)
        mudarFragment.commit()
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.btn_perfil ->{
                setFragment(perfilFragment)
            }
            R.id.btn_instituicao ->{
                setFragment(instituicaoFragment)
            }
            R.id.btn_horario ->{
                setFragment(horarioFragment)
            }
        }
    }

}