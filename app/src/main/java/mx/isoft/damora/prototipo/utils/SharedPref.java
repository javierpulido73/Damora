package mx.isoft.damora.prototipo.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import mx.isoft.damora.prototipo.model.RegistrosPedidosModel;

/**
 * Description: Clase encargada de extraer las preferencias de usario desde SharedPreferences
 * Created by EX383473 on 10/01/2019.
 */
public class SharedPref {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor sharedPreferencesEdit;

    public static void inicializaPreferencias(Context context) {
        if (sharedPreferences == null)
            sharedPreferences = context.getSharedPreferences(Constantes.SHAR_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPreferencesEdit == null)
            sharedPreferencesEdit = sharedPreferences.edit();
    }

    public static boolean getBoolean(final String nameSharedPreference) {
        return sharedPreferences.getBoolean(nameSharedPreference, false);
    }

    public static void setBoolean(final String nameSharedPreference, final boolean value) {
        sharedPreferencesEdit.putBoolean(nameSharedPreference, value);
        sharedPreferencesEdit.commit();
    }

    public static String getString(final String nameSharedPreference) {
        return sharedPreferences.getString(nameSharedPreference, null);
    }

    public static void setString(final String nameSharedPreference, final String value) {
        sharedPreferencesEdit.putString(nameSharedPreference, value);
        sharedPreferencesEdit.commit();
    }

    public static Integer getInteger(final String nameSharedPreference) {
        return sharedPreferences.getInt(nameSharedPreference, 0);
    }

    public static void setInteger(final String nameSharedPreference, final int value) {
        sharedPreferencesEdit.putInt(nameSharedPreference, value);
        sharedPreferencesEdit.commit();
    }

    public static void guardarRegistroPedidos(final Context context, final RegistrosPedidosModel registrosPedidosModel){
        inicializaPreferencias(context);
        Gson gson = new Gson();
        final String JSON_CONTENIDO = gson.toJson(registrosPedidosModel);
        sharedPreferencesEdit.putString(Constantes.SHAR_PREF_PEDIDOS_GUARDADOS, JSON_CONTENIDO);
        sharedPreferencesEdit.commit();

    }

    public static RegistrosPedidosModel extraerRegistrosPedidos(final Context context){
        inicializaPreferencias(context);
        Gson gson = new Gson();
        final String JSON_CONTENIDO = sharedPreferences.getString(Constantes.SHAR_PREF_PEDIDOS_GUARDADOS, null);
        return gson.fromJson(JSON_CONTENIDO, RegistrosPedidosModel.class);
    }


}
