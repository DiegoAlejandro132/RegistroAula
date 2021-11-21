package ifam.com.registrohorarioaula.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import ifam.com.registrohorarioaula.model.RegistroAulas

class DataBaseHandler(ctx:Context) : SQLiteOpenHelper(ctx, DB_NAME, null, DB_VERSION) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME($IDAULA INTEGER PRIMARY KEY, $DIASEMANA TEXT, $HORAINICIO TEXT, $HORAFIM TEXT, $DESCRICAO TEXT);"
        p0?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME;"
        p0?.execSQL(DROP_TABLE)
        onCreate(p0)
    }

    //adicionando um registro de aula
    fun addRegistro(registro : RegistroAulas){
        val p0 = writableDatabase
        val values = ContentValues().apply{
            put(DIASEMANA, registro.diaSemana)
            put(HORAINICIO, registro.horaInicio)
            put(HORAFIM, registro.horaFim)
            put(DESCRICAO, registro.descricaoAula)
        }
        p0.insert(TABLE_NAME, null, values)
    }

    //lendo o registro
    fun getRegistro(id:Int):RegistroAulas{
        val p0 = readableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME WHERE $IDAULA = $IDAULA;"
        val cursor = p0.rawQuery(selectQuery, null)
        cursor?.moveToFirst()
        val pessoa = populateRegistro(cursor)
        cursor.close()
        return pessoa
    }

    //deletando registro
    fun deleteRegistro(id: Int){
        val p0 = writableDatabase
        p0.delete(TABLE_NAME, "$IDAULA=?", arrayOf(id.toString()) )
    }

    //atualizando registro
    fun updatePessoa(registro: RegistroAulas){
        val p0 = writableDatabase
        val values = ContentValues().apply {
            put(DIASEMANA, registro.diaSemana)
            put(HORAINICIO, registro.horaInicio)
            put(HORAFIM, registro.horaFim)
            put(DESCRICAO, registro.descricaoAula)
        }
        p0.update(TABLE_NAME, values, "$IDAULA=?", arrayOf(registro.idAula.toString()))
    }


    fun getRegistroList() : ArrayList<RegistroAulas>{
        val pessoaList = ArrayList<RegistroAulas>()
        val p0 = readableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME ORDER BY $IDAULA;"
        val cursor = p0.rawQuery(selectQuery, null)
        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    val registro = populateRegistro(cursor)
                }while(cursor.moveToNext())
            }
        }
        cursor.close()
        return pessoaList
    }


    @SuppressLint("Range")
    fun populateRegistro(cursor: Cursor): RegistroAulas{
        val registro = RegistroAulas()
        registro.idAula = cursor.getInt(cursor.getColumnIndex(IDAULA))
        registro.diaSemana = cursor.getString(cursor.getColumnIndex(DIASEMANA))
        registro.horaInicio = cursor.getString(cursor.getColumnIndex(HORAINICIO))
        registro.horaFim = cursor.getString(cursor.getColumnIndex(HORAFIM))
        registro.descricaoAula = cursor.getString(cursor.getColumnIndex(DESCRICAO))
        return registro
    }

    companion object{
        private val DB_VERSION = 1
        private val DB_NAME = "CadastroAula"
        private val TABLE_NAME = "RegistroAula"
        private val IDAULA = "IdAula"
        private val DIASEMANA = "DiaSemana"
        private val HORAINICIO = "HoraInicio"
        private val HORAFIM = "HoraFim"
        private val DESCRICAO = "Descricao"
    }
}