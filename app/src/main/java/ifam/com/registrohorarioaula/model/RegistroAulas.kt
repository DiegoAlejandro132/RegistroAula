package ifam.com.registrohorarioaula.model

import android.widget.ArrayAdapter

data class RegistroAulas (var idAula: Int = 0,
                          var diaSemana: String = "",
                          var horaInicio: String = "",
                          var horaFim: String = "",
                          var descricaoAula: String = "") {
}